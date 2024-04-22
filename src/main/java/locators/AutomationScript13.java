package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;

/*Task
* 1) Select the first checkbox and verify if it is successfully checked
* and deselect it again to verify if it is successfully unchecked
*
* 2) Get the count of total number of checkboxes present in the page
* */
public class AutomationScript13 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(2000);
        //Task-1
        driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected());
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).click();
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected());

        //Task-2
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

    }
}
