package backend.exception;

public class DuplicateAchievementException extends BackendException {

    private static final String DUPLICATE_ACHIEVEMENT_MESSAGE =
            "You cannot add the same achievement twice!";

    public DuplicateAchievementException() {
        super(DUPLICATE_ACHIEVEMENT_MESSAGE);
    }

}
