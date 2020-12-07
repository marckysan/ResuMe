import achievement.AchievementList;
import achievement.Achievement;

public interface User {
    String getName();
    AchievementList getAchievements();
    void addAchievement(Achievement achievement);
}
