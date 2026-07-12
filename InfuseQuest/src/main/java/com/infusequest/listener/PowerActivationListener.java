package com.infusequest.listener;



import com.infusequest.power.PowerActivationManager;
import com.infusequest.power.AbilitySyncManager;


import org.bukkit.entity.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.player.PlayerJoinEvent;




public class PowerActivationListener implements Listener {



    private final PowerActivationManager activationManager;


    private final AbilitySyncManager syncManager;







    public PowerActivationListener(

            PowerActivationManager activationManager,

            AbilitySyncManager syncManager

    ){


        this.activationManager = activationManager;


        this.syncManager = syncManager;


    }









    @EventHandler

    public void onJoin(

            PlayerJoinEvent event

    ){



        Player player =

                event.getPlayer();






        /*
        Sync real InfuseSMP abilities

        Example:

        Player has FIRE in InfuseSMP

        Then InfuseQuest saves:

        FIRE
        Level 1
        Owned true

        */


        syncManager.sync(player);








        /*
        Activate owned abilities

        Example:

        FIRE Level 2
        Speed Level 3

        */

        activationManager.activate(player);



    }





}