package main.java.Helpers;

import main.java.ApplicationManager;
import main.java.Pages.PageManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;


public class HelperWithWebDriverBase extends HelperBase {


    protected static WebDriver driver;
    protected final PageManager pages;

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
        return new WebDriverWait(driver, time);

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

    public String openInNewWindow(String url) {
        String name = "mail";
        ((JavascriptExecutor) driver)
                .executeScript("window.open(arguments[0],\"" + name + "\")", url);
        return name;
    }

    protected void refreshCurrentPage() {
        driver.navigate().refresh();
    }

}
