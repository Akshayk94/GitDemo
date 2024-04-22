package ecommerceExcercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

//Add multiple elements at a same time into cart
//Demo of implicit and explicit wait
public class AutomationScript3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        Thread.sleep(2000);
        //call add to cart method
        addToCart(driver);
        //call checkout method
        checkout(driver);
    }

    private static void checkout(WebDriver driver) {
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//button[text()='Apply']")).click();
        //Explicit wait
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoinfo")));
        System.out.println(driver.findElement(By.cssSelector("span.promoinfo")).getText());
    }

    private static void addToCart(WebDriver driver) throws InterruptedException {
        //create a list of items
        List<String> vegetables= Arrays.asList("Cucumber","Beetroot","Beans");
        //Get the list of all elements
        List<WebElement> items = driver.findElements(By.cssSelector("h4.product-name"));
        for (int a=0;a< items.size();a++){
            String product=items.get(a).getText();
            for (String s:vegetables){
                if (product.contains(s)){
                    driver.findElements(By.xpath("//div[@class='product-action']/button")).get(a).click();
                }
            }
        }
    }
}
