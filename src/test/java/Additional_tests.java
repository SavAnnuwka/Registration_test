package test.java;

import main.java.UI.Constants;
import main.java.testBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class Additional_tests extends testBase {
   private String language;

    @BeforeMethod
    private void goToRegisterPageAndSelectLang()
    {
        app.getRegistrationHelper().goToRegistrationPageFromURL();
        language =  app.getLanguagesHelper().selectLanguage();
        System.out.println("before");
    }

    private void checkFieldIsEmpty(String name, String org, String email, String error) throws UnsupportedEncodingException {
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
    public void incorrectOneEmptyFields() throws InterruptedException, UnsupportedEncodingException {
        log.log(Level.INFO, "Incorrect test: One empty fields start. Use lang:" + language);
        checkFieldIsEmpty("", Constants.SimpleOrganisation, Constants.SimpleEmail, "register.username.error");
        checkFieldIsEmpty(Constants.SimpleName, "", Constants.SimpleEmail, "register.organisation.error");
        checkFieldIsEmpty(Constants.SimpleName, Constants.SimpleOrganisation, "", "register.email.error");

    }

   // @Test
    public void failMethod() throws InterruptedException, IOException {
        app.getRegistrationHelper().goToRegistrationFromMainPage();
        assertThat(0,equalTo(0));
    }


}
