package com.ambs;
import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;
public class AMBS_Security_transaction2 {
    public static String browser = "chrome";
    public static WebDriver driver;
    @Test
    public void Security() throws InterruptedException{
        // TODO Auto-generated method stub
        if(browser.equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if(browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.get("https://192.168.97.56:1105/Login.aspx");
        driver.manage().window().maximize();
        WebElement advance = driver.findElement(By.xpath("//*[@id=\'details-button\']"));
        advance.click();
        WebElement permission = driver.findElement(By.xpath("//*[@id=\'proceed-link\']"));
        permission.click();
        Thread.sleep(3000);
        WebElement Login = driver.findElement(By.xpath("//*[@id=\'login_UserName\']"));
        Login.sendKeys("admin");
        WebElement Pass = driver.findElement(By.xpath("//*[@id=\'login_Password\']"));
        Pass.sendKeys("Test@123");

        WebElement LoginClick = driver.findElement(By.xpath("//*[@id=\'login_LoginImageButton\']"));
        LoginClick.click();
        //Click on Security Transaction
        WebElement Click_SecurityTransaction = driver.findElement(By.xpath("//*[@id=\'ext-element-15\']/span"));
        Click_SecurityTransaction.click();

        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//*[@id=\'ctl00_mnuPageToolbarn1\']/table/tbody/tr/td/a")).click();
        driver.switchTo().defaultContent();
        Thread.sleep(2000);

        driver.close();
    }
}
