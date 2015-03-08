package main.java.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Anna on 19.01.2015.
 */
public class MailPage extends AnyPage {
    public MailPage(PageManager pages) {
        super(pages);
    }

    @FindBy(css = "span.email")
    private WebElement emailName;

    @FindBy(css = "span.badge")
    private WebElement counter;

    @FindBy(xpath = "//pre")
    private WebElement mailText;

    @FindBy(css = "pre a[href*='invitation']")
    private WebElement link;

    public WebElement getMail() {
        return emailName;
    }

    public String getMailName() {
        return emailName.getText();
    }

    public WebElement getEmailCounter() {
        return counter;
    }

    public boolean MailWasNotReceived() {
        return counter.getText().isEmpty();
    }

    public String getMailtext() {
        return mailText.getText();
    }

    public WebElement getEmailLink() {
        return link;
    }
}
