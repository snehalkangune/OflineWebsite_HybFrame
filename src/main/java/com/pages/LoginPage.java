package com.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pages.DashBoardPage;


public class LoginPage {
	WebDriver driver=null;
	
	@FindBy(xpath="/html/body/div/center/img")
	WebElement logo;
	@FindBy(xpath = "//b[text()='Java By Kiran']")
	WebElement heading1;
	@FindBy(xpath = "//h4[text()='JAVA | SELENIUM | PYTHON']")
	WebElement heading2;
	@FindBy(xpath = "//p[text()='Sign in to start your session']")
	WebElement loginBoxMsg;
	@FindBy(id = "email")
	WebElement uname;
	@FindBy(id = "password")
	WebElement pass;
	@FindBy(xpath = "//button")
	WebElement loginButton;
	@FindBy(id = "email_error")
	WebElement email_error;
	@FindBy(xpath = "//a[text()='Register a new membership']")
	WebElement register;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);// initElements()-use this driver to find the above elements like email,pass,button
		// use of initElements-to initialize all the webelement present in the perticular class
		this.driver = driver;
	}
	
	public boolean displayLogo(){
		return logo.isDisplayed();
		
	}
	
	public String verifyH1(){
		return heading1.getText();
	}
	
	public String verifyH2(){
		return heading2.getText();
	}
	
	public String verifyH3(){
		return loginBoxMsg.getText();
	}
	
	public DashBoardPage validLogin() {
		typeUname("kiran@gmail.com");
		typePassword("123456");
		loginButton.click();
		return new DashBoardPage(driver);
	}
	//_____________________________________________________________________________________________
	public String getEmailError() {
		return email_error.getText();
	}

	public void typeUname(String username) {
		uname.sendKeys(username);
	}

	public void typePassword(String password) {
		pass.sendKeys(password);
	}
	public void inValidLogin(String username, String password) {
		typeUname(username);
		typePassword(password);
		loginButton.click();
	}
	
	public void registerPageLink(){
		register.click();
	}
	
	
}
