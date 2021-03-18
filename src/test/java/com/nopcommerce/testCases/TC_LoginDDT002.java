package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjets.LoginPage;
import com.nopcommerce.utilities.XLUtils;

public class TC_LoginDDT002 extends BaseClass
{
    @Test(dataProvider="LoginData")  
	public void loginTest(String user,String pwd) throws  InterruptedException
	{
	driver.get(baseURL);
	
	driver.manage().window().maximize();
    	
    	logger.info("URL is opened....");
    	
    
    	
    	LoginPage lp=new LoginPage(driver);
    	
    	lp.setUserName(user);
    	logger.info("user provided");
    	
    	lp.setPassword(pwd);
    	logger.info("password provided");
    	
    	  lp.clickLogin();
    	  logger.info("login in  clicked");
    	  Thread.sleep(2000);
    	  
    	  
    	  if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
    	  {
    		  Assert.assertTrue(true);
    		 lp.clickLogout(); 
    		 logger.info("login is passed"); 
    	  }
    	  else
    	  {
    		//  captureScreen(driver,"loginTest");
    		  Assert.assertTrue(false);
    	//	 lp.clickLogout(); 
    		 logger.info("Login is Failed");
    	  }
	}

    @DataProvider(name="LoginData")
    public String[][] getData() throws IOException
    {
    	String path=System.getProperty("user.dir")+"/src/test//java/com/nopcommerce/testData/LoginData.xlsx";
    	
    	int rownum=XLUtils.getRowCount(path,"Sheet1");
    	int colcount=XLUtils.getCellCount(path,"Sheet1",1);
    	
    	String logindata[][]=new String[rownum][colcount];
		//return null;
    	
    	for(int i=1;i<=rownum;i++)
    	{
    		for(int j=0;j<colcount;j++)
    		{
    			logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1",i,j);
    		}
    	}
    	
    	return logindata;
    }
}
