package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;

/*Validating whether UI elements enabled or disabled with Attributes*/
public class AutomationScript15 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(3000);

        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[id='ctl00_mainContent_rbtnl_Trip_1']")).click();
        String data=driver.findElement(By.id("Div1")).getAttribute("style");
        System.out.println(data);
        if (data.contains("0.5")){
            Assert.assertTrue(true);
        }else {
            Assert.fail();
        }
    }
}
