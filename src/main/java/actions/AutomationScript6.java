package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
/*Assignment on Iframes*/
public class AutomationScript6 {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-top");
        System.out.println(driver.findElement(By.cssSelector("div#content")).getText());
    }
}
