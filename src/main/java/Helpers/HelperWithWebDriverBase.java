package main.java.Helpers;

import main.java.ApplicationManager;
import main.java.Pages.PageManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;


public  class HelperWithWebDriverBase  extends HelperBase{


	protected WebDriver driver;
    protected final PageManager pages;    //init!!!!!!!!!!

	public HelperWithWebDriverBase(ApplicationManager app)  {
        super(app);
		driver = app.getWebDriverHelper().getDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        pages = new PageManager(driver);
        System.out.println("HelperWithWebDriverBase construction");
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
  /*  protected void fillTextField( String text, By locator) {
            WebElement field = findElement(locator);
            field.clear();
            field.sendKeys(text);

    }*/
   /* protected void fillTextFieldFromClipBoard(String text, By locator) {
        app.getWindowsHelper().setClipBoardContent(text);
        WebElement field = findElement(locator);
        field.clear();
        field.sendKeys(Keys.CONTROL+"v");
    }*/
   /* public String getText(String locator) {
        return findElement(app.getUIMap().getLocator(locator)).getText();

    }*/


    protected void  switchTo(String handle) {
       driver.switchTo().window(handle);
    }
    protected void  activeElement() {
        driver.switchTo().activeElement();
    }
    public void  wait(By linkText)
    { WebDriverWait wait = new WebDriverWait(driver, 60);
      wait.until(ExpectedConditions.visibilityOfElementLocated(linkText));
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


}
