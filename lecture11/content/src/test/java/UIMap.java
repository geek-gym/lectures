import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selectors.withText;

public class UIMap {
    Properties properties;
    private static UIMap map = new UIMap("src/main/resources/uimap.properties");

    public static By getLocator(String key) {
        return map.getLocatorByKey(key);
    }

    public UIMap(String uimapPath) {
        try {
            FileInputStream stream = new FileInputStream(uimapPath);
            this.properties = new Properties();
            this.properties.load(stream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public By getLocatorByKey(String key) {
        String value = this.properties.getProperty(key);
        String[] locatorArr = value.split(":");
        if (locatorArr.length < 2) {
            throw new IllegalArgumentException("Property value should have type and value.");
        }
        String type = locatorArr[0];
        String locator = locatorArr[1];

        if (type.equalsIgnoreCase("id")) {
            return By.id(locator);
        } else if (type.equalsIgnoreCase("class")) {
            return By.className(locator);
        } else if (type.equalsIgnoreCase("tag")) {
            return By.tagName(locator);
        } else if (type.equalsIgnoreCase("text")) {
            return withText(locator);
        }

        throw new IllegalArgumentException("Can't resolve locator type " + type);
    }
}
