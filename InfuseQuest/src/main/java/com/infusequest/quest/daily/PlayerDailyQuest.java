package com.infusequest.quest.daily;

public class PlayerDailyQuest {

    private final String questId;
    private int progress;
    private boolean claimed;

    public PlayerDailyQuest(String questId) {
        this.questId = questId;
        this.progress = 0;
        this.claimed = false;
    }

    public String getQuestId() {
        return questId;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public boolean isClaimed() {
        return claimed;
    }

    public void setClaimed(boolean claimed) {
        this.claimed = claimed;
    }

}