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

    public static final String CSS = "css:";
    public static final String ID = "id:";
    public static final String XPATH = "xpath:";
    public static final String CLASS = "class:";

    public UIMap(ApplicationManager app) {
        super(app);
    }
    private Properties getProperties() {
        Properties map = new Properties();
        try {
            map.load(new FileReader(app.getProperty("locatorPropertyFile")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }


    public By getLocator(String key)  {
        Properties map = getProperties();
        String locator = map.getProperty(key);
        if (locator.startsWith(CSS)) {
            return By.cssSelector(locator.substring(CSS.length()));
        } else if (locator.startsWith(ID)) {
            return By.id(locator.substring(ID.length()));
        } else if (locator.startsWith(XPATH)) {
            return By.xpath(locator.substring(XPATH.length()));
        } else if (locator.startsWith(CLASS)) {
            return By.className(locator.substring(CLASS.length()));
        }
        else {
            throw  new Error("Unrecognized locator"+locator);

        }
    }


   /* public String getLocator(String key, String locatorName)  {
        Properties map = getProperties();
        String locator = map.getProperty(key);
        return locator.substring((locatorName + ":").length());

    }*/


    public String getLocatorNameforFindBy (String key)  {
        Properties map = getProperties();
        String locator = map.getProperty(key);
        if (locator.startsWith(CSS)) {
            return CSS;
        } else if (locator.startsWith(ID)) {
            return ID;
        } else if (locator.startsWith(XPATH)) {
            return XPATH ;
        } else if (locator.startsWith(CLASS)) {
            return CLASS;
        }
        else {
            throw  new Error("Unrecognized locator"+locator);
        }
    }
}
