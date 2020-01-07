package com.interview.automation.appln.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonPage {
	
	
	@FindBy(id="twotabsearchtextbox")
	private static WebElement searchBox;
	
	@FindBy(xpath="//div[@class='nav-right']/div[1]/input")
	private static WebElement clickSearchBttn;
	
	@FindBy(linkText="Apple iPhone XR (64GB) - Yellow")
	private static WebElement iPhoneXR_64;
	
	@FindBy(xpath="//span[@id='priceblock_ourprice']")
	private static WebElement iPhone_Price;

	public static  void enter_Text_Into_SearchBox(String search) {
		searchBox.clear();
		searchBox.sendKeys(search);

	}
	
	public static void click_On_Search_Bttn() {
		
		clickSearchBttn.click();

	}
	
	public static   void click_On_Selected_Iphone() {
		iPhoneXR_64.click();
	}
	
	public static int get_Selected_Iphone_Price() {	
		String text=iPhone_Price.getText();
		
		String mobile_Price=text.substring(2).replace(",", "");
		float floatValue = Float.parseFloat(mobile_Price);
		int amazonPrice =(int) floatValue;
		return amazonPrice;

	}
	
	
	

}
