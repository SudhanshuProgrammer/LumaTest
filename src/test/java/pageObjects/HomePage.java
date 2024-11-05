package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	// Find Locators
	@FindBy(xpath = "//div[@class='panel header']//a[normalize-space()='Create an Account']")
	WebElement lnkCreateAccount;

	@FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
	WebElement lnkLogin;


	// Action methods

	public void CreateAccount() {
		lnkCreateAccount.click();
	}

	public void LoginAccount() {
		lnkLogin.click();
	}

	

}
