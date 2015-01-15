package test.java;

import main.java.ApplicationManager;
import main.java.UI.Constant;
import main.java.testBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class Additional_tests extends testBase {



    private void checkFieldIsEmpty(String name, String org, String email, String error) throws UnsupportedEncodingException {
        app.getRegistrationHelper().fillRegistrationForm(name, org, email);
        app.getRegistrationHelper().clickRegisterButton();
        assertThat(app.getRegistrationHelper().getText(error), equalTo(Constant.getEmptyErrorLanguage(language)));
        log.info(Constant.getEmptyErrorLanguage(language));
    }


    @Test ()
    public void incorrectOneEmptyFields() throws InterruptedException, UnsupportedEncodingException {
        log.log(Level.INFO, "Incorrect test: One empty fields start. Use lang:" + language);
        checkFieldIsEmpty("", Constant.SimpleOrganisation, Constant.SimpleEmail, "register.username.error");
        checkFieldIsEmpty(Constant.SimpleName, "", Constant.SimpleEmail, "register.organisation.error");
        checkFieldIsEmpty(Constant.SimpleName, Constant.SimpleOrganisation, "", "register.email.error");

    }
    @Test ( dataProvider = "registrationSimpleData", dataProviderClass = DataGenerator.class)
     public void checkMainRegistrationPage(String name, String org, String email) throws InterruptedException {
         log.log(Level.INFO, "Check title and description. Use lang:" + language);
         log.log(Level.INFO, "title:" + app.getRegistrationHelper().getText("register.title"));
         assertThat(app.getRegistrationHelper().getText("register.title"), equalTo(Constant.getTitleLanguage(language)));
         log.log(Level.INFO, "description:" + app.getRegistrationHelper().getText("register.description"));
         assertThat(app.getRegistrationHelper().getText("register.description"), equalTo(Constant.getDescriptionLanguage(language)));
         app.getRegistrationHelper().fillRegistrationForm(name, org, email);
         app.getRegistrationHelper().clickRegisterButton();
         Assert.assertEquals(app.getRegistrationHelper().checkPage(2), true) ;
         log.log(Level.INFO, "checkBox:" + app.getRegistrationHelper().getText("register.page2.confirm"));
         assertThat( app.getRegistrationHelper().getText("register.page2.confirm"), equalTo(Constant.getConfirmCheckboxLanguage(language)));
     }


    //@Test  ()
    public void failMethod() throws InterruptedException, IOException {
        app.getNavigationHelper().goToRegistrationPageFromURL();
        assertThat(0,equalTo(0));
    }



}
