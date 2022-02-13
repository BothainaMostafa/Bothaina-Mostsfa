package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignUpPage extends PageBase
{

	public SignUpPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy (name = "firstname")
	WebElement firstNameTxtField;
	
	@FindBy (name = "lastname")
	WebElement lastNameTxtField;
	
	@FindBy (name = "reg_email__")
	WebElement emailTxtField;
	
	@FindBy (name = "reg_email_confirmation__")
	WebElement emailConfirmTxtField;
	
	@FindBy (name = "reg_passwd__")
	WebElement passwordTxtField;
	
	@FindBy (name = "birthday_day")
	WebElement dayField;
	
	@FindBy (name = "birthday_month")
	WebElement monthField;
	
	@FindBy (name = "birthday_year")
	WebElement yearField;
	
	@FindBy (xpath = "//span[@class='_5k_2 _5dba'][1]")
	WebElement female;
	
	@FindBy (xpath = "//span[@class='_5k_2 _5dba'][2]")
	WebElement male;
	
	@FindBy (xpath = "//span[@class='_5k_2 _5dba'][3]")
	WebElement custom;
	
	@FindBy (name = "websubmit")
	WebElement submitBtn;
	
	public void registerNewUser (String firstName, String lastName, String email, String password, String day, String month, String year, String gender)
	{
		wait.until(ExpectedConditions.elementToBeClickable(firstNameTxtField));
		firstNameTxtField.sendKeys(firstName);
		
		wait.until(ExpectedConditions.elementToBeClickable(lastNameTxtField));
		lastNameTxtField.sendKeys(lastName);
		
		wait.until(ExpectedConditions.elementToBeClickable(emailTxtField));
		emailTxtField.sendKeys(email);
		
		wait.until(ExpectedConditions.elementToBeClickable(emailConfirmTxtField));
		emailConfirmTxtField.sendKeys(email);
		
		wait.until(ExpectedConditions.elementToBeClickable(passwordTxtField));
		passwordTxtField.sendKeys(password);

		wait.until(ExpectedConditions.elementToBeClickable(dayField));
		dayField.sendKeys(day);
		
		wait.until(ExpectedConditions.elementToBeClickable(monthField));
		monthField.sendKeys(month);
		
		wait.until(ExpectedConditions.elementToBeClickable(yearField));
		yearField.sendKeys(year);
		
		if (gender == "female")
		{
			female.click();
		}
		else if (gender == "male")
		{
			male.click();
		}
		else
		{
			custom.click();
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
		submitBtn.click();

	}
}
