package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

/*Handling Iframes in Selenium*/
public class AutomationScript5 {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();
        //switch to iframe
        //driver.switchTo().frame(0);
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
        driver.findElement(By.id("draggable")).click();
        //Drag and drop element
        WebElement drag=driver.findElement(By.id("draggable"));
        WebElement drop=driver.findElement(By.id("droppable"));
        Actions a=new Actions(driver);
        a.dragAndDrop(drag,drop).perform();
        //This will switch back to main web page
        driver.switchTo().defaultContent();
    }
}
