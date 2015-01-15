package main.java.Pages;

import main.java.UI.UIMap;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RegistrationPage extends AnyPage {
    public RegistrationPage(PageManager pages) {
        super(pages);
    }

    @FindBy(id = "registration_user_name")
    private WebElement nameField;

    @FindBy(id = "registration_content_provider_name")
    private WebElement organisationField;

    @FindBy(id = "registration_user_email")
    private WebElement emailField;


    @FindBy(className = "btn")
    private WebElement submitButton;



    public RegistrationPage setNameField(String text) {
        nameField.clear();
        nameField.sendKeys(text);
        return this;
    }

    public RegistrationPage setNameFieldfromClipBoard(String text) {
        setClipBoardContent(text);
        nameField.clear();
        nameField.sendKeys(Keys.CONTROL+"v");
        return this;
    }

    public RegistrationPage getUsername() {
        nameField.getAttribute("value").toString();
        return this;
    }

    public RegistrationPage setOrganisationField(String text) {
        organisationField.clear();
        organisationField.sendKeys(text);
        return this;
    }

    public RegistrationPage setOrganisationFieldfromClipBoard(String text) {
        setClipBoardContent(text);
        organisationField.clear();
        organisationField.sendKeys(Keys.CONTROL+"v");
        return this;
    }

    public RegistrationPage getOrganisation() {
        organisationField.getAttribute("value").toString();
        return this;
    }

    public RegistrationPage setEmailField(String text) {
        emailField.clear();
        emailField.sendKeys(text);
        return this;
    }

    public RegistrationPage setEmailFieldgromClipBoard(String text) {
        setClipBoardContent(text);
        emailField.clear();
        emailField.sendKeys(Keys.CONTROL+"v");
        return this;
    }

    public RegistrationPage getEmail() {
        emailField.getAttribute("value").toString();
        return this;
    }
    public void clickSubmitButton() {
        submitButton.click();
    }


}
