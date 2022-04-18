package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){

        // Find username field and enter “Admin” username
        WebElement usernameField = driver.findElement(By.id("txtUsername"));
        usernameField.sendKeys("Admin");
        // Find password field and enter “admin123 password
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        passwordField.sendKeys("admin123");
        // Find and click on ‘LOGIN’ button
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
        //Verify the 'Welcome' text is display
        String expectedText = "Welcome";
        // Get text from successful login page
        WebElement actualTextElement = driver.findElement(By.xpath("//a[@id='welcome']"));
         String actualTextFUll = actualTextElement.getText();
         String actualText = actualTextFUll.substring(0,7); // get first 7 letters ('welcome' only)
        System.out.println(actualText);
         // Verify expected and actual text
        Assert.assertEquals("Not navigated to successful login page with 'Welcome' text", expectedText,actualText );

    }

    @After
    public void tearDown(){
        closeBrowser();
    }

}
