package com.infusequest.gui;



import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import org.bukkit.Material;

import org.bukkit.entity.Player;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


import java.util.Arrays;



public class QuestGUI {



    public static void open(
            Player player
    ){


        Inventory inv =
                Bukkit.createInventory(
                        null,
                        27,
                        "§8Daily Quests"
                );



        ItemStack zombie =
                createItem(
                        Material.ROTTEN_FLESH,
                        "§cZombie Hunter",
                        "§7Kill 25 Zombies",
                        "§bReward: §f2 Essence"
                );



        ItemStack miner =
                createItem(
                        Material.DIAMOND_PICKAXE,
                        "§6Master Miner",
                        "§7Mine 128 Blocks",
                        "§bReward: §f2 Essence"
                );



        ItemStack close =
                createItem(
                        Material.BARRIER,
                        "§cClose",
                        "§7Click to close"
                );




        inv.setItem(
                11,
                zombie
        );


        inv.setItem(
                15,
                miner
        );


        inv.setItem(
                22,
                close
        );



        player.openInventory(inv);


        GUIManager.open(
                player,
                "QUEST"
        );



    }






    private static ItemStack createItem(
            Material material,
            String name,
            String... lore
    ){


        ItemStack item =
                new ItemStack(material);



        ItemMeta meta =
                item.getItemMeta();



        meta.setDisplayName(
                name
        );



        meta.setLore(
                Arrays.asList(lore)
        );



        item.setItemMeta(meta);



        return item;


    }


}