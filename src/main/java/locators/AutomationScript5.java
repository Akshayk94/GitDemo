package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/*Sibling to child to parent traverse*/
public class AutomationScript5 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://www.shoppersstack.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        Thread.sleep(6000);
        driver.findElement(By.cssSelector("a#men")).click();
        Thread.sleep(1000);
        /*Select element by using Parent to child traversing*/
        String item1=driver.findElement(By.xpath("//div[contains(@class,'cat_box')]/div[2]//span[text()='Skinny Men Blue Jeans']")).getText();
        System.out.println(item1);
        Thread.sleep(2000);
        /*Traverse from one child to another child of same parent*/
        String item2=driver.findElement(By.xpath("//div[contains(@class,'cat_box')]/div[2]/following-sibling::div[3]//span[text()='footwear']")).getText();
        System.out.println(item2);
        /*Traverse from child to immediate parent*/
        driver.findElement(By.xpath("//div[contains(@class,'cat_box')]/div[2]//span[text()='Skinny Men Blue Jeans']/parent::div"));

    }
}
/*This type of traversing can not be done using css selector
* we must have to use xpath for this*/