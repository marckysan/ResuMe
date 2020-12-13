package backend.model.person;

import backend.model.achievement.Achievement;
import backend.model.achievement.AchievementList;
import backend.model.resume.Resume;
import backend.model.resume.ResumeList;

public interface Person {
    PersonName getName();
    Achievement getAchievement(int index);
    AchievementList getAchievementList();
    ResumeList getResumeList();
    Resume getResume(int index);
    int getNumAchievements();
    void addAchievement(Achievement achievement);
    void removeAchievement(int index);
    void addResume(Resume resume);
    void removeResume(int index);
}
