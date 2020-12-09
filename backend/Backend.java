package backend;

import backend.exception.UninitializedGeneratorException;
import backend.logic.ResumeGenerator;
import backend.logic.ResumeGeneratorImpl;
import backend.model.achievement.*;
import backend.model.person.Person;
import backend.model.person.PersonImpl;
import backend.model.person.PersonName;
import backend.model.resume.Resume;
import backend.model.resume.ResumeList;
import backend.model.resume.ResumeListImpl;
import backend.storage.Storage;
import backend.storage.StorageImpl;

public class Backend {

    private final Person person;
    private final Storage storage;
    private ResumeGenerator generator = null;

    private static final Backend BACKEND = new Backend(new PersonImpl(
            new PersonName("Joshua Chew"), new AchievementListImpl(), new ResumeListImpl()));

    private Backend(Person person) {
        this.person = person;
        this.storage = new StorageImpl();
    }

    public static Backend getBackend() {
        return BACKEND;
    }

    public Person getPerson() {
        return person;
    }

    public AchievementList getAchievements() {
        return person.getAchievements();
    }

    public ResumeList getResumes() {
        return person.getResumes();
    }

    public int getNumAchievements() {
        return person.getNumAchievements();
    }

    public void addAchievement(Achievement achievement) {
        person.addAchievement(achievement);
        storage.save(person);
    }

    public void removeAchievement(Achievement achievement) {
        person.removeAchievement(achievement);
        storage.save(person);
    }

    public void addResume(Resume resume) {
        person.addResume(resume);
        storage.save(person);
    }

    public void removeResume(Resume resume) {
        person.removeResume(resume);
        storage.save(person);
    }

    public void selectAchievement(int index) {
        if (generator == null) {
            generator = new ResumeGeneratorImpl(getNumAchievements());
        }
        generator.selectAchievement(index);
    }

    public void deselectAchievement(int index) {
        if (generator == null) {
            generator = new ResumeGeneratorImpl(getNumAchievements());
        }
        generator.deselectAchievement(index);
    }

    public Resume generateResume() {
        if (generator == null) {
            throw new UninitializedGeneratorException();
        }
        return generator.generateResume(person.getAchievements());
    }

    public static void main(String[] args) {
        Backend backend = getBackend();

        backend.addAchievement(new PersonalProject(new AchievementName("ResuMe"), new AchievementContents("Wrote the backend.")));
        backend.addAchievement(new PersonalProject(new AchievementName("The Tower"), new AchievementContents("Implemented on Pygame.")));
        backend.addAchievement(new PersonalProject(new AchievementName("Tweevestigator"), new AchievementContents("Using Tweepy framework.")));
        backend.addAchievement(new PersonalProject(new AchievementName("Duke"), new AchievementContents("Individual project for CS2103.")));
        backend.addAchievement(new PersonalProject(new AchievementName("TAskmaster"), new AchievementContents("Team project for CS2103.")));
        backend.addAchievement(new PersonalProject(new AchievementName("Sudoku Solver"), new AchievementContents("Used Tkinter for GUI.")));
        backend.removeAchievement(new PersonalProject(new AchievementName("Sudoku Solver"), new AchievementContents("Used Tkinter for GUI.")));

        backend.selectAchievement(0);
        backend.selectAchievement(1);
        backend.selectAchievement(2);
        backend.selectAchievement(3);
        backend.selectAchievement(4);
        backend.deselectAchievement(4);
        backend.selectAchievement(4);
        Resume resume = backend.generateResume();
        backend.addResume(resume);
    }

}
