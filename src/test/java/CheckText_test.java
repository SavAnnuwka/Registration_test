package test.java;

import java.util.logging.Level;

import main.java.UI.Constants;
import main.java.testBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by Annet on 06.12.2014.
 */
public class CheckText_test extends testBase {

    String language;

  //  @Test (groups = {"default"}, dataProvider = "registrationSimpleData", dataProviderClass = DataGenerator.class)

        public void checkMainRegistrationPage(String name, String org, String email) throws InterruptedException {
        log.log(Level.INFO, "Check title and description. Use lang:" + language);
        log.log(Level.INFO, "title:" + app.getRegistrationHelper().getText("register.title"));
        assertThat(app.getRegistrationHelper().getText("register.title"), equalTo(Constants.getTitleLanguage(language)));
        log.log(Level.INFO, "description:" + app.getRegistrationHelper().getText("register.description"));
        assertThat(app.getRegistrationHelper().getText("register.description"), equalTo(Constants.getDescriptionLanguage(language)));
        app.getRegistrationHelper().fillRegistrationForm(name, org, email);
        app.getRegistrationHelper().clickRegisterButtonPage1();
        Assert.assertEquals(app.getRegistrationHelper().checkPage(2), true) ;
        log.log(Level.INFO, "checkBox:" + app.getRegistrationHelper().getText("register.page2.confirm"));
        assertThat( app.getRegistrationHelper().getText("register.page2.confirm"), equalTo(Constants.getConfirmCheckboxLanguage(language)));

    }




}
