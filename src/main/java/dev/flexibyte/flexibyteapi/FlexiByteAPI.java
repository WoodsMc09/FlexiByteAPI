package dev.flexibyte.flexibyteapi;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class FlexiByteAPI extends JavaPlugin {

    //THIS CODE IS INTENTIONALLY MESSY


    public static Plugin plugin;

    private static FlexiByteAPIManager api;

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        api.closeConnection();


    }


    private static File file;
    private static YamlConfiguration info;

    public static YamlConfiguration getInfo() {
        return info;
    }

    private static FlexiByteAPIManager getAPI(Plugin p){
        plugin = p;
        file = new File(p.getDataFolder(), "data/info.yml");

        if(!file.exists()){
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        info = YamlConfiguration.loadConfiguration(file);

        String information = "PLUGIN INFORMATION> >This Plugin was created by FlexiByte Services.>The name of this plugin is " + p.getName() + ">" + p.getDescription() + "> >Thank you for using FlexiByte Services!> >serviceID: 12 7* 93 A* 01 D* 12* K1 9* 23";
        String[] strings = information.split(">");
        List<String> list = new ArrayList<>();
        for(String s : strings){
            list.add(s);
        }
        info.set("plugin-info", list);
        save();

        try {
            api = new FlexiByteAPIManager(p);
            api.initializeDatabase();


            PluginProfile profile = new PluginProfile(p.getName(), p.getDescription().getDescription(), true);
            if(api.findPluginProfileByName(profile.getName()) == null)
                api.createPluginProfile(profile);
            else
                api.updatePluginProfile(api.getPluginProfileFromDatabase(profile.getName()));

            new BukkitRunnable(){

                @Override
                public void run() {
                    try {
                        api.checkPluginProfile(profile);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }.runTaskTimer(plugin, 0, 600);


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return new FlexiByteAPIManager(p);
    }

    private static void save() {
        try {
            info.save(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setAPI(Plugin p){
        getAPI(p);
    }
}
