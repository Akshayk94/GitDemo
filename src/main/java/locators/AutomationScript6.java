package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

/*Handling static dropdowns using Web Driver API*/
public class AutomationScript6 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(2000);
        String text1=driver.findElement(By.tagName("b")).getText();
        Assert.assertEquals(text1,"COUNTRY");
        Thread.sleep(2000);
        WebElement element= driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        //dropdown with select tag
        Select dropDown=new Select(element);
        //select option based on index number
        dropDown.selectByIndex(2);
        System.out.println(dropDown.getFirstSelectedOption().getText());
        Thread.sleep(2000);
        //select option based on visible text
        dropDown.selectByVisibleText("USD");
        System.out.println(dropDown.getFirstSelectedOption().getText());
        Thread.sleep(2000);
        //select option based on value
        dropDown.selectByValue("INR");
        System.out.println(dropDown.getFirstSelectedOption().getText());
        Thread.sleep(1000);
        //close the browser
        driver.quit();
    }
}
