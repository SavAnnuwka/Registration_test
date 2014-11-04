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


    @DataProvider(name = "registrationCorrectData")
    public static Object[][] generateRegistrationNameData() {
        return new Object[][]{{RandomGenerateString(248),RandomGenerateString(248)}
        };

    }

    @DataProvider(name = "registrationLongData")
    public static Object[][] generateRegistrationLongNameData() {
        return new Object[][]{{RandomGenerateLongString(),RandomGenerateLongString(),RandomGenerateLongString()}
        };

    }
}




