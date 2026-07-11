package com.infusequest.gui;


import com.infusequest.InfuseQuest;

import com.infusequest.power.PowerManager;
import com.infusequest.power.PowerType;


import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;

import org.bukkit.event.inventory.InventoryClickEvent;

import org.bukkit.entity.Player;



public class GUIListener implements Listener {



    private final InfuseQuest plugin;




    public GUIListener(
            InfuseQuest plugin
    ){

        this.plugin = plugin;

    }






    @EventHandler

    public void click(
            InventoryClickEvent event
    ){



        if(!(event.getWhoClicked()
                instanceof Player player))
            return;





        String title =
                event.getView()
                .getTitle();





        /*
         Cancel all GUI clicks
        */

        if(title.equals("§8Daily Quests")
        ||
        title.equals("§8Infuse Powers")){


            event.setCancelled(true);


        }





        /*
          POWER UPGRADE MENU

          Speed button slot = 11

        */


        if(title.equals("§8Infuse Powers")){



            if(event.getSlot() == 11){



                plugin.getPowerManager()
                        .upgrade(

                                player,

                                PowerType.SPEED

                        );



                player.closeInventory();



            }



        }





    }


}