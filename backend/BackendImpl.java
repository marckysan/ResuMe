package backend;

import backend.exception.CorruptedPersonDataException;
import backend.exception.UninitializedGeneratorException;
import backend.logic.ResumeGenerator;
import backend.logic.ResumeGeneratorImpl;
import backend.logic.ResumeSaver;
import backend.logic.ResumeSaverImpl;
import backend.model.achievement.Achievement;
import backend.model.achievement.AchievementList;
import backend.model.person.Person;
import backend.model.person.PersonImpl;
import backend.model.resume.Resume;
import backend.model.resume.ResumeList;
import backend.storage.Storage;
import backend.storage.StorageImpl;

public class BackendImpl implements Backend {

    private Person person;
    private ResumeGenerator generator = null;
    private final ResumeSaver saver = new ResumeSaverImpl();
    private final Storage storage = new StorageImpl();

    private static final BackendImpl BACKEND = new BackendImpl();

    private BackendImpl() {
        try {
            this.person = storage.load();
        } catch (CorruptedPersonDataException e) {
            System.out.println(e.getMessage());
            this.person = PersonImpl.DEFAULT_PERSON;
        }
    }

    public static BackendImpl getBackend() {
        return BACKEND;
    }

    @Override
    public Person getPerson() {
        return person;
    }

    @Override
    public AchievementList getAchievements() {
        return person.getAchievements();
    }

    @Override
    public ResumeList getResumes() {
        return person.getResumes();
    }

    @Override
    public int getNumAchievements() {
        return person.getNumAchievements();
    }

    @Override
    public void addAchievement(Achievement achievement) {
        person.addAchievement(achievement);
        storage.save(person);
    }

    @Override
    public void removeAchievement(Achievement achievement) {
        person.removeAchievement(achievement);
        storage.save(person);
    }

    @Override
    public void addResume(Resume resume) {
        person.addResume(resume);
        storage.save(person);
    }

    @Override
    public void removeResume(Resume resume) {
        person.removeResume(resume);
        storage.save(person);
    }

    @Override
    public void selectAchievement(int index) {
        if (generator == null) {
            generator = new ResumeGeneratorImpl(getNumAchievements());
        }
        generator.selectAchievement(index);
    }

    @Override
    public void deselectAchievement(int index) {
        if (generator == null) {
            generator = new ResumeGeneratorImpl(getNumAchievements());
        }
        generator.deselectAchievement(index);
    }

    @Override
    public Resume generateResume() {
        if (generator == null) {
            throw new UninitializedGeneratorException();
        }
        Resume resume = generator.generateResume(person.getAchievements());
        generator = null;
        return resume;
    }

    @Override
    public void saveAsPdf(Resume resume) {
        saver.saveAsPdf(resume);
    }

}
