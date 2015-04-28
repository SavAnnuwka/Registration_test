package test.java;

import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class TestBaseForRegistration extends testBase {

    @BeforeMethod()
    public void goToRegisterPageAndSelectLang(Method method) {
       if (!method.getName().contains("withoutStartingBrowser")) {
           app.getNavigationHelper().goToRegistrationPageFromURL();
           language = app.getLanguagesHelper().selectLanguage();
       }
    }
}
