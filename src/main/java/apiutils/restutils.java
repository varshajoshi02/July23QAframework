package apiutils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class restutils {
	

		private static restutils utils;
		private static final Properties prop= new Properties();
	
	
		
		public  restutils() throws IOException
		{
			InputStream is= restutils.class.getResourceAsStream("/Assignment_02/resources/config.properties");
			prop.load(is);
			
		}
	
		public static restutils getInstance() {
		
			if(utils==null) {
		
				synchronized(restutils.class) {
					try {
						utils= new restutils();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
		}
			return utils;
		}
		
		
		public String getString(String key)
		{
			return System.getProperty(key,prop.getProperty(key));
		}

	

	

		
		}



