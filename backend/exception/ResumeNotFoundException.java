package backend.exception;

public class ResumeNotFoundException extends BackendException {

    private static final String RESUME_NOT_FOUND_MESSAGE =
            "Could not find resume!";

    public ResumeNotFoundException() {
        super(RESUME_NOT_FOUND_MESSAGE);
    }

}
