package backend.login;

public class LoginManagerImpl implements LoginManager {

    private boolean isLoggedIn = false;

    public LoginManagerImpl() {}

    @Override
    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    @Override
    public void login() {
        isLoggedIn = true;
    }

    @Override
    public void logout() {
        isLoggedIn = false;
    }

    @Override
    public void register() {

    }
}
