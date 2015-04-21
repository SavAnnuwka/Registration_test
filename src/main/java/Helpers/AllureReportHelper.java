package main.java.Helpers;

import main.java.ApplicationManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.yandex.qatools.allure.annotations.Attachment;
import java.util.logging.Level;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class AllureReportHelper    implements ITestListener
    { protected Logger log = Logger.getLogger("main.java.TestNGLog");





        /* public void takeScreenShot(String fileName) throws IOException {
                File scrFile = ((TakesScreenshot) app.getWebDriverHelper().getDriver()).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(scrFile, new File(app.getProperty("pathScreenshot") + fileName + ".png"));
            }
        */

        @Override
        public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
            try {
                makeScreenshot("Failure screenshot", iTestResult);
            } catch (IOException e) {
               log.log(Level.SEVERE, e.getMessage());
                e.printStackTrace();
            }
        }

        @Override
        public void onStart(ITestContext iTestContext) {

        }

        @Override
        public void onFinish(ITestContext iTestContext) {

        }

        @Override
        public void onTestStart(ITestResult iTestResult) {

        }

        @Override
        public void onTestSuccess(ITestResult iTestResult) {
            try {
                makeScreenshot("Pass screenshot", iTestResult);
            } catch (IOException e) {
              log.log(Level.SEVERE, e.getMessage());
                e.printStackTrace();

            }
        }

        @Override
        public void onTestFailure(ITestResult iTestResult) {
            try {
                makeScreenshot("Failure screenshot", iTestResult);
            } catch (IOException e) {
              log.log(Level.SEVERE, e.getMessage());
                e.printStackTrace();

            }
        }

        @Override
        public void onTestSkipped(ITestResult iTestResult) {

        }



        @Attachment(value = "{0}", type = "image/png")
        public byte [] makeScreenshot(String name, ITestResult iTestResult) throws IOException {
           //if (!iTestResult.isSuccess()) {
              return ((TakesScreenshot)   ApplicationManager.getInstance().getWebDriverHelper().getDriver()).getScreenshotAs(OutputType.BYTES);
              // takeScreenShot(iTestResult.getName());


           }

}
