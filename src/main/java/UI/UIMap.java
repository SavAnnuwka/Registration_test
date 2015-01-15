package main.java.UI;

import main.java.ApplicationManager;
import main.java.Helpers.HelperWithWebDriverBase;
import org.openqa.selenium.By;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Annet on 16.11.2014.
 */
public class UIMap extends HelperWithWebDriverBase {

    public UIMap(ApplicationManager app) {
        super(app);
    }

    public By getLocator(String key)  {
        Properties map = new Properties();
        try {
            map.load(new FileReader(app.getProperty("locatorPropertyFile")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String locator = map.getProperty(key);
        if (locator.startsWith("css:")) {
            return By.cssSelector(locator.substring("css:".length()));
        } else if (locator.startsWith("id:")) {
            return By.id(locator.substring("id:".length()));
        } else if (locator.startsWith("xpath:")) {
            return By.xpath(locator.substring("xpath:".length()));
        } else if (locator.startsWith("class:")) {
            return By.className(locator.substring("class:".length()));
        }
        else {
            throw  new Error("Unrecognized locator"+locator);

        }
    }
}
