package backend.login;

public interface LoginManager {
    boolean isLoggedIn();
    void login();
    void logout();
    void register();
}
