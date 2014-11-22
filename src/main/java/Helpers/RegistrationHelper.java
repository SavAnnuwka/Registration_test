package main.java.Helpers;

import main.java.ApplicationManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class RegistrationHelper  extends HelperWithWebDriverBase {

    public RegistrationHelper(ApplicationManager app) {
        super(app);
    }


    public String getRegistrationURL() {
        return app.getProperty("baseURL") + "/registrations/new";
    }

    public  void goToRegistrationPageFromURL() {
        app.getWebDriverHelper().openUrl(app.getRegistrationHelper().getRegistrationURL());
    }

    public void goToRegistrationFromMainPage()  {
        WebElement link = findElement(app.getUIMap().getLocator("registration_link"));
        link.click();
    }


    //page1
    public void fillRegistrationForm(String name, String org, String email) {
        fillTextField(name,app.getUIMap().getLocator("register.name"));
        fillTextField(org, app.getUIMap().getLocator("register.organisation"));
        fillTextField(email, app.getUIMap().getLocator("register.email"));
    }
    public void clickRegisterButtonPage1() {
        findElement(app.getUIMap().getLocator("register.page1.button")).click();
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
        findElement(app.getUIMap().getLocator("register.page2.confirm")).click();
    }
    public void clickRegisterButtonPage2() {
        findElement(app.getUIMap().getLocator("register.page2.button")).click();
    }

    //all page
    public boolean checkPage(int page) throws InterruptedException
    {
        WebElement element = null;
        if (page == 1)
             {
                 wait(app.getUIMap().getLocator("register.page1.isdisplayed"));
                 element = findElement(app.getUIMap().getLocator("register.page1.isdisplayed"));

            }
            if (page == 2)
            {     wait(app.getUIMap().getLocator("register.page2.isdisplayed"));
                element = findElement(app.getUIMap().getLocator("register.page2.isdisplayed"));
            }
            if (page == 3)
            {    wait(app.getUIMap().getLocator("register.page3.isdisplayed"));
                element = findElement(app.getUIMap().getLocator("register.page3.isdisplayed"));
            }
             return element != null && element.isDisplayed();


    }

    }


