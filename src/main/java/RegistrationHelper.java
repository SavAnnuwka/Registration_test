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

    //page1
    public void fillRegistrationForm(String name, String org,  String email  ) {
        fillTextField(name, app.getProperty("registrationName_id"));
        fillTextField(org ,  app.getProperty("registrationOrg_id"));
        fillTextField(email,  app.getProperty("registrationEmail_id"));
    }
    public void clickRegisterButtonPage1() {
           clickByClass(app.getProperty("register_button_page1"));
       }

    //errors
    public String  checkErrorName() {
      return   findElement(By.cssSelector( app.getProperty("error_register_user_name"))).getText();
    }
    public String  checkErrorOrganisation() {
        return   findElement(By.cssSelector( app.getProperty("error_register_organisation"))).getText();
    }
    public String  checkErrorEmail() {
        return   findElement(By.cssSelector( app.getProperty("error_register_email"))).getText();
    }




    //page2
    public void confirmCheckbox() {
        clickById(app.getProperty("registration_confirm_id"));
    }
    public void clickRegisterButtonPage2() {
        clickByCss(app.getProperty("register_button_page2"));
    }
   //all page
    public boolean  checkPage(int page) {
        WebElement element = null;
        if (  page==1 )
        {
            element = findElement(By.className("step1"));}
        if  ( page==2  )
        {
             element = findElement(By.className("step2"));}
        if  ( page==3  )
        {
             element = findElement(By.className("step3"));}

        return element.isDisplayed();
    }


}