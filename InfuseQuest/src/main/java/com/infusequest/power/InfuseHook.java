package com.infusequest.power;


import org.bukkit.entity.Player;



public class InfuseHook {



    public static void upgrade(

            Player player,

            PowerType power,

            int level

    ){


        /*
        
        Infuse API connection

        This will call InfuseSMP methods

        after detecting API classes.


        */


        player.sendMessage(

        "§a" 
        + power.name()
        + " upgraded to Level "
        + level

        );


    }




}