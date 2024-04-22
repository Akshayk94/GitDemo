package realTImeExcercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

/*Automate calendar UI in ecommerce/travel websites*/
public class AutomationScript4 {
    public static void main(String[] args) throws InterruptedException {
        String month="April";
        String date="18";
        String year="2028";
        List<String> info= Arrays.asList(month,date,year);
        WebDriver driver=new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().window().maximize();
        //open the calendar
        driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
        Thread.sleep(1000);
        //open the months
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        Thread.sleep(1000);
        //open the years
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        Thread.sleep(1000);
        //select the year with value stored in variable
        driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
        Thread.sleep(1000);
        //select the month with value stored in variable
        driver.findElement(By.xpath("//button//abbr[text()='"+month+"']")).click();
        Thread.sleep(1000);
        //select the date with value stored in variable
        driver.findElement(By.xpath("//button//abbr[text()='"+date+"']")).click();

        List<WebElement> data =driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
        for (int a=0;a< data.size();a++){
            Assert.assertEquals(data.get(a).getAttribute("value"),info.get(a));
        }
    }
}
