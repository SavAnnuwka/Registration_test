package main.java.Helpers;

import main.java.ApplicationManager;

/**
 * Created by Annet on 12.01.2015.
 */
public class NavigationHelper extends HelperWithWebDriverBase {

    public NavigationHelper(ApplicationManager app) {
        super(app);
    }

    public  String getRegistrationURL( ) {
        return app.getProperty("baseURL") + app.getProperty("registerURL");
    }
    public  String getNewUserURL() {
        return  app.getProperty("newUserURL");
    }
    public  void goToRegistrationPageFromURL( ) {
        String currentURL = currentUrl();
        if (currentURL.indexOf("?") > 0) {
            currentURL =  (currentURL.substring(0, currentURL.indexOf("?")));
        }
        if (currentURL != getRegistrationURL()) {
         app.getWebDriverHelper().openUrl(getRegistrationURL());
        }
    }

    public String getCurrentUrl() {
        return super.currentUrl();
    }

}
