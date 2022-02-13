package tests;

import testData.ExcelReader;
import pages.LoginPage;
import pages.MainPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class LoginTestSuite extends TestBase
{
	LoginPage loginPageObj;
	MainPage mainPageObj;
	
	@Test
	public void TC1_validLogin() throws Exception 
	{
		loginPageObj = new LoginPage(driver);
		mainPageObj = new MainPage(driver);
		ExcelReader.setExcelFile(System.getProperty("user.dir")+"//TestData.xlsx", "Login Data");
		loginPageObj.login (ExcelReader.getCellData(0, 1), ExcelReader.getCellData(1, 1));
		mainPageObj.assertWelcome();
	}
	
	@Test
	public void TC2_invalidEmail() throws Exception
	{
		loginPageObj = new LoginPage(driver);
		mainPageObj = new MainPage(driver);
		ExcelReader.setExcelFile(System.getProperty("user.dir")+"//TestData.xlsx", "Login Data");
		loginPageObj.login (ExcelReader.getCellData(2, 1), ExcelReader.getCellData(1, 1));
		loginPageObj.assertInvalidEmail();
	}
	
	@Test
	public void TC2_invalidPassword() throws Exception
	{
		loginPageObj = new LoginPage(driver);
		mainPageObj = new MainPage(driver);
		ExcelReader.setExcelFile(System.getProperty("user.dir")+"//TestData.xlsx", "Login Data");
		loginPageObj.login (ExcelReader.getCellData(0, 1), ExcelReader.getCellData(3, 1));
		loginPageObj.assertInvalidPassword();
	}
	
	@BeforeMethod
	public void beforeMethod() 
	{
		startChromeDriver();
		driver.navigate().to("https://www.facebook.com");
	}

	@AfterMethod
	public void afterMethod() 
	{
		
	}

}
