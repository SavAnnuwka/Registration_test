package main.java.Helpers;

import main.java.ApplicationManager;
import main.java.UI.Constants;
import main.java.testBase;
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
        String language = app.getLanguagesHelper().getRandomLanguage();
        app.getLanguagesHelper().selectLanguageInDropDownList(language);
        return  language;
    }

    public  String getRandomLanguage() {
      String[] allLang = {Constants.DE, Constants.EN, Constants.ES, Constants.FR, Constants.IT, Constants.NL, Constants.PT, Constants.RO, Constants.RU, Constants.SV, Constants.ZH};
        Random rand = new Random();
        int i= rand.nextInt(10);
        return  allLang[i];
    }

    public   void selectLanguageInDropDownList(String lang) {
        Select sel = new Select(findElement(app.getUIMap().getLocator("language")));
        sel.selectByValue(lang);
    }
}
