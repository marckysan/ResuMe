package backend;

import backend.model.achievement.AchievementList;
import backend.model.person.Person;
import backend.model.resume.ResumeList;

public interface Backend {
    Person getPerson();
    AchievementList getAchievements();
    int getNumAchievements();
    ResumeList getResumes();

    void addPersonalProject(String name, String description);
    void removeAchievement(int index);

    void selectAchievement(int index);
    void deselectAchievement(int index);

    void generateAndAddResume();
    void removeResume(int index);
    void saveAsPdf(int index);
}
