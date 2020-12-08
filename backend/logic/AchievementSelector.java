package backend.logic;

import backend.exception.InvalidAchievementIndexException;

import java.util.HashSet;
import java.util.Set;

public class AchievementSelector {

    private final int numAchievements;
    private final Set<Integer> indices = new HashSet<>();

    public AchievementSelector(int numAchievements) {
        this.numAchievements = numAchievements;
    }

    public Set<Integer> getSelection() {
        return indices;
    }

    public boolean isEmpty() {
        return indices.isEmpty();
    }

    public void select(int index) throws InvalidAchievementIndexException {
        if (!isValidIndex(index)) {
            throw new InvalidAchievementIndexException();
        }
        indices.add(index);
    }

    public void deselect(int index) throws InvalidAchievementIndexException {
        if (!isValidIndex(index)) {
            throw new InvalidAchievementIndexException();
        }
        indices.remove(index);
    }

    public boolean isValidIndex(int index) {
        return 0 <= index && index < numAchievements;
    }

}
