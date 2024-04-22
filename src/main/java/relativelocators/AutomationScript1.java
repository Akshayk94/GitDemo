package relativelocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class AutomationScript1 {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        WebElement emailInput=driver.findElement(By.cssSelector("input[name='email']"));
        //find the label element located just above the email input box.
        String data=driver.findElement(with(By.tagName("label")).above(emailInput)).getText();
        System.out.println(data);
    }
}
