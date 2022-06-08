package pom_classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClasses.UtilClass;

public class LoginPage extends UtilClass {
	WebDriver driver;
	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement email;
	@FindBy(xpath="//input[@type='password']")
	private WebElement passrd;
	@FindBy(xpath="(//button[@type='submit'])[2]")
	private WebElement loginbtn;

	public  LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	public void Putemail()
	{
		email.sendKeys("8796835865");
	}
	public void PutPassword()
	{
		passrd.sendKeys("Ramraj@123");
	}
	public void ClickLoginBtn()
	{
		loginbtn.click();
	}

}
