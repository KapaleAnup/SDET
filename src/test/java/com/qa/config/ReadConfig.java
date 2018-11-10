package com.qa.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties prop;
	
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");
		
		try {
			FileInputStream ip = new FileInputStream(src);
			prop = new Properties();
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		public String getApplicationURl()
		{
			String url =prop.getProperty("baseURL");
			return url;
			
		}
		
		public String getUsername()
		{
			String username =prop.getProperty("username");
			return username;
			
		}
		
		public String getPassword()
		{
			String password =prop.getProperty("password");
			return password;
			
		}
		
		public String getChromePath()
		{
			String chromepath =prop.getProperty("chromepath");
			return chromepath;
			
		}
		public String getFireFoxPath()
		{
			String firefoxpath =prop.getProperty("firefoxpath");
			return firefoxpath;
			
		}
	}

