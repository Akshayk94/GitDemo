package realTImeExcercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/*Assignment*/
public class AutomationScript3 {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        //Get the selected checkbox text
        driver.findElement(By.xpath("//input[@id='checkBoxOption3']/parent::label")).click();
        String choice=driver.findElement(By.xpath("//input[@id='checkBoxOption3']/parent::label")).getText();
        //Select the same option from dropdown list
        WebElement element=driver.findElement(By.tagName("select"));
        Select s=new Select(element);
        s.selectByVisibleText(choice);
        //Enter same text into input box
        driver.findElement(By.id("name")).sendKeys(choice);
        driver.findElement(By.id("alertbtn")).click();
        if(driver.switchTo().alert().getText().contains(choice)){
            System.out.println("Text is present");
        }else {
            System.out.println("Text is not present");
        }
        driver.switchTo().alert().accept();
    }
}
