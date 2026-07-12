package com.infusequest.gui;


import com.infusequest.quest.Quest;
import com.infusequest.quest.daily.DailyQuestManager;
import com.infusequest.quest.daily.PlayerDailyQuest;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


import java.util.ArrayList;
import java.util.List;



public class QuestGUI {



    public static void open(
            Player player,
            DailyQuestManager manager
    ){


        Inventory inv =
                Bukkit.createInventory(
                        null,
                        45,
                        "§8✦ Daily Quests"
                );





        /*
         * ===================
         * BORDER
         * ===================
         */


        ItemStack border =
                createItem(
                        Material.GRAY_STAINED_GLASS_PANE,
                        " "
                );



        for(int i = 0; i < 45; i++){

            inv.setItem(
                    i,
                    border
            );

        }







        /*
         * ===================
         * PLAYER INFO
         * ===================
         */


        inv.setItem(
                4,

                createItem(
                        Material.PLAYER_HEAD,
                        "§6PERRIN",

                        "§7Player: §f" + player.getName(),

                        "",

                        "§eDaily Quest System"
                )

        );









        /*
         * ===================
         * QUEST ITEMS
         * ===================
         */


        List<PlayerDailyQuest> quests =
                manager.getQuests(player);



        int slot = 10;



        for(PlayerDailyQuest pq : quests){



            Quest quest =
                    manager.getQuest(
                            pq.getQuestId()
                    );



            if(quest == null){

                continue;

            }





            Material material =
                    pq.isCompleted()

                    ?

                    Material.LIME_STAINED_GLASS

                    :

                    Material.BOOK;







            List<String> lore =
                    new ArrayList<>();



            lore.add(
                    "§7Difficulty: §f"
                    +
                    quest.getDifficulty()
            );



            lore.add("");



            lore.add(
                    "§7Progress:"
            );



            lore.add(
                    createProgressBar(
                            pq.getProgress(),
                            quest.getAmount()
                    )
            );



            lore.add(
                    "§f"
                    +
                    pq.getProgress()
                    +
                    "/"
                    +
                    quest.getAmount()
            );



            lore.add("");



            lore.add(
                    "§aReward: §e✦ "
                    +
                    quest.getEssence()
                    +
                    " Essence"
            );




            if(pq.isCompleted()){


                lore.add("");

                lore.add(
                        "§a✔ Completed"
                );


            }





            inv.setItem(

                    slot,

                    createItem(

                            material,

                            "§b"
                            +
                            quest.getName(),

                            lore.toArray(
                                    new String[0]
                            )

                    )

            );





            slot++;



            if(slot == 17){

                slot = 19;

            }



        }









        /*
         * ===================
         * FOOTER
         * ===================
         */


        inv.setItem(

                40,

                createItem(

                        Material.NETHER_STAR,

                        "§dPERRIN",

                        "§7InfuseQuest"

                )

        );







        player.openInventory(inv);





        GUIManager.open(

                player,

                "QUEST"

        );



    }









    private static String createProgressBar(

            int current,

            int max

    ){



        if(max <= 0){

            max = 1;

        }



        int bars = 10;



        double percentage =
                (double) current / max;



        int filled =
                (int)(percentage * bars);




        StringBuilder bar =
                new StringBuilder();




        for(int i = 0; i < bars; i++){


            if(i < filled){

                bar.append("§a█");

            }else{

                bar.append("§7░");

            }


        }



        return bar.toString();

    }









    private static ItemStack createItem(

            Material material,

            String name,

            String... lore

    ){



        ItemStack item =
                new ItemStack(material);



        ItemMeta meta =
                item.getItemMeta();



        if(meta != null){


            meta.setDisplayName(name);


            meta.setLore(
                    List.of(lore)
            );


            item.setItemMeta(meta);


        }



        return item;


    }



}