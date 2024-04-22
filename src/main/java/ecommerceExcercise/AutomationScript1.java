package ecommerceExcercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/*Add single item into cart*/
public class AutomationScript1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(2000);
        //Select product which need to be added into cart
        WebElement element=driver.findElement(By.xpath("//h4[contains(text(),'Beetroot')]/..//button[text()='ADD TO CART']"));
        //Add product into the cart
        element.click();
        driver.quit();
    }
}
