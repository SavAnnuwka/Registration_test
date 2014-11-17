package main.java.Helpers;


import main.java.ApplicationManager;
import org.openqa.selenium.WebElement;

public class MailHelper   extends HelperWithWebDriverBase {



    public MailHelper(ApplicationManager app) {
        super(app);
    }


    public String getTemporaryEmail() {
        WebElement email = findElement(app.getUIMap().getLocator("email.name"));
        return  email.getText();
    }
    public boolean emptyMail() {
        if ( findElement(app.getUIMap().getLocator("email.isempty")).getText().equals(""))
        return true;
        else return false;
    }
}
