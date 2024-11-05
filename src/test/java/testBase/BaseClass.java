package testBase;

// Necessary imports  
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils; // For file handling  
import org.apache.commons.lang3.RandomStringUtils; // For generating random strings/numbers  
import org.apache.logging.log4j.LogManager; // For logging  
import org.apache.logging.log4j.Logger; // For logging  
import org.openqa.selenium.OutputType; // For handling screenshots  
import org.openqa.selenium.TakesScreenshot; // For capturing screenshots  
import org.openqa.selenium.WebDriver; // WebDriver interface  
import org.openqa.selenium.chrome.ChromeDriver; // ChromeDriver class for Chrome browser  
import org.testng.annotations.AfterClass; // TestNG annotation for tearDown method  
import org.testng.annotations.BeforeClass; // TestNG annotation for setup method  

public class BaseClass {

	public static WebDriver driver;	// Declare a static WebDriver object to control the browser
	protected static final Logger logger = LogManager.getLogger(BaseClass.class);// Initialize a logger using Log4j

	// This method sets up the test environment
	@BeforeClass
	public void setup() throws IOException {

		driver = new ChromeDriver(); // Initialize the ChromeDriver
		driver.manage().deleteAllCookies(); // Clear all cookies before the test
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Set implicit wait for WebDriver
		driver.manage().window().maximize(); // Maximize the browser window
		driver.get("https://magento.softwaretestingboard.com/"); // Navigate to the specified URL

	}

	// This method cleans up after the test class is done
	@AfterClass
	public void tearDown() {
		driver.quit(); // Close all browser windows and terminate WebDriver
	}

	// This method generates a random string of 6 alphabetic characters
	public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(6);
		return generatedString;
	}

	// This method generates a random numeric string of 10 characters
	public String randomeNumber() {
		String generatedNumber = RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}

	// This method generates a random alphanumeric string
	public String randomeAlphaNumeric() {
		String generatedString = RandomStringUtils.randomAlphabetic(6); // Generate 6 alphabetic characters
		String generatedNumber = RandomStringUtils.randomNumeric(10); // Generate 10 numeric characters

		return (generatedString + "@" + generatedNumber); // Return a concatenated string of the two generated parts
	}

	// This method captures a screenshot and saves it to the specified path
	public String captureScreen() throws IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.mm.dd.HH.mm.ss"); // Create a timestamp for the screenshot name
		Date date = new Date();
		String timeStamp = sdf.format(date);

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver; // Cast the driver to TakesScreenshot to take a screenshot
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE); // Capture the screenshot and get it as a file

		String targetFilePath = System.getProperty("user.dir") + "/screenshots//screenshot-" + timeStamp + ".png"; // Define the target file path using the timestamp
		File targetFile = new File(targetFilePath);
		FileUtils.copyFile(sourceFile, targetFile); // Copy the source file to the target location

		return targetFile.getAbsolutePath(); // Return the absolute path of the saved screenshot
	}
}







