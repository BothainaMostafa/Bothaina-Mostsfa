package pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends PageBase
{
	public LoginPage (WebDriver driver)
	{
		super (driver);
	}
	
	@FindBy (id = "email")
	WebElement emailTxtField;
	
	@FindBy (id = "pass")
	WebElement passwordTxtField;
	
	@FindBy (name = "login")
	WebElement loginBtn;
	
	@FindBy (xpath = "//div[@class='_9ay7']")
	WebElement alertMessage;
	
	@FindBy (xpath = "//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")
	WebElement createAccountBtn;
	
	public void login (String email, String password)
	{
		wait.until(ExpectedConditions.elementToBeClickable(emailTxtField));
		emailTxtField.sendKeys(email);
		
		wait.until(ExpectedConditions.elementToBeClickable(passwordTxtField));
		passwordTxtField.sendKeys(password);
		
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		loginBtn.click();

	}
	
	public void assertInvalidEmail ()
	{
		wait.until(ExpectedConditions.visibilityOf(alertMessage));
		assertTrue(alertMessage.getText().contains("The email address you entered isn't connected to an account"));

	}
	
	public void assertInvalidPassword ()
	{
		wait.until(ExpectedConditions.visibilityOf(alertMessage));
		assertTrue(alertMessage.getText().contains("The password that you've entered is incorrect"));

	}
	
	public void clickCreateAccount()
	{
		wait.until(ExpectedConditions.visibilityOf(createAccountBtn));
		createAccountBtn.click();
	}
}
