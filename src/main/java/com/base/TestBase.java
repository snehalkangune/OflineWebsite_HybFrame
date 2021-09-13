package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public static WebDriver driver=null;
	FileInputStream fis = null;
	public static Logger log=Logger.getLogger(TestBase.class);
	
	public String readProperty(String key) {
		log.info("reading a property file from property file");
		Properties prop = new Properties();
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties ");
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("value found in the property file for the"+key);
		return prop.getProperty(key);
	}
	public void launchApplication(){
		log.info("launching an application");
		driver.get(readProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public WebDriver initialization(){
		log.info("initialising a browser with name"+readProperty("browser"));
		if(readProperty("browser").equals("chrome")){
			System.setProperty("Webdriver.chrome.driver","chromedriver.exe");
			driver =new ChromeDriver();
			launchApplication();
			log.info("chrome browser initialised");
			return driver;
		}
		/*else{
			System.setProperty("Webdriver.gecko.driver","geckodriver.exe");
			driver =new FirefoxDriver();
			launchApplication();
			log.info("chrome browser initialised");
			return driver;
		}*/
		return driver;
	}
	public String getScreenshot(String name){
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(System.getProperty("user.dir")+"/screenshots/"+name+".jpg");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Screenshot Captured";
		
	}
}
