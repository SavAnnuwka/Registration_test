package main.java;


import main.java.Helpers.*;
import main.java.UI.UIMap;

import java.util.Properties;

public class ApplicationManager {

    private static ApplicationManager singleton;
    private WebDriverHelper webDriverHelper;
    private Properties props;
    private ScreenshotHelper screenshotHelper;
    private RegistrationHelper registrationHelper;
    private MailHelper mailHelper;
    private WindowsHelper windowHandlerHelper;
    private UIMap uiMap;
    private LanguagesHelper languagesHelper;
    private NavigationHelper navigationHelper;

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

    public WindowsHelper getWindowsHelper() {
        if (windowHandlerHelper == null) {
            windowHandlerHelper = new WindowsHelper(this);
        }
        return windowHandlerHelper;
    }

    public LanguagesHelper getLanguagesHelper() {
        if (languagesHelper == null) {
            languagesHelper = new LanguagesHelper(this);
        }
        return languagesHelper;
    }

    public UIMap getUIMap() {
        if (uiMap == null) {
            uiMap = new UIMap(this);
        }
        return uiMap;
    }
    public NavigationHelper getNavigationHelper() {
        if (navigationHelper == null) {
            navigationHelper = new NavigationHelper(this);
        }
        return navigationHelper;
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

