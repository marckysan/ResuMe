package backend.exception;

public class DuplicateResumeException extends BackendException {

    private static final String DUPLICATE_RESUME_MESSAGE =
            "You cannot add the same resume twice!";

    public DuplicateResumeException() {
        super(DUPLICATE_RESUME_MESSAGE);
    }

}
