package test.java;

import main.java.testBase;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CorrectRegistration_test extends testBase{
    //testData
    // нужно сделать через DataProvider
    //сделать тестовые данные лучше

    private String boundaryName="1234567890-=qwertyuiop[]asdfghjkl;'zxcvbnm,./!@#$%^&*()_+QWERTYUIOP{}ASDFGHJKL:\"ZXCVBNM<>?~ЙЦУКЕНГШЩЗХЪЭЖДЛОРПАВЫФЯЧСМИТЬБЮ,!\"№;%:?*()_+1234567890-=ъхзщшгнекуцйфывапролджэ.创建一个语音导游如此容易的高效的Web界面可以让你快速创建、测试和发布语音导游。您的工作所需的所有的参考信息和文件都已准备好。üfürհայերենÖ≤∞Ø∈⊄†◊✍";
    private String boundaryOrganisation="1234567890-=qwertyuiop[]asdfghjkl;'zxcvbnm,./!@#$%^&*()_+QWERTYUIOP{}ASDFGHJKL:\"ZXCVBNM<>?~ЙЦУКЕНГШЩЗХЪЭЖДЛОРПАВЫФЯЧСМИТЬБЮ,!\"№;%:?*()_+1234567890-=ъхзщшгнекуцйфывапролджэ.创建一个语音导游如此容易的高效的Web界面可以让你快速创建、测试和发布语音导游。您的工作所需的所有的参考信息和文件都已准备好。üfürհայերենÖ≤∞Ø∈⊄†◊✍";
    private String boundaryEmail = "testtesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttt@test.com";
   // @Test
    //check correctRegister Link
    public void openRegistrationPage() {
           app.getRegistrationHelper().goToRegistrationFromMainPage();
           assertThat(app.getWebDriverHelper().getDriver().getCurrentUrl(), equalTo(app.getRegistrationHelper().getRegistrationURL()));
    }

    @Test
    public void positiveTestWithBoundaryValue() {
        app.getRegistrationHelper().goToRegistrationFromMainPage();
        app.getRegistrationHelper().fillRegistrationForm(
                boundaryName, app.getProperty("registrationName_id"),
                boundaryOrganisation, app.getProperty("registrationOrg_id"),
                boundaryEmail, app.getProperty("registrationEmail_id"));
        //button
        //other pages
        //verify after all pages
    }
}
