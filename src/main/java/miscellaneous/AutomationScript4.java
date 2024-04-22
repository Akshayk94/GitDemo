package miscellaneous;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/*Automate broken URLs*/
public class AutomationScript4 {
    public static void main(String[] args) throws IOException {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //STEP-1 Get single url and check whether it is broken or not
        String url=driver.findElement(By.cssSelector("a[href*=broken]")).getAttribute("href");
        URL link=new URL(url);
        HttpURLConnection con= (HttpURLConnection) link.openConnection();
        con.setRequestMethod("HEAD");
        con.connect();
        int resCode=con.getResponseCode();
        System.out.println(resCode);
        System.out.println("===============================");
        //STEP-2 Get all urls and check broken links
        List<WebElement> data =driver.findElements(By.xpath("//div[@id='gf-BIG']//a"));
        SoftAssert s=new SoftAssert();
        for (WebElement e:data){
            String urlLink=e.getAttribute("href");
            URL text=new URL(urlLink);
            HttpURLConnection con1= (HttpURLConnection) text.openConnection();
            con1.setRequestMethod("HEAD");
            con1.connect();
            int resCode1=con1.getResponseCode();
            s.assertTrue(resCode1<400,e.getText()+" LINK IS BROKEN");
        }
        s.assertAll();
    }
}
