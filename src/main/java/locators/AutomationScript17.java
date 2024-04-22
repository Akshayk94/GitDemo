package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/*Handling Javascript alerts using selenium WebDriver*/
public class AutomationScript17 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        String text="Akshay";
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(2000);
        //1: Handling alert box
        driver.findElement(By.cssSelector("[id='name']")).sendKeys(text);
        Thread.sleep(2000);
        driver.findElement(By.id("alertbtn")).click();
        Thread.sleep(1000);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        //2: Handling confirm box
        driver.findElement(By.cssSelector("[id='confirmbtn']")).click();
        Thread.sleep(2000);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);

    }
}
