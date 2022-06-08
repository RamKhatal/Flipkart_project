package pom_classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClasses.UtilClass;

public class CartPage extends UtilClass {
	WebDriver driver;
	@FindBy(xpath="//span[text()='Login']")
	private WebElement loginbtn1;

	public CartPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	public void CheckLoginButtonAvailable() throws InterruptedException
	{

		try {
			loginbtn1.isDisplayed();
			System.out.println("login button is present ");

		} catch (Exception e) {

			System.out.println("Login button is not present");
		}
	}

}
