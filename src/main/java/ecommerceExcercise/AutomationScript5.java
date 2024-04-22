package ecommerceExcercise;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class AutomationScript5 {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.tagName("button")).click();
        Wait<WebDriver> w=new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);

        WebElement element=w.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                if (driver.findElement(By.xpath("//div[@id='finish']/h4")).isDisplayed()){
                    return driver.findElement(By.xpath("//div[@id='finish']/h4"));
                }else{
                    return null;
                }
            }
        });
        System.out.println(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText());
    }
}
