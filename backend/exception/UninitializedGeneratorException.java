package backend.exception;

public class UninitializedGeneratorException extends BackendException {

    private static final String UNINITIALIZED_GENERATOR_MESSAGE =
            "Cannot generate resume without selecting achievements first!";

    public UninitializedGeneratorException() {
        super(UNINITIALIZED_GENERATOR_MESSAGE);
    }

}
