package main.java.Helpers;

import main.java.ApplicationManager;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Set;

/**
 * HANDLER
 */
public class WindowsHelper extends HelperWithWebDriverBase {
    private String originalHandle;
    private String mailHandle;

    public WindowsHelper(ApplicationManager app) {
        super(app);
        originalHandle = getWindowHandle();
    }
    public static String getOriginalHandle(String originalHandle) {
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
        WindowsHelper.getOriginalHandle(originalHandle);
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

    /**
     * Action with keyBoard
     */
    public void setClipBoardContent (String text){
        StringSelection stringSelection=new StringSelection(text);
        Clipboard clipboard= Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

}
