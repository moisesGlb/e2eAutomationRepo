package Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utilities {

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
