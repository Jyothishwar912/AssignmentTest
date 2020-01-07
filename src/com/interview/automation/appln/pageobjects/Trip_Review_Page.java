package com.interview.automation.appln.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Trip_Review_Page {

	

	static Actions  act;
	@FindBy(xpath="//span[@id='bubble_rating']")
	public static WebElement ele ;
	public static void overall_rating() {
		
		act.moveToElement(ele, 150, 25).click().build().perform();

	}
	
	@FindBy(xpath="//input[@name='ReviewTitle']")
	public static WebElement review_title  ;
	
	public static void title_review() {
		
		review_title.click();
		review_title.sendKeys("Title example");
	}
	
	
	
	@FindBy(xpath="//textarea[@name='ReviewText']")
	public static WebElement review_text  ;
	
	public static void text_review() {
		
		review_text.click();
		review_text.sendKeys("Text example for running this test case is given here ");
	}
	
	@FindBy(xpath="//span[@id='qid12_bubbles']")
	public static WebElement ele_hotel_service ;
	public static void rating_hotel_service() {
		
		act.moveToElement(ele, 150, 25).click().build().perform();

	}
	
	@FindBy(xpath="//span[@id='qid11_bubbles']")
	public static WebElement ele_hotel_clenliness ;
	public static void rating_hotel_clenliness() {
		
		act.moveToElement(ele, 150, 25).click().build().perform();

	}
	
	@FindBy(xpath="//span[@id='qid190_bubbles']")
	public static WebElement ele_rating_value ;
public static void rating_hotel_value() {
		
		act.moveToElement(ele, 150, 25).click().build().perform();

	}
	
	@FindBy(xpath="//input[@type='checkbox']")
	public static WebElement checkbox ;
	public static void check_box() {
		checkbox.click();

	}
}
