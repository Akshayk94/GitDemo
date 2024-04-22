package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

//Assignment on window handling
public class AutomationScript4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        Set<String> handles=driver.getWindowHandles();
        Iterator<String> itr=handles.iterator();
        String parentId=itr.next();
        String childId=itr.next();
        driver.switchTo().window(childId);
        String text=driver.findElement(By.tagName("h3")).getText();
        System.out.println(text);
        driver.switchTo().window(parentId);
        String msg=driver.findElement(By.xpath("//div/h3")).getText();
        System.out.println(msg);
    }
}
