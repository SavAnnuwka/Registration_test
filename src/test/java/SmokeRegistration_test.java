package test.java;


import main.java.UI.Constant;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import java.util.Set;
import java.util.logging.Level;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class SmokeRegistration_test extends TestBaseForRegistration {
    String correctEmail;



    @Features("Регистрация. Основные тесты")
    @Stories("Смоук тест. Прохождение всего сценария регистрации")
    @Test(dataProvider = "registrationCorrectData", dataProviderClass = DataGenerator.class, priority = 1, groups = "ChangeLanguage")
    public void positiveTest(String correctName, String correctOrg) throws InterruptedException {
        log.log(Level.INFO, "positiveTest start. LANG = " + language);
        correctEmail = app.getMailHelper().getEMail();
        app.getWindowsHelper().switchToOriginalPage();
        Assert.assertEquals(app.getRegistrationHelper().checkRegistrationPage(), true);
        log.log(Level.INFO, "Page 1 was open ");
        app.getRegistrationHelper().fillRegistrationForm(correctName, correctOrg, correctEmail);
        app.getRegistrationHelper().clickRegisterButton();
        Assert.assertEquals(app.getRegistrationHelper().checkLicencePage(), true);
        log.log(Level.INFO, "Page 2 was open");
        app.getRegistrationHelper().confirmCheckbox();
        app.getRegistrationHelper().clickRegisterLicencePageButton();
        Assert.assertEquals(app.getRegistrationHelper().checkFinishRegistrationPage(), true);
        log.log(Level.INFO, "Page 3 was open");
        app.getWindowsHelper().switchToMailPage();
        Assert.assertEquals(app.getMailHelper().emptyMail(), false);
        log.log(Level.INFO, "mail " + correctEmail + " is not empty");
        getMailText();
        getMailLink();
        log.log(Level.INFO, "positiveTest stop");
        app.getWindowsHelper().switchToOriginalPage();
    }


    public void getMailText() {
        //пока запускается before и меняется lang
        log.log(Level.INFO, "check mail text start");
        app.getWindowsHelper().switchToMailPage();
        Constant.MAILTEXT =  app.getMailHelper().getMailtext();
        log.log(Level.INFO, Constant.MAILTEXT);
    }

    public void getMailLink() {
        log.log(Level.INFO, "check mail link  start");
        app.getWindowsHelper().switchToMailPage();
        Set<String> OldList = app.getWindowsHelper().getCurrentListOfHandles();
        app.getMailHelper().goToMailLink();
        Set<String> NewList = app.getWindowsHelper().getCurrentListOfHandles();
        app.getWindowsHelper().getCMSHandles(OldList, NewList);
        app.getWindowsHelper().switchToCMSPage();
        Constant.MAILLINK=  app.getNavigationHelper().getCurrentUrl();
        log.log(Level.INFO,  Constant.MAILLINK);
        app.getWindowsHelper().switchToOriginalPage();
    }


    @Features("Регистрация. Основные тесты")
    @Stories("Смоук тест. Проверка текста в письме")
    @Test (dependsOnMethods ="positiveTest", priority = 1)
    public void  checkMailText_withoutStartingBrowser()
    {  log.log(Level.INFO, "checkMailText start");
        assertThat(Constant.MAILTEXT, containsString(Constant.getMailText(language)));
    }

    @Features("Регистрация. Основные тесты")
    @Stories("Смоук тест. Проверка ссылки  в письме")
    @Test (dependsOnMethods ="positiveTest", priority = 1 )
    public void  checkMailLink_withoutStartingBrowser()
    {
        log.log(Level.INFO, "checkMailLink start");
        assertThat( Constant.MAILLINK, containsString(app.getNavigationHelper().getNewUserURL()));
    }

    @AfterClass
    private void makeMainRegisterPage()
    { app.getWindowsHelper().switchToOriginalPage();}
}
