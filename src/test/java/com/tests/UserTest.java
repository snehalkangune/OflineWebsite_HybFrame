package com.tests;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.base.TestBase;
import com.pages.DashBoardPage;
import com.pages.LoginPage;
import com.pages.UserPage;

public class UserTest extends TestBase {
	WebDriver driver=null;
	LoginPage lp=null;
	DashBoardPage dp=null;
	UserPage up=null;
	
	@BeforeMethod
	public void setUp(){
		driver=initialization();
		lp=new LoginPage(driver);
		dp=new DashBoardPage(driver);
		up=new UserPage(driver);
	}
	
	@Test
	public void verifyuserTable() {
		dp = lp.validLogin();
		up=dp.clickUserButton();
		Assert.assertTrue(up.userTable());
}
}
