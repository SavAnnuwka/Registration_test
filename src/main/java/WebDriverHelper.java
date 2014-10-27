package main.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverHelper {

	private WebDriver driver;
	private final ApplicationManager manager;
	

    public WebDriverHelper(ApplicationManager manager){
		this.manager = manager;
		String browser = manager.getProperty("browser");
        if (driver==null) {
            if ("firefox".equals(browser)) {
                driver = new FirefoxDriver();
            } else if ("chrome".equals(browser)) {
                String path = manager.getProperty("pathWebDriverChrome");
                System.setProperty("webdriver.chrome.driver", path);
                driver = new ChromeDriver();
            }
        }
		String temp = manager.getProperty("implicitWait" , "11");
		driver.manage().timeouts().implicitlyWait(
				Integer.parseInt(temp), TimeUnit.SECONDS);
		driver.get(manager.getProperty("baseURL"));
	}
	
	public void stop() {
       // if(getDriver()!= null) {
      //      manager.setNulltoallHelper();
            driver.quit();
   // }

	}

	public WebDriver getDriver() {

        System.out.println("driver " + driver);
        return driver;
}
}
