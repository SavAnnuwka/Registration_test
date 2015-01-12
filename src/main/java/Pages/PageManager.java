package main.java.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PageManager {

  private WebDriver driver;

  public RegistrationPage registrationPage;


  public PageManager(WebDriver driver) {
    this.driver = driver;
    registrationPage = initElements(new RegistrationPage(this));

  }
  
  private <T extends Page> T initElements(T page) {
    PageFactory.initElements(driver, page);
    //PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), page);
    // PageFactory.initElements(new DisplayedElementLocatorFactory(driver, 10), page);
    return page;
  }
  
  public WebDriver getWebDriver() {
    return driver;
  }

}
