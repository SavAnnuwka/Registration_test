package main.java.Helpers;

import main.java.ApplicationManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AllureReportHelper    implements ITestListener
    { protected Logger log = Logger.getLogger("main.java.TestNGLog");

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
              }

}
