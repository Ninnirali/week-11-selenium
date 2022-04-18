package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {

    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully() {
        // click on the ‘Forgot your password’ link
        WebElement forgotYourPasswordLink = driver.findElement(By.xpath("//a[@href='/index.php/auth/requestPasswordResetCode']"));
        forgotYourPasswordLink.click();
        //  Verify the text ‘Forgot Your Password?’
        // it is from requirement
        String expectedText = "Forgot Your Password?";
        // Get text from reset password page
        WebElement actualTextDisplay = driver.findElement(By.xpath("//h1[contains(text(),'Forgot Your Password?')]"));
        String actualText = actualTextDisplay.getText();
        System.out.println(actualText);
        // verify expected and actual text
        Assert.assertEquals("Not navigate to password reset page with text 'Forgot Your Password?'",expectedText, actualText);

    }


    @After
    public void tearDown() {
        closeBrowser();
    }


}
