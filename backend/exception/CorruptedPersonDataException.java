package backend.exception;

public class CorruptedPersonDataException extends BackendException {

    private static final String CORRUPTED_PERSON_DATA_MESSAGE = "Unable to load data.";

    public CorruptedPersonDataException() {
        super(CORRUPTED_PERSON_DATA_MESSAGE);
    }

}
