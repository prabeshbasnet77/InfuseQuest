package com.infusequest.gui;


import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.Map;



public class GUIManager {


    private static Map<Player, String> opened =
            new HashMap<>();



    public static void open(
            Player player,
            String gui
    ){

        opened.put(player, gui);

    }



    public static boolean isOpen(
            Player player,
            String gui
    ){

        return gui.equals(
                opened.get(player)
        );

    }



    public static void close(
            Player player
    ){

        opened.remove(player);

    }



}