package com.interview.automation.appln.scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.interview.automation.appln.pageobjects.Trip_Home;
import com.interview.automation.appln.pageobjects.Trip_Review_Page;
import com.interview.automation.base.BaseEngine;

public class TripadvisorTest extends BaseEngine {
	
	@Test
	public void trip_Advisor_Rating() {
		getDriver().get(getPrConf().getPropertyValue("url"));
		PageFactory.initElements(getDriver(), Trip_Home.class);
    	Trip_Home.sbox();
	    Trip_Home.hsbox("club mahindra");
	    Trip_Home.searchButton();
	    Trip_Home.FLink();
	    Trip_Home.review();
	 Set<String> windows =getDriver().getWindowHandles();
	 List winli = new ArrayList(windows);
		getDriver().switchTo().window((String) winli.get(1));
		PageFactory.initElements(getDriver(), Trip_Review_Page.class);
		Trip_Review_Page.overall_rating();
		Trip_Review_Page.title_review();
		Trip_Review_Page.text_review();
		Trip_Review_Page.rating_hotel_service();
		Trip_Review_Page.rating_hotel_clenliness();
		Trip_Review_Page.rating_hotel_value();
		Trip_Review_Page.check_box();
	

	}


}
