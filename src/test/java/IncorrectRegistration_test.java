package test.java;


import main.java.UI.Constant;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class IncorrectRegistration_test extends TestBaseForRegistration {

    @Features("Регистрация.Некорректные данные")
    @Stories("Пустые поля")
    @Test(enabled = true)
    //all fields are EMPTY
    public void EmptyFields() throws InterruptedException, UnsupportedEncodingException {
        log.log(Level.INFO, "Incorrect test: All Empty fields start. Use lang:" + language);
        app.getRegistrationHelper().fillRegistrationForm("", "", "");
        app.getRegistrationHelper().clickRegisterButton();

        assertThat(app.getRegistrationHelper().getTextError(Constant.NAME), equalTo(Constant.getEmptyErrorLanguage(language)));
        log.log(Level.INFO, app.getRegistrationHelper().getTextError(Constant.NAME));
        assertThat(app.getRegistrationHelper().getTextError(Constant.ORGANISATION), equalTo(Constant.getEmptyErrorLanguage(language)));
        log.log(Level.INFO, app.getRegistrationHelper().getTextError(Constant.ORGANISATION));
        assertThat(app.getRegistrationHelper().getTextError(Constant.EMAIL), equalTo(Constant.getEmptyErrorLanguage(language)));
        log.log(Level.INFO, app.getRegistrationHelper().getTextError(Constant.EMAIL));
    }

    @Features("Регистрация.Некорректные данные")
    @Stories("Длинные значения")
    @Test(enabled = true, dataProvider = "registrationLongData", dataProviderClass = DataGenerator.class)
    public void LongFields(String longName, String longOrg, String longEmail) throws InterruptedException {
        log.log(Level.INFO, "Incorrect test: All Long fields start. Use lang:" + language);
        app.getRegistrationHelper().fillRegistrationFormFromClipBoard(longName, longOrg, longEmail);
        assertThat(app.getRegistrationHelper().getValue(Constant.NAME), equalTo(longName.substring(0, 255)));
        assertThat(app.getRegistrationHelper().getValue(Constant.ORGANISATION), equalTo(longOrg.substring(0, 255)));
        assertThat(app.getRegistrationHelper().getValue(Constant.EMAIL), equalTo(longEmail.substring(0, 255)));
    }

    @Features("Регистрация.Некорректные данные")
    @Stories("Некорректный Email")
    @Test(enabled = true, dataProvider = "registrationIncorrectEmailData", dataProviderClass = DataGenerator.class)
    public void BadTypeEmail(String name, String org, String incorrectEmail) {
        log.log(Level.INFO, "Incorrect test: email. Use lang:" + language);
        app.getRegistrationHelper().fillRegistrationFormFromClipBoard(name, org, incorrectEmail);
        app.getRegistrationHelper().clickRegisterButton();
        assertThat(app.getRegistrationHelper().getTextError(Constant.EMAIL), equalTo(Constant.getIncorrectEmailErrorLanguage(language)));
        log.log(Level.INFO, app.getRegistrationHelper().getTextError(Constant.EMAIL));
    }

    @Features("Регистрация.Некорректные данные")
    @Stories("Не согласны с лицензионным соглашением")
    @Test(enabled = true, dataProvider = "registrationSimpleData", dataProviderClass = DataGenerator.class)
    public void checkBoxIsUnselected(String name, String org, String email) {
        log.log(Level.INFO, "Incorrect test: checkbox is unchecked. Use lang:" + language);
        app.getRegistrationHelper().fillRegistrationFormFromClipBoard(name, org, email);
        app.getRegistrationHelper().clickRegisterButton();
        app.getRegistrationHelper().clickRegisterLicencePageButton();
        log.log(Level.INFO, app.getRegistrationHelper().getTextError(Constant.LICENCE_AGREE));
        assertThat(app.getRegistrationHelper().getTextError(Constant.LICENCE_AGREE), equalTo(Constant.getIncorrectCheckBoxLanguage(language)));

    }

    @Features("Регистрация.Некорректные данные")
    @Stories("Ужe зарегистрированный email")
    @Test(enabled = true, dataProvider = "registrationSimpleDataWithoutEmail", dataProviderClass = DataGenerator.class)
    public void alreadyRegisterEmail(String simpleName, String simpleOrg) {
        String email = app.getProperty("email.already.register");
        log.log(Level.INFO, "Already register  email test start . Language: " + language + " and email: " + email);
        app.getRegistrationHelper().fillRegistrationForm(simpleName, simpleOrg, email);
        app.getRegistrationHelper().clickRegisterButton();
        log.log(Level.INFO, app.getRegistrationHelper().getTextError(Constant.EMAIL));
        assertThat(app.getRegistrationHelper().getTextError(Constant.EMAIL), equalTo(Constant.getAlreadyExistErrorLanguage(language)));
    }


    @Features("Регистрация.Некорректные данные")
    @Stories("Ужe существующий в базе email")
    @Test(dataProvider = "registrationSimpleDataWithoutEmail", dataProviderClass = DataGenerator.class)
    public void alreadyExistInDataBaseEmail(String simpleName, String simpleOrg) {
        String email = app.getProperty("email.already.exist.in.db");
        log.log(Level.INFO, "Already exist in database email start. Language: " + language + " and email: " + email);
        app.getRegistrationHelper().fillRegistrationForm(simpleName, simpleOrg, email);
        app.getRegistrationHelper().clickRegisterButton();
        log.log(Level.INFO, app.getRegistrationHelper().getTextError(Constant.EMAIL));
        assertThat(app.getRegistrationHelper().getTextError(Constant.EMAIL), equalTo(Constant.getAlreadyExistInDatabaseErrorLanguage(language)));
    }
}
