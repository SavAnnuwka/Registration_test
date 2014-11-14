package test.java;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;
import java.util.Random;

public class DataGenerator {
    private static String RandomGenerateString(int value) {
        Random rnd = new Random();
        int count = rnd.nextInt(value);
        return "Test CP"+RandomStringUtils.randomAscii(count);
    }

    private static String RandomGenerateLongString() {
        return RandomStringUtils.randomAscii(255);
    }

    private static String RandomGenerateLongEmail() {
        return RandomStringUtils.randomAscii(245) + "@test.test";
    }

    @DataProvider(name = "registrationCorrectData")
    public static Object[][] generateRegistrationCorrectData() {
        return new Object[][]{{RandomGenerateString(248),RandomGenerateString(248)}
        };

    }

    @DataProvider(name = "registrationLongData")
    public static Object[][] generateRegistrationLongData() {
        return new Object[][]{{RandomGenerateLongString(),RandomGenerateLongString(),RandomGenerateLongEmail()}
        };

    }

    //change to file
    @DataProvider(name = "registrationIncorrectEmailData")
    public static Object[][] generateRegistrationIncorrectEmailData() {
        return new Object[][]{
                { "simple_name", "simple_organisation", "emailWithoutSobaka" } ,
                { "simple_name", "simple_organisation", "emailWithSobakaIntheEnd@"},
                { "simple_name", "simple_organisation", "email@WithoutTochka"},
                { "simple_name", "simple_organisation", "emailWithOneSimbolAfter@q.q"},
                { "simple_name", "simple_organisation", "email@Withnumbers.111"} ,
                { "simple_name", "simple_organisation", "emailSpecSimbols!@#$%@%^&*().ru"} ,
                { "simple_name", "simple_organisation", "emailSpecSimbols@ru.@$%^&*()"}
        };

    }
}




