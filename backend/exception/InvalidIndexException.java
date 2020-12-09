package backend.exception;

public class InvalidIndexException extends BackendException{

    private static final String INVALID_INDEX_MESSAGE = "Invalid index received!";

    public InvalidIndexException() {
        super(INVALID_INDEX_MESSAGE);
    }

}
