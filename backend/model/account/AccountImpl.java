package backend.model.account;

import backend.model.achievement.Achievement;
import backend.model.achievement.AchievementList;
import backend.model.achievement.AchievementListImpl;
import backend.model.resume.Resume;
import backend.model.resume.ResumeList;
import backend.model.resume.ResumeListImpl;

public class AccountImpl implements Account {

    private final PersonName personName;
    private final AchievementList achievements;
    private final ResumeList resumes;

    public static AccountImpl DEFAULT_ACCOUNT = new AccountImpl(
            PersonName.getDefaultName(),
            AchievementListImpl.getEmptyList(),
            ResumeListImpl.getEmptyList());

    public AccountImpl(PersonName name, AchievementList achievements, ResumeList resumes) {
        this.personName = name;
        this.achievements = achievements;
        this.resumes = resumes;
    }

    @Override
    public PersonName getPersonName() {
        return personName;
    }

    @Override
    public AchievementList getAchievementList() {
        return achievements;
    }

    @Override
    public ResumeList getResumeList() {
        return resumes;
    }

    @Override
    public Resume getResume(int index) {
        return resumes.get(index);
    }

    @Override
    public int getNumAchievements() {
        return achievements.getNumAchievements();
    }

    @Override
    public void addAchievement(Achievement achievement) {
        achievements.add(achievement);
    }

    @Override
    public void removeAchievement(int index) {
        achievements.remove(index);
    }

    @Override
    public void addResume(Resume resume) {
        resumes.add(resume);
    }

    @Override
    public void removeResume(int index) {
        resumes.remove(index);
    }

    @Override
    public String toString() {
        return getPersonName().toString();
    }

}
