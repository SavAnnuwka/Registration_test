package test.java;

import main.java.testBase;
import org.openqa.selenium.By;
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
   private String boundaryEmail = "bjademtdpcoj@dropmail.me";


   // @Test
    //check correctRegister Link
    public void openRegistrationPage() {
           app.getRegistrationHelper().goToRegistrationFromMainPage();
           assertThat(app.getWebDriverHelper().getDriver().getCurrentUrl(), equalTo(app.getRegistrationHelper().getRegistrationURL()));
    }

    @Test
    // correctRegister
    public void positiveTestWithBoundaryValue() {
        app.getRegistrationHelper().goToRegistrationFromMainPage();
        Assert.assertEquals( app.getRegistrationHelper().checkPage("Page1"), true) ;
        System.out.println("Page one was open ");
       //type page1
        app.getRegistrationHelper().fillRegistrationForm(
                boundaryName,
                boundaryOrganisation,
                boundaryEmail);
        app.getRegistrationHelper().clickRegisterButton("Page1");
        Assert.assertEquals( app.getRegistrationHelper().checkPage("Page2"), true) ;
        System.out.println("Page two was open");
        //type page 2
        app.getRegistrationHelper().confirmCheckbox();
        app.getRegistrationHelper().clickRegisterButton("Page2");
        Assert.assertEquals( app.getRegistrationHelper().checkPage("Page3"), true) ;
        System.out.println("Page three was open");
        //check  page 3
        System.out.println("End");
        //verify after all pages
    }

  //  @Test  (придумать как работать с 2мя окнами или вкладками)
    public void Mail()
    {String email = app.getMailHelper().getTemporaryEmail();
    System.out.print(email);}

}
