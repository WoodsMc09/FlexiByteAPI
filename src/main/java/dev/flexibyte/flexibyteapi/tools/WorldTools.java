package dev.flexibyte.flexibyteapi.tools;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorldTools {


    public boolean checkChunk(Location loc, Block block) {
        //get chunk
        Chunk chunk = loc.getChunk();

        //get min and max coordinates
        final int minX = chunk.getX() << 4;
        final int minZ = chunk.getZ() << 4;
        final int maxX = minX | 15;
        final int maxY = chunk.getWorld().getMaxHeight();
        final int maxZ = minZ | 15;

        //loop through all coordinates in chunk
        for (int x = minX; x <= maxX; ++x) {
            for (int y = 0; y <= maxY; ++y) {
                for (int z = minZ; z <= maxZ; ++z) {
                    //return block == block
                    return chunk.getBlock(x, y, z) == block;
                }
            }
        }

        return false;
    }


    public boolean checkChunk(Location loc, Material mat) {
        //get chunk
        Chunk chunk = loc.getChunk();

        //get min and max coordinates
        final int minX = chunk.getX() << 4;
        final int minZ = chunk.getZ() << 4;
        final int maxX = minX | 15;
        final int maxY = chunk.getWorld().getMaxHeight();
        final int maxZ = minZ | 15;

        //loop through all coordinates in chunk
        for (int x = minX; x <= maxX; ++x) {
            for (int y = 0; y <= maxY; ++y) {
                for (int z = minZ; z <= maxZ; ++z) {
                    //return blockType == material
                    return chunk.getBlock(x, y, z).getType() == mat;
                }
            }
        }

        return false;
    }

    public boolean checkChunk(Location loc, Entity e) {
        //get chunk
        Chunk chunk = loc.getChunk();
        //loop through all entities in chunk
        for(Entity check : chunk.getEntities()){
            return check == e;
        }

        return false;
    }

    public boolean checkChunk(Location loc, EntityType type) {
        //get chunk
        Chunk chunk = loc.getChunk();
        //loop through all entities in chunk
        for(Entity check : chunk.getEntities()){
            return check.getType() == type;
        }

        return false;
    }


    public List<Block> getAllChunkBlocks(Location loc) {
        //get chunk
        Chunk chunk = loc.getChunk();

        //block list
        List<Block> blocks = new ArrayList<>();

        //get min and max coordinates
        final int minX = chunk.getX() << 4;
        final int minZ = chunk.getZ() << 4;
        final int maxX = minX | 15;
        final int maxY = chunk.getWorld().getMaxHeight();
        final int maxZ = minZ | 15;

        //loop through all coordinates in chunk
        for (int x = minX; x <= maxX; ++x) {
            for (int y = 0; y <= maxY; ++y) {
                for (int z = minZ; z <= maxZ; ++z) {
                    //add block into list
                    blocks.add(chunk.getBlock(x, y, z));
                }
            }
        }

        return blocks;
    }

    public void removeAllChunkBlocks(Location loc, boolean naturally) {
        //get chunk
        Chunk chunk = loc.getChunk();

        //get min and max coordinates
        final int minX = chunk.getX() << 4;
        final int minZ = chunk.getZ() << 4;
        final int maxX = minX | 15;
        final int maxY = chunk.getWorld().getMaxHeight();
        final int maxZ = minZ | 15;

        //loop through all coordinates in chunk
        for (int x = minX; x <= maxX; ++x) {
            for (int y = 0; y <= maxY; ++y) {
                for (int z = minZ; z <= maxZ; ++z) {
                    //remove block
                    if(naturally)
                        chunk.getBlock(x, y, z).breakNaturally();
                    else
                        chunk.getBlock(x, y, z).setType(Material.AIR);
                }
            }
        }

    }


    public List<Block> getAllBlockInChunk(Location loc, Material mat) {
        //get chunk
        Chunk chunk = loc.getChunk();

        //block list
        List<Block> blocks = new ArrayList<>();

        //get min and max coordinates
        final int minX = chunk.getX() << 4;
        final int minZ = chunk.getZ() << 4;
        final int maxX = minX | 15;
        final int maxY = chunk.getWorld().getMaxHeight();
        final int maxZ = minZ | 15;

        //loop through all coordinates in chunk
        for (int x = minX; x <= maxX; ++x) {
            for (int y = 0; y <= maxY; ++y) {
                for (int z = minZ; z <= maxZ; ++z) {
                    //check block and add to list
                    if(chunk.getBlock(x, y, z).getType() == mat)
                        blocks.add(chunk.getBlock(x, y, z));
                }
            }
        }

        return blocks;
    }

    public List<Block> getNearbyBlocks(Location center, int radius){
        //create block list
        List<Block> blocks = new ArrayList<Block>();

        //Loop through all nearby blocks
        for(int x = center.getBlockX() - radius; x <= center.getBlockX() + radius; x++){
            for(int y = center.getBlockY() - radius; y <= center.getBlockX() + radius; y++){
                for(int z = center.getBlockZ() - radius; z <= center.getBlockX() + radius; z++){
                    //get block location and add to list
                    Location loc = new Location(center.getWorld(), x, y, z);
                    blocks.add(loc.getBlock());
                }
            }
        }
        return blocks;
    }

    public List<Block> getNearbyBlocks(Location center, int radius, int depth){
        //create block list
        List<Block> blocks = new ArrayList<Block>();

        //Loop through all nearby blocks
        for(int x = center.getBlockX() - radius; x <= center.getBlockX() + radius; x++){
            for(int y = center.getBlockY() - depth; y <= center.getBlockX() + depth; y++){
                for(int z = center.getBlockZ() - radius; z <= center.getBlockX() + radius; z++){
                    //get block location and add to list
                    Location loc = new Location(center.getWorld(), x, y, z);
                    blocks.add(loc.getBlock());
                }
            }
        }
        return blocks;
    }



    public void createRealisticExplosion(Location loc, int power){
        //create fake explosion
        loc.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, loc, 1);
        loc.getWorld().playSound(loc, Sound.ENTITY_GENERIC_EXPLODE, 4, 1);

        //get nearby blocks
        List<Block> blocks = getNearbyBlocks(loc, power, 2);

        for(int i = 0; i < blocks.size(); i++){
            //create random
            Random r = new Random();
            int chance = r.nextInt(3);

            //check if block will be destroyed
            if(chance != 1)
                continue;

            //create falling block
            Block b = blocks.get(i);
            FallingBlock fBlock = b.getWorld().spawnFallingBlock(b.getLocation(), b.getBlockData());
            //remove block
            b.setType(Material.AIR);
            //launch block
            fBlock.setVelocity(fBlock.getLocation().toVector().subtract(loc.subtract(0, 4, 0).toVector()).multiply(5).normalize());
            //set attributes
            fBlock.setGravity(true);
            fBlock.setDropItem(true);
            fBlock.setHurtEntities(true);


        }


    }


}
