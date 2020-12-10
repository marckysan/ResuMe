package backend.storage;

import backend.model.achievement.Achievement;
import backend.model.achievement.AchievementList;
import backend.model.person.Person;
import backend.model.person.PersonName;
import backend.model.resume.Resume;
import backend.model.resume.ResumeList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonPersonSerializer {

    private final Person person;

    public JsonPersonSerializer(Person person) {
        this.person = person;
    }

    public JSONObject serialize() {
        // Extract all Person attributes
        PersonName personName = person.getName();
        AchievementList achievements = person.getAchievementList();
        ResumeList resumes = person.getResumeList();
        JSONObject personDetails = new JSONObject();

        // Generate JSON data for each attribute
        personDetails.put("personName", personName.getFullName());
        personDetails.put("achievements", serializeAchievementList(achievements));
        personDetails.put("resumes", serializeResumeList(resumes));
        return personDetails;
    }

    private JSONArray serializeAchievementList(AchievementList achievements) {
        JSONArray achievementListData = new JSONArray();
        for (int i = 0; i < achievements.getNumAchievements(); i++) {
            achievementListData.add(serializeAchievement(achievements.get(i)));
        }
        return achievementListData;
    }

    private JSONObject serializeAchievement(Achievement achievement) {
        JSONObject achievementData = new JSONObject();
        achievementData.put("achievementName", achievement.getName().getFullName());
        achievementData.put("achievementContents", achievement.getContents().getFullContents());
        return achievementData;
    }

    private JSONArray serializeResumeList(ResumeList resumes) {
        JSONArray resumeListData = new JSONArray();
        for (int i = 0; i < resumes.getNumResumes(); i++) {
            resumeListData.add(serializeResume(resumes.get(i)));
        }
        return resumeListData;
    }

    private JSONObject serializeResume(Resume resume) {
        JSONObject resumeData = new JSONObject();
        resumeData.put("resumeName", resume.getName().getFullName());
        resumeData.put("resumeContents", resume.getContents().getFullContents());
        return resumeData;
    }

}
