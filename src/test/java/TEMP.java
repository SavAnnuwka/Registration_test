package test.java;

import main.java.UI.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

/**
 * Created by Annet on 22.03.2015.
 */
public class TEMP extends testBase {


    @Features("Общие проверки")
    @Stories("Всегда pass")
    @Test
    void PASS() {
        String URL = app.getNavigationHelper().getCurrentUrl();
        System.out.println("PASS");
        Assert.assertEquals(2,2);
    }


}

