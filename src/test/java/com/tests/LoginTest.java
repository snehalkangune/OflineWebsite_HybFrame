package com.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.LoginPage;

public class LoginTest extends TestBase {

	WebDriver driver=null;
	LoginPage lp=null;
	
	@BeforeMethod
	public void setUp(){
		driver=initialization();
		lp=new LoginPage(driver);
	}
	
	@Test
	public void displayLogo(){
		Assert.assertEquals(lp.displayLogo(), true);
	}
	
	@Test
	public void verifyHeading1(){		
		Assert.assertEquals(lp.verifyH1(),"Java By Kiran");
	}
	
	@Test
	public void verifyHeading2(){		
		Assert.assertEquals(lp.verifyH2(),"JAVA | SELENIUM | PYTHON");
	}
	
	@Test
	public void verifyHeading3(){		
		Assert.assertEquals(lp.verifyH3(),"Sign in to start your session");
	}
	
	@Test
	public void validLogin(){
		lp.validLogin();
		Assert.assertEquals(driver.getTitle(),"JavaByKiran | Dashboard");
	}
	
	@Test
	public void testFailure(){
		Assert.assertTrue(false);
	}
	
	@Test
	public void inValidLogin() {
		lp.inValidLogin("namrata@gmail.com", "159632");
		System.out.println("Error for invalid is " + lp.getEmailError());
		// WebElement email_error=driver.findElement(By.id("email_error"));
		// Assert.assertEquals(driver.getTitle(), "JavaByKiran | Log in");
		Assert.assertEquals(lp.getEmailError(), "Please enter email as kiran@gmail.com");
	}
	
	@Test
	public void blankLogin() {
		lp.inValidLogin("", "");
		System.out.println("Error for blank login is " + lp.getEmailError());
		// WebElement email_error=driver.findElement(By.id("email_error"));
		// Assert.assertEquals(driver.getTitle(), "JavaByKiran | Log in");
		Assert.assertEquals(lp.getEmailError(), "Please enter email.");
	}
	
	@Test
	public void verifyRegisterLink(){
		lp.registerPageLink();
		Assert.assertEquals(driver.getTitle(),"JavaByKiran | Registration Page");	
	}
}
