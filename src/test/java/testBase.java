package test.java;


import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import main.java.ApplicationManager;
import org.slf4j.LoggerFactory;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import uk.org.lidalia.sysoutslf4j.context.SysOutOverSLF4J;

import java.io.FileReader;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

@Listeners (main.java.Helpers.AllureReportHelper.class)
public class testBase  {

    static {
        Logger.getLogger("").setLevel(Level.ALL);
        SLF4JBridgeHandler.install();
        SysOutOverSLF4J.sendSystemOutAndErrToSLF4J();
        LoggerContext loggerContext =(LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.printInCaseOfErrorsOrWarnings(loggerContext);
    }

    protected Logger log = Logger.getLogger("main.java.testLogFile");
    protected static ApplicationManager app;
    protected static String language;

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




    /*@AfterMethod(alwaysRun = true)
    @Attachment(value = " Screenshot {0}")
    private byte[]  takeScreenshotForAllure() throws IOException   {
        System.out.println("Скриншот ");
            return ((TakesScreenshot) app.getWebDriverHelper().getDriver()).getScreenshotAs(OutputType.BYTES);
        }
*/


}

	