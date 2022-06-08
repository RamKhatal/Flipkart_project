package pom_classes;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClasses.UtilClass;

public class HomePage extends UtilClass {
	WebDriver driver;
	@FindBy(xpath=("//input[@name='q']"))
	private WebElement sarchtext;

	@FindBy(xpath="//button[@type='submit']")
	private WebElement sarchbtn;

	@FindBy(xpath="//div[@class='YUhWwv']")
	private WebElement cartbtn;

	@FindBy(xpath="//div[text()='My Account']")
	private WebElement ProfileName;
	@FindBy(xpath="//a[@class='_1fQZEK']")
	private WebElement ProductList;



	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void enterSarchText(String search)
	{
		sarchtext.sendKeys(search);
	}
	public void ClickOnSarchBtn()
	{
		sarchbtn.click();
	}
	public void cliCkOnCartBtn()
	{
		cartbtn.click();
	}
	public boolean ProfileNameisVisible()
	{
		try {
			WebElement element = ExplicitWait(driver, ProfileName);
			return true;

		} catch (Exception e) {
			return false;
		}
	}
	public boolean ProductListisVisible()
	{
		try {
			WebElement element  = ExplicitWait(driver, ProductList);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void clearSarchFeild(String SarchData)
	{
		for(int i=0;i<SarchData.length();i++)
			sarchtext.sendKeys(Keys.BACK_SPACE);
	}
	public void ClickFristProduct()
	{
		ProductList.click();
		List<String> address = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(address.get(1));
	}
}



