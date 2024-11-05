package testCases;  

import org.openqa.selenium.Keys;  
import org.openqa.selenium.interactions.Actions;  
import org.testng.Assert;  
import org.testng.annotations.Test;  

import pageObjects.CreateAccountPage; // Importing the page object for account creation  
import pageObjects.HomePage; // Importing the home page object  
import pageObjects.LoginPage; // Importing the login page object  
import pageObjects.MyAccountPage; // Importing the my account page object  
import testBase.BaseClass; // Importing the base class for common functionality  

public class TestCase_SingUp_And_Login extends BaseClass {  
    
    // Declaring instance variables for email and password  
    public String emailid;  
    public String pwd;  

    @Test(priority=1) // Defining the test method with priority 1 to signify it runs first  
    public void accountCreation() throws InterruptedException {  
        
        logger.info("********************* TC001 SignUp Test cases Started ******************");  
        logger.info("This is a debug log message");  

        try {  
            // Creating HomePage object to access methods related to Home page  
            HomePage hp = new HomePage(driver);  
            hp.CreateAccount(); // Clicking on the "Create an Account" link  
            logger.info("Clicked on Create an Account");  
        
            // Creating CreateAccountPage object to access the account creation fields  
            
            CreateAccountPage accountpage = new CreateAccountPage(driver);  
            logger.info("Providing Customer Details.");  

            // Generating random customer details for account creation  
            String firstname = randomeString().toLowerCase(); // A method that generates random strings  
            accountpage.setFirstName(firstname); // Setting first name  
            String lastname = randomeString().toLowerCase();  
            accountpage.setLastName(lastname); // Setting last name  
            
            // Creating a random email id  
            emailid = randomeString().toLowerCase() + "@gmail.com";  
            accountpage.setEmail(emailid); // Setting email  
            pwd = randomeAlphaNumeric(); // Generating a random password  
            accountpage.setPassword(pwd); // Setting password  
            accountpage.setConfirmPassword(pwd); // Confirming password  
            
            // Using Actions class to perform keyboard actions, simulating pressing the TAB and ENTER keys  
            Actions actions = new Actions(driver);  
            actions.sendKeys(Keys.TAB).perform(); // Press TAB  
            Thread.sleep(1000); // Wait for a second  
            actions.sendKeys(Keys.ENTER).perform(); // Press ENTER  
            Thread.sleep(2000); // Wait for a moment to allow processing of the action  

            logger.info("Validating the expected Message");  
            String confmsg = accountpage.getConfirmationMessage(); // Getting confirmation message after account creation  
            
            // Validating if the account was created successfully based on the confirmation message  
            if (confmsg.contains("Welcome")) {   
                captureScreen(); // Screenshots for pass status (assuming it’s a utility method)  
                logger.info("User is Created Successfully");  
                Assert.assertTrue(true); // Asserting that the test was successful  
            } else {  
                logger.error("Test Case Failed Due to Confirm Message Mismatch......");  
                logger.debug("Debug Logs......");  
                Assert.assertTrue(false); // Failing the test if the message does not match  
                captureScreen(); // Taking a screenshot to analyze failure  
            }  
            System.out.println(confmsg); // Optionally printing the confirmation message for debugging  
        } catch (Exception e) {  
            e.getMessage(); // Print exception message, but not handled here  
        }  

        // Logging out after account creation  
        MyAccountPage map = new MyAccountPage(driver); // Creating a MyAccountPage object  
        map.isMyAccountPageExists(); // Verifying if the My Account page exists  
        Thread.sleep(1000); // Waiting  
        map.clickArrow(); // Click on the account dropdown arrow  
        Thread.sleep(1000); // Waiting  
        map.clickLogout(); // Logging out from the account  
        logger.info("Logout is Clicked and Successfully LoggedOut");  
        Thread.sleep(2000);  

        logger.info("********************* TC001 SignUp Test cases Finished ******************");  
    }  

    @Test(priority=2,dependsOnMethods = "accountCreation") // Test method for the login functionality  
    public void accountLogin() throws InterruptedException {  
        
        logger.info("******** TC002 Login Test case Started ***********");  

        try {  
            // Now, testing the login functionality  
            HomePage hp = new HomePage(driver); // Creating HomePage object  
            hp.LoginAccount(); // Clicking on the "Sign In" Link  
            logger.info("SignIn Link is Clicked");  

            LoginPage lp = new LoginPage(driver); // Creating LoginPage object to access login fields  
            lp.setEmail(emailid); // Providing the email id generated during signup  
            logger.info("Email Id is Provided");  
            lp.setPassword(pwd); // Providing the password generated during signup  
            logger.info("Password is Provided");  

            // Using Actions class for keyboard actions to submit the login form  
            Actions actions = new Actions(driver);  
            actions.sendKeys(Keys.TAB).perform(); // Press TAB  
            Thread.sleep(1000); // Wait for input submission  
            actions.sendKeys(Keys.ENTER).perform(); // Press ENTER to login  
            Thread.sleep(2000); // Wait for login processing  
            captureScreen(); // Taking screenshot after login  
            logger.info("Login is Successful");  
        } catch (Exception e) {  
            Assert.fail(); // Fail the test if there is an exception  
        }  

        logger.info("************* TC002 Login Test case Finished ***************");  
    }  
}