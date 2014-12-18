package test.java;

import main.java.UI.Constants;
import main.java.testBase;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class Additional_tests extends testBase {




    private void checkFieldIsEmpty(String name, String org, String email, String error) throws UnsupportedEncodingException {
        app.getRegistrationHelper().fillRegistrationForm(
                name,
                org,
                email);
        app.getRegistrationHelper().clickRegisterButtonPage1();
        assertThat(app.getRegistrationHelper().getText(error), equalTo(Constants.getEmptyErrorLanguage(language)));
        log.info(Constants.getEmptyErrorLanguage(language));
    }


    @Test (groups = {"default"})
   // one  field is empty
    public void incorrectOneEmptyFields() throws InterruptedException, UnsupportedEncodingException {
        log.log(Level.INFO, "Incorrect test: One empty fields start. Use lang:" + language);
        checkFieldIsEmpty("", Constants.SimpleOrganisation, Constants.SimpleEmail, "register.username.error");
        checkFieldIsEmpty(Constants.SimpleName, "", Constants.SimpleEmail, "register.organisation.error");
        checkFieldIsEmpty(Constants.SimpleName, Constants.SimpleOrganisation, "", "register.email.error");

    }

   // @Test  (groups = "default")
    public void failMethod() throws InterruptedException, IOException {
        app.getRegistrationHelper().goToRegistrationPageFromURL();
        assertThat(0,equalTo(0));
    }


}
