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
        return pages.mailPage.getMailName();
       /* WebElement email = findElement(app.getUIMap().getLocator("email.name"));
          email.getText();    */
    }

    public boolean emptyMail() {
        //  locator =     app.getUIMap().getLocator("email.counter");
        waitElement(20).until(ExpectedConditions.visibilityOf(pages.mailPage.getEmailCounter()));  //visibilityOfElementLocated(locator));
        try {
            if (pages.mailPage.MailWasNotReceived())
                return true;
            else return false;
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
}
