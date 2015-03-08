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

    public boolean waitMailLoad(Integer time) {
        waitElement(time).until(ExpectedConditions.visibilityOf(pages.mailPage.getMail()));
        try {
            if (pages.mailPage.getMailName().isEmpty())
                return false;
            else return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public String getEMail() {
        app.getWindowsHelper().openNewMailWindow(app.getProperty("temporaryMail"));
        if (!waitMailLoad(5)) {
            app.getNavigationHelper().reloadPage();
            waitMailLoad(10);
        }
        return app.getMailHelper().getTemporaryEmail();
    }


    public String selectLanguage() {
        String language = Constant.getRandomLanguage();
        app.getLanguagesHelper().selectLanguageInDropDownList(language);
        return language;
    }

    public void selectLanguageInDropDownList(String lang) {
        lang = pages.registrationPage.getLanguageForRegistration() + lang;
        Select sel = new Select(pages.registrationPage.getLanguages());
        sel.selectByValue(lang);
    }
}
