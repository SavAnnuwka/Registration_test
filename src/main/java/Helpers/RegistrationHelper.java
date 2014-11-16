package main.java.Helpers;

import main.java.ApplicationManager;
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

    public void goToRegistrationFromMainPage()  {
        WebElement link = findElement(app.getUIMap().getLocator("registration_link"));
        link.click();
    }
    public void selectLanguages(String lang) {
        Select sel = new Select(findElement(app.getUIMap().getLocator("language")));
        sel.selectByValue(lang);
    }

    //page1
    public void fillRegistrationForm(String name, String org, String email) {
        fillTextField(name,app.getUIMap().getLocator("registrationName"));
        fillTextField(org, app.getUIMap().getLocator("registrationOrg"));
        fillTextField(email, app.getUIMap().getLocator("registrationEmail"));
    }
    public void clickRegisterButtonPage1() {
        findElement(app.getUIMap().getLocator("register_button_page1")).click();
    }
    public String getValue(String locator)
    {
        return  findElement(app.getUIMap().getLocator(locator)).getAttribute("value").toString();
    }


    //errors
    public String checkError(String locator) {
        return findElement(app.getUIMap().getLocator(locator)).getText();
    }

    //page2
    public void confirmCheckbox() {
        findElement(app.getUIMap().getLocator("registration_confirm")).click();
    }
    public void clickRegisterButtonPage2() {
        findElement(app.getUIMap().getLocator("register_button_page2")).click();
    }

    //all page
    public boolean checkPage(int page) throws InterruptedException
    {
        WebElement element = null;
        if (page == 1)
             {
                 wait(app.getUIMap().getLocator("PageOneIsDisplayed"));
                 element = findElement(app.getUIMap().getLocator("PageOneIsDisplayed"));

            }
            if (page == 2)
            {     wait(app.getUIMap().getLocator("PageTwoIsDisplayed"));
                element = findElement(app.getUIMap().getLocator("PageTwoIsDisplayed"));
            }
            if (page == 3)
            {    wait(app.getUIMap().getLocator("PageThreeIsDisplayed"));
                element = findElement(app.getUIMap().getLocator("PageThreeIsDisplayed"));
            }
             return element != null && element.isDisplayed();


    }

    }


