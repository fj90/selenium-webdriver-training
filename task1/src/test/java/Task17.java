import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.*;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.logging.Level;

public class Task17 {


   private WebDriver driver;

    @Before
    public void start() {
        LoggingPreferences prefs = new LoggingPreferences();
        prefs.enable("browser", Level.ALL);
        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.LOGGING_PREFS, prefs);
        driver = new EventFiringWebDriver(new ChromeDriver(options));
    }

    @Test
    public void test() throws Exception {

        LoggingPreferences prefs = new LoggingPreferences();
        prefs.enable("browser", Level.ALL);
        prefs.enable("server", Level.ALL);
        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.LOGGING_PREFS, prefs);
        driver = new EventFiringWebDriver(new ChromeDriver(options));

        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        driver.findElement(new By.ByLinkText("Subcategory")).click(); //open subcategory

        int elemets_ammount = driver.findElements(By.cssSelector("#content tr td:nth-child(3)")).size();
        for (int j = 5; j <= (elemets_ammount + 1); j++){
            driver.findElement(By.cssSelector("#content tr:nth-child("+ j +") td:nth-child(3) a")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(new By.ByLinkText("General")));

            Logs logs = driver.manage().logs();
            LogEntries BrowserlogEntries = logs.get(LogType.BROWSER);
            for (LogEntry logEntry : BrowserlogEntries) {
                    Assert.assertTrue("There is a browser message in the" + (j - 5) + "-th product"+ logEntry.getMessage(), logEntry.getMessage().equals(null));
                }
            driver.navigate().back();
            }
        
            }



    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}