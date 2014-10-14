package test.java;

import main.java.testBase;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CorrectRegistration_test extends testBase{

    @Test
    public void openRegistrationPage() {
           app.getRegistrationHelper().goToRegistrationFromMainPage();
            assertThat(app.getWebDriverHelper().getDriver().getCurrentUrl(), equalTo(app.getRegistrationHelper().getRegistrationURL()));
    }
}
