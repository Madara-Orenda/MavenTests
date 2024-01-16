import com.beust.ah.A;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Collections;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.github.javafaker.Faker;


public class Plovdiv24Testing {

    WebDriver driver;
    WebDriverWait wait;
    Faker faker;

    @Test
    public void demoTest1() {

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://www.plovdiv24.bg/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement PopUp = driver.findElement(By.className("fc-button-label"));
        PopUp.click();

        WebElement Novini = driver.findElement(By.className("hv5_n2tabne"));
        Novini.click();

        WebElement Sport = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div[3]"));
        Sport.click();

        WebElement Search = driver.findElement(By.className("hv5_n2tabnepic"));
        Search.click();

        WebElement SearchField =driver.findElement(By.className("v5_searchpole2"));
        SearchField.sendKeys("Альоша");

        WebElement InsideSearch = driver.findElement(By.className("v5_searcbut2"));
        InsideSearch.click();

        WebElement VhodButton = driver.findElement(By.className("v5_nlbutonvhod"));
        VhodButton.click();

        WebElement UsernameField = driver.findElement(By.className("inplight"));
        UsernameField.click();
        org.testng.Assert.assertTrue(UsernameField.getAttribute("value").isEmpty());
        UsernameField.sendKeys("zcvetkov@gmail.com");

        WebElement PasswordField = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div[10]/form/div/div[2]/div/div[2]/input"));
        PasswordField.click();
        PasswordField.sendKeys("111666");

        WebElement LogInButton = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div[10]/form/div/div[2]/div/div[3]/div[1]/input"));
        LogInButton.click();

        WebElement Avatar = driver.findElement(By.className("hv5_avatarovsiv"));
        Avatar.click();

        WebElement UserProfile = driver.findElement(By.className("hv5_usred"));
        UserProfile.click();
    }
}