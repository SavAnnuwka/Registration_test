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

    public WebElement findElement(By linkText) {
        return driver.findElement(linkText);
    }

    protected void click(By linkText) {
        findElement(linkText).click();
    }

    protected void fillTextField( String text, String locator) {
        WebElement  field = findElement(By.id(locator));
        field.clear();
        field.sendKeys(text);
    }
}
