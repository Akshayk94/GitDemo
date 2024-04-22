package ecommerceExcercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/*Add multiple units of specific item into cart*/
public class AutomationScript2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(2000);
        //select element and increase the qty for the same
        WebElement element =driver.findElement(By.xpath("//h4[contains(text(),'Beetroot')]/..//a[@class='increment']"));
        for (int a=1;a<=3;a++){
            element.click();
            Thread.sleep(1000);
        }
        //Now add the element into cart
        driver.findElement(By.xpath("//h4[contains(text(),'Beetroot')]/..//button[text()='ADD TO CART']")).click();
        Thread.sleep(2000);
        driver.quit();
    }
}
