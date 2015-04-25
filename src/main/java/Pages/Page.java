package main.java.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class Page {
    protected  WebDriver driver;
    protected WebDriverWait wait;
    protected PageManager pages;


    public Page(PageManager pages) {
        this.pages = pages;
        driver = pages.getWebDriver();

    }

}
