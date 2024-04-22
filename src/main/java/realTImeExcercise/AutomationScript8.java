package realTImeExcercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

/*Assignment on Auto-suggestive dropdown*/
public class AutomationScript8 {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.id("autocomplete")).sendKeys("UNITED");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> options =driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));
        for (WebElement e:options){
            if (e.getText().contains("United Kingdom")){
                e.click();
            }
        }
    }
}
