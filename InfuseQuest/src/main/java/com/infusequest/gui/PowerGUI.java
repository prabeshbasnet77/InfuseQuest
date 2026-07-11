package com.infusequest.gui;



import org.bukkit.Bukkit;

import org.bukkit.Material;

import org.bukkit.entity.Player;

import org.bukkit.inventory.Inventory;

import org.bukkit.inventory.ItemStack;

import org.bukkit.inventory.meta.ItemMeta;


import java.util.Arrays;



public class PowerGUI {



    public static void open(
            Player player
    ){



        Inventory inv =
                Bukkit.createInventory(
                        null,
                        27,
                        "§8Infuse Powers"
                );



        ItemStack speed =
                create(
                        Material.SUGAR,
                        "§b⚡ Speed",
                        "§7Current Level: §f1",
                        "",
                        "§eUpgrade Cost:",
                        "§f5 Essence"
                );



        ItemStack strength =
                create(
                        Material.IRON_SWORD,
                        "§c⚔ Strength",
                        "§7Current Level: §f1",
                        "",
                        "§eUpgrade Cost:",
                        "§f5 Essence"
                );



        ItemStack heart =
                create(
                        Material.REDSTONE,
                        "§c❤ Heart",
                        "§7Current Level: §f1"
                );




        inv.setItem(
                11,
                speed
        );


        inv.setItem(
                13,
                strength
        );


        inv.setItem(
                15,
                heart
        );



        player.openInventory(inv);



        GUIManager.open(
                player,
                "POWER"
        );


    }







    private static ItemStack create(
            Material mat,
            String name,
            String... lore
    ){


        ItemStack item =
                new ItemStack(mat);



        ItemMeta meta =
                item.getItemMeta();



        meta.setDisplayName(name);



        meta.setLore(
                Arrays.asList(lore)
        );


        item.setItemMeta(meta);



        return item;


    }


}