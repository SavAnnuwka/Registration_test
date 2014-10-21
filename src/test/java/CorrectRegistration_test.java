package test.java;

import main.java.testBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CorrectRegistration_test extends testBase{

    // нужно сделать через DataProvider
    //сделать тестовые данные лучше

   //testData boundary
   /* private String boundaryName="1234567890-=qwertyuiop[]asdfghjkl;'zxcvbnm,./!@#$%^&*()_+QWERTYUIOP{}ASDFGHJKL:\"ZXCVBNM<>?~ЙЦУКЕНГШЩЗХЪЭЖДЛОРПАВЫФЯЧСМИТЬБЮ,!\"№;%:?*()_+1234567890-=ъхзщшгнекуцйфывапролджэ.创建一个语音导游如此容易的高效的Web界面可以让你快速创建、测试和发布语音导游。您的工作所需的所有的参考信息和文件都已准备好。üfürհայերենÖ≤∞Ø∈⊄†◊✍";
    private String boundaryOrganisation="1234567890-=qwertyuiop[]asdfghjkl;'zxcvbnm,./!@#$%^&*()_+QWERTYUIOP{}ASDFGHJKL:\"ZXCVBNM<>?~ЙЦУКЕНГШЩЗХЪЭЖДЛОРПАВЫФЯЧСМИТЬБЮ,!\"№;%:?*()_+1234567890-=ъхзщшгнекуцйфывапролджэ.创建一个语音导游如此容易的高效的Web界面可以让你快速创建、测试和发布语音导游。您的工作所需的所有的参考信息和文件都已准备好。üfürհայերենÖ≤∞Ø∈⊄†◊✍";
    private String boundaryEmail = "testtesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttt@test.com";
  */

    //simple data for test
   private String boundaryName="name";
   private String boundaryOrganisation="org";
   private  String boundaryEmail = "bjdvulfpnkkl@dropmail.me";


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

    @Test
    // correctRegister
    public void positiveTest() {
        boundaryEmail = getEMail();
        app.getMailHelper().switchToOriginalPage();
        app.getRegistrationHelper().goToRegistrationFromMainPage();
        Assert.assertEquals( app.getRegistrationHelper().checkPage(1), true);
        System.out.println("Page one was open ");
       //type page1
        app.getRegistrationHelper().fillRegistrationForm(
                boundaryName,
                boundaryOrganisation,
                boundaryEmail);
        app.getRegistrationHelper().clickRegisterButtonPage1();
        Assert.assertEquals( app.getRegistrationHelper().checkPage(2), true) ;  //добавить wait
        System.out.println("Page two was open");
        //type page 2
        app.getRegistrationHelper().confirmCheckbox();
        app.getRegistrationHelper().clickRegisterButtonPage2();
        Assert.assertEquals( app.getRegistrationHelper().checkPage(3), true) ;     //добавить wait
        //check  page 3
        System.out.println("Page three was open");
        app.getMailHelper().switchToMailPage();
        //подождать 10 секунд
        //проверить,что письмо пришло (почта не пустая)
        assertThat (app.getMailHelper().emptyMail(), equalTo(false));
        //найти ссылку и перейти по ней - extended
    }




}
