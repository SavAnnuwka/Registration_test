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
    //all fields are empty
    public void incorrectAllEmptyFields() throws InterruptedException {
        log.info("Incorrect test: All Empty fields start");
        language = Constants.getRandomLanguage();
        log.info("Use language " + language);
        app.getRegistrationHelper().goToRegistrationFromMainPage();
        app.getRegistrationHelper().selectLanguages(language);
        Assert.assertEquals(app.getRegistrationHelper().checkPage(1), true) ;
        log.info("Page one was open ");
        app.getRegistrationHelper().clickRegisterButtonPage1();
        assertThat( app.getRegistrationHelper().checkError(app.getProperty("error_register_user_name")), equalTo(Constants.getEmptyErrorLanguage(language)));
        log.info(Constants.getEmptyErrorLanguage(language));
        assertThat( app.getRegistrationHelper().checkError(app.getProperty("error_register_organisation")), equalTo(Constants.getEmptyErrorLanguage(language)));
        log.info(Constants.getEmptyErrorLanguage(language));
        assertThat( app.getRegistrationHelper().checkError(app.getProperty("error_register_email")), equalTo(Constants.getEmptyErrorLanguage(language)));
        log.info(Constants.getEmptyErrorLanguage(language));
    }



  }
