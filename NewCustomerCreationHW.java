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
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.xpath;
import com.github.javafaker.Faker;


public class NewCustomerCreationHW {

    WebDriver driver;
    WebDriverWait wait;
    Faker faker;


    @Test
    public void demoTest1() {
        faker = new Faker();
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

        WebElement customersMenu = driver.findElement(By.xpath("/html/body/div[1]/nav/ul/li[6]/a"));
        customersMenu.click();

        WebElement Customers = driver.findElement(By.xpath("/html/body/div[1]/nav/ul/li[6]/ul/li[1]/a"));
        Customers.click();

        /*CREATE NEW CUSTOMER*/
        WebElement PlusButton = driver.findElement(xpath("/html/body/div[1]/div/div[1]/div/div/a/i"));
        PlusButton.click();
        
        /*CUSTOMER DETAILS*/
        WebElement FirstName = driver.findElement(By.id("input-firstname"));
        Assert.assertTrue(FirstName.getAttribute("value").isEmpty());
        FirstName.click();
        FirstName.sendKeys("Ivan");

        WebElement LastName = driver.findElement(By.id("input-lastname"));
        Assert.assertTrue(LastName.getAttribute("value").isEmpty());
        LastName.click();
        LastName.sendKeys("Petkov");

        /*СЛАГАМ HARDCODE-НАТ МЕЙЛ ЗА ДА БЪДЕ ОТКРИТ ПОСЛЕ*/
        WebElement Email = driver.findElement(By.id("input-email"));
        Assert.assertTrue(Email.getAttribute("value").isEmpty());
        Email.sendKeys("ivan.petkov123@gmail.com");

        /* - ТОВА ГЕНЕРИРА РАНДОМ МЕЙЛ С FAKER*/
        /*WebElement Email = driver.findElement(By.id("input-email"));
        Assert.assertTrue(Email.getAttribute("value").isEmpty());
        String randomEmail = faker.internet().safeEmailAddress();
        Email.sendKeys(randomEmail);*/


        WebElement Telephone = driver.findElement(By.id("input-telephone"));
        Assert.assertTrue(Telephone.getAttribute("value").isEmpty());
        String randomPHnumber = faker.phoneNumber().cellPhone();
        Telephone.sendKeys(randomPHnumber);

        /*PASSWORD*/
        WebElement Password = driver.findElement(By.id("input-password"));
        Assert.assertTrue(Password.getAttribute("value").isEmpty());
        Password.sendKeys("123456!!!");

        WebElement ConfirmPassword = driver.findElement(By.id("input-confirm"));
        Assert.assertTrue(ConfirmPassword.getAttribute("value").isEmpty());
        ConfirmPassword.sendKeys("123456!!!");

        /*Newsletter*/
        WebElement NewsletterEnabled = driver.findElement(By.id("input-newsletter"));
        Select dropdown = new Select(NewsletterEnabled);
        dropdown.selectByVisibleText("Enabled");

        WebElement Status = driver.findElement(By.id("input-status"));
        Select dropdownStatus = new Select(Status);
        dropdownStatus.selectByVisibleText("Enabled");

        WebElement Safe = driver.findElement(By.id("input-safe"));
        Select dropdown2 = new Select(Safe);
        dropdown2.selectByVisibleText("Yes");

        WebElement DisketteButton = driver.findElement(By.cssSelector("button[data-original-title='Save']"));
        DisketteButton.click();
    }

    @AfterMethod
    @Test
    public void demoTest2() {

        driver = new ChromeDriver();
        driver.get("https://shop.pragmatic.bg/admin/index.php?route=customer/customer&user_token=eeitec2cvDKwqAMazbNmnCrzq7VrCvfl&sort=c.date_added&order=DESC");
        WebElement username = driver.findElement(By.id("input-username"));
        Assert.assertTrue(username.getAttribute("value").isEmpty()); /* Това проверява дали полето е празно*/
        username.sendKeys("admin");

        WebElement password = driver.findElement(By.id("input-password"));
        Assert.assertTrue(password.getAttribute("value").isEmpty());
        password.sendKeys("parola123!");

        WebElement LoginButton = driver.findElement(className("btn-primary"));
        LoginButton.click();

        WebElement FilterEmail = driver.findElement(By.id("input-email"));
        Assert.assertTrue(FilterEmail.getAttribute("value").isEmpty());
        FilterEmail.sendKeys("ivan.petkov123@gmail.com");

        WebElement FilterButton = driver.findElement(By.id("button-filter"));
        FilterButton.click();


        }
    @AfterMethod
    public void tearDown() {
        driver.quit();

    }
}
