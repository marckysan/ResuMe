package backend;

import backend.model.achievement.AchievementList;
import backend.model.account.Account;
import backend.model.resume.ResumeList;

public interface Backend {
    boolean isLoggedIn();
    void login();
    void logout();
    void register();

    Account getAccount();
    AchievementList getAchievements();
    ResumeList getResumes();

    void addPersonalProject(String name, String description);
    void removeAchievement(int index);

    void selectAchievement(int index);
    void deselectAchievement(int index);

    void generateAndAddResume(String resumeName);
    void removeResume(int index);
    void saveAsPdf(int index);
}
