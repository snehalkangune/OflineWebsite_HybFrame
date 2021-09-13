package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {
	WebDriver driver = null;

	public DashBoardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	@FindBy(xpath = "//b[text()='Java By Kiran']")
	WebElement heading1;
	@FindBy(tagName = "h1")
	List<WebElement> heading;
	@FindBy(tagName = "h3")
	List<WebElement> courses;
	@FindBy(xpath = "//li/a/span")
	List<WebElement> sideMenu;
	@FindBy(xpath = "//a[text()='LOGOUT']")
	WebElement logoutButton;
	@FindBy(xpath = "/html/body/div/aside/section/ul/li[3]/a/span")
	WebElement UsersButton;
	@FindBy(xpath = "/html/body/div/aside/section/ul/li[4]/a/span")
	WebElement OperatorsButton;
	@FindBy(xpath = "/html/body/div/aside[1]/section/ul/li[5]/a/span")
	WebElement Useful_LinksButton;

//_______________________________________________________________________________
	
	public String verifyH1(){
		return heading1.getText();
	}
	public boolean getAllCourses() {
		ArrayList<String> actualCourses = new ArrayList<String>();
		for (WebElement course : courses) {
			String text = course.getText();
			actualCourses.add(text);
		}
		ArrayList<String> expectedCourses = new ArrayList<String>();
		expectedCourses.add("Selenium");
		expectedCourses.add("Java / J2EE");
		expectedCourses.add("Python");
		expectedCourses.add("Php");
		
		if(actualCourses.equals(expectedCourses))
			return true;
			return false;
		}
	
	public boolean getAllHeadings() {
		ArrayList<String> actualHeading = new ArrayList<String>();
		for (WebElement Heading : courses) {
			String text = Heading.getText();
			actualHeading.add(text);
		}
		ArrayList<String> expectedHeading = new ArrayList<String>();
		expectedHeading.add("Dashboard");
		expectedHeading.add("Courses Offered");
		
		if(actualHeading.equals(expectedHeading))
			return true;
			return false;
		}
//_______________________________________________________________________________
	public boolean getAllSideMenu() {
		ArrayList<String> actualsidemenu = new ArrayList<String>();
		for (WebElement menu : sideMenu) {
			String text = menu.getText();
			actualsidemenu.add(text);
		}
		ArrayList<String> expectedsidemenu = new ArrayList<String>();
		expectedsidemenu.add("Dashboard");
		expectedsidemenu.add("Users");
		expectedsidemenu.add("Operators");
		expectedsidemenu.add("Useful Links");
		expectedsidemenu.add("Downloads");
		expectedsidemenu.add("Logout");
		
		if(actualsidemenu.equals(expectedsidemenu))
			return true;
			return false;
		}
	
	public LoginPage clickLogoutButton() {		
		logoutButton.click();
		return new LoginPage(driver);
	}
	
	public UserPage clickUserButton() {		
		UsersButton.click();
		return new UserPage(driver);
	}
	
	public OperatorsPage clickOperatorsButton() {		
		OperatorsButton.click();
		return new OperatorsPage(driver);
	}
	
	public Useful_LinksPage clickUseful_LinksButton() {		
		Useful_LinksButton.click();
		return new Useful_LinksPage(driver);
	}
}
