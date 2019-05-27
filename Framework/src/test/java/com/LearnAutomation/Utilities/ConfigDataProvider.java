package com.LearnAutomation.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;
	
	public ConfigDataProvider()
	{
		
		File src=new File("F:\\KalidasWorkspace\\Framework\\Configuration\\Config.properties");
		
		
			try {
				FileInputStream Fis=new FileInputStream(src);
				
				pro=new Properties();
				
				pro.load(Fis);
			   } catch (Exception e) {
				
				System.out.println("Not able to LOad");
			   }
			
			
		
	}
	
	public String getDataFromConfig(String KeyToSearch)
	{
		return pro.getProperty(KeyToSearch);
	}
	public String getBrowser()
	{
		return pro.getProperty("BrowserName");
	}
	public String getURL()
	{
		return pro.getProperty("QAUrl");
	}
		
	}


