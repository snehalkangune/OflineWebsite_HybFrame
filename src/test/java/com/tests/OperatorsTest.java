package com.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.DashBoardPage;
import com.pages.LoginPage;
import com.pages.OperatorsPage;


public class OperatorsTest extends TestBase {
	WebDriver driver=null;
	LoginPage lp=null;
	DashBoardPage dp=null;
	OperatorsPage op=null;
	
	@BeforeMethod
	public void setUp(){
		driver=initialization();
		lp=new LoginPage(driver);
		dp=new DashBoardPage(driver);
		op=new OperatorsPage(driver);
	}
	
	@Test
	public void verifyOpratorList() {
		dp = lp.validLogin();
		op=dp.clickOperatorsButton();
		Assert.assertTrue(op.opratorList());
}

}
