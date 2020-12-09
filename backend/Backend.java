package backend;

import backend.exception.CorruptedPersonDataException;
import backend.exception.UninitializedGeneratorException;
import backend.logic.ResumeGenerator;
import backend.logic.ResumeGeneratorImpl;
import backend.model.achievement.Achievement;
import backend.model.achievement.AchievementList;
import backend.model.achievement.AchievementListImpl;
import backend.model.person.Person;
import backend.model.person.PersonImpl;
import backend.model.person.PersonName;
import backend.model.resume.Resume;
import backend.model.resume.ResumeList;
import backend.model.resume.ResumeListImpl;
import backend.storage.Storage;
import backend.storage.StorageImpl;

public class Backend {

    private Person person;
    private ResumeGenerator generator = null;
    private final Storage storage;

    private static final Backend BACKEND = new Backend();

    private Backend() {
        this.storage = new StorageImpl();
        try {
            this.person = storage.load();
        } catch (CorruptedPersonDataException e) {
            System.out.println(e.getMessage());
            this.person = new PersonImpl(new PersonName("Default Person"), new AchievementListImpl(), new ResumeListImpl());
        }
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
        Resume resume = generator.generateResume(person.getAchievements());
        generator = null;
        return resume;
    }

    public static void main(String[] args) {
        Backend backend = getBackend();
    }

}
