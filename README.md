# Test Cases for SignUp and Login Scenario 

- Excel File upoloaded for test cases documentation : LumaWebsiteTestCases(Sudhanshu).xlsx

This document outlines the test case scenarios for the SignUp and Login functionality of the application. The scenarios are implemented using Selenium WebDriver, TestNG, and the Page Object Model design pattern.  

## Getting Started  

### Cloning the Git Repository  

To clone the Git repository and set up the project on your local machine, follow these steps:  

1. **Install Git**: If you haven't installed Git yet, download and install it from [git-scm.com](https://git-scm.com/).  

2. **Clone the Repository**:  
   - Open your terminal (Command Prompt, PowerShell, or any terminal emulator).  
   - Navigate to the directory where you want to clone the repository.  
   - Run the following command (replace `repository-url` with the actual URL of the Git repository):  

> Repository url : "https://github.com/SudhanshuProgrammer/LumaTest.git"

 ```bash  
 git clone repository-url 
```  

3. **Navigate into the Project Directory**:  

  ```bash  
  cd project-directory-name  
   ```

### Setting Up the Project in Your IDE
# Importing a Project in Your IDE  

## Open Your IDE  
Open your preferred Integrated Development Environment (IDE) such as IntelliJ IDEA, Eclipse, or Visual Studio Code.  

## Import the Project  

### For IntelliJ IDEA:  
1. Choose "Open" from the welcome screen.  
2. Select the cloned repository folder and click "OK".  

### For Eclipse:  
1. Go to `File -> Import... -> Existing Maven Projects`.  
2. Browse to the cloned folder and select it.  

### For Visual Studio Code:  
1. Open the cloned folder directly using `File -> Open Folder...`.  

## Install Dependencies  
If the project is using Maven, open the terminal in your IDE and run:  

```
mvn clean install  
```
This command will download all required dependencies as specified in the pom.xml file.

#### Run Your Test Cases:

- For TestNG:

> Right-click on the test class or method you want to run and select "Run".
You can also use the terminal to run the tests:


You can also use the terminal to run the tests:
```
mvn test
```

#### Configuration
Ensure you have the necessary browser drivers (like ChromeDriver or GeckoDriver) in your system PATH, or configure the path in your code.
Update any configuration files (such as `config.properties`) if required for your environment.

---
## Test Case: TC001 - Create Account  - SignUp  

### Description  
This test case verifies the user registration process by creating a new account.  

### Preconditions  
- The application should be accessible.  
- No prior accounts should exist with the same email.  

### Steps  
1. **Navigate to Home Page:**  
   - Create an instance of `HomePage`.  
   - Click on the "Create an Account" link.  

2. **Enter User Details:**  
   - Create an instance of `CreateAccountPage`.  
   - Generate random strings for `First Name` and `Last Name`.  
   - Generate a random email using the format `randomstring@gmail.com`.  
   - Generate a random alphanumeric password.  
   - Set first name, last name, email, password, and confirm password.  

3. **Complete Account Creation:**  
   - Use the `Actions` class to simulate keyboard actions (TAB and ENTER).  
   - Wait for account creation to process.  

4. **Validate Account Creation:**  
   - Retrieve the confirmation message.  
   - Assert the message contains "Welcome".  

5. **Logout:**  
   - Create an instance of `MyAccountPage`.  
   - Verify if My Account page exists.  
   - Click on the account dropdown arrow and select Logout.  

### Expected Result  
- The account should be created successfully.  
- The confirmation message should reflect successful registration.  

---  

## Test Case: TC002 - Login  

### Description  
This test case verifies that a user can successfully log in to the created account.  

### Preconditions  
- The user has successfully created an account (TC001 has passed).  

### Steps  
1. **Navigate to Home Page:**  
   - Create an instance of `HomePage`.  
   - Click on the "Sign In" link.  

2. **Enter Login Credentials:**  
   - Create an instance of `LoginPage`.  
   - Enter the email and password used during account creation.  
   - Use the `Actions` class to simulate keyboard actions (TAB and ENTER).  

3. **Validate Login:**  
   - Wait for the login processing to complete.  
   - Capture a screenshot after logging in to validate success.  

### Expected Result  
- The login should be successful, allowing access to the user’s account.  

---  

## Notes  
- Each test case includes logging for better traceability during execution.  
- Screenshots are captured on important actions for verification purposes.  
- Exception handling is provided to ensure that the test fails gracefully if any step encounters an issue.  

---  

## Conclusion  
These test cases establish a basic flow for user account handling in the application, ensuring both signup and login functionalities work as expected.
