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
import static org.hamcrest.Matchers.equalTo;

public class SmokeRegistration_test extends TestBaseForRegistration {
    String correctEmail;



    @Features("Регистрация. Основные тесты")
    @Stories("Смоук тест. Прохождение всего сценария регистрации")
    @Test(dataProvider = "registrationCorrectData", dataProviderClass = DataGenerator.class, priority = 1, groups = "ChangeLanguage")
    public void positiveTest(String correctName, String correctOrg) throws InterruptedException {
        log.log(Level.INFO, "PositiveTest. Lang: " + language);
        correctEmail = app.getMailHelper().getEMail();
        app.getWindowsHelper().switchToOriginalPage();
        assertThat("Registration page is not opened", app.getRegistrationHelper().checkRegistrationPage(), equalTo(true));
        log.log(Level.INFO, "PositiveTest. Page 1 was open ");
        app.getRegistrationHelper().fillRegistrationForm(correctName, correctOrg, correctEmail);
        app.getRegistrationHelper().clickRegisterButton();
        assertThat("Licence page is not opened", app.getRegistrationHelper().checkLicencePage(), equalTo(true));
        log.log(Level.INFO, "PositiveTest. Page 2 was open");
        app.getRegistrationHelper().confirmCheckbox();
        app.getRegistrationHelper().clickRegisterLicencePageButton();
        assertThat("Finish  page is not opened", app.getRegistrationHelper().checkFinishRegistrationPage(), equalTo(true));
        log.log(Level.INFO, "PositiveTest. Page 3 was open");
        app.getWindowsHelper().switchToMailPage();
        assertThat("Email is empty", app.getMailHelper().emptyMail(),equalTo(false));
        log.log(Level.INFO, "PositiveTest. Mail " + correctEmail + " is not empty");
        getMailText();
        getMailLink();
        log.log(Level.INFO, "PositiveTest. Stop");
        app.getWindowsHelper().switchToOriginalPage();
    }


    public void getMailText() {
        //пока запускается before и меняется lang
        log.log(Level.INFO, "PositiveTest. Get mail text");
        app.getWindowsHelper().switchToMailPage();
        Constant.MAILTEXT =  app.getMailHelper().getMailtext();

    }

    public void getMailLink() {
        log.log(Level.INFO, "PositiveTest. Get mail link");
        app.getWindowsHelper().switchToMailPage();
        Set<String> OldList = app.getWindowsHelper().getCurrentListOfHandles();
        app.getMailHelper().goToMailLink();
        Set<String> NewList = app.getWindowsHelper().getCurrentListOfHandles();
        app.getWindowsHelper().getCMSHandles(OldList, NewList);
        app.getWindowsHelper().switchToCMSPage();
        Constant.MAILLINK=  app.getNavigationHelper().getCurrentUrl();

        app.getWindowsHelper().switchToOriginalPage();
    }


    @Features("Регистрация. Основные тесты")
    @Stories("Смоук тест. Проверка текста в письме")
    @Test (dependsOnMethods ="positiveTest", priority = 1)
    public void  checkMailText_withoutStartingBrowserTest()
    {  log.log(Level.INFO, "CheckMailText. Start");
        log.log(Level.INFO, "CheckMailText. Text:" + Constant.MAILTEXT);
                assertThat(language + ": mail incorrect. ", Constant.MAILTEXT, containsString(Constant.getMailText(language)));
    }

    @Features("Регистрация. Основные тесты")
    @Stories("Смоук тест. Проверка ссылки  в письме")
    @Test (dependsOnMethods ="positiveTest", priority = 1 )
    public void  checkMailLink_withoutStartingBrowserTest()
    {
        log.log(Level.INFO, "CheckMailLink. Start");
        log.log(Level.INFO,  "CheckMailText. Link: " + Constant.MAILLINK);
        assertThat(language + ": link incorrect. ", Constant.MAILLINK, containsString(app.getNavigationHelper().getNewUserURL()));
    }

    @AfterClass
    private void makeMainRegisterPage()
    { app.getWindowsHelper().switchToOriginalPage();}
}
