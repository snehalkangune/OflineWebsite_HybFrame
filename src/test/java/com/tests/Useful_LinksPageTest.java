package com.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.DashBoardPage;
import com.pages.LoginPage;
import com.pages.Useful_LinksPage;

public class Useful_LinksPageTest extends TestBase {
	WebDriver driver=null;
	LoginPage lp=null;
	DashBoardPage dp=null;
	Useful_LinksPage ulp=null;
	
	@BeforeMethod
	public void setUp(){
		driver=initialization();
		lp=new LoginPage(driver);
		dp=new DashBoardPage(driver);
		ulp=new Useful_LinksPage(driver);
	}
	
	@Test
	public void verifyusefulLinks() {
		dp = lp.validLogin();
		ulp=dp.clickUseful_LinksButton();
		Assert.assertTrue(ulp.usefulLinks());
}
}
