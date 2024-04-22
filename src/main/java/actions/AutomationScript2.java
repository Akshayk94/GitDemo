package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

/*Performing composite actions*/
public class AutomationScript2 {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.in/ref=nav_logo");
        driver.manage().window().maximize();
        /*identify element on which action need to be performed*/
        WebElement element=driver.findElement(By.id("twotabsearchtextbox"));
        Actions a=new Actions(driver);
        a.moveToElement(element).click().keyDown(Keys.SHIFT).sendKeys("INDUCTION").doubleClick().perform();

        a.moveToElement(driver.findElement(By.id("nav-link-accountList"))).contextClick().perform();
    }
}
