package tests;

import pages.LoginPage;
import pages.SignUpPage;
import testData.ExcelReader;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class RegistrationTestSuite extends TestBase
{
	LoginPage loginPageObj;
	SignUpPage signUpPageObj;

	@Test
	public void registerNewUser() throws Exception 
	{
		loginPageObj = new LoginPage(driver);
		signUpPageObj = new SignUpPage(driver);
		loginPageObj.clickCreateAccount();

		ExcelReader.setExcelFile(System.getProperty("user.dir")+"//TestData.xlsx", "Registeration Data");
		signUpPageObj.registerNewUser(ExcelReader.getCellData(0, 1), ExcelReader.getCellData(1, 1), ExcelReader.getCellData(2, 1), ExcelReader.getCellData(3, 1), ExcelReader.getCellData(4, 1), ExcelReader.getCellData(5, 1), ExcelReader.getCellData(6, 1), ExcelReader.getCellData(7, 1));
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
