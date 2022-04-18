package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        // find and click on the 'Sign In' link
        WebElement signInLinkElement = driver.findElement(By.linkText("Sign In"));
        signInLinkElement.click();
        // Verify the text ‘Welcome Back!’
        // It is from requirements
        String expectedText = "Welcome Back!";
        // Find the element and Get actual text from webpage
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[@class='page__heading']"));
        String actualText = actualTextElement.getText();
        System.out.println(actualText);
        // Verify that expected and actual text
        Assert.assertEquals("'WelcomeBack!' text is not displayed",expectedText,actualText);
    }

    @Test
    public void verifyTheErrorMessage(){
        // find and click on the 'Sign In' link
        WebElement signInLinkElement = driver.findElement(By.linkText("Sign In"));
        signInLinkElement.click();
        // find emailField and enter invalid username
        WebElement emailFieldElement = driver.findElement(By.id("user[email]"));
        emailFieldElement.sendKeys("prime123@gmail.com");
        // find passwordField and enter invalid password
        WebElement passwordFieldElement = driver.findElement(By.id("user[password]"));
        passwordFieldElement.sendKeys("Password123");
        // find and click on Login button
        WebElement loginButtonElement = driver.findElement(By.xpath("//input[@class='button button-primary g-recaptcha']"));
        loginButtonElement.click();
        // Verify the error message ‘Invalid email or password.’
        // It is from requirements
        String expectedTextMessage = "Invalid email or password.";
        // Get actual text message from webpage
        WebElement actualTextMessageElement = driver.findElement(By.xpath("//li[@class='form-error__list-item']"));
        String actualTextMessage = actualTextMessageElement.getText();
        System.out.println(actualTextMessage);
        // Verify actual and expected text messages
        Assert.assertEquals("'Invalid email or password.' text is not displayed", expectedTextMessage,actualTextMessage);

    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
