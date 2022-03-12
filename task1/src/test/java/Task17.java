import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task17 {
    private WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
    }

    @Test
    public void test() throws Exception {
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
            driver.navigate().back();
            }

        for (LogEntry l : driver.manage().logs().get("browser").getAll()) {
            System.out.println(l); //show log
        }
        Assert.assertTrue("There are entries in log" ,driver.manage().logs().get("browser").getAll().size()>0);

    }
    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}