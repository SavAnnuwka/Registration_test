package test.java;

import main.java.UI.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class Additional_tests extends TestBaseForRegistration {


    private String  checkFieldIsEmpty(String name, String org, String email)  {
        if (name=="") return Constant.NAME;
        if (org=="") return Constant.ORGANISATION;
        if (email=="") return Constant.EMAIL;
        else return null;
        }

    @Features("Регистрация.Дополнительные тесты")
    @Stories("Одно поле пустое, остальные заполнены")
    @Test( dataProvider = "registrationEmptyData", dataProviderClass = DataGenerator.class, priority = 3,groups = "ChangeLanguage")
    public void incorrectOneEmptyFields(String name, String org, String email) throws InterruptedException, UnsupportedEncodingException {
      //  log.log(Level.INFO, "Additional test. One empty field. Lang: " + language);
      log.info("Additional test. One empty field. Lang: " + language);
        app.getRegistrationHelper().fillRegistrationForm(name, org, email);
        app.getRegistrationHelper().clickRegisterButton();
        String field = checkFieldIsEmpty(name, org, email);
        assertThat(language + ": " + app.getRegistrationHelper().getTextError(field), app.getRegistrationHelper().getTextError(field), equalTo(Constant.getEmptyErrorLanguage(language)));
        log.info("Additional test. One empty field. Error: " + app.getRegistrationHelper().getTextError(field));


    }


    @Features("Регистрация.Дополнительные тесты")
    @Stories("Заголовок на странице Регистрации")
    @Test(priority = 3,groups = "ChangeLanguage")
    public void checkMainRegistrationPage() throws InterruptedException {
        log.log(Level.INFO, "Additional test. Check main  registration. Lang: " + language);
        log.log(Level.INFO, "Additional test.  Check main  registration. Title: " + app.getRegistrationHelper().getText(Constant.TITLE));
        assertThat(language + ": " + app.getRegistrationHelper().getText(Constant.TITLE), app.getRegistrationHelper().getText(Constant.TITLE), equalTo(Constant.getTitleLanguage(language)));
    }

    @Features("Регистрация.Дополнительные тесты")
    @Stories("Описание  на странице Регистрации")
    @Test(priority = 3, groups = "ChangeLanguage")
    public void checkMainRegistrationPageDescription() throws InterruptedException {
        log.log(Level.INFO, "Additional test. Check main  registration. Lang: " + language);
        log.log(Level.INFO, "Additional test.  Check main  registration. Description:" + app.getRegistrationHelper().getText(Constant.DESCRIPTION));
        assertThat(language + ": " + app.getRegistrationHelper().getText(Constant.DESCRIPTION), app.getRegistrationHelper().getText(Constant.DESCRIPTION), equalTo(Constant.getDescriptionLanguage(language)));
    }

    @Features("Регистрация.Дополнительные тесты")
    @Stories("Чекбокс  на странице Лицензии")
    @Test(priority = 3, dataProvider = "registrationSimpleData", dataProviderClass = DataGenerator.class,groups = "ChangeLanguage")
    public void checkMainRegistrationPageCheckbox(String name, String org, String email) throws InterruptedException {
        log.log(Level.INFO, "Additional test. Check main  registration. Lang: " + language);
        app.getRegistrationHelper().fillRegistrationForm(name, org, email);
        app.getRegistrationHelper().clickRegisterButton();
        Assert.assertEquals(app.getRegistrationHelper().checkLicencePage(), true);
        log.log(Level.INFO, "Additional test.  Check main  registration. CheckBox:" + app.getRegistrationHelper().getText(Constant.LICENCE_AGREE));
        assertThat(language + ": " +app.getRegistrationHelper().getText(Constant.LICENCE_AGREE), app.getRegistrationHelper().getText(Constant.LICENCE_AGREE), equalTo(Constant.getConfirmCheckboxLanguage(language)));
    }




}
