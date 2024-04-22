package miscellaneous;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestListener;

import java.io.File;
import java.io.IOException;

/*Taking Screenshots*/
public class AutomationScript3 {
    public static void main(String[] args) throws IOException {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://www.google.com");
        //cast driver into Screenshot
        TakesScreenshot ss= (TakesScreenshot) driver;
        //store screenshot in the form of file
        File file=ss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("D://screenshot.png"));
    }
}
