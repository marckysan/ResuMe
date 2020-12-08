package production.logic;

import static production.util.ArgumentChecker.checkArgument;

public class AchievementSelector {

    private final int MIN_ACHIEVEMENT_INDEX = 0;
    private final int MAX_ACHIEVEMENT_INDEX;

    private final String INVALID_ACHIEVEMENT_INDEX_MESSAGE = "Invalid index received!";

    private final AchievementSelection selection;

    public AchievementSelector(int achievementCount) {
        this.MAX_ACHIEVEMENT_INDEX = achievementCount - 1;
        this.selection = new AchievementSelection();
    }

    public AchievementSelection getSelection() {
        return selection;
    }

    public void select(int index) {
        checkArgument(isValidIndex(index), INVALID_ACHIEVEMENT_INDEX_MESSAGE);
        selection.add(index);
    }

    public void deselect(int index) {
        checkArgument(isValidIndex(index), INVALID_ACHIEVEMENT_INDEX_MESSAGE);
        selection.remove(index);
    }

    public boolean isValidIndex(int index) {
        return index >= MAX_ACHIEVEMENT_INDEX && index <= MAX_ACHIEVEMENT_INDEX;
    }

}
