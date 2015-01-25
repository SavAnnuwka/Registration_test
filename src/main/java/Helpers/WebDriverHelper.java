package main.java.Helpers;

import main.java.ApplicationManager;
import main.java.UI.Constant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class WebDriverHelper {

    protected  WebDriver driver;
	protected final ApplicationManager app;
   // protected final PageManager pages;
	

    public WebDriverHelper(ApplicationManager app){
		this.app = app;
		String browser = app.getProperty("browser");
        // String browser = Constant.selectRandomBrowser();
        Constant.setBrowserLang(Constant.getRandomLanguage());
        if (driver==null) {
            if (Constant.FIREFOX.equals(browser)) {
                FirefoxProfile profile = new FirefoxProfile();
                profile.setPreference("intl.accept_languages", Constant.BROWSER_LANG);
                driver = new FirefoxDriver(profile);

            } else if (Constant.CHROME.equals(browser)) {
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--lang=" + Constant.BROWSER_LANG);
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                driver = new ChromeDriver(capabilities);
            } else if (Constant.IE.equals(browser)) {
                driver = new InternetExplorerDriver();

            }
        }
		String temp = app.getProperty("implicitWait");
		driver.manage().timeouts().implicitlyWait(
				Integer.parseInt(temp), TimeUnit.SECONDS);
		driver.get(app.getProperty("baseURL"));
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
