package com.interview.automation.appln.scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.interview.automation.appln.pageobjects.AmazonPage;
import com.interview.automation.appln.pageobjects.Flipkartpage;
import com.interview.automation.base.BaseEngine;

public class AmazonPageTest extends BaseEngine {
	
	
	public static int amazonIphoneValue;
	public static int  flipkartIphonePrice;
	@Test
	public void assignment_amazonTest() throws InterruptedException {
		
		String amazon_url = getPrConf().getPropertyValue("amazon_url");
		getDriver().get(amazon_url);
		PageFactory.initElements(getDriver(), AmazonPage.class);
		AmazonPage.enter_Text_Into_SearchBox("iphone XR 64 gb yellow");
		AmazonPage.click_On_Search_Bttn();
		AmazonPage.click_On_Selected_Iphone();
		Set<String> windows = getDriver().getWindowHandles();
		List list = new ArrayList(windows);
	getDriver().switchTo().window((String) list.get(1));
	System.out.println("Amazon iPhone price:"+AmazonPage.get_Selected_Iphone_Price());
    
		
		}
	
	@Test
	public void flipkart_Test() throws InterruptedException {
		
		String flipkart_url = getPrConf().getPropertyValue("flipkart");
		getDriver().get(flipkart_url);
		PageFactory.initElements(getDriver(), Flipkartpage.class);
		Flipkartpage.enter_Text_Into_SearchBox("iphone XR 64 gb yellow");
		Thread.sleep(3000);
		Flipkartpage.close_loginBttn_flipkart();
		Flipkartpage.click_On_Search_Bttn();
		Flipkartpage.click_On_Selected_Iphone();
        Set<String> windows = getDriver().getWindowHandles();
		List list = new ArrayList(windows);
	   getDriver().switchTo().window((String) list.get(2));
	   System.out.println("Flipkart iPhone price:"+ Flipkartpage.get_Selected_Iphone_Price());
	   
		
	}
	@Test
	public void priceComparision_BothWebsites() {
		
		if(amazonIphoneValue<flipkartIphonePrice)
		{
			System.out.println("IPHONE PRICE IS GREATER ON FLIPKART SITE COMPARE WITH AMAZON SITE");
		}
		else
		{
			System.out.println("IPHONE PRICE IS LESS ON AMAZON SITE COMPARE WITH FLIPKART SITE");
		}

	}
	
		
		
		

	}


