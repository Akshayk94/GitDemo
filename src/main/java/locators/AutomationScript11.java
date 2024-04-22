package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

/*Handling the checkboxes and getting the size of them*/
public class AutomationScript11 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(3000);
        /*click on specific checkbox and display the status whether element
        * is selected or not*/
        driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
        System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());

        /*count total no of checkboxes present*/
        List<WebElement> data =driver.findElements(By.cssSelector("input[type='checkbox']"));
        System.out.println(data.size());
    }
}
