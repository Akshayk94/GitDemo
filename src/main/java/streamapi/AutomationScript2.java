package streamapi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.List;
/*Filter the web table using streams*/
public class AutomationScript2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        String search = "ch";
        driver.findElement(By.id("search-field")).sendKeys(search);
        Thread.sleep(2000);
        List<WebElement> items = driver.findElements(By.xpath("//tr/td[1]"));
        System.out.println(items.size());
        //verify that list contains specified characters in input box
        List<WebElement> matchingItems = items.stream().filter(e -> e.getText().toLowerCase().contains("ch")).toList();
        Assert.assertEquals(items.size(), matchingItems.size());
    }
}
