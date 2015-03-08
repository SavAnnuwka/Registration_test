package test.java;

import org.testng.annotations.BeforeMethod;

public class TestBaseForRegistration extends testBase {

    @BeforeMethod()
    public void goToRegisterPageAndSelectLang() {
        app.getNavigationHelper().goToRegistrationPageFromURL();
        language = app.getLanguagesHelper().selectLanguage();
    }
}
