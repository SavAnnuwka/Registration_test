package main.java.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Anna on 15.01.2015.
 */
public class ErrorPage extends AnyPage {


    public ErrorPage(PageManager pages) {
        super(pages);
    }

    @FindBy(id = "register.username.error")
    private WebElement nameError;

    @FindBy(id = "register.organisation.error")
    private WebElement organisationError;

    @FindBy(id = "register.email.error")
    private WebElement emailError;



    public String getNameError() {
        return nameError.getText();
    }

    public String getOrganisationError() {
        return organisationError.getText();
    }

    public String getEmailError() {
        return emailError.getText();
    }
}
