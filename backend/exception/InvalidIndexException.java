package backend.exception;

import backend.util.Message;

public class InvalidIndexException extends BackendException{

    public InvalidIndexException() {
        super(Message.INVALID_INDEX_MESSAGE.getMessage());
    }

}
