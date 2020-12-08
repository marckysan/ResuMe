package production.model.achievement;

import production.exception.AchievementNotFoundException;
import production.exception.DuplicateAchievementException;

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
    public int length() {
        return internalList.size();
    }

    @Override
    public void add(Achievement achievement) throws DuplicateAchievementException {
        if (this.contains(achievement)) {
            throw new DuplicateAchievementException();
        }
        assert (!this.contains(achievement));
        internalList.add(achievement);
    }

    @Override
    public void remove(Achievement achievement) throws AchievementNotFoundException {
        if (!this.contains(achievement)) {
            throw new AchievementNotFoundException();
        }
        assert (this.contains(achievement));
        internalList.remove(achievement);
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
            return "Achievement list is empty!";
        }

        String achievements = "The following are your achievements:" + "\n";
        for (Achievement achievement : internalList) {
            achievements += achievement.toString() + "\n";
        }
        return achievements;
    }

}
