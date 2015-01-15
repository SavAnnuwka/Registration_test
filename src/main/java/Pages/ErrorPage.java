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

    @FindBy(css = ".error[for=registration_user_name]")
    private WebElement nameError;

    @FindBy(css = ".error[for=registration_content_provider_name]")
    private WebElement organisationError;

    @FindBy(css = ".error[for=registration_user_email]")
    private WebElement emailError;

    @FindBy(css = ".error[for=\"registration[confirm]\"]")
    private WebElement licenceAgreeError;


    public String getNameError() {
        return nameError.getText();
    }

    public String getOrganisationError() {
        return organisationError.getText();
    }

    public String getEmailError() {
        return emailError.getText();
    }

    public String getLicenceAgreeError() {
        return licenceAgreeError.getText();
    }
}
