package com.qa.CommanData;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.config.ReadConfig;

public class BaseClass {

	ReadConfig reader = new ReadConfig();
	
	public String baseURL =reader.getApplicationURl();
	public String username= reader.getUsername();
	public String password=reader.getPassword();
	
	public static WebDriver driver;
	
	public static Logger logger;  //apache logger
	
	
	@Parameters("browser")
	@BeforeClass
	public void Setup(String br)
	{
		// System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver");
		// driver = new ChromeDriver();
		
		logger =Logger.getLogger("Inetbanking");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", reader.getChromePath());
		driver = new ChromeDriver();
		}
		else if (br.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", reader.getFireFoxPath());
			driver = new FirefoxDriver();
		}
		
		driver.get(baseURL);
		logger.info("URL is opened");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts=  (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot Taken");
		
		
	}
	
	//Generate random values.
		public static String randomstring()
		{
			String generatestring = RandomStringUtils.randomAlphabetic(8);
			return (generatestring);
		}
	
}
