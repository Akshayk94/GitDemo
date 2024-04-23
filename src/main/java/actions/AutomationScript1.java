package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
/*Move mouse pointer to specific element*/
public class AutomationScript1 {
    public static void main(String[] args) {
        System.out.println("Script Started");
        WebDriver driver=new FirefoxDriver();
        driver.get("https://www.amazon.in/ref=nav_logo");

        Actions a=new Actions(driver);
        a.moveToElement(driver.findElement(By.id("nav-link-accountList"))).perform();
        System.out.println("Script Ended");
    }
}
