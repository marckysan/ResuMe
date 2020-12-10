package backend;

import backend.model.achievement.Achievement;
import backend.model.achievement.AchievementList;
import backend.model.person.Person;
import backend.model.resume.Resume;
import backend.model.resume.ResumeList;

public interface Backend {
    Person getPerson();
    AchievementList getAchievements();
    ResumeList getResumes();
    int getNumAchievements();
    void addAchievement(Achievement achievement);
    void removeAchievement(Achievement achievement);
    void addResume(Resume resume);
    void removeResume(Resume resume);
    void selectAchievement(int index);
    void deselectAchievement(int index);
    Resume generateResume();
}
