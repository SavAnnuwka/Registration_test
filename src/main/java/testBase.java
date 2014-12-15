package main.java;


import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.LoggerFactory;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;
import uk.org.lidalia.sysoutslf4j.context.SysOutOverSLF4J;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.*;
//import org.slf4j.Logger;


public class testBase {

    static{

        Logger.getLogger("").setLevel(Level.ALL);
      //  for (Handler h:Logger.getLogger("").getHandlers())
     //   {
      //      Logger.getLogger("").removeHandler(h);
      //  }
        SLF4JBridgeHandler.install();
        SysOutOverSLF4J.sendSystemOutAndErrToSLF4J();
        StatusPrinter.print((LoggerContext) LoggerFactory.getILoggerFactory());
    }

    protected   Logger log = Logger.getLogger("main.java.testLogFile");
	public  ApplicationManager app;
    protected  String language;

    private void logFile() throws IOException {
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
    }

    @BeforeSuite
	public void setUp( ) throws Exception {
       // logFile();
        String	configFile = "application.properties";
		Properties props = new Properties();
		props.load(new FileReader(configFile));
        log.log(Level.FINE, "setUp start");
		 app =  ApplicationManager.getInstance();
		 app.setProperties(props);
        log.log(Level.FINE, "setUp end");
	  }
    
   @BeforeMethod
    public void goToRegisterPageAndSelectLang()
    {

        app.getRegistrationHelper().goToRegistrationPageFromURL();
        language =  app.getLanguagesHelper().selectLanguage();
        System.out.println("before");
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

	