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
import static org.junit.Assert.assertFalse;
import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.xpath;



public class WebPageInput {
    WebDriver driver;

    @Test
    public void demoTest1() {
        driver = new ChromeDriver();
        driver.get("https://shop.pragmatic.bg/admin");
        WebElement message = driver.findElement(By.id("input-username"));
        message.click();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement username = driver.findElement(By.id("input-username"));
        Assert.assertTrue(username.getAttribute("value").isEmpty()); /* Това проверява дали полето е празно*/
        username.sendKeys("admin");

        WebElement password = driver.findElement(By.id("input-password"));
        Assert.assertTrue(password.getAttribute("value").isEmpty());
        password.sendKeys("parola123!");

        WebElement LoginButton = driver.findElement(className("btn-primary"));
        LoginButton.click();

        /*PROFILE BUTTON DROPDOWN*/
        WebElement profileButton = driver.findElement(By.id("user-profile"));
        profileButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        By myProfileButtonClass = By.className("fa-user-circle-o");
        wait.until(ExpectedConditions.visibilityOfElementLocated(myProfileButtonClass));
        WebElement myProfileButton = driver.findElement(myProfileButtonClass);
        myProfileButton.click();

        /*SALES MENU*/
        WebElement salesMenu = driver.findElement(By.xpath("/html/body/div[1]/nav/ul/li[5]/a"));
        salesMenu.click();

        WebElement salesMenuOrders = driver.findElement(By.xpath("/html/body/div[1]/nav/ul/li[5]/ul/li[1]/a"));
        salesMenuOrders.click();

        WebElement orderID = driver.findElement(By.id("input-order-id"));
        Assert.assertTrue(orderID.getAttribute("value").isEmpty());

        WebElement inputCustomer = driver.findElement(By.id("input-customer"));
        Assert.assertTrue(inputCustomer.getAttribute("value").isEmpty());

        WebElement inputOrderStatus = driver.findElement(By.id("input-order-status"));
        Assert.assertTrue(inputOrderStatus.getAttribute("value").isEmpty());

        WebElement inputTotal = driver.findElement(By.id("input-total"));
        Assert.assertTrue(inputTotal.getAttribute("value").isEmpty());

        WebElement inputDate = driver.findElement(By.id("input-date-added"));
        Assert.assertTrue(inputDate.getAttribute("value").isEmpty());

        WebElement inputDateModified = driver.findElement(By.id("input-date-modified"));
        Assert.assertTrue(inputDateModified.getAttribute("value").isEmpty());

    }

    /* ЧАСТ 2-РА ОТ ДОМАШНОТО*/
    @AfterMethod
    @Test
    public void demoTest2() {
        driver = new ChromeDriver();
        driver.get("https://pragmatic.bg/automation/lecture13/Config.html");

        WebElement ChangeCarToMerc = driver.findElement(By.xpath("//*[@id=\"tabs-1\"]/p[1]/select"));
        Select dropdown = new Select(ChangeCarToMerc);
        dropdown.selectByVisibleText("Mercedes");

        /*RADIO Button select using ACTIONS class*/
        Actions actions = new Actions(driver);

        // Locate AirBags element
        WebElement airBags = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/p[3]/input[2]"));
        assertFalse("Button is unexpectedly selected", airBags.isSelected());

        // Click on AirBags using Actions
        actions.click(airBags).perform();

        // Locate Parking sensor element
        WebElement parkingSensor = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/p[3]/input[3]"));
        assertFalse("Button is unexpectedly selected", parkingSensor.isSelected());

        // Click on Parking sensor using Actions
        actions.click(parkingSensor).perform();
    }
/*
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
 */
}


