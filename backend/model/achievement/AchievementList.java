package backend.model.achievement;

import java.util.List;

public interface AchievementList {
    boolean isEmpty();
    boolean contains(Achievement achievement);
    int getNumAchievements();
    void add(Achievement achievement);
    void remove(Achievement achievement);
    void remove(int index);
    Achievement get(int index);
    AchievementName getAchievementName(int index);
    AchievementContents getAchievementContents(int index);
    List<Achievement> asList();
}
