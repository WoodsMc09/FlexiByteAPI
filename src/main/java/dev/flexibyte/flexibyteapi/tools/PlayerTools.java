package dev.flexibyte.flexibyteapi.tools;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerTools {

    public List<Player> getNearbyPlayers(Location center, int x, int y, int z){
        //player list
        List<Player> nearby = new ArrayList<>();
        //loop through all nearby entities
        for(Entity e : center.getWorld().getNearbyEntities(center, x, y, z)){
            //check if entity is a player and add to list
            if(e instanceof Player)
                nearby.add((Player) e);
        }

        return nearby;
    }

}
