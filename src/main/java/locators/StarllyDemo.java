package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StarllyDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://spectra.starlly.in/signin");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(2000);
        boolean status=driver.findElement(By.tagName("h1")).isDisplayed();
        if (status){
            driver.findElement(By.xpath("//input[@name='email']")).clear();
            driver.findElement(By.xpath("//input[@name='email']")).sendKeys("nikith@starlly.in");
            driver.findElement(By.xpath("//input[@name='password']")).clear();
            driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456");
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            Thread.sleep(2000);
            status=driver.findElement(By.xpath("//div[text()='Dev Test Tenant']")).isDisplayed();
            if (status){
                driver.findElement(By.xpath("//div[@class='setup false']")).click();
                WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
                driver.findElement(By.xpath("//a[text()='Milk Items']")).click();
                Thread.sleep(2000);
                status=driver.findElement(By.tagName("h4")).isDisplayed();
                System.out.println(status);
            }
        }
    }
}
