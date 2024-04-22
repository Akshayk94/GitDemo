package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
/*Handling Calendar UI in travel websites*/
public class AutomationScript14 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(3000);

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        Thread.sleep(1000);
        //select from city
        driver.findElement(By.xpath("//a[@value='PNQ']")).click();
        Thread.sleep(2000);
        //select to city
        driver.findElement(By.xpath("(//a[@value='BLR'])[2]")).click();
        Thread.sleep(2000);

        //select current date
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

    }
}
