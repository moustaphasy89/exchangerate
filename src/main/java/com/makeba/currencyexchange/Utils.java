package com.makeba.currencyexchange;
import java.io.IOException;
import java.util.Properties;

public class Utils {

  public static String API_PROPERTIES = "api.properties";

  public static String PATH_TO_RATE_FILES = "C:/jbossdata/";

  public static String readValueFromPropertieFile(final String filename, final String key) throws IOException {

    final Properties prop = new Properties();

    prop.load(Utils.class.getClassLoader().getResourceAsStream(filename));
    return prop.getProperty(key);
  }
}
