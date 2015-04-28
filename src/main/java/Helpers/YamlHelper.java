package main.java.Helpers;


import main.java.ApplicationManager;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;

public class YamlHelper extends HelperWithWebDriverBase{
    private static Properties keys;

    public YamlHelper(ApplicationManager app) {
        super(app);
        keys = getProperties();}


    public String getDescriptionLanguage(String language) throws IOException {
        return ReadFile(language, keys.getProperty("text.description"));
    }

    public String getCheckBoxText(String language) throws IOException {
        return ReadFile(language, keys.getProperty("text.checkbox"));
    }
    public String getTitleLanguage(String language) throws IOException {
        return ReadFile(language, keys.getProperty("text.description"));
    }
    public String getEmptyErrorLanguage(String language) throws IOException {
        return ReadFile(language, keys.getProperty("error.empty"));
    }
    public String getCheckBoxError(String language) throws IOException {
        return ReadFile(language, keys.getProperty("error.checkbox"));
    }
    public String getEmailError(String language) throws IOException {
        return ReadFile(language, keys.getProperty("error.email.incorrect"));
    }
    public String getAlreadyRegisterEmail(String language) throws IOException {
        return ReadFile("cms."+language, keys.getProperty("error.email.already.register"));
    }
    public String getAlreadyExistInDatabaseErrorLanguage(String language) throws IOException {
        return ReadFile("cms."+language, keys.getProperty("error.email.already.exist"));
    }

    private Properties getProperties() {
        String configFile = "YAML.keys.properties";
        Properties props = new Properties();
        try {
            props.load(new FileReader(configFile));
        } catch (IOException e) {
            log.log(Level.SEVERE,  e.getMessage());
            e.printStackTrace();
        }
        return props;
    }

    private String ReadFile(String name,  String key) throws IOException {
        String userDir = System.getProperty("user.dir");
     //   if (file==null) {
         String file = userDir + "\\src\\test\\resources\\"  + name + ".yml";
       //!file.exists()) {return "No file"+ name + ".yml";}
        try {
            ArrayList<String> keys = ParseStringKey(key, ".");
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            String line = null;

            for (int i = 0; i < keys.size(); i++)
            {
                while ((line = br.readLine()) != null) {
                    if (line.trim().startsWith(keys.get(i))) {
                        break;
                    }
                }
            }
            br.close();
            return line.substring(line.indexOf(":")+1).trim();
        }  catch (IOException e) {e.printStackTrace();}
    return null;
    }

    private boolean isCorrectString(BufferedReader br, ArrayList<String> keys, String line) throws IOException {
        if (line.trim().startsWith(keys.get(0))) {
            for (int i = 1; i < keys.size(); i++) {
                line = br.readLine();
                if (line.trim().startsWith(keys.get(i))) {
                } else return false;
            }
            return true;
        } else return false;
    }

    private ArrayList ParseStringKey(String line, String separator) {
         ArrayList  <String> arr = new ArrayList();
       // int i=0;
        while (line.contains(separator))
        {
            arr.add(line.substring(0, line.indexOf(separator)));
            line = line.substring(line.indexOf(separator) +1);
          //  i++;
        }
        arr.add(line.substring(0, line.length()));
        return arr;
    }



}
