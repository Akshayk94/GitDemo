package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

/*Handling child windows*/
public class AutomationScript3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.className("blinkingText")).click();
        //Getting all the windows opened by Selenium
        Set<String> windows=driver.getWindowHandles();
        Iterator<String> itr=windows.iterator();
        String parentId=itr.next();
        String childId=itr.next();
        System.out.println(childId);
        //switch from parent to child window
        driver.switchTo().window(childId);
        //Get the para msg from child window
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String text=driver.findElement(By.cssSelector(".im-para.red")).getText();
        System.out.println(text);
        //extract email id from text
        String[] data=text.split(" ");
        String email="";
        for (String datum : data) {
            if (datum.contains("mentor")){
                email=datum;
                break;
            }
        }
        System.out.println(email);
        Thread.sleep(5000);
        //switch from child window to parent window
        driver.switchTo().window(parentId);
        //Enter email id into username text field
        driver.findElement(By.id("username")).sendKeys(email);
    }
}
