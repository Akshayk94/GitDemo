package realTImeExcercise;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

/*Assignment on Web Tables*/
public class AutomationScript7 {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");

        //find out total no of rows in left aligned table
        List<WebElement> rows=driver.findElements(By.xpath("//table[@name='courses']//tr"));
        System.out.println("TOTAL NO OF ROWS "+rows.size());
        //find out total no of columns in table
        List<WebElement> cols=driver.findElements(By.xpath("//table[@name='courses']//th"));
        System.out.println("TOTAL NO OF COLS "+cols.size());
        //print the content from second row
        List<WebElement> content=driver.findElements(By.xpath("//table[@name='courses']//tr[3]/td"));
        for (WebElement e:content){
            System.out.println(e.getText());
        }
    }
}
