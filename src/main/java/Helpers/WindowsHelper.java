package main.java.Helpers;

import main.java.ApplicationManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.IOException;
import java.util.Set;

/**
 * HANDLER
 */
public class WindowsHelper extends HelperWithWebDriverBase {
    private String originalHandle;
    private String mailHandle;
    private String CMSHandle;

    public WindowsHelper(ApplicationManager app) {
        super(app);
        originalHandle = getWindowHandle();
    }
    public static String getOriginalHandle(String originalHandle) {
       return originalHandle;
    }
    public void waitLoadHandle(String handle) {

        try {
            for (String i : getWindowHandles()) {
                if (i.equals(handle)) {
                    switchTo(handle);
                    activeElement();
                }
            }
        }
        catch(Exception e){
            System.err.println("Couldn't get  page");
        }
    }
    public void openNewMailWindow(String url) {
        final Set<String> WindowsSet = getWindowHandles();
        WindowsHelper.getOriginalHandle(originalHandle);
        mailHandle= openInNewWindow (url);
        goToWindow(mailHandle);
        waitLoadHandle(mailHandle);

    }


    public Set<String> getCurrentListOfHandles()  {
        return getWindowHandles();
    }
    public void  getCMSHandles(Set<String> OldList,Set<String> NewList ) {
      NewList.removeAll(OldList);
        CMSHandle=  NewList.iterator().next();
      /* for(String winHandle: NewList ){
           CMSHandle =  winHandle;
        }   */
    }

    public void goToWindow(String handle) {
        if (!handle.equals(getWindowHandle())) {
            if (handle!=null)  {
                switchTo(handle);
                waitLoadHandle(handle);
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
    public void switchToCMSPage() {
        goToWindow(CMSHandle);}

    public void  takeScreenShot(String fileName) throws IOException {
        File scrFile = ((TakesScreenshot) app.getWebDriverHelper().getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(app.getProperty("pathScreenshot") + fileName + ".png"));
    }

}
