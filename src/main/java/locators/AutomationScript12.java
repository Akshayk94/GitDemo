package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;

public class AutomationScript12 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(3000);
        //Condition should return false since checkbox not yet selected
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
        /*click on specific checkbox and display the status whether element
         * is selected or not*/
        driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
        System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
        //condition should return true because checkbox is selected
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());

        /*Adding adult passenger*/
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        for (int a=1;a<4;a++){
            driver.findElement(By.id("hrefIncAdt")).click();
            Thread.sleep(2000);
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"5 Adult");
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
    }
}
