package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    static String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test

    public void userShouldNavigateToLoginPageSuccessfully() {

        // Find login link and click on login link
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        // This is from requirement
        String expectedMessage = "Welcome, Please Sign In!";

        // Find the welcome text element and get the text
        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        String actualMessage = actualMessageElement.getText();
        System.out.println(actualMessage);

        // Validate actual and expected message
        Assert.assertEquals("Not navigate to login page", expectedMessage, actualMessage);

    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Find and Click on 'Login' link
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        // Find the username text field and enter valid username
        WebElement usernameField = driver.findElement(By.id("Email"));
        usernameField.sendKeys("stellabrown@gmail.com");
        // Find the password field and enter valid password
        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("password123");
        // Find and Click on Login button
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        loginButton.click();
        //Verify the 'Log out' text is display
        // This is from requirement
        String expectedDisplay = "Log out";
        // Find the Log out element and get the text
        WebElement logoutLinkElement = driver.findElement(By.xpath("//a[contains(text(),'Log out')]"));
        String actualDisplay = logoutLinkElement.getText();
        System.out.println(actualDisplay);
        // Validate actual and expected display text
        Assert.assertEquals("'Log out' Text is not Displayed", expectedDisplay, actualDisplay);
    }

    @Test
    public void verifyTheErrorMessage() {
        // Find and Click on 'Login' link
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        // Find the username text field and enter invalid username
        WebElement usernameField = driver.findElement(By.id("Email"));
        usernameField.sendKeys("abc@gmail.com");
        // Find the password field and enter invalid password
        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("Abcd1234");
        // Find and Click on Login button
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        loginButton.click();
        //Verify the error message ‘Login was unsuccessful. Please correct the errors and try again. No customer account found’
        // This is from requirements
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        // Find the error message and get the text
        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
        String actualErrorMessage = errorMessage.getText();
        System.out.println(actualErrorMessage);
        // Validate expected and actual error message
        Assert.assertEquals("Error message can't be found", expectedErrorMessage, actualErrorMessage);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}




