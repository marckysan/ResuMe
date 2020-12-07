package production.user;

import production.achievement.Achievement;
import production.achievement.AchievementList;
import production.resume.Resume;
import production.resume.ResumeList;

public interface User {
    PersonName getName();
    AchievementList getAchievements();
    ResumeList getResumes();
    void addAchievement(Achievement achievement);
    void removeAchievement(Achievement achievement);
    void addResume(Resume resume);
    void removeResume(Resume resume);

}
