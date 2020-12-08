package production.logic;

import production.model.achievement.AchievementContents;
import production.model.achievement.AchievementList;
import production.model.achievement.AchievementName;
import production.model.resume.ResumeContents;
import production.model.resume.ResumeImpl;
import production.model.resume.ResumeName;

public class ResumeGenerator {

    public ResumeGenerator() {}

    public ResumeImpl generateResume(AchievementList achievements, AchievementSelection selection) {
        String resumeText = "Achievements:";
        for (Integer index : selection.getIndices()) {
            AchievementName name = achievements.getAchievementName(index);
            AchievementContents contents = achievements.getAchievementContents(index);
            String achievementText = name.toString() + ": " + contents.toString();
            resumeText += achievementText + "\n";
        }
        return new ResumeImpl(new ResumeName("Resume"), new ResumeContents(resumeText));
    }

}
