package main.java.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageManager {


    protected static WebDriver driver;

    public RegistrationPage registrationPage;
    public ErrorPage errorPage;
    public LicencePage licencePage;
    public FinishRegistrationPage finishRegistrationPage;
    public PasswordPage passwordPage;
    public MailPage mailPage;

    public PageManager(WebDriver driver) {
        this.driver = driver;
        registrationPage = initElements(new RegistrationPage(this));
        errorPage = initElements(new ErrorPage(this));
        licencePage = initElements(new LicencePage(this));
        finishRegistrationPage = initElements(new FinishRegistrationPage(this));
        mailPage = initElements(new MailPage(this));
        passwordPage = initElements(new PasswordPage(this));
    }
    private <T extends Page> T initElements(T page) {
        PageFactory.initElements(driver, page);
         return page;
    }
    public WebDriver getWebDriver() {
        return driver;
    }

}
