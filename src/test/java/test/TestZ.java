package test;
import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseZ;
import pom_classes.Pom1;
import pom_classes.Pom2;
import pom_classes.Pom3;
import utility.UtilityZ;


public class TestZ extends BaseZ{
	//declare all useful members as global
		
		Pom1 login1;
		Pom2 login2;
		Pom3 home;
		
	@BeforeClass
	public void openBrowser() throws Throwable {
		initilizeBrowser();
	    
	    //all objects of POM class
	    login1=new Pom1(driver);
	     login2=new Pom2(driver);
	     home=new Pom3(driver);
	}
	@BeforeMethod
	public void loginToApp() throws Throwable {
		//enter un
		 
		 login1.enterUN(UtilityZ.getTD(0, 0));//DPG458
		 System.out.println((UtilityZ.getTD(0, 0)));
		 
		 //enter pwd
		
		login1.enterPWD(UtilityZ.getTD(0, 1));
		//clck on login btn
		login1.clickLOGINBTN();
		
		//enter pin
		
		login2.enterPIN(UtilityZ.getTD(0, 2));
		//click on continue btn
		login2.clickcntBtn();
	}
	@Test
	public void verifyuserID() throws Throwable {
		Reporter.log("running verify user id",true);
		String actID = home.verifyuserID();
		 String expID=UtilityZ.getTD(0, 0);
		Assert.assertEquals(expID,actID,"both are different tc is failed");
	}
	@AfterMethod
	public void logoutApp() {
		Reporter.log("logout from the application",true);
	}
	@AfterClass
	public void closeBrowser() {
		Reporter.log("close the app",true);
	}
		
}
