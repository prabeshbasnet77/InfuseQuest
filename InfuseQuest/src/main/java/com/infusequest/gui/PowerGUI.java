package com.infusequest.gui;


import com.infusequest.InfuseQuest;
import com.infusequest.power.PowerManager;
import com.infusequest.power.PowerType;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class PowerGUI {


    private final InfuseQuest plugin;



    public PowerGUI(InfuseQuest plugin){

        this.plugin = plugin;

    }




    public void open(
            Player player,
            PowerManager manager
    ){


        Inventory inv =
                Bukkit.createInventory(
                        null,
                        54,
                        "§8✦ Infuse Powers"
                );




        int slot = 10;



        for(PowerType type : PowerType.values()){


            ItemStack item =
                    new ItemStack(
                            Material.NETHER_STAR
                    );



            ItemMeta meta =
                    item.getItemMeta();



            meta.setDisplayName(
                    "§d" + type.name()
            );



            item.setItemMeta(meta);



            inv.setItem(
                    slot,
                    item
            );


            slot++;


        }



        player.openInventory(inv);


    }


}