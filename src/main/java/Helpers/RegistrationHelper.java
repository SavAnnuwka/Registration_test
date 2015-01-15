package main.java.Helpers;

import main.java.ApplicationManager;
import main.java.UI.Constant;
import org.openqa.selenium.WebElement;


public class RegistrationHelper  extends HelperWithWebDriverBase {

    public RegistrationHelper(ApplicationManager app) {
        super(app);
    }


    /**
     * PAGE 1
     */
   public void fillRegistrationForm(String name, String org, String email) {
        pages.registrationPage.setNameField(name);
        pages.registrationPage.setOrganisationField(org);
        pages.registrationPage.setEmailField(email);
    }
    public void fillRegistrationFormFromClipBoard(String name, String org, String email) {
        pages.registrationPage.setNameFieldfromClipBoard(name);
        pages.registrationPage.setOrganisationFieldfromClipBoard(org);
        pages.registrationPage.setEmailFieldgromClipBoard(email);
    }


    public void clickRegisterButton() {
        pages.registrationPage.clickSubmitButton();
    }

   public String getValue(String locator) {
        return  findElement(app.getUIMap().getLocator(locator)).getAttribute("value").toString();
    }

    public String getTextError(String field) {
        if (field == Constant.NAME) {
            return   pages.errorPage.getNameError();
        }
        if (field == Constant.ORGANISATION) {
            return  pages.errorPage.getOrganisationError();
        }
        if (field == Constant.EMAIL) {
            return  pages.errorPage.getEmailError();
        }
        return  "Incorrect result. No  error";
    }


    /**
     * PAGE 2
     */
    public void confirmCheckbox() {
        findElement(app.getUIMap().getLocator("register.page2.confirm")).click();
    }
    public void clickRegisterLicencePageButton() {
        findElement(app.getUIMap().getLocator("register.page2.button")).click();
    }

    /**
     * ALL PAGEs
     */
    public boolean checkPage(int page) throws InterruptedException {
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

