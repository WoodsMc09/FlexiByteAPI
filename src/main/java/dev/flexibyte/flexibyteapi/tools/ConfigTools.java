package dev.flexibyte.flexibyteapi.tools;

import org.bukkit.plugin.Plugin;

public class ConfigTools {

    private Plugin plugin = null;

    public ConfigTools(Plugin plugin){
        this.plugin = plugin;
    }

    public void loadConfigOnEnable(){
        //load config
        plugin.getConfig().options().copyDefaults();
        plugin.saveDefaultConfig();
    }
}
