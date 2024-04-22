package streamapi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

/*Perform web table sorting using Selenium java streams*/
public class AutomationScript1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().window().maximize();
        //1) Click on table element to sort the data
        driver.findElement(By.xpath("//span[text()='Veg/fruit name']")).click();
        //2) Fetch the elements into list
        List<WebElement> data=driver.findElements(By.xpath("//tbody//tr/td[1]"));
        //3) Capture the text all web elements into new list
        List<String> original=data.stream().map(WebElement::getText).toList();
        //4) Sort the original list
        List<String> ordered=original.stream().sorted().toList();
        //5) Compare original list and sorted list
        Assert.assertEquals(original,ordered);
        System.out.println("Elements are matching");
        //6) Get the price of specific veggie
        List<String> cost=data.stream().filter(s->s.getText().contains("Carrot")).map(s->getPrice(s)).toList();
        cost.forEach(System.out::println);
        /*7) Get the price of specific veggie present at some other page
             Implementing pagination by using do-while loop
        * */
        List<String> price;
        do{
            List<WebElement> items=driver.findElements(By.xpath("//tbody//tr/td[1]"));
            price=items.stream().filter(s->s.getText().contains("Wheat")).map(s->getPrice(s)).toList();
            price.forEach(System.out::println);
            if (price.isEmpty()){
                driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
            }
            Thread.sleep(1000);
        }while (price.isEmpty());
    }
    private static String getPrice(WebElement s) {
        //we are navigating with parent element
        return s.findElement(By.xpath("following-sibling::td[1]")).getText();
    }
}
