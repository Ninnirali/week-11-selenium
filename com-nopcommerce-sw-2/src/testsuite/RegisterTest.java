package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static testsuite.LoginTest.baseUrl;


public class RegisterTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully(){

        // find and click on the 'Register' link
        WebElement registerLink = driver.findElement(By.xpath("//a[@href='/register?returnUrl=%2F']"));
        registerLink.click();
        // this is from requirements
        String expectedText = "Register";
        // Get text from the 'Register' link
        registerLink = driver.findElement(By.xpath("//a[@href='/register?returnUrl=%2F']"));
        String actualText = registerLink.getText();
        System.out.println(actualText);
        // Verify expected and actual text
        Assert.assertEquals("No navigate to 'Register' link ",expectedText,actualText);

    }

    @Test
    public void userSholdRegisterAccountSuccessfully() {
        // find and click on the ‘Register’ link
        WebElement registerLink = driver.findElement(By.xpath("//a[@href='/register?returnUrl=%2F']"));
        registerLink.click();
        // find and Select gender radio button and select / click on it
        WebElement genderRadioButton = driver.findElement(By.id("gender-female"));
        genderRadioButton.click();
        // find First name filed and Enter First name
        WebElement firstNameField = driver.findElement(By.id("FirstName"));
        firstNameField.sendKeys("A");
        // find Last name filed and Enter First name
        WebElement lastNameField = driver.findElement(By.id("LastName"));
        lastNameField.sendKeys("X");
        // find and select Day Month and Year
        WebElement day = driver.findElement(By.name("DateOfBirthDay"));
        Select select = new Select(day);
        select.selectByVisibleText("1");
        WebElement month = driver.findElement(By.name("DateOfBirthMonth"));
        Select select1 = new Select(month);
        select1.selectByVisibleText("January");
        WebElement year = driver.findElement(By.name("DateOfBirthYear"));
        Select select2 = new Select(year);
        select2.selectByVisibleText("2000");
        // find email field and enter email address
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("xyz789@gmail.com");
        //deselect the Newsletter option by clicking on it
        WebElement newsLetter = driver.findElement(By.id("Newsletter"));
        newsLetter.click();
        // find passwordField and enter Password
        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("Abcd123");
        // find confirmPasswordField and enter password
        WebElement confirmPasswordField = driver.findElement(By.id("ConfirmPassword"));
        confirmPasswordField.sendKeys("Abcd123");
        // find Register button and click on it
        WebElement registerButton = driver.findElement(By.id("register-button"));
        registerButton.click();
        // it is from requirements
        String expectedText = "Your registration completed";
        // Get text post registration message
        WebElement registerConfirmationMessage = driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        String actualText = registerConfirmationMessage.getText();
        // verify expected and actual text matches
        Assert.assertEquals("Can't navigate to registration confirmation page",expectedText,actualText);

    }

    @After
    public void tearDown(){
        closeBrowser();
    }

}
