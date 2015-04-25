package main.java.UI;

import java.io.UnsupportedEncodingException;
import java.util.Random;


public class Constant {

    public static  String MAILTEXT ;
    public static  String MAILLINK ;
    //Constants
    public static final String NAME = "USERNAME";
    public static final String ORGANISATION = "ORGANISATION";
    public static final String EMAIL = "EMAIL";
    public static final String LICENCE_AGREE = "LICENCE";
    public static final  String TITLE = "TITLE";
    public static final  String DESCRIPTION = "DESCRIPTION";
    // languages
    public static String BROWSER_LANG;
    public static String BROWSER;
    public static String URL;
    public static final String EN = "en";
    public static final String DE = "de";
    public static final String ES = "es";
    public static final String FR = "fr";
    public static final String IT = "it";
    public static final String NL = "nl";
    public static final String SV = "sv";
    public static final String RU = "ru";
    public static final String PT = "pt";
    public static final String RO = "ro";
    public static final String ZH = "zh";
    public static final String SimpleName = "Name Surname";
    public static final String SimpleOrganisation = "Organisation Museum";
    public static final String SimpleEmail = "testannaiziteq@gmail.com";
    public static final String CHROME = "CHROME";
    public static final String FIREFOX = "FF";
    public static final String IE = "IE";
    public static final String SimplePassword = "123123";

    //random lang
    private static String getRandomValue(String[] allValues) {
        Random rand = new Random();
        int i = rand.nextInt(allValues.length - 1);
        return allValues[i];
    }
    public static String getRandomLanguage() {
        String[] allLang = {Constant.DE, Constant.EN, Constant.ES, Constant.FR, Constant.IT, Constant.NL, Constant.PT, Constant.RO, Constant.RU, Constant.SV, Constant.ZH};
        return getRandomValue(allLang);
    }


