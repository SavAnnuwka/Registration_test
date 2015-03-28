package main.java.Helpers;


import main.java.ApplicationManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.MessageFormat;

public class MailHelper extends HelperWithWebDriverBase {


    public MailHelper(ApplicationManager app) {
        super(app);
    }

    public String getTemporaryEmail() {
        app.getWindowsHelper().switchToMailPage();
        return pages.mailPage.getMailName();
       /* WebElement email = findElement(app.getUIMap().getLocator("email.name"));
          email.getText();    */
    }

    public boolean emptyMail() {
        //  locator =     app.getUIMap().getLocator("email.counter");
        waitElement(20).until(ExpectedConditions.visibilityOf(pages.mailPage.getEmailCounter()));  //visibilityOfElementLocated(locator));
        try {
            return pages.mailPage.MailWasNotReceived();
        } catch (NoSuchElementException e) {
            System.err.println(MessageFormat.format("No element and exception {0}", e.getMessage()));
            return Boolean.parseBoolean(null);
        }
    }

    public String getMailtext() {
        try {
            return pages.mailPage.getMailtext();   //findElement(app.getUIMap().getLocator("email.text")).getText();
        } catch (NoSuchElementException e) {
            System.err.println(MessageFormat.format("No element and exception ", e.getMessage()));
            return null;
        }
    }

    public WebElement getMailLink() {
        try {
            return pages.mailPage.getEmailLink(); // findElement(app.getUIMap().getLocator("email.link"));
        } catch (NoSuchElementException e) {
            System.err.println(MessageFormat.format("No element and exception ", e.getMessage()));
            return null;
        }
    }

    public void goToMailLink() {
        WebElement linkFromMail = getMailLink();
        linkFromMail.click();
    }

    public boolean waitMailLoad(Integer time) {
        waitElement(time).until(ExpectedConditions.visibilityOf(pages.mailPage.getMail()));
        try {
            return !pages.mailPage.getMailName().isEmpty();
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
      app.getWindowsHelper().switchToMailPage();
        return app.getMailHelper().getTemporaryEmail();
    }
}
