package test.java;


import main.java.UI.Constant;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import java.io.IOException;
import java.util.logging.Level;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class IncorrectRegistration_test extends TestBaseForRegistration {

    @Features("Регистрация.Некорректные данные")
    @Stories("Пустые поля")
    @Test(priority = 3)
    //all fields are EMPTY
    public void EmptyFields() throws InterruptedException, IOException {
        log.log(Level.INFO, "Incorrect test. EmptyFields. Lang: " + language);
        app.getRegistrationHelper().fillRegistrationForm("", "", "");
        app.getRegistrationHelper().clickRegisterButton();

        assertThat(language + ": ", app.getRegistrationHelper().getTextError(Constant.NAME), equalTo(app.getYamlHelper().getEmptyErrorLanguage(language)));
        log.log(Level.INFO, "Incorrect test. EmptyFields. Empty name error: " + app.getRegistrationHelper().getTextError(Constant.NAME));
        assertThat(language + ": ",  app.getRegistrationHelper().getTextError(Constant.ORGANISATION), equalTo(app.getYamlHelper().getEmptyErrorLanguage(language)));
        log.log(Level.INFO,"Incorrect test.EmptyFields. Empty organisation error: " + app.getRegistrationHelper().getTextError(Constant.ORGANISATION));
        assertThat(language + ": ", app.getRegistrationHelper().getTextError(Constant.EMAIL), equalTo(app.getYamlHelper().getEmptyErrorLanguage(language)));
        log.log(Level.INFO,"Incorrect test.EmptyFields. Empty organisation error: "+ app.getRegistrationHelper().getTextError(Constant.EMAIL));
    }

    @Features("Регистрация.Некорректные данные")
    @Stories("Длинные значения")
    @Test(priority = 3, dataProvider = "registrationLongData", dataProviderClass = DataGenerator.class)
    public void LongFields(String longName, String longOrg, String longEmail) throws InterruptedException {
        log.log(Level.INFO, "Incorrect test. LongFields. Lang: " + language);
        app.getRegistrationHelper().fillRegistrationFormFromClipBoard(longName, longOrg, longEmail);
        assertThat(app.getRegistrationHelper().getValue(Constant.NAME), equalTo(longName.substring(0, 255)));
        assertThat(app.getRegistrationHelper().getValue(Constant.ORGANISATION), equalTo(longOrg.substring(0, 255)));
        assertThat(app.getRegistrationHelper().getValue(Constant.EMAIL), equalTo(longEmail.substring(0, 255)));
    }

    @Features("Регистрация.Некорректные данные")
    @Stories("Некорректный Email")
    @Test(priority = 3, dataProvider = "registrationIncorrectEmailData", dataProviderClass = DataGenerator.class)
    public void BadTypeEmail(String name, String org, String incorrectEmail) throws IOException {
        log.log(Level.INFO, "Incorrect test: BadTypeEmail. Lang: " + language);
        app.getRegistrationHelper().fillRegistrationForm(name, org, incorrectEmail);
        app.getRegistrationHelper().clickRegisterButton();
        assertThat(language + ": " + app.getRegistrationHelper().getTextError(Constant.EMAIL), app.getRegistrationHelper().getTextError(Constant.EMAIL), equalTo(app.getYamlHelper().getEmailError(language)));
        log.log(Level.INFO, "Incorrect test: BadTypeEmail.Error:  " + app.getRegistrationHelper().getTextError(Constant.EMAIL));
    }

    @Features("Регистрация.Некорректные данные")
    @Stories("Не согласны с лицензионным соглашением")
    @Test(priority = 3, dataProvider = "registrationSimpleData", dataProviderClass = DataGenerator.class)
    public void checkBoxIsUnselected(String name, String org, String email) throws InterruptedException, IOException {
        log.log(Level.INFO, "Incorrect test. CheckBoxIsUnselected. Lang: " + language);
        app.getRegistrationHelper().fillRegistrationForm(name, org, email);
        app.getRegistrationHelper().clickRegisterButton();
        assertThat("Licence page is not opened", app.getRegistrationHelper().checkLicencePage(),equalTo(true));
        app.getRegistrationHelper().clickRegisterLicencePageButton();
        log.log(Level.INFO, "Incorrect test. CheckBoxIsUnselected. Error: " + app.getRegistrationHelper().getTextError(Constant.LICENCE_AGREE));
        assertThat(language + ":", app.getRegistrationHelper().getTextError(Constant.LICENCE_AGREE), equalTo(app.getYamlHelper().getCheckBoxError(language)));

    }

    @Features("Регистрация.Некорректные данные")
    @Stories("Ужe зарегистрированный email")
    @Test(priority = 3, dataProvider = "registrationSimpleDataWithoutEmail", dataProviderClass = DataGenerator.class)
    public void alreadyRegisterEmail(String simpleName, String simpleOrg) throws IOException {
        String email = app.getProperty("email.already.register");
        log.log(Level.INFO, "Incorrect test. Already register  email test . Language: " + language + " and email: " + email);
        app.getRegistrationHelper().fillRegistrationForm(simpleName, simpleOrg, email);
        app.getRegistrationHelper().clickRegisterButton();
        log.log(Level.INFO, "Incorrect test. Already register  email test . Error: " + app.getRegistrationHelper().getTextError(Constant.EMAIL));
        assertThat(language + ":", app.getRegistrationHelper().getTextError(Constant.EMAIL), equalTo(app.getYamlHelper().getAlreadyRegisterEmail(language)));
    }


    @Features("Регистрация.Некорректные данные")
    @Stories("Ужe существующий в базе email")
    @Test(priority = 3, dataProvider = "registrationSimpleDataWithoutEmail", dataProviderClass = DataGenerator.class)
    public void alreadyExistInDataBaseEmail(String simpleName, String simpleOrg) throws IOException {
        String email = app.getProperty("email.already.exist.in.db");
        log.log(Level.INFO, "Incorrect test. Already exist in database email. Lang: " + language + " and email: " + email);
        app.getRegistrationHelper().fillRegistrationForm(simpleName, simpleOrg, email);
        app.getRegistrationHelper().clickRegisterButton();
        log.log(Level.INFO, "Incorrect test. Already exist in database email. Error: " +  app.getRegistrationHelper().getTextError(Constant.EMAIL));
        assertThat(language + ":", app.getRegistrationHelper().getTextError(Constant.EMAIL), equalTo(app.getYamlHelper().getAlreadyExistInDatabaseErrorLanguage(language)));
    }
}
