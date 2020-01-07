package com.interview.automation.appln.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Trip_Home {
	
	public static String clickedLink;
	@FindBy(xpath="//div[@class='brand-header-GlobalNavActions__searchWrap--2XBZ1']")
	public static WebElement search_box;
	public static void sbox() {
		search_box.click();
	}

	@FindBy(xpath="//div[@class='what_with_highlight']")
	public static WebElement highlighted_SB;
	public static void hsbox(String SearchTerm) {
		highlighted_SB.click();
		highlighted_SB.sendKeys(SearchTerm);
		
	}

	@FindBy(xpath="//div[@class='inner']")
	public static WebElement search ;
	public static void searchButton() {
		search.click();

	}


	@FindBy(xpath="//div[@class='ui_column is-12 content-column result-card result-card-default' and @data-widget-type='TOP_RESULT']//div[@class='result-title']")
	public static WebElement  First_Link;
	public static String FLink() {
		First_Link.click();
		clickedLink =First_Link.getText();
		return clickedLink;
	}


	@FindBy(xpath="//a[text()=\"Write a review\"]")
	public static WebElement Review  ;
	public static void review() {
		Review.click();

	}



}
