package com.infusequest.command;


import com.infusequest.gui.PowerGUI;


import org.bukkit.command.*;

import org.bukkit.entity.Player;



public class PowerCommand
implements CommandExecutor {



@Override

public boolean onCommand(

CommandSender sender,

Command command,

String label,

String[] args

){


if(sender instanceof Player player){


PowerGUI.open(player);


}


return true;


}


}