package test.java;


import main.java.UI.Constants;
import main.java.testBase;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.logging.Level;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SmokeRegistration_test extends testBase{
    // String correctEmail =  "btazbbytqroe@dropmail.me"; //for debug is already register
    // String correctEmail =  "aewulrrw@yomail.info";//for debug is already get email
    String correctEmail;
     String language;

    public String  getEMail()
    {   app.getWindowsHelper().openNewMailWindow(app.getProperty("temporaryMail"));
        return  app.getMailHelper().getTemporaryEmail();
    }


   @Test(enabled=false)
   //check correctRegister Link
    public void openRegistrationPage() {
           app.getRegistrationHelper().goToRegistrationPageFromURL();
           assertThat(app.getWebDriverHelper().getDriver().getCurrentUrl(), equalTo(app.getRegistrationHelper().getRegistrationURL()));
    }

    // correctRegister
    // @Test(dataProvider = "registrationCorrectData", dataProviderClass = DataGenerator.class )
    @Test(enabled=true, dataProvider = "registrationCorrectData", dataProviderClass = DataGenerator.class )
    public void positiveTest(String correctName, String correctOrg ) throws InterruptedException {
        log.log( Level.INFO, "positiveTest start");
        correctEmail = getEMail();
        app.getWindowsHelper().switchToOriginalPage();
        app.getRegistrationHelper().goToRegistrationPageFromURL();;
        Assert.assertEquals( app.getRegistrationHelper().checkPage(1), true);
        log.log(Level.INFO, "Page one was open ");
       //type page1
        app.getRegistrationHelper().fillRegistrationFormFromClipBoard(correctName, correctOrg, correctEmail);
        app.getRegistrationHelper().clickRegisterButtonPage1();

        Assert.assertEquals( app.getRegistrationHelper().checkPage(2), true) ;  //добавить wait
        log.log( Level.INFO, "Page two was open");
        //type page 2
        app.getRegistrationHelper().confirmCheckbox();
        app.getRegistrationHelper().clickRegisterButtonPage2();
        Assert.assertEquals( app.getRegistrationHelper().checkPage(3), true) ;     //добавить wait
        //check  page 3
        log.log( Level.INFO, "Page three was open");
        app.getWindowsHelper().switchToMailPage();
        assertThat (app.getMailHelper().emptyMail(), equalTo(false));
        log.log( Level.INFO, "mail is not empty");
        //найти ссылку и перейти по ней - extended
        log.log( Level.INFO, "positiveTest stop");
        app.getWindowsHelper().switchToOriginalPage();
    }

   @Test(dependsOnMethods = { "positiveTest"}, dataProvider = "registrationSimpleDataWithoutEmail", dataProviderClass = DataGenerator.class)
   public void alreadyRegisterEmail (String simpleName, String simpleOrg ){
       app.getRegistrationHelper().goToRegistrationPageFromURL();
       language =  app.getLanguagesHelper().selectLanguage();
       log.log( Level.INFO, "Already get  email test start . LANG: \" + language ");
       app.getRegistrationHelper().fillRegistrationForm(simpleName, simpleOrg, correctEmail);
       app.getRegistrationHelper().clickRegisterButtonPage1();
       assertThat( app.getRegistrationHelper().checkError("register.email.error"), equalTo(Constants.getAlreadyExistErrorLanguage(language)));
       log.log( Level.INFO, Constants.getAlreadyExistErrorLanguage(language));
   }

    //begin register in CMS!
    @Test(dependsOnMethods = { "positiveTest","alreadyRegisterEmail" }, dataProvider = "registrationSimpleDataWithoutEmail", dataProviderClass = DataGenerator.class)
    public void alreadyExistInDataBaseEmail (String simpleName, String simpleOrg ){
        app.getRegistrationHelper().goToRegistrationPageFromURL();
        language =  app.getLanguagesHelper().selectLanguage();
        log.log( Level.INFO, "Already register email start. LANG: " + language );
        //==//
        correctEmail = "bvozgzesqzaq@dropmail.me";
        app.getRegistrationHelper().fillRegistrationForm(simpleName, simpleOrg, correctEmail);
        app.getRegistrationHelper().clickRegisterButtonPage1();
        assertThat( app.getRegistrationHelper().checkError("register.email.error"), equalTo(Constants.getAlreadyExistInDatabaseErrorLanguage(language)));
        log.log( Level.INFO, Constants.getAlreadyExistInDatabaseErrorLanguage(language));
    }
}
