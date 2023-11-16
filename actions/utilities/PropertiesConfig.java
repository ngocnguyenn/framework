package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesConfig {
	private final Properties properties;
	private final String propertyFilePath = System.getProperty("user.dir")+ "/resources/config.properties";
	private static PropertiesConfig configLoader;
	private PropertiesConfig() {
		properties = PropertiesConfig.propertyLoader(propertyFilePath);
	}
	private static Properties propertyLoader(String propertyFilePath) {
		Properties properties = new Properties();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			try {
				properties.load(reader);
				reader.close();
			} catch(IOException e)
			{
				e.printStackTrace();
				throw new RuntimeException("Failed to load properties file " + propertyFilePath);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration properties not found at " + propertyFilePath);
		}
		return properties;
	}
	public static PropertiesConfig getFileConfigReader()
	{
		if(configLoader == null)
		{
			configLoader = new PropertiesConfig();
		}
		return configLoader;
	}
	public long getLongTimeout()
	{
		String longTimeout = properties.getProperty("LongTimeout");
		if(longTimeout != null)
			return Long.parseLong(longTimeout);
		else
			throw new RuntimeException("Long timeout not found in Config file");
	}
	public long getShortTimeout() {
		String shortTimeout = properties.getProperty("ShortTimeout");
		if(shortTimeout != null)
			return Long.parseLong(shortTimeout);
		else
			throw new RuntimeException("Short timeout not found in Config file");
	}
	public String getUserUrl()
	{
		String userUrl = properties.getProperty("UseUrl");
		if(userUrl != null)
			return userUrl;
		else
			throw new RuntimeException("User URL not found in Config file");
	}
	public String getAdminUrl()
	{
		String adminUrl = properties.getProperty("AdminUrl");
		if(adminUrl != null)
			return adminUrl;
		else
			throw new RuntimeException("Admin URL not found in Config file");
	}
}
