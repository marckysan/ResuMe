package backend.logic;

import backend.exception.InvalidIndexException;
import backend.model.achievement.AchievementContents;
import backend.model.achievement.AchievementList;
import backend.model.achievement.AchievementName;
import backend.model.resume.ResumeContents;
import backend.model.resume.ResumeImpl;
import backend.model.resume.ResumeName;

public class ResumeGeneratorImpl implements ResumeGenerator {

    private final int numAchievements;
    private final AchievementSelector selector;

    public ResumeGeneratorImpl(int numAchievements) {
        this.numAchievements = numAchievements;
        this.selector = new AchievementSelector(numAchievements);
    }

    @Override
    public boolean isValidIndex(int index) {
        return 0 <= index && index < numAchievements;
    }

    @Override
    public void selectAchievement(int index) throws InvalidIndexException {
        if (!isValidIndex(index)) {
            throw new InvalidIndexException();
        }
        selector.select(index);
    }

    @Override
    public void deselectAchievement(int index) throws InvalidIndexException {
        if (!isValidIndex(index)) {
            throw new InvalidIndexException();
        }
        selector.deselect(index);
    }

    @Override
    public ResumeImpl generateResume(AchievementList achievements, String resumeName) {
        String resumeText = "Achievements:" + "\n";
        for (Integer index : selector.getSelection()) {
            AchievementName name = achievements.getAchievementName(index);
            AchievementContents contents = achievements.getAchievementContents(index);
            String achievementText = "- " + name.toString() + ": " + contents.toString();
            resumeText += achievementText + "\n";
        }
        return new ResumeImpl(new ResumeName(resumeName), new ResumeContents(resumeText));
    }

}
