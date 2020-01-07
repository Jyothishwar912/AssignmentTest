package com.interview.automation.appln.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Flipkartpage {
	
	
	@FindBy(name="q")
	private static WebElement flipkart_searchBox;
	
	@FindBy(xpath="//button[@class='vh79eN']")
	private static WebElement flipkart_clickSearchBttn;
	
	@FindBy(xpath="//div[@class='_2ISNhP _3AOFWO']/div/button")
	private static WebElement close_loginBttn;
	
	@FindBy(xpath="//*[text()='Apple iPhone XR (Yellow, 64 GB)']")
	private static WebElement flipkart_iPhoneXR_64;
	
	@FindBy(xpath="//div[@class='_2i1QSc']/div/div")
	private static WebElement flipkart_iPhone_Price;

	public static  void enter_Text_Into_SearchBox(String search) {
		flipkart_searchBox.clear();
		flipkart_searchBox.sendKeys(search);

	}
	
	public static void click_On_Search_Bttn() {
		
		flipkart_clickSearchBttn.click();

	}
public static void close_loginBttn_flipkart() {
		
	close_loginBttn.click();

	}
	
	
	public static   void click_On_Selected_Iphone() {
		flipkart_iPhoneXR_64.click();
	}
	
	public static int get_Selected_Iphone_Price() {	
		String text=flipkart_iPhone_Price.getText();
		String mobile_Price=text.substring(1).replace(",", "");
		float floatValue = Float.parseFloat(mobile_Price);
		int flipkartPrice =(int) floatValue;
		return flipkartPrice;

	}

}
