package production.user;

import production.achievement.AchievementList;
import production.achievement.Achievement;

public interface User {
    PersonName getName();
    AchievementList getAchievements();
    void addAchievement(Achievement achievement);
    void removeAchievement(Achievement achievement);
}
