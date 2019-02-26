import com.codeborne.selenide.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTests {


//    @AfterEach
//    public void tearDown() {
//        SelenideElement profileButton = $(By.className("header")).find(By.tagName("button"));
//        if (profileButton.isDisplayed()) {
//            profileButton.click();
//            $(withText("Log out")).click();
//        }
//    }

    @Test
    public void emptyLoginAndPasswordTest() {
        open("http://testit-beta.meistersoft.ru/");

        $(UIMap.getLocator("login.username")).setValue("");
        $(UIMap.getLocator("login.password")).setValue("");
        $(UIMap.getLocator("login.submit")).click();

        $(UIMap.getLocator("login.enter_pwd_msg")).shouldBe(visible);
        $(UIMap.getLocator("login.enter_login_msg")).shouldBe(visible);
    }

    @Test
    public void rawWebDriverTest() {
        System.setProperty("webdriver.chrome.driver", "/Users/miailrabov/chromedriver");
        ChromeDriver driver = new ChromeDriver();

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("ie");

        URL hubUrl = new URL("http://192.168.88.138:4444");
        RemoteWebDriver remote = new RemoteWebDriver(hubUrl, caps);

        driver.get("http://testit-beta.meistersoft.ru/");

        WebElement loginInput = driver.findElement(UIMap.getLocator("login.username"));
        loginInput.sendKeys("");
        WebElement pwdInput = driver.findElement(UIMap.getLocator("login.password"));
        pwdInput.sendKeys("");
        WebElement submitBtn = driver.findElement(UIMap.getLocator("login.submit"));
        submitBtn.click();

        WebElement error_msg = driver.findElement(UIMap.getLocator("login.error_msg"));
        assertEquals("Please, enter login.", error_msg.getText());
    }

    @Test
    public void emptyLoginPageObjectTest() {
        open("http://testit-beta.meistersoft.ru/");
        LoginPage.login("", "");
        assertEquals("Please, enter login.", LoginPage.getError());
    }

    @Test
    public void wrongPasswordTest() {
        open("http://testit-beta.meistersoft.ru/");

        $(By.id("login")).setValue("user");
        $(By.id("password")).setValue("wrongPassword");
        $(By.tagName("button")).click();

        $(withText("Wrong username or password")).shouldBe(visible).should(exist);
    }

    @Test
    public void successfulLogInTest() {
        open("http://testit-beta.meistersoft.ru/");

        $(By.id("login")).setValue("admin");
        $(By.id("password")).setValue("M2RmNzg3");
        $(By.tagName("button")).click();

        $(By.tagName("h1")).shouldHave(text("Projects")).shouldBe(visible);
    }

//    @Test
//    public void projectTilesTest() {
//        open("http://testit-beta.meistersoft.ru/");
//
//        $(By.id("login")).setValue("admin");
//        $(By.id("password")).setValue("M2RmNzg3");
//        $(By.tagName("button")).click();
//
//        // встроенные селекторы selenium
//        By.id("login");
//        By.className("class");
//        By.tagName("div");
//        By.cssSelector("button#login.classname");
//        By.linkText("http://ldlld");
//
//        // добавлено в selenenide
//        byText("Полное совпадение");
//        withText("Вхождение строки");
//        byTitle("Атрибут title");
//        byValue("Атрибут value");
//
//        // действия
//        $("element").click();
//        $("element").doubleClick();
//
//        //
//        //waitUntil();
//        //waitWhile();
//
//        ElementsCollection projectTiles = $$(By.tagName("app-project-tile"));
//        projectTiles.shouldHave(sizeGreaterThan(10));
//    }
}
