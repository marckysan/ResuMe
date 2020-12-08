package backend.exception;

public class AchievementNotFoundException extends BackendException {

    private static final String ACHIEVEMENT_NOT_FOUND_MESSAGE =
            "Could not find achievement!";

    public AchievementNotFoundException() {
        super(ACHIEVEMENT_NOT_FOUND_MESSAGE);
    }

}
