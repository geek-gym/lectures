import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public static void login(String login, String password) {
        setLogin(login);
        setPassword(password);
        submitLoginForm();
    }

    public static void setLogin(String login) {
        $(UIMap.getLocator("login.username")).setValue(login);
    }

    public static void setPassword(String password) {
        $(UIMap.getLocator("login.password")).setValue(password);
    }

    public static void submitLoginForm() {
        $(UIMap.getLocator("login.submit")).click();
    }

    public static String getError() {
        return $(UIMap.getLocator("login.error_msg")).getText();
    }
}
