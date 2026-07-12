package com.infusequest.command;


import com.infusequest.InfuseQuest;
import com.infusequest.gui.PowerGUI;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Player;



public class PowerCommand implements CommandExecutor {



private final InfuseQuest plugin;



public PowerCommand(
        InfuseQuest plugin
){

    this.plugin = plugin;

}







@Override
public boolean onCommand(

CommandSender sender,

Command command,

String label,

String[] args

){



if(!(sender instanceof Player player)){

return true;

}





PowerGUI.open(

        player,

        plugin.getPowerManager()

);





return true;


}



}