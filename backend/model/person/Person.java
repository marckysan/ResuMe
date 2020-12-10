package backend.model.person;

import backend.model.achievement.Achievement;
import backend.model.achievement.AchievementList;
import backend.model.resume.Resume;
import backend.model.resume.ResumeList;

public interface Person {
    PersonName getName();
    AchievementList getAchievements();
    ResumeList getResumes();
    int getNumAchievements();
    void addAchievement(Achievement achievement);
    void removeAchievement(Achievement achievement);
    void removeAchievement(int index);
    void addResume(Resume resume);
    void removeResume(Resume resume);
    void removeResume(int index);
}
