package main.java.Helpers;

import main.java.ApplicationManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;

/**
 * Created by Annet on 08.03.2015.
 */
public class AllureReportHelper extends HelperWithWebDriverBase  implements ITestListener
{
    public AllureReportHelper(ApplicationManager app)  {
        super(app);
    }


    public void takeScreenShot(String fileName) throws IOException {
        File scrFile = ((TakesScreenshot) app.getWebDriverHelper().getDriver()).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(scrFile, new File(app.getProperty("pathScreenshot") + fileName + ".png"));}

        @Override
        public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
            try {
                makeScreenshot("Failure screenshot", iTestResult);
            } catch (IOException e) {
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

        }

        @Override
        public void onTestFailure(ITestResult iTestResult) {
            try {
                makeScreenshot("Failure screenshot", iTestResult);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onTestSkipped(ITestResult iTestResult) {

        }

        @Attachment(value = "{0}", type = "image/png")
        public void makeScreenshot(String name, ITestResult iTestResult) throws IOException {
            if (!iTestResult.isSuccess()) {
                takeScreenShot(iTestResult.getName());
            }
        }
}
