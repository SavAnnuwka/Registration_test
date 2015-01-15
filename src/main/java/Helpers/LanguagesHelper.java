package main.java.Helpers;

import main.java.ApplicationManager;
import main.java.UI.Constant;
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
      String[] allLang = {Constant.DE, Constant.EN, Constant.ES, Constant.FR, Constant.IT, Constant.NL, Constant.PT, Constant.RO, Constant.RU, Constant.SV, Constant.ZH};
        Random rand = new Random();
        int i= rand.nextInt(10);
        return  allLang[i];
    }

    public   void selectLanguageInDropDownList(String lang) {
        Select sel = new Select(findElement(app.getUIMap().getLocator("language")));
        sel.selectByValue(lang);
    }
}
