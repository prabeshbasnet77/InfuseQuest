package com.infusequest.power;


import com.infusequest.InfuseQuest;
import com.infusequest.database.PowerRepository;


import org.bukkit.entity.Player;



public class PowerManager {



    private final InfuseQuest plugin;


    private final PowerRepository repository;



    private final int MAX_LEVEL = 5;






    public PowerManager(

            InfuseQuest plugin

    ){


        this.plugin = plugin;


        this.repository =
                new PowerRepository(plugin);


    }









    public PlayerPower getPower(

            Player player,

            PowerType type

    ){



        return repository.getPower(

                player.getUniqueId(),

                type

        );


    }









    public boolean upgrade(


            Player player,


            PowerType type


    ){





        PlayerPower power =

                repository.getPower(

                        player.getUniqueId(),

                        type

                );









        /*
        Check ownership
        */


        if(!power.isOwned()){



            player.sendMessage(

                    "§cYou do not own "
                    + type.name()
                    + " ability!"

            );



            return false;


        }









        /*
        Maximum level check
        */


        if(power.getLevel()
                >= MAX_LEVEL){



            player.sendMessage(

                    "§c"
                    + type.name()
                    + " is already MAX level!"

            );



            return false;


        }









        /*
        Upgrade cost

        Level 1 -> 2 = 10
        Level 2 -> 3 = 20
        Level 3 -> 4 = 30
        Level 4 -> 5 = 40

        */


        int cost =

                power.getLevel()
                * 10;









        /*
        Check essence
        */


        int essence =

                plugin
                .getDatabase()
                .getEssence(

                        player.getUniqueId()

                );







        if(essence < cost){



            player.sendMessage(

                    "§cYou need §e"
                    + cost
                    + " Essence §cto upgrade!"

            );



            return false;


        }









        /*
        Remove essence
        */


        plugin
        .getDatabase()
        .removeEssence(

                player.getUniqueId(),

                cost

        );









        /*
        Increase level
        */


        power.setLevel(

                power.getLevel()+1

        );









        /*
        Save power
        */


        repository.save(

                player.getUniqueId(),

                power

        );









        player.sendMessage(

                "§a✦ "
                + type.name()
                + " upgraded to Level §e"
                + power.getLevel()

        );



        player.sendMessage(

                "§7Cost: §c-"
                + cost
                + " Essence"

        );







        return true;



    }








    public int getUpgradeCost(

            Player player,

            PowerType type

    ){



        PlayerPower power =

                getPower(

                        player,

                        type

                );



        return power.getLevel()*10;


    }








    public boolean hasPower(

            Player player,

            PowerType type

    ){



        return getPower(

                player,

                type

        ).isOwned();


    }






}