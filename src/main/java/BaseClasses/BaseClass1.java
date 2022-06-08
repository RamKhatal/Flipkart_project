package BaseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import UtilityClasses.UtilClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass1  extends UtilClass{
	public static WebDriver getDriver(String browser)
	{
		WebDriver driver = null;
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
//			System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\Browser\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}else if (browser.equals("firefox"))
			
		{
			WebDriverManager.chromedriver().setup();
//			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Sagar Suepkar\\Driver\\chromedriver.exe");
			driver = new FirefoxDriver();
		}
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();		
		return driver;
	}

}
