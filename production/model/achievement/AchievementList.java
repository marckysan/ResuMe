package production.model.achievement;

public interface AchievementList {
    boolean isEmpty();
    boolean contains(Achievement achievement);
    int length();
    void add(Achievement achievement);
    void remove(Achievement achievement);
}
