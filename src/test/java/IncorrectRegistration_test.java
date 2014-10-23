package test.java;


import main.java.Constants;
import main.java.testBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class IncorrectRegistration_test extends testBase {
    String language;

    @Test
    public void incorrectEmptyFields() {
        log.info("Incorrect test: Empty fields start");
        language = Constants.getRandomLanguage();
        log.info("Use language " + language);
        app.getRegistrationHelper().goToRegistrationFromMainPage();
        app.getRegistrationHelper().selectLanguages(language);
        Assert.assertEquals(app.getRegistrationHelper().checkPage(1), true) ;
        log.info("Page one was open ");
        app.getRegistrationHelper().clickRegisterButtonPage1();
        assertThat( app.getRegistrationHelper().checkErrorName(), equalTo(Constants.getEmptyErrorLanguage(language)));
        log.info(Constants.getEmptyErrorLanguage(language));
        assertThat( app.getRegistrationHelper().checkErrorOrganisation(), equalTo(Constants.getEmptyErrorLanguage(language)));
        log.info(Constants.getEmptyErrorLanguage(language));
        assertThat( app.getRegistrationHelper().checkErrorEmail(), equalTo(Constants.getEmptyErrorLanguage(language)));
        log.info(Constants.getEmptyErrorLanguage(language));
    }
}
