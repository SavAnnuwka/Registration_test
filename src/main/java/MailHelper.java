package main.java;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Properties;

public class MailHelper   extends HelperWithWebDriverBase {


    private ApplicationManager appMail;

    public MailHelper(ApplicationManager app) {
        super(app);
    }

    //use dropmail.me
    public String getTemporaryEmail() {
        appMail =  ApplicationManager.getInstance();
        openUrl( appMail.getProperty("temporaryMail"));
        WebElement email = findElement(By.className("email"));
        return  email.getText();
    }


}
