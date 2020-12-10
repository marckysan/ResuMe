package backend.exception;

public class ModifyOnGenerationException extends BackendException {

    private static final String MODIFY_ON_GENERATION_MESSAGE
            = "Cannot modify achievement list when resume is being generated!";

    public ModifyOnGenerationException() {
        super(MODIFY_ON_GENERATION_MESSAGE);
    }

}
