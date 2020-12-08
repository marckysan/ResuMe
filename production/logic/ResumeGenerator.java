package production.logic;

import production.model.achievement.AchievementList;
import production.model.resume.ResumeImpl;

public interface ResumeGenerator {
    boolean isValidIndex(int index);
    void selectAchievement(int index);
    void deselectAchievement(int index);
    ResumeImpl generateResume(AchievementList achievements);
}
