package testpersonal.pom_selenium_01.utils.json_reader;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReader<T> {
	private static ObjectMapper objMap = new ObjectMapper();
	public static <T> T getValue(String path, Class<T> className) throws IOException {
		File file = new File(path);
		 if (!file.exists() || !file.canRead()) {
	            throw new IOException("File does not exist or cannot be read: " + path);
	        }
		return objMap.readValue(file, className);
	}
	

}
