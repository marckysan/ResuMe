package backend.exception;

public class UnableSavePersonException extends BackendException {

    private static final String UNABLE_SAVE_PERSON_MESSAGE =
            "Unable to save person!";

    public UnableSavePersonException() {
        super(UNABLE_SAVE_PERSON_MESSAGE);
    }

}
