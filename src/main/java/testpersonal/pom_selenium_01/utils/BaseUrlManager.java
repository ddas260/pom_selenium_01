package testpersonal.pom_selenium_01.utils;

import java.io.IOException;

import testpersonal.pom_selenium_01.utils.json_reader.JsonReader;
import testpersonal.pom_selenium_01.utils.json_reader.base_url_objects.EnvData;

public class BaseUrlManager {
	public static String getUrl(String name) {
		EnvData envData = null;
		try {
			envData = JsonReader.getValue("./src/main/resources/env.json", EnvData.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String url = "";
		try {
			if (name.contains("prod")) {
				url = envData.getProduction().getUrl();
			} else if (name.contains("dev")) {
				url = envData.getDevelopment().getUrl();
			} else {
				throw new Exception("URL not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}

}
