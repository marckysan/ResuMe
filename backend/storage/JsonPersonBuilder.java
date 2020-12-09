package backend.storage;

import backend.exception.CorruptedPersonDataException;
import backend.model.achievement.*;
import backend.model.person.PersonImpl;
import backend.model.person.PersonName;
import backend.model.resume.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonPersonBuilder {

    private final JSONObject personData;

    public JsonPersonBuilder(JSONObject personData) {
        this.personData = personData;
    }

    public PersonImpl build() throws CorruptedPersonDataException {
        try {
            // Extract all Person attributes as JSON data
            String fullName = (String) personData.get("personName");
            JSONArray achievementListData = (JSONArray) personData.get("achievements");
            JSONArray resumeListData = (JSONArray) personData.get("resumes");

            // Generate all Person attributes
            PersonName personName = new PersonName(fullName);
            AchievementList achievements = buildAchievementList(achievementListData);
            ResumeList resumes = buildResumeList(resumeListData);
            return new PersonImpl(personName, achievements, resumes);
        } catch (NullPointerException e) {
            throw new CorruptedPersonDataException();
        }
    }

    private AchievementList buildAchievementList(JSONArray achievementListData) {
        AchievementListImpl achievements = AchievementListImpl.getEmptyList();
        achievementListData.forEach(achievementData ->
                achievements.add(buildAchievement((JSONObject) achievementData)));
        return achievements;
    }

    private Achievement buildAchievement(JSONObject achievementData) {
        // FIXME: This is a temporary method, since there is only one type of Achievement, which is PersonalProject.
        String fullName = (String) achievementData.get("achievementName");
        String fullContents = (String) achievementData.get("achievementContents");
        return new PersonalProject(new AchievementName(fullName), new AchievementContents(fullContents));
    }

    private ResumeList buildResumeList(JSONArray resumeListData) {
        ResumeList resumes = ResumeListImpl.getEmptyList();
        resumeListData.forEach(resumeData ->
                resumes.add(buildResume((JSONObject) resumeData)));
        return resumes;
    }

    private Resume buildResume(JSONObject resumeData) {
        String fullName = (String) resumeData.get("resumeName");
        String fullContents = (String) resumeData.get("resumeContents");
        return new ResumeImpl(new ResumeName(fullName), new ResumeContents(fullContents));
    }

}
