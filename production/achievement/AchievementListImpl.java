package achievement;

import exception.DuplicateAchievementException;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class AchievementListImpl implements AchievementList {

    private final List<Achievement> internalList = new ArrayList<>();

    public AchievementListImpl() {}

    @Override
    public boolean isEmpty() {
        return internalList.isEmpty();
    }

    @Override
    public boolean contains(Achievement achievement) {
        return internalList.contains(achievement);
    }

    @Override
    public void add(Achievement achievement) throws DuplicateAchievementException {
        if (internalList.contains(achievement)) {
            throw new DuplicateAchievementException();
        }
        assert (!internalList.contains(achievement));
        internalList.add(achievement);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AchievementListImpl that = (AchievementListImpl) o;
        return Objects.equals(internalList, that.internalList);
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Achievement.Achievement List is empty!";
        }

        String achievements = "The following are your achievements:" + "\n";
        for (Achievement achievement : internalList) {
            achievements += achievement.toString() + "\n";
        }
        return achievements;
    }

}
