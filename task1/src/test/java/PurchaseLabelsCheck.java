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


        for(int i = 1; i <6; i++) {
            //Most Popular
            List<WebElement> L= driver.findElements(By.cssSelector("#box-most-popular > div > ul > li:nth-child(" +i+") > a.link > div.image-wrapper > div"));
            if (L.size() !=1) throw new Exception("label for Most Popular either does not exist or is not the only one");
            //if (L.size() ==1) System.out.println ("Label =1");
            //Latest Production
            List <WebElement>L2= driver.findElements(By.cssSelector(" #box-latest-products > div > ul > li:nth-child(" +i+") > a.link > div.image-wrapper > div"));
            if (L.size() !=1) throw new Exception("label for Latest Production either does not exist or is not the only one") ;
        }


        //Campaigns
        List <WebElement>L6= driver.findElements(By.cssSelector("#box-campaigns > div > ul > li > a.link > div.image-wrapper > div"));
        if (L6.size()!=1) throw new Exception("There are more than one label") ;


    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

    }