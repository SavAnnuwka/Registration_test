package test.java;


import main.java.ApplicationManager;
import main.java.UI.Constant;
import main.java.testBase;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.Set;
import java.util.logging.Level;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class SmokeRegistration_test extends testBase{
    String correctEmail;



    // correctRegister
     @Test( dataProvider = "registrationCorrectData", dataProviderClass = DataGenerator.class )
    public void positiveTest(String correctName, String correctOrg ) throws InterruptedException {
        log.log( Level.INFO, "positiveTest start. LANG = " + language);
        correctEmail = getEMail();
        app.getWindowsHelper().switchToOriginalPage();
        Assert.assertEquals( app.getRegistrationHelper().checkPage(1), true);
        log.log(Level.INFO, "Page 1 was open ");
        app.getRegistrationHelper().fillRegistrationFormFromClipBoard(correctName, correctOrg, correctEmail);
        app.getRegistrationHelper().clickRegisterButton();
        Assert.assertEquals( app.getRegistrationHelper().checkPage(2), true) ;  //добавить wait
        log.log( Level.INFO, "Page 2 was open");
        app.getRegistrationHelper().confirmCheckbox();
        app.getRegistrationHelper().clickRegisterLicencePageButton();
        Assert.assertEquals( app.getRegistrationHelper().checkPage(3), true) ;     //добавить wait
        log.log( Level.INFO, "Page 3 was open");
        app.getWindowsHelper().switchToMailPage();
        Assert.assertEquals(app.getMailHelper().emptyMail(), false);
        log.log( Level.INFO, "mail "+ correctEmail +" is not empty");
         //отдельно
         checkMailText();
         //отдельно
         checkMailLink();
        log.log( Level.INFO, "positiveTest stop");
        app.getWindowsHelper().switchToOriginalPage();
    }


    public void checkMailText() {
         //пока запускается before и меняется lang
        log.log( Level.INFO, "check mail text start");
        app.getWindowsHelper().switchToMailPage();
        //move to main test
        log.log( Level.INFO, app.getMailHelper().getMailtext());
         assertThat(app.getMailHelper().getMailtext().contains(Constant.getMailText(language)), equalTo(true));
    }
    public void checkMailLink() {
        //пока запускается before и меняется lang
        //need refactor
        log.log( Level.INFO, "check mail link  start");
        app.getWindowsHelper().switchToMailPage();
        Set<String> OldList = app.getWindowsHelper().getCurrentListOfHandles();
        app.getMailHelper().goToMailLink();
        Set<String> NewList = app.getWindowsHelper().getCurrentListOfHandles();
        app.getWindowsHelper().getCMSHandles(OldList, NewList);
        app.getWindowsHelper().switchToCMSPage();
        log.log( Level.INFO, app.getNavigationHelper().getCurrentUrl());
        assertThat(app.getNavigationHelper().getCurrentUrl() , containsString(app.getNavigationHelper().getNewUserURL()));
        app.getWindowsHelper().switchToOriginalPage();
    }
    public String  getEMail()
    {   app.getWindowsHelper().openNewMailWindow(app.getProperty("temporaryMail"));
        return  app.getMailHelper().getTemporaryEmail();
    }







}
