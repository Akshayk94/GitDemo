package relativelocators;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/*Invoking multiple tabs/windows  from selenium*/
public class AutomationScript2 {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        //invoke new window
        driver.switchTo().newWindow(WindowType.TAB);
        Set<String> handles=driver.getWindowHandles();
        Iterator<String> itr=handles.iterator();
        String parentId=itr.next();
        String childId=itr.next();
        driver.switchTo().window(childId);
        driver.get("https://rahulshettyacademy.com/");
        List<WebElement> data =driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p/']"));
        String course=data.get(1).getText();
        Thread.sleep(2000);
        driver.switchTo().window(parentId);
        WebElement element=driver.findElement(By.cssSelector("input[class*='ng-untouched']"));
        element.sendKeys(course);
        /*Taking partial screenshot*/
        File file=element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("logo.png"));
        /*Get height and width of text box*/
        System.out.println(element.getRect().getHeight());
        System.out.println(element.getRect().getWidth());
    }
}
