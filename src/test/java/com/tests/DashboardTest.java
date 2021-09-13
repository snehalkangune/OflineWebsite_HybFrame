package com.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.DashBoardPage;
import com.pages.LoginPage;

public class DashboardTest extends TestBase {
	WebDriver driver;
	LoginPage lp;
	DashBoardPage dp=null;
	
	@BeforeMethod
	public void setUp(){
		driver=initialization();
		lp=new LoginPage(driver);
		dp=new DashBoardPage(driver);
	}
	
	@Test
	public void verifyHeading1() {
		dp = lp.validLogin();
		Assert.assertEquals(dp.verifyH1(),"Java By Kiran");
}
	
	@Test
	public void verifyCourses() {
		dp = lp.validLogin();
		Assert.assertTrue(dp.getAllCourses());// return true or false
	}
	
	@Test
	public void verifyHeadings2() {
		dp = lp.validLogin();
		Assert.assertTrue(dp.getAllHeadings());// return true or false
	}

	@Test
	public void verifySideMenu() {
		dp = lp.validLogin();
		Assert.assertTrue(dp.getAllSideMenu());// return true or false
	}

	@Test
	public void lougoutButton(){
		dp.clickLogoutButton();
		Assert.assertEquals(driver.getTitle(),"JavaByKiran | Log in");	
	}
}
