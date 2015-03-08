package main.java.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Anna on 19.01.2015.
 */
public class LicencePage extends AnyPage {
    public LicencePage(PageManager pages) {
        super(pages);
    }

    @FindBy(className = "step2")
    private WebElement licencePage;

    @FindBy(css = "label[for=registration_confirm]")
    private WebElement licenceAgree;

    @FindBy(css = ".step2 .btn[role=\"next-step\"]")
    private WebElement submitButton;


    public WebElement getLicencePage() {
        return licencePage;
    }

    public String getLicenceAgree() {
        return licenceAgree.getText();
    }

    public boolean IsLoadLicencePage() {
        return licencePage.isDisplayed();
    }

    public LicencePage setLicenceAgree() {
        licenceAgree.click();
        return this;
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

}
