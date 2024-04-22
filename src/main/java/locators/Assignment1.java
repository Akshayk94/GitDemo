package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

/*End To End Automation Using All UI Elements*/
public class Assignment1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        //STEP-1 OPEN URL IN BROWSER
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        //STEP-2 MAXIMIZE THE WINDOW
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(2000);
        //STEP-3 SELECT COUNTRY
        driver.findElement(By.id("autosuggest")).sendKeys("IND");
        List<WebElement> data =driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for (WebElement e:data){
            if (e.getText().equalsIgnoreCase("INDIA")){
                e.click();
            }
        }
        Thread.sleep(2000);
        //STEP-4 SELECT FROM CITY
        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']//a[@value='BLR']")).click();
        Thread.sleep(2000);
        //STEP-5 SELECT TO CITY
        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")).click();
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='PNQ']")).click();
        Thread.sleep(2000);
        //STEP-6 SELECT DEPART DATE
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
        Thread.sleep(2000);
        //STEP-7 VERIFY THAT RETURN DATE IS DISABLED
        if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")){
            Assert.assertTrue(true);
        }else {
            Assert.assertTrue(false);
        }
        Thread.sleep(2000);
        //STEP-8 SELECT PASSENGERS TYPE & COUNT
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        for (int a=1;a<5;a++){
            driver.findElement(By.id("hrefIncAdt")).click();
            Thread.sleep(2000);
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        Thread.sleep(2000);
        //STEP-9 SELECT CURRENCY
        WebElement element= driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropDown=new Select(element);
        dropDown.selectByIndex(2);
        Thread.sleep(2000);
        //STEP-10 CHECK THE STATUS OF PASSENGERS
        driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
        Thread.sleep(2000);
        //STEP-11 CLICK ON SEARCH BUTTON
        driver.findElement(By.cssSelector("[id='ctl00_mainContent_btn_FindFlights']")).click();
        Thread.sleep(5000);
        //TEP-12 CLOSE THE BROWSER
        driver.quit();
    }
}
