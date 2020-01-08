package Utils;

import java.text.DecimalFormat;
import java.util.Random;

public class Utilities {

    public static class Utilidades{

        private Random rand = new Random();
        private DecimalFormat df4 = new DecimalFormat("0000"); // 4 zeros

        public String generateEmail(String name){
            if (name.contains(" ")){
                String[] arrOfStr = name.split(" ");
                return arrOfStr[0]+"."+arrOfStr[arrOfStr.length-1]+"@testmail.com";
            }else return name+"@testmail.com";
        }

        public String generatePhoneNumber(){
            int num1 = (rand.nextInt(7) + 1) * 100 + (rand.nextInt(8) * 10) + rand.nextInt(8);
            int num2 = rand.nextInt(743);
            int num3 = rand.nextInt(10000);

            DecimalFormat df3 = new DecimalFormat("000"); // 3 zeros
            return df3.format(num1) + "-" + df3.format(num2) + "-" + df4.format(num3);
        }

        public String getJiraId(String jiraId){
            if (jiraId.contains("JIRA")){
                String[] vec = jiraId.split("_");
                return vec[0];
            }else return "";


        }



    }


}
