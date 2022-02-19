import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.openqa.selenium.By;
import java.util.List;

public class PurchaseLabelsCheck {

    private WebDriver driver;
   // private WebDriverWait wait;

    @Before
    public void start() {

        driver = new ChromeDriver();
       // wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void PurchaseLabelsChecking() throws Exception {
        driver.get("http://localhost/litecart/en/");

        //Most Popular
       List<WebElement> L1= driver.findElements(By.cssSelector("#box-most-popular > div > ul > li:nth-child(1) > a.link > div.image-wrapper > div"));
       if (L1.size()>1) throw new Exception("There are more than one label") ;
        List <WebElement> L2= driver.findElements(By.cssSelector("#box-most-popular > div > ul > li:nth-child(2) > a.link > div.image-wrapper > div"));
        if (L2.size()>1) throw new Exception("There are more than one label") ;
        List<WebElement> L3= driver.findElements(By.cssSelector("#box-most-popular > div > ul > li:nth-child(3) > a.link > div.image-wrapper > div"));
        if (L3.size()>1) throw new Exception("There are more than one label") ;
        List<WebElement> L4= driver.findElements(By.cssSelector("#box-most-popular > div > ul > li:nth-child(4) > a.link > div.image-wrapper > div"));
        if (L4.size()>1) throw new Exception("There are more than one label") ;
        List <WebElement>L5= driver.findElements(By.cssSelector("#box-most-popular > div > ul > li:nth-child(5) > a.link > div.image-wrapper > div"));
        if (L5.size()>1) throw new Exception("There are more than one label") ;

        //Campaigns
        List <WebElement>L6= driver.findElements(By.cssSelector("#box-campaigns > div > ul > li > a.link > div.image-wrapper > div"));
        if (L6.size()>1) throw new Exception("There are more than one label") ;

        //Latest Production
        List <WebElement>L7= driver.findElements(By.cssSelector(" #box-latest-products > div > ul > li:nth-child(1) > a.link > div.image-wrapper > div"));
        if (L7.size()>1) throw new Exception("There are more than one label") ;
        List <WebElement>L8= driver.findElements(By.cssSelector(" #box-latest-products > div > ul > li:nth-child(2) > a.link > div.image-wrapper > div"));
        if (L8.size()>1) throw new Exception("There are more than one label") ;
        List <WebElement>L9= driver.findElements(By.cssSelector(" #box-latest-products > div > ul > li:nth-child(3) > a.link > div.image-wrapper > div"));
        if (L9.size()>1) throw new Exception("There are more than one label") ;
        List <WebElement>L10= driver.findElements(By.cssSelector(" #box-latest-products > div > ul > li:nth-child(4) > a.link > div.image-wrapper > div"));
        if (L10.size()>1) throw new Exception("There are more than one label") ;
        List <WebElement>L11= driver.findElements(By.cssSelector(" #box-latest-products > div > ul > li:nth-child(5) > a.link > div.image-wrapper > div"));
        if (L11.size()>1) throw new Exception("There are more than one label") ;
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

    }