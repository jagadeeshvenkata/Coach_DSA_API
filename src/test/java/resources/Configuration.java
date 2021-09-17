package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.cucumber.java.Before;

public class Configuration {

	private static String env;
	private static Properties prop;


	public static String getEnv(){
		try {
			FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\config.properties");
			prop=new Properties();
			prop.load(fi);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return env = prop.getProperty("env");
	}
	


	
}
