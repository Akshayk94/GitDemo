package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class AutomationScript2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://www.goibibo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.xpath(".//span[@class='logSprite icClose']")).click();
        driver.findElement(By.xpath("(.//p[@class='sc-12foipm-20 bhnHeQ'])[1]")).click();
        driver.findElement(By.xpath(".//input[@type='text']")).sendKeys("pune");
        driver.findElement(By.xpath(".//span[contains(text(),'Pune')]")).click();

        System.out.println(driver.findElement(By.xpath("//div/h2")).getText());
    }
}
