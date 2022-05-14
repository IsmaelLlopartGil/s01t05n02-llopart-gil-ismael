package edu.n5.exercise_1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHandler {

	Properties properties;

	public PropertiesHandler() {
		loadProperties();
	}

	private void loadProperties() {
		
		String appConfigPath =  "iu.properties";

		properties = new Properties();
		
		try {
			properties.load(new FileInputStream(appConfigPath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getProperty(String property) {

		return properties.getProperty(property);
	}
}
