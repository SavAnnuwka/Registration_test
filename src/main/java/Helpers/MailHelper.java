package main.java.Helpers;


import main.java.ApplicationManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.text.MessageFormat;

public class MailHelper   extends HelperWithWebDriverBase {



    public MailHelper(ApplicationManager app) {
        super(app);
    }


    public String getTemporaryEmail() {
        WebElement email = findElement(app.getUIMap().getLocator("email.name"));
        return  email.getText();
    }
    public boolean emptyMail() {
       try {
           if (findElement(app.getUIMap().getLocator("email.counter")).getText().isEmpty())
               return true;
           else return false;
       }
       catch(NoSuchElementException e) {
           System.err.println(MessageFormat.format("No element and exception {0}", e.getMessage()));
           return Boolean.parseBoolean(null);
       }
    }

    public String  getMailtext() {
        try{
       return  findElement(app.getUIMap().getLocator("email.text")).getText();
        }
        catch (NoSuchElementException  e) {
            System.err.println(MessageFormat.format("No element and exception ", e.getMessage()));
            return null;
        }
    }

}
