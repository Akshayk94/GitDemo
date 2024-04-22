package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;
/*Looping through dropdown */
public class AutomationScript7 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(2000);
        String text1=driver.findElement(By.tagName("b")).getText();
        Assert.assertEquals(text1,"COUNTRY");
        Thread.sleep(2000);
        /*Adding adult passenger*/
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        for (int a=1;a<5;a++){
            driver.findElement(By.id("hrefIncAdt")).click();
            Thread.sleep(2000);
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        Thread.sleep(2000);
        /*Adding child passenger*/
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        for (int a=1;a<4;a++){
            driver.findElement(By.id("hrefIncChd")).click();
            Thread.sleep(2000);
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
    }
}
