package backend.exception;

public class UnableSavePdfException extends BackendException {

    private static final String UNABLE_SAVE_PDF_MESSAGE =
            "Unable to save PDF resume!";

    public UnableSavePdfException() {
        super(UNABLE_SAVE_PDF_MESSAGE);
    }

}
