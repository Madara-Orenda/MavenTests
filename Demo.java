import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

public class Demo {
    WebDriver driver;

    @Test
    public void demoTest() {
        WebElement text = driver.findElement(By.className("messages"));
        Assert.assertEquals(text, "Examples");
    }

    @Test
    public void demoTest1() {
        driver = new ChromeDriver();
        driver.get("https://www.gta5-mods.com/vehicles");
        WebElement message = driver.findElement(By.id("tag-list"));
        message.click();
    }

    @BeforeMethod
    public void demoTest3() {
        driver = new EdgeDriver();
        driver.get("https://www.gta5-mods.com/vehicles");
        WebElement message = driver.findElement(By.id("tag-list"));
        message.click();
    }

    @AfterMethod // това затваря браузъра след всеки тест. After се изпълнява след всеки тест!
    public void tearDown() {
        driver.quit();
    }
}

