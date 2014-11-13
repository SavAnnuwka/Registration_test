package main.java;


import java.util.Properties;

public class ApplicationManager {

    private static ApplicationManager singleton;
    private WebDriverHelper webDriverHelper;

    private Properties props;
    private ScreenshotHelper screenshotHelper;
    private RegistrationHelper registrationHelper;
    private MailHelper mailHelper;
    private WindowHandlerHelper windowHandlerHelper;


    public static ApplicationManager getInstance() {
        if (singleton == null) {
            singleton = new ApplicationManager();
        }
        return singleton;
    }


    public WebDriverHelper getWebDriverHelper() {
        if (webDriverHelper == null) {
            webDriverHelper = new WebDriverHelper(this);
        }
        return webDriverHelper;
    }


    public ScreenshotHelper getScreenshotHelper() {
        if (screenshotHelper == null) {
            screenshotHelper = new ScreenshotHelper(this);
        }
        return screenshotHelper;
    }

    public RegistrationHelper getRegistrationHelper() {
        if (registrationHelper == null) {
            registrationHelper = new RegistrationHelper(this);
        }
        return registrationHelper;
    }

    public MailHelper getMailHelper() {
        if (mailHelper == null) {
            mailHelper = new MailHelper(this);
        }
        return mailHelper;
    }

    public WindowHandlerHelper getWindowHandlerHelper() {
        if (windowHandlerHelper == null) {
            windowHandlerHelper = new WindowHandlerHelper(this);
        }
        return windowHandlerHelper;
    }


    //properties
	public void setProperties(Properties props) {
		this.props = props;
	}
	public String getProperty(String key) {
		return props.getProperty(key);
	}
	public String getProperty(String key, String defaultValue) {
		return props.getProperty(key, defaultValue);
	}

}

