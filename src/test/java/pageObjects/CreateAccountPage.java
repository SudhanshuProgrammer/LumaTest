package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends BasePage {

	public CreateAccountPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//input[@id='firstname']")
	WebElement txtfirstName;

	@FindBy(xpath = "//input[@id='lastname']")
	WebElement txtlastName;

	@FindBy(xpath = "//input[@id='email_address']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id='password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@id='password-confirmation']")
	WebElement txtConfirmPassword;

	@FindBy(xpath = "//button[@title='Create an Account']//span[contains(text(),'Create an Account')]")
	WebElement btnCreateAccount;

	@FindBy(xpath = "//div[@class='panel header']//span[@class='logged-in']")
	WebElement msgConfirmation;

	// Actions Methods
	public void setFirstName(String fname) {
		txtfirstName.sendKeys(fname);
	}

	public void setLastName(String lname) {
		txtlastName.sendKeys(lname);
	}

	public void setEmail(String eid) {
		txtEmail.sendKeys(eid);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void setConfirmPassword(String pwd) {
		txtConfirmPassword.sendKeys(pwd);
	}

	public void CreateAnAccount() {
		btnCreateAccount.click();
	}

	public String getConfirmationMessage() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

}
