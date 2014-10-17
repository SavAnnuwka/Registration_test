package test.java;


import main.java.Constants;
import main.java.testBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class IncorrectRegistration_test extends testBase {
    String language;

    @Test
    public void emptyFieldsEn() {
        //выбрать язык
        language = Constants.getRandomLanguage();
        app.getRegistrationHelper().goToRegistrationFromMainPage();
        app.getRegistrationHelper().selectLanguages(language);
        Assert.assertEquals(app.getRegistrationHelper().checkPage(1), true) ;
        System.out.println("Page one was open ");
        app.getRegistrationHelper().clickRegisterButtonPage1();
        //придумать как отдавать верное сообщение,в зависимости от lang
        assertThat( app.getRegistrationHelper().checkErrorName() , equalTo(Constants.Error.EMPTY));
        System.out.println(Constants.Error.EMPTY);
        assertThat(app.getRegistrationHelper().checkErrorOrganisation(), equalTo(Constants.Error.EMPTY));
        System.out.println(Constants.Error.EMPTY);
        assertThat(app.getRegistrationHelper().checkErrorEmail(), equalTo(Constants.Error.EMPTY));
        System.out.println(Constants.Error.EMPTY);
    }
}
