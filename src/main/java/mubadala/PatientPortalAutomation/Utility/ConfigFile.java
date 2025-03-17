package mubadala.PatientPortalAutomation.Utility;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigFile {
	
	private static Properties properties = new Properties();

	public ConfigFile() { super(); }
	
	static {
		try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties")){
			properties.load(fileInputStream);
		} catch (Exception e) {
			throw new RuntimeException("Unable load config.properties file: " + e.getMessage());
		}
	}
	
	public static String getProperty(String key) {
		return properties.getProperty(key);
	}
	
	
}
