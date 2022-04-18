package testsuite;

import browserfactory.BaseTest;
import javafx.scene.control.Tab;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {

     String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully(){
        //Find and Click on the 'Computers' Tab
        WebElement computersTab = driver.findElement(By.linkText("Computers"));
        computersTab.click();

        //Verify the text 'Computers'
        // This is from requirements
        String expectedText = "Computers";
        // get text from computer tab
        computersTab = driver.findElement(By.linkText("Computers"));
        String actualText = computersTab.getText();
        System.out.println(actualText);
        // Validate actual and expected text
        Assert.assertEquals("Not navigate to 'Computers' Tab ", expectedText,actualText);
    }

    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully(){
        //Find and click on the ‘Electronics’ Tab
        WebElement electronicsTab = driver.findElement(By.linkText("Electronics"));
        electronicsTab.click();
        //Verify the text ‘Electronics’
        //this is from requirement
        String expectedText = "Electronics";
        // Get Text from 'Electronics' Tab
        electronicsTab = driver.findElement(By.linkText("Electronics"));
        String actualText = electronicsTab.getText();
        System.out.println(actualText);
        // Validate actual and expected text
                Assert.assertEquals("Not navigate to'Electronics' Tab", expectedText,actualText);
    }

    @Test
    public void userShouldNavigateToApparelPageSuccessfully(){
        // find and click on the ‘Apparel’Tab
        WebElement apparelTabElement = driver.findElement(By.linkText("Apparel"));
        apparelTabElement.click();
        // This is from requirement
        String expectedText = "Apparel";
        // Get Text from 'Apparel' Tab
        apparelTabElement = driver.findElement(By.linkText("Apparel"));
        String actualText = apparelTabElement.getText();
        System.out.println(actualText);
        // Verify expected and actual text
        Assert.assertEquals("Not navigate to 'Apparel' Tab", expectedText, actualText);

    }

    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully() {
        // find and click on the ‘Digital downloads’ Tab
        WebElement digitalDownloadsTab = driver.findElement(By.linkText("Digital downloads"));
        digitalDownloadsTab.click();
        // It is from requirements
        String expectedText = "Digital downloads";
        // get text from 'Digital downloads' Tab
        digitalDownloadsTab = driver.findElement(By.linkText("Digital downloads"));
        String actualText = digitalDownloadsTab.getText();
        System.out.println(actualText);
        //Verify the expected and actual text
        Assert.assertEquals("Not navigate to 'Digital downloads' Tab", expectedText, actualText);

    }

    @Test
    public void userShouldNavigateToBooksPageSuccessfully(){
        //find and click on the ‘Books’ Tab
        WebElement booksTab = driver.findElement(By.xpath("//a[@href='/books']"));
        booksTab.click();
        // this is from requirement
        String expectedText = "Books";
        // Get text from 'Books' Tab
        booksTab = driver.findElement(By.xpath("//a[@href='/books']"));
        String actualText = booksTab.getText();
        System.out.println(actualText);
        // Verify the actual and expected text
        Assert.assertEquals("Not navigate to 'Book' Tab", expectedText,actualText);

    }

    @Test
    public void userShouldNavigateToJewelryPageSuccessfully(){
        //find and click on the ‘Jewelry’ Tab
        WebElement jewelryTab = driver.findElement(By.xpath("//a[@href='/jewelry']"));
        jewelryTab.click();
        // this is from requirement
        String expectedText = "Jewelry";
        // Get text from 'Jewelry'Tab
        jewelryTab = driver.findElement(By.xpath("//a[@href='/jewelry']"));
        String actualText = jewelryTab.getText();
        System.out.println(actualText);
        // Verify the actual and expected text
        Assert.assertEquals("not navigate to 'Jewelry' Tab", expectedText, actualText );
    }

    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully(){
      // find and click on the ‘Gift Cards’ Tab
        WebElement giftCardsTab = driver.findElement(By.xpath("//a[@href='/gift-cards']"));
        giftCardsTab.click();
        // this is from the requirements
        String expectedText = "Gift Cards";
        // Get text from ' Gift Cards' Tab
        giftCardsTab = driver.findElement(By.xpath("//a[@href='/gift-cards']"));
        String actualText = giftCardsTab.getText();
        System.out.println(actualText);
        // Verify expected and actual text
        Assert.assertEquals("No navigate to 'Gift Cards' Tab", expectedText, actualText);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
