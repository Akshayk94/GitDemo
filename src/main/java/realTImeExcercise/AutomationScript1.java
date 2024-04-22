package realTImeExcercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

/*Limiting Web Driver Scope*/
public class AutomationScript1 {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        /*Print the links count in page*/
        List<WebElement> items =driver.findElements(By.tagName("a"));
        System.out.println("TOTAL NO OF LINKS "+items.size());
        /*print the count of links present inside the footer*/
        List<WebElement> data=driver.findElements(By.xpath("//div[@id='gf-BIG']//a"));
        System.out.println("FOOTER LINKS "+data.size());
        /*print the count of links present inside the first column of footer*/
        List<WebElement> info=driver.findElements(By.xpath("//div[@id='gf-BIG']//tr/td[1]/ul//a"));
        System.out.println("DISCOUNT COLUMN LINKS "+info.size());
        /*click on each link present inside the column
        * and check whether links are working or not*/
        for (WebElement e:info){
            e.click();
        }
    }
}
