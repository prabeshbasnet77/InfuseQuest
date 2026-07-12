package com.infusequest.gui;


import org.bukkit.entity.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;



public class GUIListener implements Listener {



    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){


        if(!(event.getWhoClicked() instanceof Player)){
            return;
        }


        String title = event.getView().getTitle();


        if(title.equals("§8✦ Daily Quests")
                ||
           title.equals("§8✦ Infuse Powers")){


            event.setCancelled(true);

        }

    }





    @EventHandler
    public void onInventoryDrag(InventoryDragEvent event){


        String title = event.getView().getTitle();


        if(title.equals("§8✦ Daily Quests")
                ||
           title.equals("§8✦ Infuse Powers")){


            event.setCancelled(true);

        }

    }


}