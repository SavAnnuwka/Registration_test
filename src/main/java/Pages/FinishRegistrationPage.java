package main.java.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Anna on 19.01.2015.
 */
public class FinishRegistrationPage extends AnyPage {

    public FinishRegistrationPage(PageManager pages) {
        super(pages);
    }

    @FindBy(className = "step3")
    private WebElement finishRegistrationPage;


    public WebElement getFinishRegistrationPage() {
        return finishRegistrationPage;
    }


    public boolean IsLoadFinishPage() {
        return finishRegistrationPage.isDisplayed();
    }

}
