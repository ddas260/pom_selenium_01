package testpersonal.pom_selenium_01.utils;

import java.util.Objects;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PropertiesManager {
	private static Properties properties;
	public static String getProperty(String key) throws FileNotFoundException, IOException {
		if(Objects.isNull(properties)) {
			properties = new Properties();
			properties.load(new FileInputStream("./src/main/java/testpersonal/pom_selenium_01/config/config.properties"));
		}
		return properties.getProperty(key);	
	}
	public static void clear() {
		properties.clear();
	}
	

}