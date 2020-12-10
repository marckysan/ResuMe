package backend;

import backend.exception.CorruptedPersonDataException;
import backend.exception.AchievementsNotSelectedYetException;
import backend.exception.ModifyOnGenerationException;
import backend.logic.ResumeGenerator;
import backend.logic.ResumeGeneratorImpl;
import backend.logic.ResumeSaver;
import backend.logic.ResumeSaverImpl;
import backend.login.LoginManager;
import backend.login.LoginManagerImpl;
import backend.model.achievement.Achievement;
import backend.model.achievement.AchievementList;
import backend.model.achievement.PersonalProject;
import backend.model.account.Account;
import backend.model.account.AccountImpl;
import backend.model.resume.Resume;
import backend.model.resume.ResumeList;
import backend.storage.Storage;
import backend.storage.StorageImpl;

public class BackendImpl implements Backend {

    private LoginManager loginManager = new LoginManagerImpl();

    private Account account;

    private ResumeGenerator generator = null;
    private final ResumeSaver saver = new ResumeSaverImpl();

    private final Storage storage = new StorageImpl();

    private static final BackendImpl BACKEND = new BackendImpl();

    private BackendImpl() {
        try {
            this.account = storage.load();
        } catch (CorruptedPersonDataException e) {
            System.out.println(e.getMessage());
            this.account = AccountImpl.DEFAULT_ACCOUNT;
        }
    }

    public static BackendImpl getBackend() {
        return BACKEND;
    }

    @Override
    public boolean isLoggedIn() {
        return loginManager.isLoggedIn();
    }

    @Override
    public void login() {
        loginManager.login();
    }

    @Override
    public void logout() {
        loginManager.logout();
    }

    @Override
    public void register() {
        loginManager.register();
    }

    @Override
    public Account getAccount() {
        return account;
    }

    @Override
    public AchievementList getAchievements() {
        return account.getAchievementList();
    }

    @Override
    public ResumeList getResumes() {
        return account.getResumeList();
    }

    @Override
    public void addPersonalProject(String name, String description) throws ModifyOnGenerationException {
        if (generator != null) {
            throw new ModifyOnGenerationException();
        }
        Achievement project = PersonalProject.of(name, description);
        account.addAchievement(project);
        storage.save(account);
    }

    @Override
    public void removeAchievement(int index) throws ModifyOnGenerationException {
        if (generator != null) {
            throw new ModifyOnGenerationException();
        }
        account.removeAchievement(index);
        storage.save(account);
    }

    @Override
    public void removeResume(int index) {
        account.removeResume(index);
        storage.save(account);
    }

    @Override
    public void selectAchievement(int index) {
        if (generator == null) {
            generator = new ResumeGeneratorImpl(account.getNumAchievements());
        }
        generator.selectAchievement(index);
    }

    @Override
    public void deselectAchievement(int index) {
        if (generator == null) {
            generator = new ResumeGeneratorImpl(account.getNumAchievements());
        }
        generator.deselectAchievement(index);
    }

    @Override
    public void generateAndAddResume(String resumeName) {
        if (generator == null) {
            throw new AchievementsNotSelectedYetException();
        }
        Resume resume = generator.generateResume(account.getAchievementList(), resumeName);
        account.addResume(resume);
        generator = null;
        storage.save(account);
    }

    @Override
    public void saveAsPdf(int index) {
        saver.saveAsPdf(account.getResume(index));
    }

}
