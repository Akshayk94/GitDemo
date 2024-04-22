package realTImeExcercise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/*Opening the links in new tab*/
public class AutomationScript2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        /*print the count of links present inside the first column of footer*/
        List<WebElement> info=driver.findElements(By.xpath("//div[@id='gf-BIG']//tr/td[1]/ul//a"));
        System.out.println("DISCOUNT COLUMN LINKS "+info.size());
        /*click on each link present inside the column
         * and open that link in new tab*/
        for (WebElement e:info){
            String clickableLink=Keys.chord(Keys.CONTROL,Keys.ENTER);
            e.sendKeys(clickableLink);
        }
        /*Get the title of each page opened in different tab*/
        Set<String> tabs=driver.getWindowHandles();
        Iterator<String> data=tabs.iterator();
        while (data.hasNext()){
            driver.switchTo().window(data.next());
            System.out.println(driver.getTitle());
            Thread.sleep(2000);
        }
    }
}
