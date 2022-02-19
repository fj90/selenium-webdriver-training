import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class MenuClick {


    private WebDriver driver;
   // private WebDriverWait wait;

    @Before
    public void start() {

        driver = new ChromeDriver();
       // wait = new WebDriverWait(driver, 10);

    }

    @Test
    public void MenuClicking() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        //Appearence
        driver.findElement(By.cssSelector("#box-apps-menu li:first-child")).click();
        driver.findElement(By.cssSelector("#content > h1"));
        driver.findElement(By.linkText("Template")).click();
        driver.findElement(By.cssSelector("#content > h1"));
        driver.findElement(By.linkText("Logotype")).click();
        driver.findElement(By.cssSelector("#content > h1"));


        //Catalog
        driver.findElement(By.xpath("/html/body/div/div/div/table/tbody/tr/td[1]/div[3]/ul/li[2]/a")).click();

        driver.findElement(By.cssSelector("#app- > ul li:nth-child(2)")).click();
        driver.findElement(By.cssSelector("#content > h1"));
        driver.findElement(By.cssSelector("#app- > ul li:nth-child(3)")).click();
        driver.findElement(By.cssSelector("#content > h1"));
        driver.findElement(By.cssSelector("#app- > ul li:nth-child(4)")).click();
        driver.findElement(By.cssSelector("#content > h1"));
        driver.findElement(By.cssSelector("#app- > ul li:nth-child(5)")).click();
        driver.findElement(By.cssSelector("#content > h1"));
        driver.findElement(By.cssSelector("#app- > ul li:nth-child(6)")).click();
        driver.findElement(By.cssSelector("#content > h1"));
        driver.findElement(By.cssSelector("#app- > ul li:nth-child(7)")).click();
        driver.findElement(By.cssSelector("#content > h1"));
        driver.findElement(By.cssSelector("#app- > ul li:nth-child(8)")).click();
        driver.findElement(By.cssSelector("#content > h1"));
        driver.findElement(By.cssSelector("#app- > ul li:nth-child(9)")).click();
        driver.findElement(By.cssSelector("#content > h1"));


        //Countries
        driver.findElement(By.xpath("/html/body/div/div/div/table/tbody/tr/td[1]/div[3]/ul/li[3]/a/span[2]")).click();
        driver.findElement(By.cssSelector("#content > h1"));

        //Currencies
        driver.findElement(By.xpath(" /html/body/div/div/div/table/tbody/tr/td[1]/div[3]/ul/li[4]/a/span[2]")).click();
        driver.findElement(By.cssSelector("#content > h1"));

        //Customers
        driver.findElement(By.xpath("/html/body/div/div/div/table/tbody/tr/td[1]/div[3]/ul/li[5]/a")).click();
        driver.findElement(By.cssSelector("#content > h1"));
        driver.findElement(By.linkText("CSV Import/Export")).click();
        driver.findElement(By.cssSelector("#content > h1"));
        driver.findElement(By.linkText("Newsletter")).click();
        driver.findElement(By.cssSelector("#content > h1"));

        //Geo Zones
        driver.findElement(By.xpath("/html/body/div/div/div/table/tbody/tr/td[1]/div[3]/ul/li[6]/a")).click();
        driver.findElement(By.cssSelector("#content > h1"));

        // Languages
        driver.findElement(By.xpath("/html/body/div/div/div/table/tbody/tr/td[1]/div[3]/ul/li[7]/a/span[2]")).click();
        driver.findElement(By.cssSelector("#content > h1"));
        driver.findElement(By.linkText("Storage Encoding")).click();
        driver.findElement(By.cssSelector("#content > h1"));

        //Modules
        driver.findElement(By.xpath("/html/body/div/div/div/table/tbody/tr/td[1]/div[3]/ul/li[8]/a")).click();
        driver.findElement(By.cssSelector("#content > h1"));
        driver.findElement(By.linkText("Customer")).click();
        driver.findElement(By.cssSelector("#content > h1"));
        driver.findElement(By.linkText("Shipping")).click();
        driver.findElement(By.cssSelector("#content > h1"));
        driver.findElement(By.linkText("Payment")).click();
        driver.findElement(By.cssSelector("#content > h1"));
        driver.findElement(By.linkText("Order Total")).click();
        driver.findElement(By.cssSelector("#content > h1"));
        driver.findElement(By.linkText("Order Success")).click();
        driver.findElement(By.cssSelector("#content > h1"));
        driver.findElement(By.linkText("Order Action")).click();
        driver.findElement(By.cssSelector("#content > h1"));

        //Orders
        driver.findElement(By.xpath("/html/body/div/div/div/table/tbody/tr/td[1]/div[3]/ul/li[9]/a/span[2]")).click();
        driver.findElement(By.cssSelector("#content > h1"));
        driver.findElement(By.linkText("Order Statuses")).click();
        driver.findElement(By.cssSelector("#content > h1"));


        //Pages
        driver.findElement(By.xpath("/html/body/div/div/div/table/tbody/tr/td[1]/div[3]/ul/li[10]/a")).click();
        driver.findElement(By.cssSelector("#content > h1"));

        //Reports
        driver.findElement(By.xpath(" /html/body/div/div/div/table/tbody/tr/td[1]/div[3]/ul/li[11]/a")).click();
        driver.findElement(By.cssSelector("#content > h1"));
        driver.findElement(By.linkText("Most Sold Products")).click();
        driver.findElement(By.cssSelector("#content > h1"));
        driver.findElement(By.linkText("Most Sold Products")).click();
        driver.findElement(By.cssSelector("#content > h1"));
        driver.findElement(By.linkText("Most Shopping Customers")).click();
        driver.findElement(By.cssSelector("#content > h1"));

        //Settings
        driver.findElement(By.xpath(" /html/body/div/div/div/table/tbody/tr/td[1]/div[3]/ul/li[12]/a")).click();
        driver.findElement(By.cssSelector("#content > h1"));
        driver.findElement(By.linkText("Defaults")).click();
        driver.findElement(By.cssSelector("#content > h1"));
        driver.findElement(By.linkText("General")).click();
        driver.findElement(By.cssSelector("#content > h1"));
        driver.findElement(By.linkText("Listings")).click();
        driver.findElement(By.cssSelector("#content > h1"));
        driver.findElement(By.linkText("Images")).click();
        driver.findElement(By.cssSelector("#content > h1"));
        driver.findElement(By.linkText("Checkout")).click();
        driver.findElement(By.cssSelector("#content > h1"));
        driver.findElement(By.linkText("Advanced")).click();
        driver.findElement(By.cssSelector("#content > h1"));
        driver.findElement(By.linkText("Security")).click();
        driver.findElement(By.cssSelector("#content > h1"));

        // Slides
        driver.findElement(By.xpath("/html/body/div/div/div/table/tbody/tr/td[1]/div[3]/ul/li[13]/a")).click();
        driver.findElement(By.cssSelector("#content > h1"));

        //Tax
        driver.findElement(By.xpath("/html/body/div/div/div/table/tbody/tr/td[1]/div[3]/ul/li[14]/a")).click();
        driver.findElement(By.cssSelector("#content > h1"));
        driver.findElement(By.linkText("Tax Rates")).click();
        driver.findElement(By.cssSelector("#content > h1"));

        //Translations
        driver.findElement(By.xpath("/html/body/div/div/div/table/tbody/tr/td[1]/div[3]/ul/li[15]/a/span[2]")).click();
        driver.findElement(By.cssSelector("#content > h1"));
        driver.findElement(By.linkText("Scan Files")).click();
        driver.findElement(By.cssSelector("#content > h1"));
        driver.findElement(By.linkText("CSV Import/Export")).click();
        driver.findElement(By.cssSelector("#content > h1"));

        //Users
        driver.findElement(By.xpath("/html/body/div/div/div/table/tbody/tr/td[1]/div[3]/ul/li[16]/a")).click();
        driver.findElement(By.cssSelector("#content > h1"));


        //vQmods
        driver.findElement(By.xpath("/html/body/div/div/div/table/tbody/tr/td[1]/div[3]/ul/li[17]/a")).click();
        driver.findElement(By.cssSelector("#content > h1"));


        driver.findElement(By.xpath("/html/body/div/div/div/table/tbody/tr/td[1]/div[3]/ul/li[17]/ul/li/a")).click();
        driver.findElement(By.cssSelector("#content > h1"));

    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}



