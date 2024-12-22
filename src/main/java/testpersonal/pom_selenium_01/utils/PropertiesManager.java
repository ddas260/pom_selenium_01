package testpersonal.pom_selenium_01.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {
	private static Properties properties = new Properties();
	private static String location = "./src/main/java/testpersonal/pom_selenium_01/config/config.properties";
	static {
		try {
			properties.load(new FileInputStream(location));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key) throws FileNotFoundException, IOException {	
		return properties.getProperty(key);	
	}
	public static void clear() {
		properties.clear();
	}
	

}
