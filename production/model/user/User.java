package production.model.user;

import production.model.achievement.Achievement;
import production.model.achievement.AchievementList;
import production.model.resume.Resume;
import production.model.resume.ResumeList;

public interface User {
    PersonName getName();
    AchievementList getAchievements();
    ResumeList getResumes();
    int getNumAchievements();
    void addAchievement(Achievement achievement);
    void removeAchievement(Achievement achievement);
    void addResume(Resume resume);
    void removeResume(Resume resume);

}
