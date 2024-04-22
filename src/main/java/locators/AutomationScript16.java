package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
/*Registration form Assignment*/
public class AutomationScript16 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div/input[@name='name']")).sendKeys("AKSH");
        driver.findElement(By.cssSelector("[name='email']")).sendKeys("ak@gmail.com");
        driver.findElement(By.cssSelector("[type*='pass']")).sendKeys("123456");
        driver.findElement(By.id("exampleCheck1")).click();

        WebElement genderDropDown=driver.findElement(By.id("exampleFormControlSelect1"));
        Select s=new Select(genderDropDown);
        s.selectByIndex(0);

        driver.findElement(By.id("inlineRadio2")).click();

        driver.findElement(By.cssSelector("[name='bday']")).sendKeys("04-02-2000");
        driver.findElement(By.cssSelector("[type='submit']")).click();

        System.out.println(driver.findElement(By.cssSelector("div[class*='alert-success']")).getText());
    }
}
