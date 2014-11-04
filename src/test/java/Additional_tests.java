package test.java;

import main.java.Constants;
import main.java.testBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class Additional_tests extends testBase {
    String language;


    private void checkFieldIsEmpty(String name, String org, String email, String error) {
        app.getRegistrationHelper().fillRegistrationForm(
                name,
                org,
                email);
        app.getRegistrationHelper().clickRegisterButtonPage1();
        assertThat(app.getRegistrationHelper().checkError(error), equalTo(Constants.getEmptyErrorLanguage(language)));
        log.info(Constants.getEmptyErrorLanguage(language));
    }


    @Test
   // one  field is empty
    public void incorrectOneEmptyFields() throws InterruptedException {
        log.log( Level.INFO, "Incorrect test: One empty fields start");
        language = Constants.getRandomLanguage();
        log.log( Level.INFO, "Use language " + language);
        app.getRegistrationHelper().goToRegistrationFromMainPage();
        app.getRegistrationHelper().selectLanguages(language);
       // Assert.assertEquals(app.getRegistrationHelper().checkPage(1), true);
       // log.info("Page one was open ");
        checkFieldIsEmpty("", Constants.SimpleOrganisation, Constants.SimpleEmail, app.getProperty("error_register_user_name"));
        checkFieldIsEmpty(Constants.SimpleName, "", Constants.SimpleEmail, app.getProperty("error_register_organisation"));
        checkFieldIsEmpty(Constants.SimpleName, Constants.SimpleOrganisation, "", app.getProperty("error_register_email"));

    }

   // @Test
    public void failMethod() throws InterruptedException, IOException {

        app.getRegistrationHelper().goToRegistrationFromMainPage();
        assertThat(0,equalTo(0));
    }


}
