package backend.exception;

public class AchievementsNotSelectedYetException extends BackendException {

    private static final String ACHIEVEMENT_NOT_SELECTED_YET_MESSAGE =
            "Cannot generate resume without selecting achievements first!";

    public AchievementsNotSelectedYetException() {
        super(ACHIEVEMENT_NOT_SELECTED_YET_MESSAGE);
    }

}
