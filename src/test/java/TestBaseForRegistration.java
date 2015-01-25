package test.java;

import org.testng.annotations.BeforeMethod;

public class testBaseForRegistration extends testBase {

    @BeforeMethod()
    public void goToRegisterPageAndSelectLang() {
//ug
        app.getNavigationHelper().goToRegistrationPageFromURL();
        language = app.getLanguagesHelper().selectLanguage();
    }
}
