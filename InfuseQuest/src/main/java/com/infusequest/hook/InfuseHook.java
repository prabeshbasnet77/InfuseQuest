package com.infusequest.hook;


import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;



public class InfuseHook {


    private final Plugin infusePlugin;



    public InfuseHook(){


        infusePlugin =
                Bukkit.getPluginManager()
                        .getPlugin("Infuse");


    }






    public boolean isEnabled(){


        return infusePlugin != null
                &&
                infusePlugin.isEnabled();


    }








    public boolean hasAbility(

            Player player,

            String ability

    ){



        if(!isEnabled()){

            return false;

        }




        try{


            Class<?> dataManager =

                    Class.forName(
                    "com.catadminer.infuseSMP.managers.DataManager"
                    );





            /*
            Search possible methods
            */


            for(Method method :
                    dataManager.getMethods()){


                String name =
                        method.getName()
                        .toLowerCase();





                if(
                name.contains("effect")
                ||
                name.contains("ability")
                ||
                name.contains("power")
                ){



                    Bukkit.getLogger()
                    .info(

                    "[InfuseQuest] Testing method: "
                    +
                    method.getName()

                    );



                }



            }



        }catch(Exception e){


            e.printStackTrace();


        }




        return false;


    }



}