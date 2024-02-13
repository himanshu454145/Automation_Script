package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;



public class HomePageTest extends BaseTest{
	
	
	
	
	@Test
	public void homePageTitleTest() {
		String actualTitle = homePage.getHomePageTitle();
		Assert.assertEquals(actualTitle,AppConstants.HOME_PAGE_TITLE);
	}
	
	@Test 
	public void homePageURLTest() {
		String actualURL = homePage.getHomePageURL();
		Assert.assertEquals(actualURL,prop.getProperty("url"));
	}
	
	
//	we can provide data's here or we can use excel sheet
	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] {
			{"Mackbook"},
			{"iMac"},
			{"Samsumg"}
		};
	}
	
	
	@Test (dataProvider = "getProductData")
	
	public void searchTest(String productName) {
		String actualSearchHeader = homePage.doSearch(productName);
		Assert.assertEquals(actualSearchHeader, "Search - "+productName);
		
	}
	
	

	

}
