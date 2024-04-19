package com.waspshopkey.framework.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    public ConfigReader() {
        loadProperties();
    }

    private void loadProperties() {
        properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getChromeDriverPath() {
        return properties.getProperty("chrome.driver.path");
    }

    public String getFirefoxDriverPath() {
        return properties.getProperty("firefox.driver.path");
    }

    // Add more methods for other web drivers as needed

    // Corrected method to expose the Properties object
    public Properties getProperties() {
        return properties;
    }

	public static String getPropertyValue(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
