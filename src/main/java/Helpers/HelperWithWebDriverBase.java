package main.java.Helpers;

import main.java.ApplicationManager;
import main.java.Pages.PageManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.logging.Logger;


public  class HelperWithWebDriverBase  { //extends HelperBase {

    private static WebDriver driver;
    protected   PageManager pages;
    protected Logger log = Logger.getLogger("main.java.javaLogFile");
    protected  ApplicationManager app;


    protected HelperWithWebDriverBase(ApplicationManager app) {
        this.app = app;
        driver = app.getWebDriverHelper().getDriver();
        pages = app.getPageManager();

    }

    protected WebDriverWait waitElement(int time) {
        try {
            return new WebDriverWait(driver, time);
        } catch (Exception e) {
            log.severe(e.getMessage());
            return null;
        }

    }
    protected void switchTo(String handle) {
        driver.switchTo().window(handle);
    }
    protected void activeElement() {
        driver.switchTo().activeElement();
    }
    protected void wait(WebElement element, Integer seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    protected Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }
    protected String getWindowHandle() {
        return driver.getWindowHandle();
    }
    protected void openInNewWindow(String url) {
        ((JavascriptExecutor) driver)
                .executeScript("window.open(arguments[0])", url);
    }

    protected String currentUrl() {
        return driver.getCurrentUrl();
    }
    protected void refreshCurrentPage() {
        driver.navigate().refresh();
    }


}
