package test.java;


import main.java.Constants;
import main.java.testBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class IncorrectRegistration_test extends testBase {
    String language;

    private String RandomLangSelected() {
        String lang = Constants.getRandomLanguage();
        log.log( Level.INFO, "Use language " + lang);
        return  lang;
    }

    //@Test
    //all fields are empty
    public void incorrectAllEmptyFields() throws InterruptedException, UnsupportedEncodingException {
        log.log(Level.INFO, "Incorrect test: All Empty fields start");
        language = RandomLangSelected();
        app.getRegistrationHelper().getRegistrationURL();
        app.getRegistrationHelper().selectLanguages(language);
        app.getRegistrationHelper().clickRegisterButtonPage1();
        assertThat( app.getRegistrationHelper().checkError(app.getProperty("error_register_user_name")), equalTo(Constants.getEmptyErrorLanguage(language)));
        log.log( Level.INFO, Constants.getEmptyErrorLanguage(language));
        assertThat( app.getRegistrationHelper().checkError(app.getProperty("error_register_organisation")), equalTo(Constants.getEmptyErrorLanguage(language)));
        log.log( Level.INFO, Constants.getEmptyErrorLanguage(language));
        assertThat( app.getRegistrationHelper().checkError(app.getProperty("error_register_email")), equalTo(Constants.getEmptyErrorLanguage(language)));
        log.log( Level.INFO, Constants.getEmptyErrorLanguage(language));
    }


   // @Test(dataProvider = "registrationLongData", dataProviderClass = DataGenerator.class )
    public void incorrectAllLongFields(String longName, String longOrg, String longEmail) throws InterruptedException {
        log.log(Level.INFO, "Incorrect test: All Long fields start");
        app.getWebDriverHelper().openUrl(app.getRegistrationHelper().getRegistrationURL());
        app.getRegistrationHelper().fillRegistrationForm(
                longName,
                longOrg,
                longEmail);
        assertThat(app.getRegistrationHelper().getValue(app.getProperty("registrationName_id")), equalTo(longName.substring(0, 255)));
        assertThat(app.getRegistrationHelper().getValue(app.getProperty("registrationOrg_id")), equalTo(longOrg.substring(0, 255)));
        assertThat(app.getRegistrationHelper().getValue(app.getProperty("registrationEmail_id")), equalTo(longEmail.substring(0, 255)));
    }


    @Test (dataProvider = "registrationIncorrectEmailData", dataProviderClass = DataGenerator.class)
    public void incorrectEmailFields(String name, String org, String incorrectEmail)
     {      log.log(Level.INFO, "Incorrect test: email");
            language =  RandomLangSelected();
            app.getRegistrationHelper().selectLanguages(language);
            app.getRegistrationHelper().fillRegistrationForm(
                    name,
                    org,
                    incorrectEmail);
         assertThat(app.getRegistrationHelper().getValue(app.getProperty("registrationEmail_id")), equalTo(Constants.getIncorrectEmailErrorLanguage(language)));

     }

    }
