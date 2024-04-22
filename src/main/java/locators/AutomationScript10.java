package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

/*Handling Auto suggestive dropdown with Selenium*/
public class AutomationScript10 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(4000);
        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        List< WebElement> data =driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

        for (WebElement e:data){
            if (e.getText().equalsIgnoreCase("india")){
                e.click();
            }
        }
    }
}
