package Setups;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class WebElementPropertiesReader {
    private static Properties properties = new Properties();

      public static Properties getWebElementsPath() {

          try {
              // Load the property file
              FileInputStream fileInputStream = new FileInputStream("src/test/resources/AllWebElements.properties");
              properties.load(fileInputStream);
              fileInputStream.close();

          } catch (IOException e) {
              e.printStackTrace();
          }

          return properties;
      }

      public static ArrayList<String> getMastodonLogInCredentials(){
          String filePath = "C:/Users/rudym/Desktop/Automation/credentials.txt";
          File file = new File(filePath);
          ArrayList<String> credentials = new ArrayList<>();
          try {
              Scanner scanner = new Scanner(file);

              while (scanner.hasNextLine()) {
                  String line = scanner.nextLine();
                  credentials.add(line);
              }

              scanner.close();
          } catch (FileNotFoundException e) {
              System.out.println("File not found: " + filePath);
              e.printStackTrace();
          }


          return credentials;
      }

}
