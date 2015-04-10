package test.java;

import main.java.Helpers.WindowsHelper;
import main.java.UI.Constant;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import java.util.logging.Level;

/**
 * Created by Annet on 21.01.2015.
 */
public class Common_test extends testBase {
      @Features("Общие проверки")
      @Stories("Проверка, что браузер откроется на языке браузера. Язык выбирается рандомно")
      @Test(priority = 0)
        public void CheckDefaultLanguage() {

          String URL = app.getNavigationHelper().getCurrentUrl();
          log.log(Level.INFO, "Common test. Check default language. Lang: " + Constant.BROWSER_LANG);
          Assert.assertTrue(URL.contains("/" + Constant.BROWSER_LANG), "Common test. Check default language. Browser has lang " + Constant.BROWSER_LANG + ", but URL=" + URL);
    }


    void Fail() {
        //check url
        String URL = app.getNavigationHelper().getCurrentUrl();
        System.out.println("FAIL");
        Assert.assertEquals(1,2);
    }


}

