package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase
{
	public static WebDriver driver;

	public void startFirefoxDriver ()
	{	 
		//open firefox instance
		String	firefoxPath = System.getProperty("user.dir") + "\\resources\\geckodriver.exe"; 
		System.setProperty("webdriver.gecko.driver", firefoxPath); 
		driver = new FirefoxDriver(); 
	}

	public void startChromeDriver ()
	{
		//open chrome instance
		String chromePath = System.getProperty("user.dir")+"\\resources\\chromedriver2.exe";
		System.setProperty("webdriver.chrome.driver", chromePath); 
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options); 
		driver.manage().window().maximize();
	}

	public void startInternetExplorerDriver ()
	{	 
		//open internet explorer instance
		String internetExplorerPath = System.getProperty("user.dir")+"\\resources\\IEDriverServer.exe";
		System.setProperty("webdriver.ie.driver", internetExplorerPath);
		driver = new InternetExplorerDriver();
	}

	public void quitDriver ()
	{
		driver.close();
	}
}