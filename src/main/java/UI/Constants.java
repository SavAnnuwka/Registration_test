package main.java.UI;

import java.io.UnsupportedEncodingException;
import java.util.Random;

public class Constants {
   // languages
   public static String EN =  "en";
    public static String DE =  "de";
    public static String ES =  "es";
    public static String FR =  "fr";
    public static String IT =  "it";
    public static String NL =  "nl";
    public static String SV =  "sv";
    public static String RU =  "ru";
    public static  String PT =  "pt";
    public static String RO =  "ro";
    public static  String ZH =  "zh";
     public static String  SimpleName = "Name Surname";
    public static String  SimpleOrganisation= "Organisation Museum";
    public static String  SimpleEmail = "testannaiziteq@gmail.com";


    //EMPTY ERROR
    public static String getEmptyErrorLanguage(String language ) throws UnsupportedEncodingException {
        if   (language.equals(EN)) {
            return "Required field can not be left blank.";
        }
        if   (language.equals(DE)) {
            return "Das Pflichtfeld darf nicht leer sein.";
        }
        if   (language.equals(ES)) {
            return "El campo obligatorio no puede dejarse en blanco.";
        }
        if  (language.equals(FR)) {
            return "Le champ obligatoire ne peut être laissé vide.";
        }
        if   (language.equals(IT)) {
            return "Il campo obbligatorio non può essere vuoto.";
        }
        if   (language.equals(NL)) {
            return "Een verplicht veld mag niet leeg zijn.";
        }
        if   (language.equals(SV)) {
            return "Obligatoriskt fält kan inte lämnas tomt.";
        }
        if   (language.equals(RU)){
            return "Это поле должно быть заполнено.";
        }
        if   (language.equals(PT)) {
             //????//
            return new  String( "Campo obrigatório não pode ser deixado em branco.".getBytes("UTF-8"), "UTF-8") ;

        }
        if   (language.equals(RO)) {
            return "Câmpul obligatoriu nu poate fi lăsat necompletat.";
        }
        if  (language.equals(ZH)) {
            return "必填栏不得留空。";
        }
        throw new Error("Unknown lang" + language);

    }

    //INCORRECT EMAIL
    public static String getIncorrectEmailErrorLanguage(String language)
    {
        if   (language.equals(EN)) {
            return "Invalid e-mail format";
        }
        if   (language.equals(DE)) {
            return "Ungültiges E-Mail-Format";
        }
        if   (language.equals(ES)) {
            return "Formato de correo electrónico incorrecto";
        }
        if  (language.equals(FR)) {
            return "Format d'adresse e-mail invalide";
        }
        if   (language.equals(IT)) {
            return "Il formato dell'email non è valido";
        }
        if   (language.equals(NL)) {
            return "Ongeldig e-mailformaat";
        }
        if   (language.equals(PT)) {
            return "Formato de e-mail inválido";
        }
        if   (language.equals(RO)) {
            return "Format e-mail nevalid";
        }
        if   (language.equals(RU)){
            return "Недопустимый формат электронной почты";
        }
        if   (language.equals(SV)) {
            return "Felaktigt e-postformat";
        }
        if  (language.equals(ZH)) {
            return "无效邮件格式";
        }
        throw new Error("Unknown lang" + language);
    }


//INCORRECT checkbox
    public static String getIncorrectCheckBoxLanguage(String language) {
        if   (language.equals(EN)) {
            return "In order to use our service, you must agree to the License terms";
        }
        if   (language.equals(DE)) {
            return "Um unseren Dienst nutzen zu können, müssen Sie den Lizenzbedingungen zustimmen";
        }
        if   (language.equals(ES)) {
            return "Formato de correo electrónico incorrecto";
        }
        if  (language.equals(FR)) {
            return "Pour utiliser notre service, vous devez accepter les Conditions de la licence";
        }
        if   (language.equals(IT)) {
            return "Per poter utilizzare il nostro servizio, devi accettare i Termini di Licenza";
        }
        if   (language.equals(NL)) {
            return "Om onze dienst te gebruiken, moet u akkoord gaan met de licentievoorwaarden";
        }
        if   (language.equals(PT)) {
            return "Para utilizar o nosso serviço, você deve concordar com os termos da Licença";
        }
        if   (language.equals(RO)) {
            return "Pentru a putea folosi serviciul nostru, trebuie să fiți de acord cu Termenii licenței";
        }
        if   (language.equals(RU)){
            return "Для продолжения регистрации необходимо принять условия лицензионного соглашения";
        }
        if   (language.equals(SV)) {
            return "För att använda vår tjänst måste du godkänna licensvillkoren";
        }
        if  (language.equals(ZH)) {
            return "该邮件地址已被注册 ";
        }
        throw new Error("Unknown lang" + language);
    }

