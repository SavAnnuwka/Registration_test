package test.java;

import java.util.logging.Level;

import main.java.UI.Constants;
import main.java.testBase;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by Annet on 06.12.2014.
 */
public class CheckText_test extends testBase {

    @Test
        public void checkMainRegistrationPage(){
        log.log(Level.INFO, "Check title and description. Use lang:" + language);
        assertThat( app.getRegistrationHelper().getText("register.title"), equalTo(Constants.getTitleLanguage(language)));
        System.out.println("Selenium:" + app.getRegistrationHelper().getText("register.title"));
        System.out.println("Constant:" + equalTo(Constants.getTitleLanguage(language)));
        assertThat(app.getRegistrationHelper().getText("register.description"), equalTo(Constants.getDescriptionLanguage(language)));

    }


}
