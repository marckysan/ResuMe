package production.logic;

import production.exception.AchievementNotFoundException;
import production.exception.DuplicateAchievementException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AchievementSelection {

    private final List<Integer> indices = new ArrayList<>();

    public AchievementSelection() {}

    public List<Integer> getIndices() {
        return indices;
    }

    public boolean isEmpty() {
        return indices.isEmpty();
    }

    public boolean contains(int index) {
        return indices.contains(index);
    }

    public void add(int index) throws DuplicateAchievementException {
        if (indices.contains(index)) {
            throw new DuplicateAchievementException();
        }
        indices.add(index);
        Collections.sort(indices);
    }

    public void remove(int index) throws AchievementNotFoundException {
        if (!indices.contains(index)) {
            throw new AchievementNotFoundException();
        }
        indices.removeAll(Arrays.asList(index));
    }

}
