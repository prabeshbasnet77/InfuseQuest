package com.infusequest.power;


import com.infusequest.InfuseQuest;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;



public class PowerActivationManager {



    private final InfuseQuest plugin;



    public PowerActivationManager(
            InfuseQuest plugin
    ){

        this.plugin = plugin;

    }







    public void activate(Player player){



        PowerManager manager =
                plugin.getPowerManager();





        /*
        FIRE POWER
        */


        if(manager.hasPower(
                player,
                PowerType.FIRE
        )){


            PlayerPower fire =
                    manager.getPower(
                            player,
                            PowerType.FIRE
                    );



            activateFire(
                    player,
                    fire.getLevel()
            );


        }







        /*
        SPEED POWER
        */


        if(manager.hasPower(
                player,
                PowerType.SPEED
        )){


            PlayerPower speed =
                    manager.getPower(
                            player,
                            PowerType.SPEED
                    );


            activateSpeed(
                    player,
                    speed.getLevel()
            );


        }



    }










    private void activateFire(

            Player player,

            int level

    ){



        player.addPotionEffect(

                new PotionEffect(

                PotionEffectType.FIRE_RESISTANCE,

                20*60,

                level-1

                )

        );



    }









    private void activateSpeed(

            Player player,

            int level

    ){



        player.addPotionEffect(

                new PotionEffect(

                PotionEffectType.SPEED,

                20*60,

                level-1

                )

        );


    }



}