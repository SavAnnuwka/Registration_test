package main.java.Helpers;

import main.java.ApplicationManager;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Annet on 22.11.2014.
 */
public class LanguagesHelper extends HelperWithWebDriverBase {

    public LanguagesHelper(ApplicationManager app) {
        super(app);
    }

    public String selectLanguage() {

        String language =  app.getWebDriverHelper().getLanguage(); //Constant.getRandomLanguage();
        app.getLanguagesHelper().selectLanguageInDropDownList(language);
        return language;
    }
    public void selectLanguageInDropDownList(String lang) {
    //  for old system
      //lang = pages.registrationPage.getLanguageForRegistration() + lang;
        Select sel = new Select(pages.registrationPage.getLanguages());
        sel.selectByValue(lang);
    }
}
