package backend.model.achievement;

import backend.exception.AchievementNotFoundException;
import backend.exception.DuplicateAchievementException;
import backend.exception.InvalidIndexException;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class AchievementListImpl implements AchievementList {

    private static final String EMPTY_ACHIEVEMENT_LIST_MESSAGE = "Achievement list is empty!";

    private final List<Achievement> internalList = new ArrayList<>();

    private AchievementListImpl() {}

    public static AchievementListImpl getEmptyList() {
        return new AchievementListImpl();
    }

    @Override
    public boolean isEmpty() {
        return internalList.isEmpty();
    }

    @Override
    public boolean contains(Achievement achievement) {
        return internalList.contains(achievement);
    }

    @Override
    public int getNumAchievements() {
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
    public void remove(int index) throws InvalidIndexException {
        try {
            internalList.remove(index);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidIndexException();
        }
    }

    @Override
    public Achievement get(int index) throws InvalidIndexException {
        try {
            return internalList.get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidIndexException();
        }
    }

    @Override
    public AchievementName getAchievementName(int index) throws InvalidIndexException {
        try {
            return internalList.get(index).getName();
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidIndexException();
        }
    }

    @Override
    public AchievementContents getAchievementContents(int index) throws InvalidIndexException {
        try {
            return internalList.get(index).getContents();
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidIndexException();
        }
    }

    @Override
    public List<Achievement> asList() {
        return internalList;
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
            return EMPTY_ACHIEVEMENT_LIST_MESSAGE;
        }
        String achievements = "Achievement list:" + "\n";
        int count = 0;
        for (Achievement achievement : internalList) {
            achievements += Integer.toString(count) + ". "
                    +  achievement.toString() + "\n";
            count++;
        }
        return achievements;
    }

}
