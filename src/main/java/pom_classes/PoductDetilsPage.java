package pom_classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClasses.UtilClass;

public class PoductDetilsPage extends UtilClass {
	WebDriver driver;
	@FindBy(xpath="//button[text()='ORDER IT']")
	private WebElement orderNowButton;

	public PoductDetilsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	public boolean isOrderNowButtonApperar()
	{
		try {
			WebElement element = ExplicitWait(driver,orderNowButton);
			return true;

		} catch (Exception e) 
		{
			return false;
		}
		

	}

}
