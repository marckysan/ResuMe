package backend;

import backend.model.achievement.Achievement;
import backend.model.achievement.AchievementList;
import backend.model.person.Person;
import backend.model.resume.Resume;
import backend.model.resume.ResumeList;

public interface Backend {
    Person getPerson();

    Achievement getAchievement(int index);
    AchievementList getAchievements();
    void addPersonalProject(String name, String description);
    void removeAchievement(int index);

    void selectAchievement(int index);
    void deselectAchievement(int index);

    Resume getResume(int index);
    ResumeList getResumes();
    void generateAndAddResume(String resumeName);
    void removeResume(int index);
    void saveAsPdf(int index);
}
