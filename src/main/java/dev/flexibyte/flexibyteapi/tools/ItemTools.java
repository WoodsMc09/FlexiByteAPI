package dev.flexibyte.flexibyteapi.tools;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionData;

import java.util.ArrayList;
import java.util.List;

public class ItemTools {

    public ItemStack createItem(Material m, int count, String name, List<String> lore, boolean unbreakable){
        //create item
        ItemStack i = new ItemStack(m, count);
        //get item meta
        ItemMeta meta = i.getItemMeta();
        //set item name
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
        //set item lore
        List<String> finalLore = new ArrayList<>();
        for(String s : lore){
            finalLore.add(ChatColor.translateAlternateColorCodes('&', s));
        }
        meta.setLore(finalLore);
        //unbreakable
        meta.setUnbreakable(unbreakable);

        //set meta
        i.setItemMeta(meta);

        return i;
    }

    public ItemStack createItem(Material m, int count, String name, List<String> lore, int modelData, boolean unbreakable){
        //create item
        ItemStack i = new ItemStack(m, count);
        //get item meta
        ItemMeta meta = i.getItemMeta();
        //set item name
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
        //set item lore
        List<String> finalLore = new ArrayList<>();
        for(String s : lore){
            finalLore.add(ChatColor.translateAlternateColorCodes('&', s));
        }
        meta.setLore(finalLore);
        //set model data
        meta.setCustomModelData(modelData);
        //unbreakable
        meta.setUnbreakable(unbreakable);

        //set meta
        i.setItemMeta(meta);

        return i;
    }

    public ItemStack createPlayerHead(OfflinePlayer owner, int count, String name, List<String> lore, int modelData){
        //create item
        ItemStack i = new ItemStack(Material.PLAYER_HEAD, count);
        //get item meta
        SkullMeta meta = (SkullMeta) i.getItemMeta();
        //set item name
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
        //set item lore
        List<String> finalLore = new ArrayList<>();
        for(String s : lore){
            finalLore.add(ChatColor.translateAlternateColorCodes('&', s));
        }
        meta.setLore(finalLore);
        //set model data
        meta.setCustomModelData(modelData);
        //owner
        meta.setOwningPlayer(owner);

        //set meta
        i.setItemMeta(meta);

        return i;
    }


    public ItemStack createPotion(PotionData data, int count, Color color, String name, List<String> lore, int modelData){
        //create item
        ItemStack i = new ItemStack(Material.POTION, count);
        //get item meta
        PotionMeta meta = (PotionMeta) i.getItemMeta();
        //set item name
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
        //set item lore
        List<String> finalLore = new ArrayList<>();
        for(String s : lore){
            finalLore.add(ChatColor.translateAlternateColorCodes('&', s));
        }
        meta.setLore(finalLore);
        //set model data
        meta.setCustomModelData(modelData);
        //potion
        meta.setBasePotionData(data);
        meta.setColor(color);

        //set meta
        i.setItemMeta(meta);

        return i;
    }


    public ItemStack setEnchanted(ItemStack i){
        //add useless enchantment
        i.addEnchantment(Enchantment.DURABILITY, 1);

        return i;
    }


}
