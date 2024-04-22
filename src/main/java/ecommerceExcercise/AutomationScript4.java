package ecommerceExcercise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class AutomationScript4 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().window().maximize();
        login(driver);
        addToCart(driver);
    }

    private static void addToCart(WebDriver driver) {
        Actions a1=new Actions(driver);
        a1.scrollToElement(driver.findElement(By.cssSelector(".card-footer .btn-info"))).perform();
        List<String> products = Arrays.asList("iphone", "Samsung", "Nokia", "Balckberry");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
        List<WebElement> items = driver.findElements(By.cssSelector(".card-footer .btn-info"));
        for (int a = 0; a < items.size(); a++) {
            items.get(a).click();
        }
        driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();
    }

    private static void login(WebDriver driver) {
        //Enter Credentials
        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");
        driver.findElement(By.xpath("//input[@value='user']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
        System.out.println("element identified");
        driver.findElement(By.id("okayBtn")).sendKeys(Keys.ENTER);
        WebElement element = driver.findElement(By.tagName("select"));
        Select s = new Select(element);
        List<WebElement> options = s.getOptions();
        for (WebElement e : options) {
            if (e.getText().equalsIgnoreCase("student")) {
                e.click();
            }
        }
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("signInBtn")).click();
    }
}
