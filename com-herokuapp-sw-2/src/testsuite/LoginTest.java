package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        // Find username field and enter "tomsmith" username
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("tomsmith");
        // Find password field and enter “SuperSecretPassword!” password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword!");
        // Find and Click on 'LOGIN' button
        WebElement loginButton = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        loginButton.click();
        // Verify the text “Secure Area”
        // It is from requirements
        String expectedText = "Secure Area";
        // get text to validate
        WebElement actualTextElement = driver.findElement(By.tagName("h2"));
        String actualText = actualTextElement.getText();
        System.out.println(actualText);
        // verify actual and expected text
        Assert.assertEquals("No navigation to next page with display text 'Secure Area' ",expectedText,actualText);

    }

    @Test
    public void verifyTheUsernameErrorMessage(){
        // find username field and Enter “tomsmith1” username
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("tomsmith1");
        // Find password field and enter “SuperSecretPassword!” password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword!");
        // Find and Click on 'LOGIN' button
        WebElement loginButton = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        loginButton.click();
        // Verify the error message “Your username is invalid!”
        // It is given in requirement
        String expectedText = "Your username is invalid!";
        // get text from actual message
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@id='flash']"));
        String actualText = actualTextElement.getText();
        System.out.println(actualText);
        // Verify expected text and actual text
        Assert.assertEquals("can't read the text 'Your username is invalid!'", expectedText,actualText);

    }

    @Test
    public void verifyThePasswordErrorMessage(){
        // find username field and Enter “tomsmith” username
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("tomsmith");
        // Find password field and enter “SuperSecretPassword” password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword");
        // Find and Click on 'LOGIN' button
        WebElement loginButton = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        loginButton.click();
        // Verify the error message “Your password is invalid!”
        // It is given in requirement
        String expectedText = "Your password is invalid!";
        // get text from actual message
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@id='flash']"));
        String actualText = actualTextElement.getText();
        System.out.println(actualText);
        // Verify expected text and actual text
        Assert.assertEquals("can't read the text 'Your password is invalid!'", expectedText,actualText);

    }

    @After
    public void tearDown(){
        closeBrowser();
    }

}
