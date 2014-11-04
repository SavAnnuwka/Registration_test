package main.java;


import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.*;

public class testBase {

	protected Logger log = Logger.getLogger("main.java.testLogFile");
	public static ApplicationManager app;
	

	@BeforeSuite
	public void setUp( ) throws Exception {

    /*    try {
            LogManager.getLogManager().readConfiguration(
                    testBase.class.getResourceAsStream("logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }*/

        FileHandler handler;
        try {
            handler=new FileHandler("application_log",true);
            SimpleFormatter formatter=new SimpleFormatter();
            handler.setFormatter(formatter);
            log.addHandler(handler);

            log.setLevel(Level.ALL);
        }
        catch (  SecurityException e) {
            System.err.println("Security exception while initialising logger : " + e.getMessage());
        }
        String	configFile = "application.properties";
		Properties props = new Properties();
		props.load(new FileReader(configFile));
        log.log(Level.FINE, "setUp start");
		 app =  ApplicationManager.getInstance();
		 app.setProperties(props);
        log.log(Level.FINE, "setUp end");
	  }
	
	@AfterSuite
	public void tearDown() throws Exception {
        log.log(Level.FINE, "tearDown start");
        ApplicationManager.getInstance().getWebDriverHelper().stop();
        log.log(Level.FINE, "tearDown end");
        log.log(Level.INFO, "-------------------------------------------------------------");
	  }

    @AfterMethod (alwaysRun = true)
      public void takeScreenshotWhenFail(ITestResult result) throws IOException {
        if (!result.isSuccess()) {
            app.getScreenshotHelper().takeScreenShot(result.getName());
            log.log(Level.SEVERE, "<a href='" + app.getProperty("pathScreenshot") + result.getName() + ".png'>" +  result.getName() + "</a>");
        }
    }



}

	