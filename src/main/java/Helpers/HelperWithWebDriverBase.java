package main.java.Helpers;

import ch.qos.logback.classic.Level;
import main.java.ApplicationManager;
import main.java.Pages.PageManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


public  class HelperWithWebDriverBase extends HelperBase {


    protected static WebDriver driver;
    protected final PageManager pages;
    protected Logger log = Logger.getLogger("main.java.javaLogFile");



    public HelperWithWebDriverBase(ApplicationManager app) {
        super(app);
        driver = app.getWebDriverHelper().getDriver();
        // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        pages = new PageManager(driver);
    }

    public String currentUrl() {
        return driver.getCurrentUrl();
    }

    public WebDriverWait waitElement(int time) {
        try {
            return new WebDriverWait(driver, time);
        } catch (Exception e) {
            log.severe(e.getMessage());
            return null;
        }

    }



    public WebElement findElement(By linkText) {
        return driver.findElement(linkText);
    }


    protected void switchTo(String handle) {
        driver.switchTo().window(handle);
    }

    protected void activeElement() {
        driver.switchTo().activeElement();
    }

    public void wait(WebElement element, Integer seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    protected Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    protected String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public void openInNewWindow(String url) {
        ((JavascriptExecutor) driver)
                .executeScript("window.open(arguments[0])", url);
    }

    protected void refreshCurrentPage() {
        driver.navigate().refresh();
    }


}
