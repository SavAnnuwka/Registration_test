package main.java;

import java.util.Random;

/**
 * Created by Anna on 17.10.2014.
 */
public class Constants {
   // languages
    static String EN =  "en";
    static String DE =  "de";
    static String ES =  "es";
    static String FR =  "fr";
    static String IT =  "it";
    static String NL =  "nl";
    static String SV =  "sv";
    static String RU =  "ru";
    static  String PT =  "pt";
    static String RO =  "ro";
    static  String ZH =  "zh";
    public static String  SimpleName = "Name Surname";
    public static String  SimpleOrganisation= "Organisation Museum";
    public static String  SimpleEmail = "testannaiziteq@gmail.com";




    //EMPTY ERRoR
    public static String getEmptyErrorLanguage(String language ) {
        if   (language  == EN) {
            return "Required field can not be left blank.";
        }
        if   (language   == DE) {
            return "Das Pflichtfeld darf nicht leer sein.";
        }
        if   (language  == ES) {
            return "El campo obligatorio no puede dejarse en blanco.";
        }
        if   (language == FR) {
            return "Le champ obligatoire ne peut être laissé vide.";
        }
        if   (language  == IT) {
            return "Il campo obbligatorio non può essere vuoto.";
        }
        if   (language  == NL) {
            return "Een verplicht veld mag niet leeg zijn.";
        }
        if   (language  == SV) {
            return "Obligatoriskt fält kan inte lämnas tomt.";
        }
        if   (language  == RU) {
            return "Это поле должно быть заполнено.";
        }
        if   (language  == PT) {
            return "Campo obrigatório não pode ser deixado em branco.";
        }
        if   (language  == RO) {
            return "Câmpul obligatoriu nu poate fi lăsat necompletat.";
        }
        if   (language  == ZH) {
            return "必填栏不得留空。";
        }
        return null;

    }

    public static String getRandomLanguage() {
      String[] allLang = {DE, EN, ES, FR, IT, NL, PT, RO, RU, SV, ZH};
        Random rand = new Random();
        int i= rand.nextInt(10);
        return  allLang[i];
    }
}
