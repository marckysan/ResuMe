package achievement;

public interface AchievementList {
    boolean isEmpty();
    boolean contains(Achievement achievement);
    void add(Achievement achievement);
    void remove(Achievement achievement);
}
