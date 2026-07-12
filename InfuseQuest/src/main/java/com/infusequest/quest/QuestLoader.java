package com.infusequest.quest;

import com.infusequest.InfuseQuest;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Loads quests from configuration files.
 * Supports dynamic quest definitions from config.yml and quests.yml
 */
public class QuestLoader {

    private final InfuseQuest plugin;

    private final List<Quest> quests = new ArrayList<>();

    public QuestLoader(InfuseQuest plugin) {
        this.plugin = plugin;
    }

    /**
     * Load all quests from configuration.
     * First loads hardcoded default quests, then loads from config files.
     */
    public void load() {

        FileConfiguration config = plugin.getConfig();

        quests.clear();

        // Load default quests
        loadDefaultQuests();

        // Try to load from quests.yml if it exists
        try {
            loadQuestsFromConfig(config);
        } catch (Exception e) {
            plugin.getLogger().warning("Could not load quests from config: " + e.getMessage());
        }

        plugin.getLogger().info("Loaded " + quests.size() + " quests");
    }

    /**
     * Load default hardcoded quests.
     * These are fallback quests if config is not available.
     */
    private void loadDefaultQuests() {
        
        // Zombie Hunter Quest
        quests.add(new Quest(
                "zombie",
                "§cZombie Hunter",
                QuestType.KILL_ENTITY,
                "ZOMBIE",
                25,
                2
        ));

        // Master Miner Quest
        quests.add(new Quest(
                "miner",
                "§6Master Miner",
                QuestType.BREAK_BLOCK,
                "STONE",
                128,
                2
        ));

        // Skeleton Slayer Quest
        quests.add(new Quest(
                "skeleton",
                "§7Skeleton Slayer",
                QuestType.KILL_ENTITY,
                "SKELETON",
                20,
                2
        ));

        // Wood Cutter Quest
        quests.add(new Quest(
                "woodcutter",
                "§aWood Cutter",
                QuestType.BREAK_BLOCK,
                "OAK_LOG",
                64,
                2
        ));

        // Spider Exterminator Quest
        quests.add(new Quest(
                "spider",
                "§4Spider Exterminator",
                QuestType.KILL_ENTITY,
                "SPIDER",
                15,
                2
        ));

        // Dirt Digger Quest
        quests.add(new Quest(
                "dirt",
                "§8Dirt Digger",
                QuestType.BREAK_BLOCK,
                "DIRT",
                256,
                2
        ));

    }

    /**
     * Load quests from the configuration file.
     * Expected format in config file:
     * 
     * daily-quests:
     *   quest_id:
     *     name: "Quest Name"
     *     type: "KILL_ENTITY or BREAK_BLOCK"
     *     entity/block: "ENTITY_TYPE or BLOCK_TYPE"
     *     amount: 10
     *     reward: 5
     * 
     * @param config The FileConfiguration to load from
     */
    private void loadQuestsFromConfig(FileConfiguration config) {
        
        // Try different possible config paths
        String[] configPaths = {
            "daily-quests",
            "daily.quests",
            "quests.daily"
        };

        for (String path : configPaths) {
            if (config.isConfigurationSection(path)) {
                loadQuestsFromSection(config, path);
                return;
            }
        }

    }

    /**
     * Load quests from a specific configuration section.
     * 
     * @param config The FileConfiguration
     * @param sectionPath The path to the quests section
     */
    private void loadQuestsFromSection(FileConfiguration config, String sectionPath) {
        
        var section = config.getConfigurationSection(sectionPath);
        
        if (section == null) {
            return;
        }

        Set<String> questIds = section.getKeys(false);

        for (String questId : questIds) {
            
            String fullPath = sectionPath + "." + questId;
            
            if (!config.isConfigurationSection(fullPath)) {
                continue;
            }

            try {
                
                String name = config.getString(fullPath + ".name", "Unknown Quest");
                String typeStr = config.getString(fullPath + ".type", "KILL_ENTITY");
                QuestType type = QuestType.valueOf(typeStr);
                
                String target = "";
                
                // Determine target based on quest type
                if (type == QuestType.KILL_ENTITY) {
                    List<String> entities = config.getStringList(fullPath + ".entity");
                    target = entities.isEmpty() ? "ZOMBIE" : entities.get(0);
                } else if (type == QuestType.BREAK_BLOCK) {
                    List<String> blocks = config.getStringList(fullPath + ".block");
                    target = blocks.isEmpty() ? "STONE" : blocks.get(0);
                }
                
                int amount = config.getInt(fullPath + ".amount", 10);
                int reward = config.getInt(fullPath + ".reward.essence", 1);
                
                // Check if quest already exists (from defaults)
                if (getQuest(questId) == null) {
                    quests.add(new Quest(questId, name, type, target, amount, reward));
                }
                
            } catch (IllegalArgumentException e) {
                plugin.getLogger().warning("Invalid quest type in config for quest: " + questId);
            }
            
        }

    }

    /**
     * Get all loaded quests.
     * 
     * @return List of all Quest objects
     */
    public List<Quest> getQuests() {
        return quests;
    }

    /**
     * Find a quest by its ID.
     * 
     * @param id The quest ID to find
     * @return Quest object or null if not found
     */
    public Quest getQuest(String id) {

        for (Quest quest : quests) {

            if (quest.getId().equalsIgnoreCase(id)) {
                return quest;
            }

        }

        return null;
    }

    /**
     * Add a quest to the list.
     * Useful for dynamic quest creation.
     * 
     * @param quest The quest to add
     */
    public void addQuest(Quest quest) {
        if (getQuest(quest.getId()) == null) {
            quests.add(quest);
        }
    }

    /**
     * Remove a quest from the list.
     * 
     * @param questId The ID of the quest to remove
     */
    public void removeQuest(String questId) {
        quests.removeIf(q -> q.getId().equalsIgnoreCase(questId));
    }

}
