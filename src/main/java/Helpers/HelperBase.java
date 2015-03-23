package main.java.Helpers;

import main.java.ApplicationManager;
import org.openqa.selenium.WebDriver;

public class HelperBase {

    protected final ApplicationManager app;


    public HelperBase(ApplicationManager app) {
        this.app = app;
    }

}