     //Already try to register
    public static String getAlreadyExistErrorLanguage(String language) {
        if   (language.equals(EN)) {
            return "An e-mail containing instructions about how to complete the registration has sent to this address";
        }
        if   (language.equals(DE)) {
            return "Eine E-Mail mit Erläuterungen zum Abschluss der Anmeldung wurde an diese Adresse versandt";
        }
        if   (language.equals(ES)) {
            return "Se ha enviado a esta dirección un correo electrónico que contiene instrucciones acerca de cómo completar el registro";
        }
        if  (language.equals(FR)) {
            return "Un e-mail contenant des instructions sur la procédure de finalisation de l'inscription a été envoyé à cette adresse";
        }
        if   (language.equals(IT)) {
            return "Una e-mail con le istruzioni per il completamento della registrazione è stata inviata a questo indirizzo e-mail";
        }
        if   (language.equals(NL)) {
            return "Er is een e-mail met instructies over hoe u de registratie moet voltooien naar dit adres gestuurd";
        }
        if   (language.equals(PT)) {
            return "Um e-mail com instruções sobre como preencher o cadastro foi enviado para esse endereço";
        }
        if   (language.equals(RO)) {
            return "Un e-mail cu instrucțiunile privind finalizarea înregistrării a fost trimis la această adresă";
        }
        if   (language.equals(RU)){
            return "На этот почтовый адрес отправлено письмо с инструкцией по завершению регистрации";
        }
        if   (language.equals(SV)) {
            return "Ett e-postmeddelande med instruktioner om hur du slutför registreringen har skickats till den här adressen";
        }
        if  (language.equals(ZH)) {
            return "已经向该地址发送了一封包含如何完成注册程序的说明的邮件";
        }
        throw new Error("Unknown lang" + language);
    }


    //Already register
    public static String getAlreadyExistInDatabaseErrorLanguage(String language) {
        if   (language.equals(EN)) {
            return "This e-mail address is already registered";
        }
        if   (language.equals(DE)) {
            return "Diese E-Mail-Adresse ist bereits registriert";
        }
        if   (language.equals(ES)) {
            return "Esta dirección de correo electrónico ya está registrada";
        }
        if  (language.equals(FR)) {
            return "Cette adresse e-mail est déjà enregistrée";
        }
        if   (language.equals(IT)) {
            return "Questo indirizzo e-mail risulta già registrato";
        }
        if   (language.equals(NL)) {
            return "Dit e-mailadres is reeds geregistreerd";
        }
        if   (language.equals(PT)) {
            return "Esse endereço de e-mail já está cadastrado";
        }
        if   (language.equals(RO)) {
            return "Această adresă de e-mail este deja înregistrată";
        }
        if   (language.equals(RU)){
            return "Этот почтовый адрес уже зарегистрирован";
        }
        if   (language.equals(SV)) {
            return "Den här e-postadressen är redan registrerad";
        }
        if  (language.equals(ZH)) {
            return "该邮件地址已被注册";
        }
        throw new Error("Unknown lang" + language);
    }


}
