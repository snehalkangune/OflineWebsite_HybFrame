package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OperatorsPage {
	WebDriver driver = null;

	public OperatorsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;	
	}
	
	@FindBy(xpath = "//table/tbody")
	WebElement tableBody;
	@FindBy(tagName = "tr")
	List<WebElement> rowList;
	@FindBy(xpath="//table/tbody/tr[1]")
	WebElement row1;
	@FindBy(tagName = "th")
	List<WebElement> colomnsList;
	
	public boolean opratorList(){
		System.out.println(rowList.size());
		System.out.println(colomnsList.size());
		for (int i = 2; i <= rowList.size(); i++) {
			for (int j = 1; j <= colomnsList.size(); j++) {
				
				WebElement EachElementwe = driver
						.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/div[2]/table/tbody/tr[" + i + "]/td[" + j + "]"));
				String tableElement = EachElementwe.getText();
				System.out.print("       " + tableElement);

			}
			System.out.println();
		}
		return true;
		}
	}

	

