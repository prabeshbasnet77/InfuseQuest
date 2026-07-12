package com.infusequest.listener;

import com.infusequest.InfuseQuest;
import com.infusequest.gui.PowerGUI;
import com.infusequest.power.PowerManager;
import com.infusequest.power.PowerType;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import org.bukkit.inventory.ItemStack;


public class PowerGUIListener implements Listener {


    private final InfuseQuest plugin;

    private final PowerManager powerManager;



    public PowerGUIListener(
            InfuseQuest plugin,
            PowerManager powerManager
    ) {


        this.plugin = plugin;
        this.powerManager = powerManager;


    }






    @EventHandler
    public void onClick(
            InventoryClickEvent event
    ) {



        if(!(event.getWhoClicked() instanceof Player player)) {

            return;

        }




        if(!event.getView()
                .getTitle()
                .equals("§8✦ Infuse Powers")) {


            return;

        }




        event.setCancelled(true);





        ItemStack item =
                event.getCurrentItem();




        if(item == null ||
                !item.hasItemMeta()) {


            return;

        }





        String name =
                ChatColor.stripColor(
                        item.getItemMeta()
                                .getDisplayName()
                );





        PowerType type;


        try {


            type =
                    PowerType.valueOf(
                            name
                    );


        } catch(Exception e) {


            return;

        }






        boolean success =
                powerManager.upgrade(
                        player,
                        type
                );






        if(success) {


            player.closeInventory();



            PowerGUI gui =
                    new PowerGUI(plugin);



            gui.open(
                    player,
                    powerManager
            );


        }



    }


}