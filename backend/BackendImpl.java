package backend;

import backend.exception.CorruptedPersonDataException;
import backend.exception.AchievementsNotSelectedYetException;
import backend.exception.ModifyOnGenerationException;
import backend.logic.ResumeGenerator;
import backend.logic.ResumeGeneratorImpl;
import backend.logic.ResumeSaver;
import backend.logic.ResumeSaverImpl;
import backend.model.achievement.Achievement;
import backend.model.achievement.AchievementList;
import backend.model.achievement.PersonalProject;
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
    public Achievement getAchievement(int index) {
        return person.getAchievement(index);
    }

    @Override
    public AchievementList getAchievements() {
        return person.getAchievementList();
    }

    @Override
    public ResumeList getResumes() {
        return person.getResumeList();
    }

    @Override
    public void addPersonalProject(String name, String description) throws ModifyOnGenerationException {
        if (generator != null) {
            throw new ModifyOnGenerationException();
        }
        Achievement project = PersonalProject.of(name, description);
        person.addAchievement(project);
        storage.save(person);
    }

    @Override
    public void removeAchievement(int index) throws ModifyOnGenerationException {
        if (generator != null) {
            throw new ModifyOnGenerationException();
        }
        person.removeAchievement(index);
        storage.save(person);
    }

    @Override
    public void removeResume(int index) {
        person.removeResume(index);
        storage.save(person);
    }

    @Override
    public void selectAchievement(int index) {
        if (generator == null) {
            generator = new ResumeGeneratorImpl(person.getNumAchievements());
        }
        generator.selectAchievement(index);
    }

    @Override
    public void deselectAchievement(int index) {
        if (generator == null) {
            generator = new ResumeGeneratorImpl(person.getNumAchievements());
        }
        generator.deselectAchievement(index);
    }

    @Override
    public Resume getResume(int index) {
        return person.getResume(index);
    }

    @Override
    public void generateAndAddResume(String resumeName) {
        if (generator == null) {
            throw new AchievementsNotSelectedYetException();
        }
        Resume resume = generator.generateResume(person.getAchievementList(), resumeName);
        person.addResume(resume);
        generator = null;
        storage.save(person);
    }

    @Override
    public void saveAsPdf(int index) {
        saver.saveAsPdf(person.getResume(index));
    }

}
