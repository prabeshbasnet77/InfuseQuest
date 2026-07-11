package com.infusequest.listener;


import com.infusequest.quest.QuestManager;


import org.bukkit.event.Listener;

import org.bukkit.event.EventHandler;

import org.bukkit.event.block.BlockBreakEvent;



public class BlockBreakListener
implements Listener {



private QuestManager manager;



public BlockBreakListener(
QuestManager manager
){

this.manager=manager;

}





@EventHandler

public void breakBlock(
BlockBreakEvent event
){


manager.addProgress(

event.getPlayer(),

"miner",

1

);



}


}