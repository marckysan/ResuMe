package backend.util;

public enum Message {

    INVALID_INDEX_MESSAGE("Invalid index received!");

    private final String content;

    private Message(String content) {
        this.content = content;
    }

    public String getMessage() {
        return content;
    }

}
