package dev.flexibyte.flexibyteapi.tools;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;

public class StringTools {

    public String format(String s){
        //format chat color
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public String format(String s, String prefixVar, String prefix){
        /*
        format chat color codes
        replace prefixVar w/ prefix
         */
        return ChatColor.translateAlternateColorCodes('&', s.replace(prefixVar, prefix));
    }


    public String getFromConfig(String path, FileConfiguration config){
        //get string from config
        return config.getString(path);
    }

    public String getFromConfig(String path, FileConfiguration config, boolean color){
        /*
        get string from config
        format color
         */
        return color ? config.getString(path) : format(config.getString(path));
    }
    public String getFromConfig(String path, FileConfiguration config, boolean prefix, String prefixVar, String pref){
        /*
        get string from config
        format color
        format prefix
         */
        return prefix ? config.getString(path) : format(config.getString(path), prefixVar, pref);
    }

    public List<String> format(List<String> list){
        //format every string in list
        List<String> finalList = new ArrayList<>();
        for(String s : list){
            finalList.add(format(s));
        }

        return finalList;
    }

    public List<String> format(List<String> list, String prefixVar, String prefix){
        /*
        format every string in list
        format every prefix in the list
         */
        List<String> finalList = new ArrayList<>();
        for(String s : list){
            finalList.add(format(s, prefixVar, prefix));
        }

        return finalList;
    }

}
