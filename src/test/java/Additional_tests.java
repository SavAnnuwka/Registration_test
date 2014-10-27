package test.java;

import main.java.Constants;
import main.java.testBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by Anna on 27.10.2014.
 */
public class Additional_tests extends testBase {
    String language;



    private void checkFieldIsEmpty(String name, String org, String email, String error) {
       // app.getRegistrationHelper().goToRegistrationFromMainPage();
        app.getRegistrationHelper().fillRegistrationForm(
                name,
                org,
                email);
        app.getRegistrationHelper().clickRegisterButtonPage1();
        assertThat(app.getRegistrationHelper().checkError(error), equalTo(Constants.getEmptyErrorLanguage(language)));
        log.info(Constants.getEmptyErrorLanguage(language));
    }


    @Test
    //one  field is empty
    public void incorrectOneEmptyFields() throws InterruptedException {
        log.info("Incorrect test: One empty fields start");
        language = Constants.getRandomLanguage();
        log.info("Use language " + language);
        app.getRegistrationHelper().goToRegistrationFromMainPage();
        app.getRegistrationHelper().selectLanguages(language);
       // Assert.assertEquals(app.getRegistrationHelper().checkPage(1), true);
       // log.info("Page one was open ");
        checkFieldIsEmpty("", Constants.SimpleOrganisation, Constants.SimpleEmail, app.getProperty("error_register_user_name"));
        checkFieldIsEmpty(Constants.SimpleName, "", Constants.SimpleEmail, app.getProperty("error_register_organisation"));
        checkFieldIsEmpty(Constants.SimpleName, Constants.SimpleOrganisation, "", app.getProperty("error_register_email"));

    }


}
