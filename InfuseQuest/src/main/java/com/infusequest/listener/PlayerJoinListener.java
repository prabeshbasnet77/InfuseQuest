package com.infusequest.listener;


import org.bukkit.event.Listener;

import org.bukkit.event.EventHandler;

import org.bukkit.event.player.PlayerJoinEvent;


import java.sql.PreparedStatement;


import com.infusequest.InfuseQuest;



public class PlayerJoinListener
implements Listener {



private InfuseQuest plugin;



public PlayerJoinListener(
InfuseQuest plugin
){

this.plugin=plugin;

}




@EventHandler

public void join(
PlayerJoinEvent event
){


try{


PreparedStatement ps =
plugin.getDatabase()
.getConnection()
.prepareStatement(

"""
INSERT OR IGNORE INTO players(uuid)

VALUES(?)

"""

);


ps.setString(

1,

event.getPlayer()
.getUniqueId()
.toString()

);


ps.executeUpdate();



}catch(Exception e){

e.printStackTrace();

}



}


}