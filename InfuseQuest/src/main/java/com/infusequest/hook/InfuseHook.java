package com.infusequest.hook;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


public class InfuseHook {


    private final Plugin infusePlugin;



    public InfuseHook() {


        infusePlugin =
                Bukkit.getPluginManager()
                        .getPlugin("Infuse");


    }





    /**
     * Check if Infuse plugin exists and is enabled
     */
    public boolean isEnabled() {


        return infusePlugin != null
                &&
                infusePlugin.isEnabled();


    }





    /**
     * Debug hook connection
     */
    public void debugMethods() {


        Bukkit.getLogger()
                .info("[InfuseQuest] InfuseHook Debug Loaded");


        if(!isEnabled()) {


            Bukkit.getLogger()
                    .warning(
                            "[InfuseQuest] Infuse plugin not found!"
                    );


            return;

        }



        try {


            Class<?> dataManager =
                    Class.forName(
                            "com.catadminer.infuseSMP.managers.DataManager"
                    );



            Bukkit.getLogger()
                    .info(
                            "[InfuseQuest] Searching Infuse methods..."
                    );




            for(Method method : dataManager.getMethods()) {


                if(!Modifier.isPublic(method.getModifiers())) {

                    continue;

                }



                String name =
                        method.getName()
                                .toLowerCase();




                if(
                        name.contains("effect")
                        ||
                        name.contains("ability")
                        ||
                        name.contains("power")
                        ||
                        name.contains("has")
                        ||
                        name.contains("get")
                ) {



                    Bukkit.getLogger()
                            .info(
                                    "[InfuseQuest] Found method: "
                                            +
                                            method.getName()
                            );


                }



            }




        } catch (Exception e) {


            Bukkit.getLogger()
                    .warning(
                            "[InfuseQuest] Failed loading Infuse DataManager"
                    );


            e.printStackTrace();


        }


    }







    /**
     * Check player ability from Infuse
     */
    public boolean hasAbility(
            Player player,
            String ability
    ) {



        if(!isEnabled()) {


            return false;


        }





        try {


            Class<?> dataManager =
                    Class.forName(
                            "com.catadminer.infuseSMP.managers.DataManager"
                    );





            /*
             Future reflection connection.
             Currently only scans methods.
             Actual method call depends on
             Infuse plugin API.
            */



            for(Method method :
                    dataManager.getMethods()) {



                String methodName =
                        method.getName()
                                .toLowerCase();




                if(
                        methodName.contains("ability")
                        ||
                        methodName.contains("power")
                        ||
                        methodName.contains("effect")
                ) {



                    Bukkit.getLogger()
                            .info(
                                    "[InfuseQuest] Checking method: "
                                            +
                                            method.getName()
                            );


                }



            }



        } catch(Exception e) {


            e.printStackTrace();


        }




        return false;


    }





}