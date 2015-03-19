package test.java;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class TestBaseForRegistration extends testBase {

    @BeforeMethod()
    public void goToRegisterPageAndSelectLang() {
        System.err.println("BeforeMethod");
         app.getNavigationHelper().goToRegistrationPageFromURL();
        language = app.getLanguagesHelper().selectLanguage();
    }
}
