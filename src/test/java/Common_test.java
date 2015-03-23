package test.java;

import main.java.Helpers.WindowsHelper;
import main.java.UI.Constant;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

/**
 * Created by Annet on 21.01.2015.
 */
public class Common_test extends testBase {
      @Features("Общие проверки")
      @Stories("Проверка, что браузер откроется на языке браузера. Язык выбирается рандомно")
      @Test(priority = 0)
        public void CheckDefaultLanguage() {
        //check url
        String URL = app.getNavigationHelper().getCurrentUrl();
        Assert.assertTrue(URL.contains(Constant.URL + "/" + Constant.BROWSER_LANG), "Browser has lang " + Constant.BROWSER_LANG + ", but URL=" + URL);
    }


    void Fail() {
        //check url
        String URL = app.getNavigationHelper().getCurrentUrl();
        System.out.println("FAIL");
        Assert.assertEquals(1,2);
    }


}

