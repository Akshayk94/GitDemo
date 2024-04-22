package realTImeExcercise;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*Performing scroll operation at table and window level*/
public class AutomationScript5 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //cast web driver into javascript executor
        JavascriptExecutor js= (JavascriptExecutor) driver;
        //scrolling window vertically with given co-ordinates
        js.executeScript("window.scrollBy(0,600)");
        Thread.sleep(1500);
        //scrolling table component withing window
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=2000");
        Thread.sleep(1500);
    }
}
