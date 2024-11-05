package pageObjects;  

import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.support.PageFactory;  

/* BasePage serves as a base class for all page object classes.  
   It encapsulates common functionalities for handling WebDriver and element initialization.  */

public class BasePage {  
    
    WebDriver driver;    // WebDriver instance to control the browser  

    // Constructor for BasePage.Initializes the WebDriver and sets up the PageFactory elements. 
  
    BasePage(WebDriver driver) {  
        this.driver = driver;      // Assign the provided WebDriver to the class member  
        PageFactory.initElements(driver, this);     // Initialize the elements of the page using the WebDriver  
    }  

}