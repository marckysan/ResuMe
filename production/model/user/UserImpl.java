package production.model.user;

import production.model.achievement.*;
import production.model.resume.Resume;
import production.model.resume.ResumeList;
import production.model.resume.ResumeListImpl;

public class UserImpl implements User {

    private final PersonName name;
    private final AchievementList achievements;
    private final ResumeList resumes;

    public UserImpl(PersonName name, AchievementList achievements, ResumeList resumes) {
        this.name = name;
        this.achievements = achievements;
        this.resumes = resumes;
    }

    @Override
    public PersonName getName() {
        return name;
    }

    @Override
    public AchievementList getAchievements() {
        return achievements;
    }

    @Override
    public ResumeList getResumes() {
        return resumes;
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
    public void addResume(Resume resume) {
        resumes.add(resume);
    }

    @Override
    public void removeResume(Resume resume) {
        resumes.remove(resume);
    }

    @Override
    public String toString() {
        return getName().toString();
    }

    public static void main(String[] args) {
        User joshua = new UserImpl(new PersonName("Joshua Chew"), new AchievementListImpl(), new ResumeListImpl());
        joshua.addAchievement(new PersonalProject(new AchievementName("ResuMe"), new AchievementContents("Wrote the backend.")));
        joshua.addAchievement(new PersonalProject(new AchievementName("The Tower"), new AchievementContents("Implemented on Pygame.")));
        joshua.addAchievement(new PersonalProject(new AchievementName("Tweevestigator"), new AchievementContents("Using Tweepy framework.")));
        joshua.addAchievement(new PersonalProject(new AchievementName("Duke"), new AchievementContents("Individual project for CS2103.")));
        joshua.addAchievement(new PersonalProject(new AchievementName("TAskmaster"), new AchievementContents("Team project for CS2103.")));
        joshua.addAchievement(new PersonalProject(new AchievementName("Sudoku Solver"), new AchievementContents("Used Tkinter for GUI.")));
        joshua.removeAchievement(new PersonalProject(new AchievementName("Sudoku Solver"), new AchievementContents("Used Tkinter for GUI.")));
        AchievementList achievements = joshua.getAchievements();
        System.out.println(achievements.toString());
    }

}
