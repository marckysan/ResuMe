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
    public AchievementList getAchievements() {
        return achievements;
    }

    @Override
    public ResumeList getResumes() {
        return resumes;
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

}
