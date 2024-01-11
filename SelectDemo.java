import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import javax.swing.*;

public class SelectDemo {
    WebDriver driver;
    Action builder;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("");
    }

       @Test
    public void selectTest(){
           WebElement make = driver.findElement(By.name("make"));
           Select brandSelect = new Select(make);
           brandSelect.selectByValue("mercedes");
        }
    }


