package miscellaneous;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/*Handling HTTP certifications in automated browsers*/
public class AutomationScript1 {
    public static void main(String[] args) {
        FirefoxOptions options=new FirefoxOptions();
        options.setAcceptInsecureCerts(true);
        WebDriver driver=new FirefoxDriver(options);
        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());
    }
}
