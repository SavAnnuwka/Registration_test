package main.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HelperWithWebDriverBase extends HelperBase{


	private WebDriver driver;
	
	public HelperWithWebDriverBase(ApplicationManager app)
	{   super(app);
		driver = app.getWebDriverHelper().getDriver();
		}

    protected void openUrl(String string) {
        driver.get(string);
    }

    protected String CurrentUrl() {
        return driver.getCurrentUrl();
    }
    protected void fillTextField( String text, String locator) {
        WebElement  field = findElement(By.id(locator));
        field.clear();
        field.sendKeys(text);
    }
    public WebElement findElement(By linkText) {
        return driver.findElement(linkText);
    }

    protected void clickByLink(By linkText) {
        findElement(linkText).click();
    }
    protected void clickByClass(String locator) {
         findElement(By.className(locator)).click();
    }
    protected void clickById(String locator) {
            driver.findElement(By.id(locator)).click();
    }
    protected void clickByCss(String locator) {
        driver.findElement(By.cssSelector(locator)).click();
    }
    protected void clickByXpath(String locator) {
        driver.findElement(By.xpath(locator)).click();
    }



}
