package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class AutomationScript3 {
    public static void main(String[] args) throws InterruptedException
    {
        FirefoxOptions opt=new FirefoxOptions();
        opt.addPreference("dom.webnotifications.enabled",false);
        /*Browser will open in custom settings*/
        WebDriver driver=new FirefoxDriver(opt);
        driver.get("https://www.nobroker.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        /*Identifying element by using css selector with the help of Attribute*/
        driver.findElement(By.cssSelector("input[placeholder='Search upto 3 localities or landmarks']")).sendKeys("Banshankari");
        Thread.sleep(1000);
        /*Identifying element by using indexing xpath
        * If multiple elements are matching given type then we can
        * identify specific element by using index number*/
        driver.findElement(By.xpath("//input[@type='text'][1]")).clear();
        Thread.sleep(1000);
        /*Identifying element by using css selector with the help of ID*/
        driver.findElement(By.cssSelector("input#listPageSearchLocality")).sendKeys("Jaynagar");
        Thread.sleep(2000);
        /*Identifying element by using css selector with the help of nth-child
        * If multiple elements are matching given type then we can
        * identify specific element by using nth-child selector */
        driver.findElement(By.cssSelector("input[type='text']:nth-child(1)")).clear();
        Thread.sleep(1000);
        /*Identifying element by using css selector with the help of
        regular expression*/
        driver.findElement(By.cssSelector("input[type*='te']")).sendKeys("Basvangudi");
        Thread.sleep(2000);
        /*Identifying element by using xpath with the help of class name
        * which is changing dynamically*/
        driver.findElement(By.xpath("//button[contains(@class,'prop-search-button')]")).click();
        //driver.quit();
    }
}
