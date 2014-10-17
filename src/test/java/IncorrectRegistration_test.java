package test.java;


import main.java.testBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class IncorrectRegistration_test extends testBase {

    @Test
    public void emptyFieldsEn() {
        //выбрать язык
        app.getRegistrationHelper().goToRegistrationFromMainPage();
        Assert.assertEquals(app.getRegistrationHelper().checkPage(1), true) ;
        System.out.println("Page one was open ");
        app.getRegistrationHelper().clickRegisterButtonPage1();
        assertThat(app.getRegistrationHelper().checkErrorName(), equalTo( app.getProperty("error_register.empty.text")));
        System.out.println("error_register.empty.text");
        assertThat(app.getRegistrationHelper().checkErrorOrganisation(), equalTo( app.getProperty("error_register.empty.text")));
        System.out.println("error_register.empty.text");
        assertThat(app.getRegistrationHelper().checkErrorEmail(), equalTo( app.getProperty("error_register.empty.text")));
        System.out.println("error_register.empty.text");
    }
}