    public static String selectRandomBrowser() {
        String[] allBrowser = {Constant.CHROME, Constant.FIREFOX, Constant.IE};
        return getRandomValue(allBrowser);

    }
     public static String getEmptyErrorLanguage(String language) throws UnsupportedEncodingException {
        if (language.equals(EN)) {
            return "Required field can not be left blank.";
        }
        if (language.equals(DE)) {
            return "Das Pflichtfeld darf nicht leer sein.";
        }
        if (language.equals(ES)) {
            return "El campo obligatorio no puede dejarse en blanco.";
        }
        if (language.equals(FR)) {
            return "Le champ obligatoire ne peut être laissé vide.";
        }
        if (language.equals(IT)) {
            return "Il campo obbligatorio non può essere vuoto.";
        }
        if (language.equals(NL)) {
            return "Een verplicht veld mag niet leeg zijn.";
        }
        if (language.equals(SV)) {
            return "Obligatoriskt fält kan inte lämnas tomt.";
        }
        if (language.equals(RU)) {
            return "Это поле должно быть заполнено.";
        }
        if (language.equals(PT)) {
            return new String("Campo obrigatório não pode ser deixado em branco.".getBytes("UTF-8"), "UTF-8");

        }
        if (language.equals(RO)) {
            return "Câmpul obligatoriu nu poate fi lăsat necompletat.";
        }
        if (language.equals(ZH)) {
            return "必填栏不得留空。";
        }
        throw new Error("Unknown lang" + language);

    }
    public static String getIncorrectEmailErrorLanguage(String language) {
        if (language.equals(EN)) {
            return "Invalid e-mail format";
        }
        if (language.equals(DE)) {
            return "Ungültiges E-Mail-Format";
        }
        if (language.equals(ES)) {
            return "Formato de correo electrónico incorrecto";
        }
        if (language.equals(FR)) {
            return "Format d'adresse e-mail invalide";
        }
        if (language.equals(IT)) {
            return "Il formato dell'email non è valido";
        }
        if (language.equals(NL)) {
            return "Ongeldig e-mailformaat";
        }
        if (language.equals(PT)) {
            return "Formato de e-mail inválido";
        }
        if (language.equals(RO)) {
            return "Format e-mail nevalid";
        }
        if (language.equals(RU)) {
            return "Недопустимый формат электронной почты";
        }
        if (language.equals(SV)) {
            return "Felaktigt e-postformat";
        }
        if (language.equals(ZH)) {
            return "无效邮件格式";
        }
        throw new Error("Unknown lang" + language);
    }
    public static String getIncorrectCheckBoxLanguage(String language) {
        if (language.equals(EN)) {
            return "In order to use our service, you must agree to the License terms";
        }
        if (language.equals(DE)) {
            return "Um unseren Dienst nutzen zu können, müssen Sie den Lizenzbedingungen zustimmen";
        }
        if (language.equals(ES)) {
            return "Para utilizar nuestro servicio, debe aceptar los Términos de la licencia";
        }
        if (language.equals(FR)) {
            return "Pour utiliser notre service, vous devez accepter les Conditions de la licence";
        }
        if (language.equals(IT)) {
            return "Per poter utilizzare il nostro servizio, devi accettare i Termini di Licenza";
        }
        if (language.equals(NL)) {
            return "Om onze dienst te gebruiken, moet u akkoord gaan met de licentievoorwaarden";
        }
        if (language.equals(PT)) {
            return "Para utilizar o nosso serviço, você deve concordar com os termos da Licença";
        }
        if (language.equals(RO)) {
            return "Pentru a putea folosi serviciul nostru, trebuie să fiți de acord cu Termenii licenței";
        }
        if (language.equals(RU)) {
            return "Для продолжения регистрации необходимо принять условия лицензионного соглашения";
        }
        if (language.equals(SV)) {
            return "För att använda vår tjänst måste du godkänna licensvillkoren";
        }
        if (language.equals(ZH)) {
            return "该邮件地址已被注册 ";
        }
        throw new Error("Unknown lang" + language);
    }
    public static String getAlreadyExistErrorLanguage(String language) {
        if (language.equals(EN)) {
            return "An e-mail containing instructions about how to complete the registration has sent to this address";
        }
        if (language.equals(DE)) {
            return "Eine E-Mail mit Erläuterungen zum Abschluss der Anmeldung wurde an diese Adresse versandt";
        }
        if (language.equals(ES)) {
            return "Se ha enviado a esta dirección un correo electrónico que contiene instrucciones acerca de cómo completar el registro";
        }
        if (language.equals(FR)) {
            return "Un e-mail contenant des instructions sur la procédure de finalisation de l'inscription a été envoyé à cette adresse";
        }
        if (language.equals(IT)) {
            return "Una e-mail con le istruzioni per il completamento della registrazione è stata inviata a questo indirizzo e-mail";
        }
        if (language.equals(NL)) {
            return "Er is een e-mail met instructies over hoe u de registratie moet voltooien naar dit adres gestuurd";
        }
        if (language.equals(PT)) {
            return "Um e-mail com instruções sobre como preencher o cadastro foi enviado para esse endereço";
        }
        if (language.equals(RO)) {
            return "Un e-mail cu instrucțiunile privind finalizarea înregistrării a fost trimis la această adresă";
        }
        if (language.equals(RU)) {
            return "На этот почтовый адрес отправлено письмо с инструкцией по завершению регистрации";
        }
        if (language.equals(SV)) {
            return "Ett e-postmeddelande med instruktioner om hur du slutför registreringen har skickats till den här adressen";
        }
        if (language.equals(ZH)) {
            return "已经向该地址发送了一封包含如何完成注册程序的说明的邮件";
        }
        throw new Error("Unknown lang" + language);
    }
    public static String getAlreadyExistInDatabaseErrorLanguage(String language) {
        if (language.equals(EN)) {
            return "This e-mail address is already registered";
        }
        if (language.equals(DE)) {
            return "Diese E-Mail-Adresse ist bereits registriert";
        }
        if (language.equals(ES)) {
            return "Esta dirección de correo electrónico ya está registrada";
        }
        if (language.equals(FR)) {
            return "Cette adresse e-mail est déjà enregistrée";
        }
        if (language.equals(IT)) {
            return "Questo indirizzo e-mail risulta già registrato";
        }
        if (language.equals(NL)) {
            return "Dit e-mailadres is reeds geregistreerd";
        }
        if (language.equals(PT)) {
            return "Esse endereço de e-mail já está cadastrado";
        }
        if (language.equals(RO)) {
            return "Această adresă de e-mail este deja înregistrată";
        }
        if (language.equals(RU)) {
            return "Этот почтовый адрес уже зарегистрирован";
        }
        if (language.equals(SV)) {
            return "Den här e-postadressen är redan registrerad";
        }
        if (language.equals(ZH)) {
            return "该邮件地址已被注册";
        }
        throw new Error("Unknown lang" + language);
    }
    public static String getTitleLanguage(String language) {
        if (language.equals(EN)) {
            return "Creating an audio guide is easy!";
        }
        if (language.equals(DE)) {
            return "Einen Audioguide zu erstellen ist wirklich ganz einfach!";
        }
        if (language.equals(ES)) {
            return "¡Crear una audioguía es fácil!";
        }
        if (language.equals(FR)) {
            return "Créer un audioguide est simple !";
        }
        if (language.equals(IT)) {
            return "Creare un'audioguida è semplice!";
        }
        if (language.equals(NL)) {
            return "Een audiogids maken is eenvoudig!";
        }
        if (language.equals(PT)) {
            return "É muito fácil criar um guia de áudio!";
        }
        if (language.equals(RO)) {
            return "Este foarte uşor să creaţi un ghid audio!";
        }
        if (language.equals(RU)) {
            return "Создать аудиогид очень просто!";
        }
        if (language.equals(SV)) {
            return "Att skapa en audioguide är enkelt!";
        }
        if (language.equals(ZH)) {
            return "创建一个语音导游如此容易！";
        }
        throw new Error("Unknown lang" + language);

    }
    public static String getDescriptionLanguage(String language) {
        if (language.equals(EN)) {
            return "The izi.TRAVEL CMS interface allows you to quickly create, test and publish an audio guide. All instructions and resources available on login under HELP menu.";
        }
        if (language.equals(DE)) {
            return "Das IZI.CMS Interface erlaubt Ihnen das schnelle Erstellen, Testen und Veröffentlichen eines Audioführers. Alle Anleitungen und Ressourcen sind nach dem Login im HILFE-Menü verfügbar.";
        }
        if (language.equals(ES)) {
            return "La interfaz de IZI.CMS le permite crear, probar y publicar rápidamente audioguías. Todas las instrucciones y recursos disponibles una vez que inicie sesión bajo el menú AYUDA.";
        }
        if (language.equals(FR)) {
            return "L'interface IZI.CMS vous permet de créer, de tester et de publier rapidement une visite audioguidée. Toutes les instructions et les ressources sont disponibles, après connexion, dans le menu HELP (Aide).";
        }
        if (language.equals(IT)) {
            return "L'interfaccia CMS di izi.TRAVEL ti consente di creare, testare e pubblicare velocemente un'audioguida. Dopo aver effettuato l'accesso, tutte le istruzioni e le risorse sono disponibili nel menu HELP.";
        }
        if (language.equals(NL)) {
            return "Met de izi.TRAVEL CMS interface kunt u snel een audiogids maken, testen en publiceren. U vindt alle aanwijzingen en hulp als u inlogt in het CMS via het HELP menu.";
        }
        if (language.equals(PT)) {
            return "A interface do IZI.CMS permite a você criar, testar e publicar rapidamente um audioguia. Todas as instruções e recursos estão disponíveis ao efetuar login, no menu AJUDA.";
        }
        if (language.equals(RO)) {
            return "Interfaţa IZI.CMS vă permite să creaţi rapid un ghid audio, să îl testaţi şi să-l publicaţi. Toate instrucţiunile şi resursele sunt disponibile după autentificare, în meniul HELP.";
        }
        if (language.equals(RU)) {
            return "Удобный веб-интерфейс IZI.CMS позволит быстро создать, протестировать и опубликовать готовый аудиогид. Для вашей работы подготовлена вся необходимая справочная информация и рекомендации.";
        }
        if (language.equals(SV)) {
            return "IZI.CMS gränssnitt låter dig snabbt skapa, testa och publicera en ljudguide. Alla instruktioner och resurser finns tillgängliga efter inloggningen under HJÄLP-menyn.";
        }
        if (language.equals(ZH)) {
            return "IZI.CMS接口允许您快速创建，测试并发布一段语音导览。登录后，所有说明和资源都在帮助菜单下。";
        }
        throw new Error("Unknown lang" + language);

    }
    public static String getConfirmCheckboxLanguage(String language) {
        if (language.equals(EN)) {
            return "I agree to the terms and conditions of the license agreement";
        }
        if (language.equals(DE)) {
            return "Ich stimme den allgemeinen Lizenzrichtlinien zu";
        }
        if (language.equals(ES)) {
            return "Acepto los términos y condiciones del acuerdo de licencia";
        }
        if (language.equals(FR)) {
            return "J'accepte les Conditions générales de l'accord de licence";
        }
        if (language.equals(IT)) {
            return "Accetto i termini e le condizioni stabiliti nell'accordo di licenza";
        }
        if (language.equals(NL)) {
            return "Ik ga akkoord met de voorwaarden van de licentieovereenkomst";
        }
        if (language.equals(PT)) {
            return "Concordo com os termos e condições do contrato de licença";
        }
        if (language.equals(RO)) {
            return "Sunt de acord cu termenii și condițiile acordului de licență";
        }
        if (language.equals(RU)) {
            return "Я согласен с условиями лицензионного соглашения";
        }
        if (language.equals(SV)) {
            return "Jag godkänner regler och villkor för licensavtalet";
        }
        if (language.equals(ZH)) {
            return "我同意本许可协议的条款和条件";
        }
        throw new Error("Unknown lang" + language);
    }
    public static String getMailText(String language) {
        if (language.equals(EN)) {
            return "This e-mail was provided during registration for the";

        }
        if (language.equals(DE)) {
            return "Diese E-Mail wurde während der Registrierung  auf der";
        }
        if (language.equals(ES)) {
            return "Este correo electrónico se ha generado durante el registro en la página";
        }
        if (language.equals(FR)) {
            return "Cet e-mail a été émis lors de votre inscription sur le site";
        }
        if (language.equals(IT)) {
            return "Questa email è stata fornita durante la registrazione per il sito";
        }
        if (language.equals(NL)) {
            return "Deze e-mail werd verstuurd tijdens de registratie voor de site";
        }
        if (language.equals(PT)) {
            return "Este endereço de e-mail foi fornecido durante a inscrição para o site";
        }
        if (language.equals(RO)) {
            return "Această adresă de e-mail a fost furnizată în momentul înregistrării pe site-ul";
        }
        if (language.equals(RU)) {
            return "Ваш почтовый адрес был указан при регистрации на сайте";
        }
        if (language.equals(SV)) {
            return "Denna e-postadress angavs under registrering på webbplatsen";
        }
        if (language.equals(ZH)) {
            return "这个在注册中提供的邮件将给与";
        }
        throw new Error("Unknown lang" + language);
    }



}
