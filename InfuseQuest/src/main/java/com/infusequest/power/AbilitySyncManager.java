package com.infusequest.power;


import com.infusequest.InfuseQuest;
import com.infusequest.hook.InfuseHook;


import org.bukkit.entity.Player;




public class AbilitySyncManager {



    private final InfuseQuest plugin;


    private final InfuseHook hook;





    public AbilitySyncManager(

            InfuseQuest plugin

    ){


        this.plugin = plugin;


        this.hook =
                new InfuseHook();


    }







    public void sync(Player player){



        for(PowerType type :
                PowerType.values()){





            boolean has =

                    hook.hasAbility(

                            player,

                            type.name()

                    );







            if(has){


                plugin.getLogger()
                .info(

                player.getName()
                +
                " has "
                +
                type.name()

                );



            }



        }



    }



}