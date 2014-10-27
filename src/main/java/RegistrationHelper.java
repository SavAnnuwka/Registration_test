package main.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class RegistrationHelper  extends HelperWithWebDriverBase {

    public RegistrationHelper(ApplicationManager app) {
        super(app);
    }

    public String getRegistrationURL() {
        return app.getProperty("baseURL") + "/registrations/new";
    }



    public void goToRegistrationFromMainPage() {
        // WebElement link=  findElement(By.cssSelector("body > div.sticky-footer-page-wrap > div.browse-page > div.top-menu-block--default > div > div.right-block > a.sign-up"));
        WebElement link = findElement(By.className("sign-up"));
        link.click();
    }

    public void selectLanguages(String lang) {
        Select sel = new Select(findElement(By.id(app.getProperty("language_id"))));
        sel.selectByValue(lang);


    }

    //page1
    public void fillRegistrationForm(String name, String org, String email) {
        fillTextField(name, app.getProperty("registrationName_id"));
        fillTextField(org, app.getProperty("registrationOrg_id"));
        fillTextField(email, app.getProperty("registrationEmail_id"));
    }

    public void clickRegisterButtonPage1() {
        clickByClass(app.getProperty("register_button_page1"));
    }

    //errors
    public String checkError(String locator) {
        return findElement(By.cssSelector(locator)).getText();
    }

    //page2
    public void confirmCheckbox() {
        clickById(app.getProperty("registration_confirm_id"));
    }

    public void clickRegisterButtonPage2() {
        clickByCss(app.getProperty("register_button_page2"));
    }

    //all page
    public boolean checkPage(int page) throws InterruptedException
    {
        WebElement element = null;
        if (page == 1)
             {
                 wait(By.className("step1"));
                element = findElement(By.className("step1"));

            }
            if (page == 2)
            {   wait(By.className("step2"));
                element = findElement(By.className("step2"));
            }
            if (page == 3)
            {   wait(By.className("step3"));
                element = findElement(By.className("step3"));
            }
             return element != null && element.isDisplayed();


    }

    }


