package main.java;

import java.util.Random;

/**
 * Created by Anna on 17.10.2014.
 */
public class Constants {


     public  class  Error {
          public final static String   EMPTY = "Required field can not be left blank.";
     }

    public static String getRandomLanguage() {
      String[] allLang = {"de", "en", "es", "fr", "it", "nl", "pt", "ro", "ru", "sv", "zh"};
        Random rand = new Random();
        int i= rand.nextInt(10);
        return  allLang[i];
    }
}
