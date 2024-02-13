package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

//every page has his own java class

public class HomePage {

	//1. String Locators - OR
	
	
	private Page page;
	
	private String search = "input[placeholder='Search']";
	private String searchIcon = "div#search button";
	private String searchPageHeader = "div#content h1";
	
     
	private String loginLink = "a:text('Login')";
	private String myAccountLink = "a[title='My Account']";
	
	

//	page constructor
	public HomePage(Page page) {
		this.page = page;
	}
	
	
	//page actions or methods
	
	public String getHomePageTitle() {
		String title = page.title();
		System.out.println("page title" + title);
        return title;
	}
	
	
	public String getHomePageURL() {
		String url =  page.url();
		System.out.println("page url :" + url);
		return url;
	}
	
//	user will do search for product name 
	public String doSearch(String productName) {
		page.fill(search, productName);
		page.waitForTimeout(2000);
		page.click(searchIcon);
//		returning the textContent of this page 
		page.waitForTimeout(1000);
	     String header =  page.textContent(searchPageHeader);
		System.out.println("search header is " + header);
		return header;
	}
	
	
	
//	Now I am landing on a new page 
	public LoginPage navigateToLoginPage() {
		page.click(myAccountLink);
		page.click(loginLink);
		
//		Page Chaining 
		return new LoginPage(page);
	}
	
	
	
	
	
	
	
}
