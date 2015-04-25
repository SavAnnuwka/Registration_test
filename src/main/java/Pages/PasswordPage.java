package main.java.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PasswordPage extends AnyPage {
    public PasswordPage(PageManager pages) {
        super(pages);
    }

    @FindBy(id = "user_password")
    private WebElement password;

    @FindBy(id = "user_password_confirmation")
    private WebElement confirmPassword;

    @FindBy(className = "btn")
    private WebElement submit;


    public void clickSubmitButton() {
        submit.click();
    }
    public PasswordPage setPasswordField(WebElement pass, String text) {
        pass.clear();
        pass.sendKeys(text);
        return this;
    }
    public WebElement getPassword() {
        return password;
    }
    public WebElement getConfirmPassword() {
        return confirmPassword;
    }

}
