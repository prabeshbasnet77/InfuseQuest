package com.infusequest.command;

import com.infusequest.InfuseQuest;
import com.infusequest.gui.PowerGUI;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Player;


public class PowerCommand implements CommandExecutor {


    private final InfuseQuest plugin;



    public PowerCommand(InfuseQuest plugin) {

        this.plugin = plugin;

    }





    @Override
    public boolean onCommand(

            CommandSender sender,

            Command command,

            String label,

            String[] args

    ) {



        /*
         * Only players can open GUI
         */
        if (!(sender instanceof Player player)) {


            sender.sendMessage(
                    "Only players can use this command."
            );


            return true;

        }





        /*
         * Permission check
         */
        if (!player.hasPermission("infusequest.power")) {


            player.sendMessage(
                    "§cYou don't have permission to use this."
            );


            return true;

        }





        /*
         * Open Power GUI
         */
        PowerGUI gui =
        new PowerGUI(plugin);


gui.open(
        player,
        plugin.getPowerManager()
);



        return true;


    }



}