package pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends PageBase
{
	public MainPage (WebDriver driver)
	{
		super (driver);
	}
	
	@FindBy (xpath = "//span[@class='d2edcug0 hpfvmrgz qv66sw1b c1et5uql lr9zc1uh a8c37x1j fe6kdd0r mau55g9w c8b282yb keod5gw0 nxhoafnm aigsh9s9 qg6bub1s iv3no6db o0t2es00 f530mmz5 hnhda86s oo9gr5id']")
	WebElement welcome;
	
	public void assertWelcome ()
	{
		wait.until(ExpectedConditions.visibilityOf(welcome));
		assertTrue(welcome.getText().contains("Welcome to Facebook"));

	}
}
