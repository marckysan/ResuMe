package backend.exception;

import backend.util.Message;

public class InvalidAchievementIndexException extends BackendException{

    public InvalidAchievementIndexException() {
        super(Message.INVALID_ACHIEVEMENT_INDEX_MESSAGE.getMessage());
    }

}
