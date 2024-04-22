package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;

public class AutomationScript4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://www.shoppersstack.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        /*Identifying element by using unique tag name
        * check expected output by using Assert.assertEquals()*/
        String text=driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(text,"Welcome to ShoppersStack. Enjoy shopping with us.");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@id='loginBtn']")).click();
        Thread.sleep(2000);
        String text1=driver.findElement(By.cssSelector("h5 strong")).getText();
        Assert.assertEquals(text1,"Shopper Login");
        driver.findElement(By.cssSelector("input#Email")).sendKeys("akshay98@gmail.com");
        driver.findElement(By.cssSelector("input#Password")).sendKeys("Password@123");
        driver.findElement(By.cssSelector("button#Login")).click();
        Thread.sleep(2000);
        String text2=driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(text2,"Hello, Akshay");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(@class,'MuiAvatar-root')]")).click();
        Thread.sleep(2000);
        /*Generating xpaths based on list text*/
        driver.findElement(By.xpath("//li[text()='Logout']")).click();
        Thread.sleep(2000);
        String text3=driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(text3,"Welcome to ShoppersStack. Enjoy shopping with us.");
        driver.quit();
    }
}
