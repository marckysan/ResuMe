package backend.logic;

import backend.model.achievement.AchievementList;
import backend.model.resume.ResumeImpl;

public interface ResumeGenerator {
    boolean isValidIndex(int index);
    void selectAchievement(int index);
    void deselectAchievement(int index);
    ResumeImpl generateResume(AchievementList achievements, String resumeName);
}
