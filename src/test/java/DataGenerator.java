package test.java;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;
import java.util.Random;

public class DataGenerator {
    private static String RandomGenerateString() {
        Random rnd = new Random();
        int count = rnd.nextInt(248);
        return "Test CP"+RandomStringUtils.randomAscii(count);
    }


    @DataProvider(name = "registrationCorrectData")
    public static Object[][] generateRegistrationNameData() {
        return new Object[][]{{RandomGenerateString(),RandomGenerateString()}
        };

    }
}




