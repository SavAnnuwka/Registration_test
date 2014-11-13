package main.java;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class MailHelper   extends HelperWithWebDriverBase {



    public MailHelper(ApplicationManager app) {
        super(app);
    }


    public String getTemporaryEmail() {
        WebElement email = findElement(By.className("email"));
        return  email.getText();
    }
    public boolean emptyMail() {
        if ( findElement(By.cssSelector("em")).getText().equals(""))
        return true;
        else return false;
    }
}
