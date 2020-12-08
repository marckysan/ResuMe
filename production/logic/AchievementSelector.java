package production.logic;

public class AchievementSelector {

    private final int MIN_ACHIEVEMENT_INDEX = 0;
    private final int MAX_ACHIEVEMENT_INDEX;

    private final AchievementSelection selection;

    public AchievementSelector(int achievementCount) {
        this.MAX_ACHIEVEMENT_INDEX = achievementCount - 1;
        this.selection = new AchievementSelection();
    }

    public AchievementSelection getSelection() {
        return selection;
    }

    public void select(int index) {
        selection.add(index);
    }

    public void deselect(int index) {
        selection.remove(index);
    }

}
