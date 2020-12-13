package backend.model.person;

import backend.model.achievement.Achievement;
import backend.model.achievement.AchievementList;
import backend.model.achievement.AchievementListImpl;
import backend.model.resume.Resume;
import backend.model.resume.ResumeList;
import backend.model.resume.ResumeListImpl;

public class PersonImpl implements Person {

    private final PersonName name;
    private final AchievementList achievements;
    private final ResumeList resumes;

    public static PersonImpl DEFAULT_PERSON = new PersonImpl(
            PersonName.getDefaultName(),
            AchievementListImpl.getEmptyList(),
            ResumeListImpl.getEmptyList());

    public PersonImpl(PersonName name, AchievementList achievements, ResumeList resumes) {
        this.name = name;
        this.achievements = achievements;
        this.resumes = resumes;
    }

    @Override
    public PersonName getName() {
        return name;
    }

    @Override
    public Achievement getAchievement(int index) {
        return achievements.get(index);
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
        return getName().toString();
    }

}
