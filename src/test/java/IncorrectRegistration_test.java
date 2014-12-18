package test.java;


import main.java.UI.Constants;
import main.java.testBase;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class IncorrectRegistration_test extends testBase {
    //protected  String language;


    @Test
    //all fields are EMPTY
    public void incorrectAllEmptyFields() throws InterruptedException, UnsupportedEncodingException {
        log.log(Level.INFO, "Incorrect test: All Empty fields start. Use lang:" + language);
        app.getRegistrationHelper().fillRegistrationForm("", "", "");
        app.getRegistrationHelper().clickRegisterButtonPage1();
        assertThat( app.getRegistrationHelper().getText("register.username.error"), equalTo(Constants.getEmptyErrorLanguage(language)));
        log.log( Level.INFO, Constants.getEmptyErrorLanguage(language));
        assertThat( app.getRegistrationHelper().getText("register.organisation.error"), equalTo(Constants.getEmptyErrorLanguage(language)));
        log.log( Level.INFO, Constants.getEmptyErrorLanguage(language));
        assertThat( app.getRegistrationHelper().getText("register.email.error"), equalTo(Constants.getEmptyErrorLanguage(language)));
        log.log( Level.INFO, Constants.getEmptyErrorLanguage(language));
    }

   //all fields are LONG
   @Test (groups = {"default"}, enabled = true, dataProvider = "registrationLongData", dataProviderClass = DataGenerator.class )
    public void incorrectAllLongFields(String longName, String longOrg, String longEmail) throws InterruptedException {
        log.log(Level.INFO, "Incorrect test: All Long fields start. Use lang:" + language);
        app.getWebDriverHelper().openUrl(app.getRegistrationHelper().getRegistrationURL());
        app.getRegistrationHelper().fillRegistrationFormFromClipBoard(longName, longOrg, longEmail);
        assertThat(app.getRegistrationHelper().getValue("register.name"), equalTo(longName.substring(0, 255)));
        assertThat(app.getRegistrationHelper().getValue("register.organisation"), equalTo(longOrg.substring(0, 255)));
        assertThat(app.getRegistrationHelper().getValue("register.email"), equalTo(longEmail.substring(0, 255)));
    }

    //Email incorrect
    @Test (groups = {"default"}, enabled = true, dataProvider = "registrationIncorrectEmailData", dataProviderClass = DataGenerator.class)
    public void incorrectEmailFields(String name, String org, String incorrectEmail)
     {
         log.log(Level.INFO, "Incorrect test: email. Use lang:" + language);
         app.getRegistrationHelper().fillRegistrationFormFromClipBoard(name, org, incorrectEmail);
         app.getRegistrationHelper().clickRegisterButtonPage1();
         assertThat(app.getRegistrationHelper().getText("register.email.error"), equalTo(Constants.getIncorrectEmailErrorLanguage(language)));

     }

    //checkbox is unchecked
    @Test (groups = {"default"}, dataProvider = "registrationSimpleData", dataProviderClass = DataGenerator.class)
    public void checkBoxIsUnselected(String name, String org, String email)
    {    log.log(Level.INFO, "Incorrect test: checkbox is unchecked. Use lang:" + language);
         app.getRegistrationHelper().fillRegistrationFormFromClipBoard(name, org, email);
         app.getRegistrationHelper().clickRegisterButtonPage1();
         app.getRegistrationHelper().clickRegisterButtonPage2();
         assertThat(app.getRegistrationHelper().getText("register.checkbox.error"), equalTo(Constants.getIncorrectCheckBoxLanguage(language)));

    }
    }
