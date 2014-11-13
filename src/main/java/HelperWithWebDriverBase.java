package main.java;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Timestamp;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class HelperWithWebDriverBase extends HelperBase{


	private WebDriver driver;
	
	public HelperWithWebDriverBase(ApplicationManager app)
	{   super(app);
		driver = app.getWebDriverHelper().getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

    public WebElement findElement(By linkText) {
        return driver.findElement(linkText);
    }
    protected void fillTextField( String text, String locator) {
        WebElement  field = findElement(By.id(locator));
        field.clear();
        field.sendKeys(text);
    }
    protected Set<String> getWindowHandles() {
       return driver.getWindowHandles();
    }
    protected String getWindowHandle() {
        return driver.getWindowHandle();
    }
    protected void  switchTo(String handle) {
       driver.switchTo().window(handle);
    }
    protected void  activeElement() {
        driver.switchTo().activeElement();
    }
    public String openInNewWindow(String url) {
        String name = "mail";
        ((JavascriptExecutor) driver)
                .executeScript("window.open(arguments[0],\"" + name + "\")", url);
        return name;
    }

    public void  wait(By linkText)
    { WebDriverWait wait = new WebDriverWait(driver, 60);
      wait.until(ExpectedConditions.visibilityOfElementLocated(linkText));
    }
}
