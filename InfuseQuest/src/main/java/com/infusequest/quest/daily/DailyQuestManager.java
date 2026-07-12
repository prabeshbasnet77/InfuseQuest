package com.infusequest.quest.daily;


import com.infusequest.InfuseQuest;
import com.infusequest.database.DailyQuestRepository;
import com.infusequest.quest.Quest;


import org.bukkit.entity.Player;


import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;



public class DailyQuestManager {



    private final DailyQuestRepository repository;
    
    private final Map<java.util.UUID, List<PlayerDailyQuest>> playerQuests = new HashMap<>();



    private final int DAILY_AMOUNT = 3;




    public DailyQuestManager(
            InfuseQuest plugin
    ){

        repository =
                new DailyQuestRepository(plugin);

    }




    /**
     * Get daily quests for a player.
     * If the player needs a reset (new day), reset their quests.
     * If they have no quests, generate new ones.
     * 
     * @param player The player to get quests for
     * @return List of PlayerDailyQuest objects
     */
    public List<PlayerDailyQuest> getQuests(
            Player player
    ){

        java.util.UUID playerUUID = player.getUniqueId();

        if(repository.needsReset(playerUUID)){
            repository.reset(playerUUID);
            playerQuests.remove(playerUUID);
        }

        // Check if player already has quests in memory
        if(playerQuests.containsKey(playerUUID)){
            List<PlayerDailyQuest> quests = playerQuests.get(playerUUID);
            if(!quests.isEmpty()){
                return quests;
            }
        }

        // Generate new quests
        List<PlayerDailyQuest> quests = new ArrayList<>();

        List<Quest> random =
                DailyQuestPool.getRandomQuests(
                        DAILY_AMOUNT
                );

        for(Quest quest : random){

            PlayerDailyQuest daily =
                    new PlayerDailyQuest(
                            quest.getId()
                    );

            repository.save(
                    playerUUID,
                    daily
            );

            quests.add(daily);

        }

        // Cache in memory
        playerQuests.put(playerUUID, quests);

        return quests;

    }




    /**
     * Get a quest by its ID from the daily quest pool.
     * 
     * @param id The quest ID
     * @return Quest object or null if not found
     */
    public Quest getQuest(String id){
        
        for(Quest quest :
                DailyQuestPool.getAll()){

            if(quest.getId()
                    .equalsIgnoreCase(id)){

                return quest;

            }

        }

        return null;

    }


    /**
     * Update progress for a specific daily quest.
     * 
     * @param player The player updating their quest
     * @param questID The quest ID to update
     * @param amount The amount to add to progress
     */
    public void updateProgress(
            Player player,
            String questID,
            int amount
    ){

        java.util.UUID playerUUID = player.getUniqueId();
        
        List<PlayerDailyQuest> quests =
                getQuests(player);

        for(PlayerDailyQuest quest : quests){

            if(
                    quest.getQuestId()
                    .equalsIgnoreCase(questID)

            ){

                quest.setProgress(
                        quest.getProgress()
                        + amount
                );

                repository.update(
                        playerUUID,
                        quest
                );

            }

        }

    }

    /**
     * Clear player quests from cache when they disconnect.
     * 
     * @param player The player disconnecting
     */
    public void clearPlayerCache(Player player) {
        playerQuests.remove(player.getUniqueId());
    }


}
