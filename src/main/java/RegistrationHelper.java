package main.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class RegistrationHelper  extends HelperWithWebDriverBase {

    public RegistrationHelper(ApplicationManager app) {
        super(app);
    }

    public String getRegistrationURL() {
        return app.getProperty("baseURL") + "/registrations/new";
    }

    public void openRegistrationURL() {
        app.getNavigationHelper().openUrl(getRegistrationURL());
    }

    public void goToRegistrationFromMainPage() {
        // WebElement link=  findElement(By.cssSelector("body > div.sticky-footer-page-wrap > div.browse-page > div.top-menu-block--default > div > div.right-block > a.sign-up"));
        WebElement link = findElement(By.className("sign-up"));
        link.click();
    }


    public void fillRegistrationForm(String name, String name_id, String org, String org_id, String email, String email_id ) {
        fillTextField(name, name_id);
        fillTextField(org, org_id);
        fillTextField(email, email_id);
    }
}