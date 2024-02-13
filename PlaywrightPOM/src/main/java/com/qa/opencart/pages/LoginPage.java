package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

	
	private Page page;
	
	private String emailId = "//input[@id='input-email']";
	private String password = "//input[@id='input-password']";
	private String loginBtn = "//input[@value='Login']";
	
	private String forgetPwdLink = "//div[@class='form-group']//a[normalize-space()='Forgotten Password']";
	
	private String logoutLink = "//a[@class='list-group-item'][normalize-space()='Logout']";
	
//	page constructor
	 
	    public LoginPage(Page page) {
	    	this.page = page;
	    }
	    
	    
//	 page actions 
	    
	    public String getLoginPageTitle() {
	    	return page.title();
	    }
	    
	    
	    public boolean isForgetPwdLinkExist() {
	    	return page.isVisible(forgetPwdLink);
	    }
	    
	    public boolean doLogin(String appUserName , String appPassword) {
	    	
	    	System.out.println("App creds" + appUserName + ":" + appPassword);
	    	page.fill(emailId, appUserName);
	    	page.fill(password, appPassword);
	    	page.click(loginBtn);
	    	
	    	if(page.isVisible(logoutLink)) {
	    		System.out.println("user is logged in");
	    		return true;
	    	}
	    	
	    	return false;
	    	
	    }
	    
	    
	    
	    
	
}
