package main.java.Pages;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public abstract class AnyPage extends Page {

    public AnyPage(PageManager pages) {
        super(pages);
    }

    public void setClipBoardContent (String text){
        StringSelection stringSelection=new StringSelection(text);
        Clipboard clipboard= Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }
}