package miscellaneous;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*Handling cookies*/
public class AutomationScript2 {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        //delete all cookies
        driver.manage().deleteAllCookies();
        //delete specific cookie
        driver.manage().deleteCookieNamed("sdsads");
        driver.get("https://www.google.com");
    }
}
