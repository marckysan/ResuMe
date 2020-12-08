package production.logic;

import production.exception.InvalidAchievementIndexException;
import production.model.achievement.AchievementContents;
import production.model.achievement.AchievementList;
import production.model.achievement.AchievementName;
import production.model.resume.ResumeContents;
import production.model.resume.ResumeImpl;
import production.model.resume.ResumeName;

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
    public void selectAchievement(int index) throws InvalidAchievementIndexException {
        if (!isValidIndex(index)) {
            throw new InvalidAchievementIndexException();
        }
        selector.select(index);
    }

    @Override
    public void deselectAchievement(int index) throws InvalidAchievementIndexException {
        if (!isValidIndex(index)) {
            throw new InvalidAchievementIndexException();
        }
        selector.deselect(index);
    }

    @Override
    public ResumeImpl generateResume(AchievementList achievements) {
        String resumeText = "Achievements:";
        for (Integer index : selector.getSelection()) {
            AchievementName name = achievements.getAchievementName(index);
            AchievementContents contents = achievements.getAchievementContents(index);
            String achievementText = name.toString() + ": " + contents.toString();
            resumeText += achievementText + "\n";
        }
        return new ResumeImpl(new ResumeName("Resume"), new ResumeContents(resumeText));
    }

}
