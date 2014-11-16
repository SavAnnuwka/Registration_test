package main.java.Helpers;


import main.java.ApplicationManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class ScreenshotHelper extends HelperWithWebDriverBase {
	

	public ScreenshotHelper(ApplicationManager manager){
		super(manager);
		}

   public void  takeScreenShot(String fileName) throws IOException {
    File scrFile = ((TakesScreenshot) app.getWebDriverHelper().getDriver()).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(scrFile, new File( app.getProperty("pathScreenshot")  +  fileName +".png"));
   }
}
