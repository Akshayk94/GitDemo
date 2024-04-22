package realTImeExcercise;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.List;

/*Handle table grids in web page*/
public class AutomationScript6 {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> data=driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        int sum=0;
        for (WebElement e:data){
            sum+=Integer.parseInt(e.getText());
        }
        //compare the sum with generated total
        String value=driver.findElement(By.cssSelector(".totalAmount")).getText();
        int total=Integer.parseInt(value.split(":")[1].trim());
        Assert.assertEquals(sum,total);
        System.out.println(sum);
    }
}
