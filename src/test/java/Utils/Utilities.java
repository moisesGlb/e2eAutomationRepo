package Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

public class Utilities {

    private Random rand = new Random();
    private FileHandler fileHandler;

    public String generateEmail(String name) {
        if (name.contains(" ")) {
            String[] arrOfStr = name.split(" ");
            return arrOfStr[0] + "." + arrOfStr[arrOfStr.length - 1] + "@testmail.com";
        } else return name + "@testmail.com";
    }

    public String getJiraId(String jiraId) {
        if (jiraId.contains("JIRA")) {
            String[] vec = jiraId.split("_");
            return vec[0];
        } else return "";
    }

    public Properties readFromProperties() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find application.properties file");
                return null;
            }
            Properties prop = new Properties();
            prop.load(input);
            return prop;
        } catch (IOException ex) {
            System.out.println("Sorry, unable to find application.properties file");
            ex.printStackTrace();
        }
        return null;
    }
}
