import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.firefox.FirefoxDriver;




public class Task2Login {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {

       // driver = new ChromeDriver();
       // wait = new WebDriverWait(driver,10);

        driver = new InternetExplorerDriver();
        wait = new WebDriverWait(driver,10);

     //   driver  = new FirefoxDriver();
     // wait = new WebDriverWait(driver,10);
    }

    @Test
    public void myFirstTest() {
        //driver.get("https://www.google.com");
         driver.get("http://localhost/litecart/admin/login.php?redirect_url=%2Flitecart%2Fadmin%2F");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();




    }

    @After  public void stop() {
        driver.quit();
        driver=null;
    }
}
