package com.infusequest.command;


import com.infusequest.InfuseQuest;
import com.infusequest.gui.QuestGUI;


import org.bukkit.command.Command;

import org.bukkit.command.CommandExecutor;

import org.bukkit.command.CommandSender;

import org.bukkit.entity.Player;

public class QuestCommand implements CommandExecutor {

    private final InfuseQuest plugin;


public QuestCommand(InfuseQuest plugin){

    this.plugin = plugin;

}

@Override

public boolean onCommand(

CommandSender sender,

Command command,

String label,

String[] args

){



if(sender instanceof Player player){
            QuestGUI.open(player, plugin.getDailyQuestManager());
            return true;
}

    return false;


}
}