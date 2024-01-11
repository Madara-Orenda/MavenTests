import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import javax.xml.xpath.XPath;
import java.time.Duration;
import java.util.concurrent.locks.Condition;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.xpath;
import com.github.javafaker.Faker;

public class OpenCartHW {
    WebDriver driver;
    WebDriverWait wait;

    Faker faker;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust the timeout value as needed

    }

    @Test
    public void Test1() {
        faker = new Faker();
        driver.get("http://shop.pragmatic.bg/index.php?route=product/product&product_id=43");

        WebElement addToCart = driver.findElement(By.id("button-cart"));
        addToCart.click();

        WebElement item = driver.findElement(By.id("cart-total"));
        item.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("fa-share"))); // Fixing the locator

        WebElement CheckOut = driver.findElement(By.className("fa-share"));
        CheckOut.click();

        wait.until(ExpectedConditions.urlContains("checkout/checkout"));
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout/checkout"), "Not on the expected checkout page");

        /*Step 1: Radio button Guest*/
        WebElement guestRadioButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div/div/div[1]/div[2]/label")));
        guestRadioButton.click();

        WebElement Continue1 = driver.findElement(By.id("button-account"));
        Continue1.click();

        /*Step 2: Billing details*/
        WebElement FirstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-payment-firstname")));
        FirstName.sendKeys("Ivan");

        WebElement LastName = driver.findElement(By.id("input-payment-lastname"));
        Assert.assertTrue(LastName.getAttribute("value").isEmpty());
        LastName.click();
        LastName.sendKeys("Petkov");

        WebElement Email = driver.findElement(By.id("input-payment-email"));
        Assert.assertTrue(Email.getAttribute("value").isEmpty());
        Email.click();
        Email.sendKeys("ivan.petkov123@gamil.com");

        WebElement Telephone = driver.findElement(By.id("input-payment-telephone"));
        Assert.assertTrue(Telephone.getAttribute("value").isEmpty());
        String randomPHnumber = faker.phoneNumber().cellPhone();
        Telephone.sendKeys(randomPHnumber);

        WebElement Address = driver.findElement(By.id("input-payment-address-1"));
        Assert.assertTrue(Address.getAttribute("value").isEmpty());
        String randomAddress = faker.address().streetAddress();
        Address.sendKeys(randomAddress);

        WebElement City = driver.findElement(By.id("input-payment-city"));
        Assert.assertTrue(City.getAttribute("value").isEmpty());
        String randomCity = faker.address().city();
        City.sendKeys(randomCity);

        WebElement PostCode = driver.findElement(By.id("input-payment-postcode"));
        Assert.assertTrue(PostCode.getAttribute("value").isEmpty());
        String randomPostCode = faker.address().zipCode();
        PostCode.sendKeys(randomPostCode);

        WebElement Country = driver.findElement(By.id("input-payment-country"));
        Select dropdown = new Select(Country);
        dropdown.selectByVisibleText("Bulgaria");

        WebElement Region = driver.findElement(By.id("input-payment-zone"));
        Select dropdown2 = new Select(Region);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dropdown2.selectByVisibleText("Plovdiv");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement Continue2 = driver.findElement(By.id("button-guest"));
        Continue2.click();


        /*Step 3 Payment Method*/
        WebElement AddCommentForOrder = driver.findElement(By.className("form-control"));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/div/p[2]/textarea")));
        AddCommentForOrder.click();
        AddCommentForOrder.sendKeys("Please call me a few hours before you deliver my package ot the address!");

        WebElement TermsAndConditionsCheckBox = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[3]/div[2]/div/div[2]/div/input[1]"));
        TermsAndConditionsCheckBox.click();

        WebElement Continue3 = driver.findElement(By.id("button-payment-method"));
        Continue3.click();

    }
}
