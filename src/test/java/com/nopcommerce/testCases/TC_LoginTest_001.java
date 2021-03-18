package com.nopcommerce.testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjets.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
	
  
    @Test
    public void loginTest() throws InterruptedException, IOException
    {
    	driver.get(baseURL);
    	
    	logger.info("URL is opened....");
    	
    	LoginPage lp=new LoginPage(driver);
    	
    	lp.setUserName(username);
    	logger.info("user provided");
    	
    	lp.setPassword(password);
    	logger.info("pass word provided");
    	
    	  lp.clickLogin();
    	  logger.info("login in  clicked");
    	  Thread.sleep(5000);
    	  
    	  
    	  if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
    	  {
    		  Assert.assertTrue(true);
    		 lp.clickLogout(); 
    		 logger.info("login is passed"); 
    	  }
    	  else
    	  {
    		  captureScreen(driver,"loginTest");
    		  Assert.assertTrue(false);
    	//	 lp.clickLogout(); 
    		 logger.info("login is failed"); 
    		  
    	  }
    		  
    }


     }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

