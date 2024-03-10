package dev.flexibyte.flexibyteapi;

import dev.flexibyte.flexibyteapi.tools.StringTools;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class FlexiCommand implements CommandExecutor {

    private String dev = "";
    private String client = "";
    private Plugin plugin = null;
    private StringTools stringTools = null;

    public FlexiCommand(Plugin plugin, String dev, String client, StringTools stringTools){
        this.plugin = plugin;
        this.dev = dev;
        this.client = client;
        this.stringTools = stringTools;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        //get message
        String message = "&3&lFlexiByte Services;&3Plugin: &b" + plugin.getName() + ";&3Version: &b" + plugin.getServer().getVersion() +";&3Developer: &b" + dev + ";&3Client &b" + client+ ";&e&oGet your plugin today! https://flexibyte.dev";
        String[] send = message.split(";");

        //send message
        for(String s : send){
            sender.sendMessage(stringTools.format(s));
        }
        return true;
    }
}
