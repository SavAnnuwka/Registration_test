package main.java.Helpers;

import main.java.ApplicationManager;
import main.java.UI.Constant;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Annet on 22.11.2014.
 */
public class LanguagesHelper extends HelperWithWebDriverBase {

    public LanguagesHelper(ApplicationManager app) {
        super(app);
    }




    public String selectLanguage() {
        String language = Constant.getRandomLanguage();
        app.getLanguagesHelper().selectLanguageInDropDownList(language);
        return language;
    }

    public void selectLanguageInDropDownList(String lang) {
    //    lang = pages.registrationPage.getLanguageForRegistration() + lang;
        Select sel = new Select(pages.registrationPage.getLanguages());
        sel.selectByValue(lang);
    }
}
