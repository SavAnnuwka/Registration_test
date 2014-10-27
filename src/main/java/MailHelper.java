package main.java;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class MailHelper   extends HelperWithWebDriverBase {

    private String originalHandle;
    private String mailHandle;


    public MailHelper(ApplicationManager app) {
        super(app);
        originalHandle = getWindowHandle();
    }

    public String getOriginalHandle() {
       return originalHandle;
    }
    public void WaitLoadHandle(String handle) {

        try {
            for (String i : getWindowHandles()) {
                if (i.equals(handle)) {
                    switchTo(handle);
                    activeElement();
                }
            }
        }
         catch(Exception e){
         System.err.println("Couldn't get to second page");
        }
      }
    public void openNewMailWindow(String url) {
        final Set<String> WindowsSet = getWindowHandles();
        getOriginalHandle();
         mailHandle= openInNewWindow (url);
         goToWindow(mailHandle);
         WaitLoadHandle(mailHandle);

    }
    public void goToWindow(String handle) {
        if (!handle.equals(getWindowHandle())) {
            if (handle!=null)  {
                switchTo(handle);
                WaitLoadHandle(handle);
            } else System.out.println(handle +"page is not exist");
        }
    }


    public void switchToOriginalPage()
    {
        goToWindow(originalHandle);
    }
    public void switchToMailPage()
    {
        goToWindow(mailHandle);
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
