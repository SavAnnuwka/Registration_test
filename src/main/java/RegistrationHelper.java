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

    //Page1
    public void fillRegistrationForm(String name, String org,  String email  ) {
        fillTextField(name, app.getProperty("registrationName_id"));
        fillTextField(org ,  app.getProperty("registrationOrg_id"));
        fillTextField(email,  app.getProperty("registrationEmail_id"));
    }

    public void clickRegisterButton(String page) {
       if (page=="Page1") {
           clickByClass(app.getProperty("register_button_page1"));
       }
       if (page=="Page2") {
           clickByXpath(app.getProperty("register_button_page2"));
       }
    }



    //page2
    public void confirmCheckbox() {
        clickById(app.getProperty("registration_confirm_id"));
    }
    public boolean  checkPage(String page) {
        WebElement element = null;
        if (  page=="Page1" )
        {
            element = findElement(By.className("step1"));}
        if  ( page=="Page2"  )
        {
             element = findElement(By.className("step2 hidden"));}
        if  ( page=="Page3"  )
        {
             element = findElement(By.className("step3 hidden"));}

        return element.isEnabled();
    }

}