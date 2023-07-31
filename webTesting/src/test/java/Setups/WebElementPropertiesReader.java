package Setups;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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

}
