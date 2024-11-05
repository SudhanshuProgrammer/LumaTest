package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[text()='My Account']")
	WebElement msgHeading;

	@FindBy(xpath = "//div[@class='panel header']//button[@type='button']") 
	WebElement lnkarrow;

	@FindBy(xpath = "//div[@aria-hidden='false']//a[normalize-space()='Sign Out']") 
	WebElement lnkLogout;

	// Action method

	public boolean isMyAccountPageExists() {

		try {
			return (msgHeading.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	}

	public void clickArrow() {
		lnkarrow.click();
	}

	public void clickLogout() {
		lnkLogout.click();
	}

}
