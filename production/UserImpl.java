import achievement.*;

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
    public void removeAchievement(Achievement achievement) {
        achievements.remove(achievement);
    }

    @Override
    public String toString() {
        return getName();
    }

    public static void main(String[] args) {
        User joshua = new UserImpl("Joshua Chew", new AchievementListImpl());
        joshua.addAchievement(new PersonalProject(new AchievementName("ResuMe"), new AchievementDescription("Wrote the backend.")));
        joshua.addAchievement(new PersonalProject(new AchievementName("The Tower"), new AchievementDescription("Implemented on Pygame.")));
        joshua.addAchievement(new PersonalProject(new AchievementName("Tweevestigator"), new AchievementDescription("Using Tweepy framework.")));
        joshua.addAchievement(new PersonalProject(new AchievementName("Duke"), new AchievementDescription("Individual project for CS2103.")));
        joshua.addAchievement(new PersonalProject(new AchievementName("TAskmaster"), new AchievementDescription("Team project for CS2103.")));
        joshua.addAchievement(new PersonalProject(new AchievementName("Sudoku Solver"), new AchievementDescription("Used Tkinter for GUI.")));
        joshua.removeAchievement(new PersonalProject(new AchievementName("Sudoku Solver"), new AchievementDescription("Used Tkinter for GUI.")));
        AchievementList achievements = joshua.getAchievements();
        System.out.println(achievements.toString());
    }

}
