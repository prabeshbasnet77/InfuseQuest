package com.infusequest.quest;

public class PlayerQuest {

    private final Quest quest;

    private int progress;

    private boolean completed;

    private boolean rewardClaimed;

    public PlayerQuest(Quest quest) {
        this.quest = quest;
        this.progress = 0;
        this.completed = false;
        this.rewardClaimed = false;
    }

    public Quest getQuest() {
        return quest;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;

        if (this.progress >= quest.getGoal()) {
            this.progress = quest.getGoal();
            this.completed = true;
        }
    }

    public void addProgress(int amount) {
        setProgress(progress + amount);
    }

    public boolean isCompleted() {
        return completed;
    }

    public boolean isRewardClaimed() {
        return rewardClaimed;
    }

    public void setRewardClaimed(boolean rewardClaimed) {
        this.rewardClaimed = rewardClaimed;
    }
}