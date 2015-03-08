package main.java.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RegistrationPage extends AnyPage {
    public RegistrationPage(PageManager pages) {
        super(pages);
    }

    @FindBy(className = "step1")
    private WebElement registrationPage;

    @FindBy(id = "registration_user_name")
    private WebElement nameField;

    @FindBy(id = "registration_content_provider_name")
    private WebElement organisationField;

    @FindBy(id = "registration_user_email")
    private WebElement emailField;


    @FindBy(className = "btn")
    private WebElement submitButton;

    @FindBy(className = "title")
    private WebElement title;

    @FindBy(className = "text-content")
    private WebElement description;

    public WebElement getRegistrationPage() {
        return registrationPage;
    }

    public RegistrationPage setNameField(String text) {
        nameField.clear();
        nameField.sendKeys(text);
        return this;
    }

    public RegistrationPage setNameFieldfromClipBoard(String text) {
        setClipBoardContent(text);
        nameField.clear();
        nameField.sendKeys(Keys.CONTROL + "v");
        return this;
    }

    public String getUsername() {
        return nameField.getAttribute("value").toString();

    }

    public RegistrationPage setOrganisationField(String text) {
        organisationField.clear();
        organisationField.sendKeys(text);
        return this;
    }

    public RegistrationPage setOrganisationFieldfromClipBoard(String text) {
        setClipBoardContent(text);
        organisationField.clear();
        organisationField.sendKeys(Keys.CONTROL + "v");
        return this;
    }

    public String getOrganisation() {
        return organisationField.getAttribute("value").toString();
    }

    public RegistrationPage setEmailField(String text) {
        emailField.clear();
        emailField.sendKeys(text);
        return this;
    }

    public RegistrationPage setEmailFieldgromClipBoard(String text) {
        setClipBoardContent(text);
        emailField.clear();
        emailField.sendKeys(Keys.CONTROL + "v");
        return this;
    }

    public String getEmail() {
        return emailField.getAttribute("value").toString();
    }

    public String getTitle() {
        return title.getText();
    }

    public String getDescription() {
        return description.getText();
    }

    public void clickSubmitButton() {
        submitButton.click();
    }


    public boolean IsLoadRegistrationPage() {
        return registrationPage.isDisplayed();
    }

    public String getLanguageForRegistration() {
        return "/registrations/new?locale=";


    }


}
