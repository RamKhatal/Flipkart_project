package TestClasses;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BaseClasses.BaseClass1;
import UtilityClasses.UtilClass;
import pom_classes.HomePage;
import pom_classes.LoginPage;
import pom_classes.PoductDetilsPage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class VerifyUserCanByProduct extends UtilClass {
	WebDriver driver;
	LoginPage lp;
	HomePage hp;
	PoductDetilsPage pd;
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports report;
	ExtentTest test;
	
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String k) 
	{
		driver = BaseClass1.getDriver(k);
	}
	@BeforeMethod
	public void beforeMethod() 
	{


		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		pd = new PoductDetilsPage(driver);
	}
	@Test(priority=1)
	public void  VerifyUserCanLogin() 
	{

		lp.Putemail();
		lp.PutPassword();
		lp.ClickLoginBtn();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(hp.ProfileNameisVisible());
		soft.assertAll();
	}
	@Test(priority=2)
	public void VerifyUserCanSerchProduct() throws EncryptedDocumentException, IOException
	{
		String data =hp.getDataFromExcelSheet("Sheet1",0,0);
		hp.enterSarchText(data);
		hp.ClickOnSarchBtn();
		Assert.assertTrue(hp.ProductListisVisible());

	}
	@Test(priority=3)
	public void VerifyUserCanMoveToTheProductDetailsPage()
	{
		hp.ClickFristProduct();
		Assert.assertTrue(pd.isOrderNowButtonApperar());
	}


	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
		if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "Test is passed " + result.getName());
		}
		else
		{
			String path = hp.getScreenShot(driver, result.getName());
			test.log(Status.FAIL, "Test is failed " + result.getName(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			
			
		}
	}
	
	@AfterClass
	public void afterClass()
	{
		report.flush();
	}
	
	
}
