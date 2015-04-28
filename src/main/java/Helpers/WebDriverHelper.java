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

    private static    WebDriver driver;
    private static ApplicationManager app;


    public WebDriverHelper(ApplicationManager app) {
        this.app = app;
        Constant.BROWSER  = getBrowser();
        Constant.BROWSER_LANG =  getLanguage();
        initDriver();
        setImplicityWait();
        setBaseUrl();
    }
    private void setBaseUrl() {
        if (System.getProperty("baseURL")!=null)
            Constant.URL = System.getProperty("baseURL");
        else Constant.URL =app.getProperty("baseURL");
        driver.get(Constant.URL);
    }
    private void setImplicityWait() {
        String temp = app.getProperty("implicityWait");
        driver.manage().timeouts().implicitlyWait(
        Integer.parseInt(temp), TimeUnit.SECONDS);
    }
    private void initDriver() {
        if (driver == null) {
            if (Constant.FIREFOX.equals(Constant.BROWSER)) {
                FirefoxProfile profile = new FirefoxProfile();
                profile.setPreference("intl.accept_languages", Constant.BROWSER_LANG);
                driver = new FirefoxDriver(profile);
            } else if (Constant.CHROME.equals(Constant.BROWSER)) {
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--lang=" + Constant.BROWSER_LANG);
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                driver = new ChromeDriver(capabilities);
            } else if (Constant.IE.equals(Constant.BROWSER)) {
                driver = new InternetExplorerDriver();

            }
        }
    }
    private String getBrowser() {
        if (System.getProperty("browser")!=null)
            return System.getProperty("browser");
        else if (app.getProperty("browser")!=null)
            return app.getProperty("browser");
        else return Constant.selectRandomBrowser();
    }
    public  String getLanguage() {
        if (System.getProperty("language")!="RANDOM") {
            if (System.getProperty("language") != null)
                return System.getProperty("language").toLowerCase();
            else if (app.getProperty("language") != null)
                return app.getProperty("language");
        }
         return Constant.getRandomLanguage();
    }

    public WebDriver getDriver() {
        return driver;
    }
    public void openUrl(String string) {
        driver.get(string);
    }
    public void stop() {
        driver.quit();
    }

}
