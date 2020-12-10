package backend.model.account;

import backend.model.achievement.Achievement;
import backend.model.achievement.AchievementList;
import backend.model.resume.Resume;
import backend.model.resume.ResumeList;

public interface Account {
    PersonName getPersonName();
    AchievementList getAchievementList();
    ResumeList getResumeList();
    Resume getResume(int index);
    int getNumAchievements();
    void addAchievement(Achievement achievement);
    void removeAchievement(int index);
    void addResume(Resume resume);
    void removeResume(int index);
}
