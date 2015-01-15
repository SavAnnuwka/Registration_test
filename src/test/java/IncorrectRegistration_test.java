package test.java;


import main.java.Helpers.RegistrationHelper;
import main.java.UI.Constant;
import main.java.testBase;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class IncorrectRegistration_test extends testBase {
    //protected  String language;


    @Test  (enabled = true)
    //all fields are EMPTY
    public void incorrectAllEmptyFields() throws InterruptedException, UnsupportedEncodingException {
        log.log(Level.INFO, "Incorrect test: All Empty fields start. Use lang:" + language);
        app.getRegistrationHelper().fillRegistrationForm("", "", "");
        app.getRegistrationHelper().clickRegisterButtonPage1();
        assertThat( app.getRegistrationHelper().getText("register.username.error"), equalTo(Constant.getEmptyErrorLanguage(language)));
        log.log( Level.INFO,app.getRegistrationHelper().getText("register.username.error"));
        assertThat( app.getRegistrationHelper().getText("register.organisation.error"), equalTo(Constant.getEmptyErrorLanguage(language)));
        log.log( Level.INFO,app.getRegistrationHelper().getText("register.organisation.error"));
        assertThat( app.getRegistrationHelper().getText("register.email.error"), equalTo(Constant.getEmptyErrorLanguage(language)));
        log.log( Level.INFO,  app.getRegistrationHelper().getText("register.email.error"));
    }

   //all fields are LONG
   @Test (enabled = true, dataProvider = "registrationLongData", dataProviderClass = DataGenerator.class )
    public void incorrectAllLongFields(String longName, String longOrg, String longEmail) throws InterruptedException {
        log.log(Level.INFO, "Incorrect test: All Long fields start. Use lang:" + language);
        app.getWebDriverHelper().openUrl(app.getNavigationHelper().getRegistrationURL());
        app.getRegistrationHelper().fillRegistrationFormFromClipBoard(longName, longOrg, longEmail);
       // переделать
        assertThat(app.getRegistrationHelper().getValue("register.name"), equalTo(longName.substring(0, 255)));
        assertThat(app.getRegistrationHelper().getValue("register.organisation"), equalTo(longOrg.substring(0, 255)));
        assertThat(app.getRegistrationHelper().getValue("register.email"), equalTo(longEmail.substring(0, 255)));
    }

    //Email incorrect
    @Test (enabled = true, dataProvider = "registrationIncorrectEmailData", dataProviderClass = DataGenerator.class)
    public void incorrectEmailFields(String name, String org, String incorrectEmail)
     {
         log.log(Level.INFO, "Incorrect test: email. Use lang:" + language);
         app.getRegistrationHelper().fillRegistrationFormFromClipBoard(name, org, incorrectEmail);
         app.getRegistrationHelper().clickRegisterButtonPage1();
         log.log( Level.INFO, app.getRegistrationHelper().getText("register.email.error"));
         assertThat(app.getRegistrationHelper().getText("register.email.error"), equalTo(Constant.getIncorrectEmailErrorLanguage(language)));

     }

    //checkbox is unchecked
    @Test ( enabled = true, dataProvider = "registrationSimpleData", dataProviderClass = DataGenerator.class)
    public void checkBoxIsUnselected(String name, String org, String email)
    {    log.log(Level.INFO, "Incorrect test: checkbox is unchecked. Use lang:" + language);
         app.getRegistrationHelper().fillRegistrationFormFromClipBoard(name, org, email);
         app.getRegistrationHelper().clickRegisterButtonPage1();
         app.getRegistrationHelper().clickRegisterButtonPage2();
        log.log( Level.INFO, app.getRegistrationHelper().getText("register.checkbox.error"));
         assertThat(app.getRegistrationHelper().getText("register.checkbox.error"), equalTo(Constant.getIncorrectCheckBoxLanguage(language)));

    }

    //email already register
    @Test(enabled = true, dataProvider = "registrationSimpleDataWithoutEmail", dataProviderClass = DataGenerator.class)
    public void alreadyRegisterEmail (String simpleName, String simpleOrg ){
        String email = app.getProperty("email.already.register") ;
        log.log( Level.INFO, "Already register  email test start . Language: " + language + " and email: " + email);
        app.getRegistrationHelper().fillRegistrationForm(simpleName, simpleOrg, email);
        app.getRegistrationHelper().clickRegisterButtonPage1();
        log.log( Level.INFO, app.getRegistrationHelper().getText("register.email.error"));
        assertThat( app.getRegistrationHelper().getText("register.email.error"), equalTo(Constant.getAlreadyExistErrorLanguage(language)));
    }


    //email already exist in database
    @Test( dataProvider = "registrationSimpleDataWithoutEmail", dataProviderClass = DataGenerator.class)
    public void alreadyExistInDataBaseEmail (String simpleName, String simpleOrg ){
        String email = app.getProperty("email.already.exist.in.db") ;
        log.log( Level.INFO, "Already exist in database email start. Language: " + language + " and email: " + email);
        app.getRegistrationHelper().fillRegistrationForm(simpleName, simpleOrg, email);
        app.getRegistrationHelper().clickRegisterButtonPage1();
        log.log( Level.INFO,  app.getRegistrationHelper().getText("register.email.error"));
        assertThat( app.getRegistrationHelper().getText("register.email.error"), equalTo(Constant.getAlreadyExistInDatabaseErrorLanguage(language)));
     }
    }
