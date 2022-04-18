package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){

        // find username field and enter “standard_user” username
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");
        // find passwordField and enter “secret_sauce” password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");
        // find and click on ‘LOGIN’ button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        // Verify the text “PRODUCTS”
        // It is from requirements
        String expectedText = "PRODUCTS";
        // Get text from actual
        WebElement actualTextElement = driver.findElement(By.xpath("//span[@class='title']"));
        String actualText = actualTextElement.getText();
        System.out.println(actualText);
        // verify expected and actual text
        Assert.assertEquals("Can't see text : 'PRODUCTS",expectedText,actualText);

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){

        // find username field and enter “standard_user” username
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");
        // find passwordField and enter “secret_sauce” password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");
        // find and click on ‘LOGIN’ button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        // Verify that six products are displayed on page
        // it is from requirements
        int sizeOfExpectedItemList = 6;
        // count no. of 'Products' displayed on webpage using item label
        List<WebElement> itemList = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        int sizeOfActualItemList = itemList.size();
        System.out.println("sizeOfActualItemList is " + sizeOfActualItemList);
        // Verify expected and actual size of item / product list
        Assert.assertEquals("6 no. products are not displayed on the webpage", sizeOfExpectedItemList,sizeOfActualItemList);

    }
    
    @After
    public void tearDown(){
        closeBrowser();
    }

}
