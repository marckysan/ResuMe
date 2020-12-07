import achievement.Achievement;
import achievement.AchievementList;
import achievement.AchievementListImpl;
import achievement.PersonalProject;

public class UserImpl implements User {

    private final String name;
    private final AchievementList achievements;

    public UserImpl(String name, AchievementList achievements) {
        this.name = name;
        this.achievements = achievements;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public AchievementList getAchievements() {
        return achievements;
    }

    @Override
    public void addAchievement(Achievement achievement) {
        achievements.add(achievement);
    }

    @Override
    public String toString() {
        return getName();
    }

    public static void main(String[] args) {
        User joshua = new UserImpl("Joshua Chew", new AchievementListImpl());
        joshua.addAchievement(new PersonalProject("ResuMe", "Wrote the backend."));
        joshua.addAchievement(new PersonalProject("The Tower", "Implemented on Pygame."));
        joshua.addAchievement(new PersonalProject("Tweevestigator", "Using Tweepy framework."));
        joshua.addAchievement(new PersonalProject("Duke", "Individual project for CS2103."));
        joshua.addAchievement(new PersonalProject("TAskmaster", "Team project for CS2103."));
        joshua.addAchievement(new PersonalProject("Sudoku Solver", "Used Tkinter for GUI."));
        AchievementList achievements = joshua.getAchievements();
        System.out.println(achievements.toString());
    }

}
