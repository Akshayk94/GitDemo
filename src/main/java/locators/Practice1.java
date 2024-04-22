package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

/*Automating Red Bus Home Page*/
public class Practice1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://www.redbus.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(2000);
        //STEP-1 SELECT FROM CITY
        driver.findElement(By.cssSelector("[id='src']")).sendKeys("PUN");
        Thread.sleep(2000);
        List<WebElement> data =driver.findElements(By.cssSelector("ul[class*='sc-dnq']"));
        for (WebElement e:data){
            if (e.getText().equalsIgnoreCase("Wakad")){
                e.click();
            }
        }
        Thread.sleep(2000);
        //STEP-2 SELECT TO CITY
        driver.findElement(By.cssSelector("[id='dest']")).sendKeys("BAN");
        Thread.sleep(2000);
        List<WebElement> info=driver.findElements(By.cssSelector("ul[class*='sc-dnq']"));
        for (WebElement e:info){
            if (e.getText().equalsIgnoreCase("Majestic")){
                e.click();
            }
        }
        Thread.sleep(2000);
        //STEP-3 SELECT TRAVEL DATE
        driver.findElement(By.id("onwardCal")).click();
        driver.findElement(By.xpath("//span[text()='22']")).click();
        Thread.sleep(2000);
        //STEP-4 CLICK ON SEARCH BUTTON
        driver.findElement(By.cssSelector("[id='search_button']")).click();
        Thread.sleep(5000);
        driver.quit();
    }
}
