package test.java;


import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import main.java.ApplicationManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.LoggerFactory;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.Attachment;
import uk.org.lidalia.sysoutslf4j.context.LogLevel;
import uk.org.lidalia.sysoutslf4j.context.SysOutOverSLF4J;
import uk.org.lidalia.sysoutslf4j.context.exceptionhandlers.ExceptionHandlingStrategy;
import uk.org.lidalia.sysoutslf4j.context.exceptionhandlers.ExceptionHandlingStrategyFactory;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class testBase  {

    static {

        Logger.getLogger("").setLevel(Level.ALL);
        SLF4JBridgeHandler.install();
       SysOutOverSLF4J.sendSystemOutAndErrToSLF4J();
        LoggerContext loggerContext =(LoggerContext) LoggerFactory.getILoggerFactory();
       StatusPrinter.printInCaseOfErrorsOrWarnings(loggerContext);
     //   loggerContext.stop();

    }

    protected Logger log = Logger.getLogger("main.java.testLogFile");
    public static ApplicationManager app;
    protected String language;


  /*  private void logFile() throws IOException {
        FileHandler handler;
        try {

            handler = new FileHandler("application_log", true);
            SimpleFormatter formatter = new SimpleFormatter();
            handler.setFormatter(formatter);
            log.addHandler(handler);

            log.setLevel(Level.ALL);
        } catch (SecurityException e) {
            System.err.println("Security exception while initialising logger : " + e.getMessage());
        }
    }*/

    @BeforeSuite
    public void setUp() throws Exception {
        String configFile = "application.properties";
        Properties props = new Properties();
        props.load(new FileReader(configFile));
        log.log(Level.FINE, "setUp start");
        app = ApplicationManager.getInstance();
        app.setProperties(props);

    }

    @AfterSuite (alwaysRun = true)
    public void tearDown() throws Exception {
        log.log(Level.FINE, "tearDown start");
        ApplicationManager.getInstance().getWebDriverHelper().stop();
        log.log(Level.FINE, "tearDown end");
    }


    @AfterMethod(alwaysRun = false)
    public void  takeScreenshotWhenFail(ITestResult result) throws IOException   {

        if (!result.isSuccess()) {
            String filename =  app.getWindowsHelper().takeScreenShot(result.getName());
            log.log(Level.SEVERE, "<a href='" +filename +  "</a>");
            log.severe("RRRR");
            }
    }

    @AfterMethod(alwaysRun = false)
    @Attachment("Скриншот")
    public byte[]  takeScreenshotForAllure () throws IOException   {
            return ((TakesScreenshot) app.getWebDriverHelper().getDriver()).getScreenshotAs(OutputType.BYTES);


        }

   /* @AfterMethod(alwaysRun = true)
    @Attachment(value = "Снимок ''{0}''", type = "image/png")
    public static byte[] saveScreenShot(Screenshot screenshot) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(screenshot.getImage(), "png", baos);
        return baos.toByteArray();
    }*/

}

	