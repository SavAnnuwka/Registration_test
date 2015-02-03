package main.java.Helpers;

import main.java.ApplicationManager;
import main.java.UI.Constant;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

/**
 * Created by Annet on 22.11.2014.
 */
public class LanguagesHelper extends HelperWithWebDriverBase{

    public LanguagesHelper(ApplicationManager app) {
        super(app);
    }


    public  String selectLanguage() {
        String language = Constant.getRandomLanguage();
        app.getLanguagesHelper().selectLanguageInDropDownList(language);
        return  language;
    }


    public   void selectLanguageInDropDownList(String lang) {
        lang = pages.registrationPage.getLanguageForRegistration() + lang;
        Select sel = new Select(pages.registrationPage.getLanguages()) ;
       // Select sel = new Select(findElement(app.getUIMap().getLocator("language")));
        sel.selectByValue(lang);
    }
}
