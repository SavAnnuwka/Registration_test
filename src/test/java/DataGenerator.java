package test.java;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;

import java.util.Objects;
import java.util.Random;

/**
 * Created by Anna on 24.10.2014.
 */
public class DataGenerator {
    private static String RandomGenerateString() {
        Random rnd = new Random();
        int count = rnd.nextInt(254) + 1;
        return RandomStringUtils.randomAscii(count);
    }


    @DataProvider(name = "registrationCorrectData")
    public static Object[][] generateRegistrationNameData() {
        return new Object[][]{{RandomGenerateString(),RandomGenerateString()}
        };

    }
}




