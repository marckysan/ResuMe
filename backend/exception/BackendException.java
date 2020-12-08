package backend.exception;

public class BackendException extends RuntimeException {
    private final String message;

    public BackendException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
