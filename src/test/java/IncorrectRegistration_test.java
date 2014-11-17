package test.java;


import main.java.UI.Constants;
import main.java.testBase;
import org.testng.annotations.BeforeTest;
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


    @BeforeTest
     public void goToRegistrationPage() {
        app.getWebDriverHelper().openUrl(app.getRegistrationHelper().getRegistrationURL());
    }

    @BeforeTest
    public String selectLanguage() {
        language =  RandomLangSelected();
        app.getRegistrationHelper().selectLanguages(language);
        return  language;
    }



    @Test
    //all fields are EMPTY
    public void incorrectAllEmptyFields() throws InterruptedException, UnsupportedEncodingException {
        log.log(Level.INFO, "Incorrect test: All Empty fields start");
        language = RandomLangSelected();
        app.getRegistrationHelper().getRegistrationURL();
        app.getRegistrationHelper().selectLanguages(language);
        app.getRegistrationHelper().clickRegisterButtonPage1();
        assertThat( app.getRegistrationHelper().checkError("register.username.error"), equalTo(Constants.getEmptyErrorLanguage(language)));
        log.log( Level.INFO, Constants.getEmptyErrorLanguage(language));
        assertThat( app.getRegistrationHelper().checkError("register.organisation.error"), equalTo(Constants.getEmptyErrorLanguage(language)));
        log.log( Level.INFO, Constants.getEmptyErrorLanguage(language));
        assertThat( app.getRegistrationHelper().checkError("register.email.error"), equalTo(Constants.getEmptyErrorLanguage(language)));
        log.log( Level.INFO, Constants.getEmptyErrorLanguage(language));
    }

   //all fields are LONG
   @Test(dataProvider = "registrationLongData", dataProviderClass = DataGenerator.class )
    public void incorrectAllLongFields(String longName, String longOrg, String longEmail) throws InterruptedException {
        log.log(Level.INFO, "Incorrect test: All Long fields start");
        app.getWebDriverHelper().openUrl(app.getRegistrationHelper().getRegistrationURL());
        app.getRegistrationHelper().fillRegistrationForm(
                longName,
                longOrg,
                longEmail);
        assertThat(app.getRegistrationHelper().getValue("register.name"), equalTo(longName.substring(0, 255)));
        assertThat(app.getRegistrationHelper().getValue("register.organisation"), equalTo(longOrg.substring(0, 255)));
        assertThat(app.getRegistrationHelper().getValue("register.email"), equalTo(longEmail.substring(0, 255)));
    }

    //Email incorrect
    @Test (dataProvider = "registrationIncorrectEmailData", dataProviderClass = DataGenerator.class)
    public void incorrectEmailFields(String name, String org, String incorrectEmail)
     {      log.log(Level.INFO, "Incorrect test: email");
         app.getWebDriverHelper().openUrl(app.getRegistrationHelper().getRegistrationURL());
            language =  RandomLangSelected();
            app.getRegistrationHelper().selectLanguages(language);
            app.getRegistrationHelper().fillRegistrationForm(
                    name,
                    org,
                    incorrectEmail);
         app.getRegistrationHelper().clickRegisterButtonPage1();
         assertThat(app.getRegistrationHelper().checkError("register.email.error"), equalTo(Constants.getIncorrectEmailErrorLanguage(language)));

     }

    //checkbox is unchecked
    @Test (dataProvider = "registrationSimpleData", dataProviderClass = DataGenerator.class)
    public void CheckBoxIsUnselected (String name, String org, String email)
    {    log.log(Level.INFO, "Incorrect test: checkbox is unchecked");
         app.getRegistrationHelper().fillRegistrationForm(name, org, email);
         app.getRegistrationHelper().clickRegisterButtonPage1();
         app.getRegistrationHelper().clickRegisterButtonPage2();
         assertThat(app.getRegistrationHelper().checkError("register.checkbox.error"), equalTo(Constants.getIncorrectCheckBoxLanguage(language)));

    }

    }
