package test.java;

import main.java.UI.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class Additional_tests extends TestBaseForRegistration {


    private void checkFieldIsEmpty(String name, String org, String email, String field) throws UnsupportedEncodingException {
        app.getRegistrationHelper().fillRegistrationForm(name, org, email);
        app.getRegistrationHelper().clickRegisterButton();
        assertThat( app.getRegistrationHelper().getTextError(field) , equalTo(Constant.getEmptyErrorLanguage(language)));
        log.log(Level.INFO, app.getRegistrationHelper().getTextError(field));
    }


    @Test ()
    public void incorrectOneEmptyFields() throws InterruptedException, UnsupportedEncodingException {
        log.log(Level.INFO, "Incorrect test: One empty fields start. Use lang:" + language);
        checkFieldIsEmpty("", Constant.SimpleOrganisation, Constant.SimpleEmail, Constant.NAME);
        checkFieldIsEmpty(Constant.SimpleName, "", Constant.SimpleEmail,  Constant.ORGANISATION);
        checkFieldIsEmpty(Constant.SimpleName, Constant.SimpleOrganisation, "",  Constant.EMAIL);

    }
    @Test ( dataProvider = "registrationSimpleData", dataProviderClass = DataGenerator.class)
     public void checkMainRegistrationPage(String name, String org, String email) throws InterruptedException {
         log.log(Level.INFO, "Check title and description. Use lang:" + language);
         log.log(Level.INFO, "title:" + app.getRegistrationHelper().getText(Constant.TITLE));
         assertThat(app.getRegistrationHelper().getText(Constant.TITLE), equalTo(Constant.getTitleLanguage(language)));
         log.log(Level.INFO, "description:" + app.getRegistrationHelper().getText(Constant.DESCRIPTION));
         assertThat(app.getRegistrationHelper().getText(Constant.DESCRIPTION), equalTo(Constant.getDescriptionLanguage(language)));
         app.getRegistrationHelper().fillRegistrationForm(name, org, email);
         app.getRegistrationHelper().clickRegisterButton();
         Assert.assertEquals(app.getRegistrationHelper().checkLicencePage(), true) ;
        log.log(Level.INFO, "checkBox:" + app.getRegistrationHelper().getText(Constant.LICENCE_AGREE));
         assertThat(  app.getRegistrationHelper().getText(Constant.LICENCE_AGREE), equalTo(Constant.getConfirmCheckboxLanguage(language)));
     }


    //@Test  ()
    public void failMethod() throws InterruptedException, IOException {
        app.getNavigationHelper().goToRegistrationPageFromURL();
        assertThat(0,equalTo(0));
    }



}
