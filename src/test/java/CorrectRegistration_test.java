package test.java;


import main.java.testBase;
import org.testng.Assert;


import java.util.logging.Level;
import java.util.logging.Logger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CorrectRegistration_test extends testBase{
     String correctEmail;

    public String  getEMail()
    {   app.getMailHelper().openNewMailWindow(app.getProperty("temporaryMail"));
        return  app.getMailHelper().getTemporaryEmail();
    }

   // @Test
   //check correctRegister Link
    public void openRegistrationPage() {
           app.getRegistrationHelper().goToRegistrationFromMainPage();
           assertThat(app.getWebDriverHelper().getDriver().getCurrentUrl(), equalTo(app.getRegistrationHelper().getRegistrationURL()));
    }

    //@Test
    //(dataProvider = "registrationCorrectData", dataProviderClass = DataGenerator.class )
    // correctRegister
    public void positiveTest(String correctName, String correctOrg ) throws InterruptedException {
        log.log( Level.INFO, "positiveTest start");
        correctEmail = getEMail();
        app.getMailHelper().switchToOriginalPage();
        app.getRegistrationHelper().goToRegistrationFromMainPage();
        Assert.assertEquals( app.getRegistrationHelper().checkPage(1), true);
        log.log(Level.INFO, "Page one was open ");
       //type page1
        app.getRegistrationHelper().fillRegistrationForm(
                correctName,
                correctOrg,
                correctEmail);
        app.getRegistrationHelper().clickRegisterButtonPage1();

        Assert.assertEquals( app.getRegistrationHelper().checkPage(2), true) ;  //добавить wait
        log.log( Level.INFO, "Page two was open");
        //type page 2
        app.getRegistrationHelper().confirmCheckbox();
        app.getRegistrationHelper().clickRegisterButtonPage2();
        Assert.assertEquals( app.getRegistrationHelper().checkPage(3), true) ;     //добавить wait
        //check  page 3
        log.log( Level.INFO, "Page three was open");
        app.getMailHelper().switchToMailPage();
        assertThat (app.getMailHelper().emptyMail(), equalTo(false));
        log.log( Level.INFO, "mail is not empty");
        //найти ссылку и перейти по ней - extended
        log.log( Level.INFO, "positiveTest stop");
        app.getMailHelper().switchToOriginalPage();
    }




}
