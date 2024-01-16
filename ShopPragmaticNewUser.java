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
public class ShopPragmaticNewUser {

    WebDriver driver;
    WebDriverWait wait;
    Faker faker;

    @Test
    public void demoTest1() {
        faker = new Faker();
        driver = new ChromeDriver();
        driver.get("https://shop.pragmatic.bg/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement MyAccountButton = driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/a/span[1]"));
        MyAccountButton.click();

        WebElement Register = driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/ul/li[1]/a"));
        Register.click();

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
        Email.sendKeys("ivan.todorov123@gmail.com");

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
        WebElement NewsletterEnabled = driver.findElement(By.className("radio-inline"));
        NewsletterEnabled.click();

        /*Checkbox/Terms and conditions*/
        WebElement Checkbox = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div/div/input[1]"));
        Checkbox.click();
        
        /*Continue Button*/
        WebElement ContinueButtonBlue = driver.findElement(By.className("btn-primary"));
        ContinueButtonBlue.click();
        
        /*Logout assert, meaning we are logged-in in the created account*/
        WebElement LogoutButton = driver.findElement(By.className("list-group-item"));
        Assert.assertTrue(LogoutButton.isDisplayed());

    }

    }
