package backend;

import backend.model.achievement.AchievementList;
import backend.model.person.Person;
import backend.model.resume.Resume;
import backend.model.resume.ResumeList;

public interface Backend {
    Person getPerson();
    AchievementList getAchievements();
    ResumeList getResumes();
    int getNumAchievements();
    void addPersonalProject(String name, String description);
    void removeAchievement(int index);
    void addResume(Resume resume);
    void removeResume(Resume resume);
    void selectAchievement(int index);
    void deselectAchievement(int index);
    Resume generateResume();
    void saveAsPdf(Resume resume);
}
