package main.java.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public abstract class AnyPage extends Page {

    @FindBy(id = "locale")
    private WebElement language;

    public AnyPage(PageManager pages) {
        super(pages);
    }
    public void setClipBoardContent(String text) {
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }
    public WebElement getLanguages() {
        return language;
    }
}