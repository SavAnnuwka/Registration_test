package test.java;

import main.java.UI.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.Level;

/**
 * Created by Annet on 21.01.2015.
 */
public class Common_tests extends testBase {

    @Test
    public void CheckDefaultLanguage() {
        //check url
        String URL = app.getNavigationHelper().getCurrentUrl();
        //  for old system
        Assert.assertTrue(URL.contains("locale=" + Constant.BROWSER_LANG), "Browser has lang " + Constant.BROWSER_LANG + ", but URL=" + URL);
        log.log(Level.INFO, "browserLang " + Constant.BROWSER_LANG);
        //for new system
        // Assert.assertTrue(URL.contains(app.getProperty("baseURL")+"/" + Constant.BROWSER_LANG), "Browser has lang " + Constant.BROWSER_LANG + ", but URL=" + URL);
    }


}
