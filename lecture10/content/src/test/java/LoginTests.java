import com.codeborne.selenide.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;

public class LoginTests {


    @AfterEach
    public void tearDown() {
        SelenideElement profileButton = $(By.className("header")).find(By.tagName("button"));
        if (profileButton.isDisplayed()) {
            profileButton.click();
            $(withText("Log out")).click();
        }
    }

    @Test
    public void emptyLoginAndPasswordTest() {
        open("http://testit-beta.meistersoft.ru/");

        $(By.id("login")).setValue("");
        $(By.id("password")).setValue("");
        $(By.tagName("button")).click();

        $(withText("Please, enter login")).shouldBe(visible);
        $(withText("Please, enter password")).shouldBe(visible);
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

    @Test
    public void projectTilesTest() {
        open("http://testit-beta.meistersoft.ru/");

        $(By.id("login")).setValue("admin");
        $(By.id("password")).setValue("M2RmNzg3");
        $(By.tagName("button")).click();

        // встроенные селекторы selenium
        By.id("login");
        By.className("class");
        By.tagName("div");
        By.cssSelector("button#login.classname");
        By.linkText("http://ldlld");

        // добавлено в selenenide
        byText("Полное совпадение");
        withText("Вхождение строки");
        byTitle("Атрибут title");
        byValue("Атрибут value");

        // действия
        $("element").click();
        $("element").doubleClick();

        //
        //waitUntil();
        //waitWhile();

        ElementsCollection projectTiles = $$(By.tagName("app-project-tile"));
        projectTiles.shouldHave(sizeGreaterThan(10));
    }
}
