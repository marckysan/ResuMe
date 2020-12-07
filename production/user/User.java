package production.user;

import production.achievement.Achievement;
import production.achievement.AchievementList;

public interface User {
    PersonName getName();
    AchievementList getAchievements();
    void addAchievement(Achievement achievement);
    void removeAchievement(Achievement achievement);
}
