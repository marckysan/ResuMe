package backend.logic;

import backend.exception.InvalidIndexException;

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

    public void select(int index) throws InvalidIndexException {
        if (!isValidIndex(index)) {
            throw new InvalidIndexException();
        }
        indices.add(index);
    }

    public void deselect(int index) throws InvalidIndexException {
        if (!isValidIndex(index)) {
            throw new InvalidIndexException();
        }
        indices.remove(index);
    }

    public boolean isValidIndex(int index) {
        return 0 <= index && index < numAchievements;
    }

}
