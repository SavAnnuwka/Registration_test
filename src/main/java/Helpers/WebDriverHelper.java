package main.java.Helpers;

import main.java.ApplicationManager;
import main.java.Pages.PageManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverHelper {

	protected WebDriver driver;
	protected final ApplicationManager app;
    protected PageManager pages;
	

    public WebDriverHelper(ApplicationManager app){
		this.app = app;
		String browser = app.getProperty("browser");
        if (driver==null) {
            if ("firefox".equals(browser)) {
                driver = new FirefoxDriver();

            } else if ("chrome".equals(browser)) {
                String path = app.getProperty("pathWebDriverChrome");
                System.setProperty("webdriver.chrome.driver", path);
                driver = new ChromeDriver();
            }
        }
		String temp = app.getProperty("implicitWait");
		driver.manage().timeouts().implicitlyWait(
				Integer.parseInt(temp), TimeUnit.SECONDS);
		driver.get(app.getProperty("baseURL"));
        pages = new PageManager(driver);
	}

	public WebDriver getDriver() {

        System.out.println("driver " + driver);
        return driver;
}
    public void openUrl(String string) {
        driver.get(string);
    }
    public void stop() {
        driver.quit();
    }

}
