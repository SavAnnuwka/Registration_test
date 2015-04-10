package main.java.Helpers;


import main.java.ApplicationManager;
import main.java.UI.Constant;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.MessageFormat;
import java.util.logging.Level;

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
            log.log(Level.SEVERE, e.getMessage());
            return Boolean.parseBoolean(null);
        }
    }

    public String getMailtext() {
        try {
            return pages.mailPage.getMailtext();   //findElement(app.getUIMap().getLocator("email.text")).getText();
        } catch (NoSuchElementException e) {
            log.log(Level.SEVERE, e.getMessage());
            System.err.println(MessageFormat.format("No element and exception ", e.getMessage()));
            return null;
        }
    }

    public WebElement getMailLink() {
        try {
            return pages.mailPage.getEmailLink(); // findElement(app.getUIMap().getLocator("email.link"));
        } catch (NoSuchElementException e) {
            log.log(Level.SEVERE, e.getMessage());
            System.err.println(MessageFormat.format("No element and exception ", e.getMessage()));
            return null;
        }
    }

    public void goToMailLink() {
        WebElement linkFromMail = getMailLink();
        linkFromMail.click();
    }

    public boolean waitMailLoad(Integer time) {
      //  if (!Constant.BROWSER.equals(Constant.CHROME)){
        waitElement(time).until(ExpectedConditions.elementToBeClickable(pages.mailPage.getMail()));
     //   else{
     //   waitElement(time).until(ExpectedConditions.elementToBeClickable(pages.mailPage.getClipboard()));}
        try {
            return pages.mailPage.displayMailName();}
        catch (NoSuchElementException e) {log.log(Level.SEVERE, e.getMessage()); return false;}

    }


    public String getEMail() {
        app.getWindowsHelper().openNewMailWindow(app.getProperty("temporaryMail"));
        app.getWindowsHelper().switchToMailPage();
       if (!waitMailLoad(5)) {
            app.getNavigationHelper().reloadPage();
            waitMailLoad(5);
        }

        return app.getMailHelper().getTemporaryEmail();
    }
}
