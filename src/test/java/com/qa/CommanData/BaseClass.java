package com.qa.CommanData;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfig reader = new ReadConfig();
	
	public String baseURL =reader.getApplicationURl();
	public String username= reader.getUsername();
	public String password=reader.getPassword();
	
	public static WebDriver driver;
	
	public static Logger logger;  //apache logger
	
	public final static int TIMEOUT =30;
	public final static int PAGE_LOAD_TIMEOUT =20;
	
	
	@Parameters("browser")
	@BeforeClass
	public void Setup(String br)
	{
		// System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver");
		// driver = new ChromeDriver();
		
		logger =Logger.getLogger("Inetbanking");
		
		
		if(br.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		//System.setProperty("webdriver.chrome.driver", reader.getChromePath());
		//driver = new ChromeDriver();
		}
		else if (br.equalsIgnoreCase("firefox"))
		{
		//	System.setProperty("webdriver.gecko.driver", reader.getFireFoxPath());
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(baseURL);
		
		logger.info("URL is opened");
		
		
		
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String testcasename) throws IOException
	{
		TakesScreenshot ts=  (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+ testcasename +".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot Taken");
		
		
		
		
		
	}
	
	//Generate random values.
		public static String randomstring()
		{
			String generatestring = RandomStringUtils.randomAlphabetic(8);
			return (generatestring);
			
		
		}
		
		 public static String getrandomPhoneNumber(){


		       String phonenumber= RandomStringUtils.randomNumeric(10);

		       return (phonenumber);
		    }
	
}
