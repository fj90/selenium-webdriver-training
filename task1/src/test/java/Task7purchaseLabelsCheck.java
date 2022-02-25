import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.openqa.selenium.By;
import java.util.List;

public class Task7purchaseLabelsCheck {

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

        List<WebElement> Most_popular_list= driver.findElements(By.cssSelector("#box-most-popular li"));
        int most_popular_size = Most_popular_list.size();
        for(int i = 1; i <(most_popular_size+1); i++) {
            List<WebElement> L= driver.findElements(By.cssSelector("#box-most-popular li:nth-child(" +i+") .sticker"));
            if (L.size() !=1) throw new Exception("label for Most Popular either does not exist or is not the only one");
            //if (L.size() ==1) System.out.println ("Label =1");

        }


        List<WebElement> Latest_production= driver.findElements(By.cssSelector("#box-latest-products li"));
        int latest_production_size = Latest_production.size();
        for(int i = 1; i <(latest_production_size+1); i++) {
            List <WebElement>L2= driver.findElements(By.cssSelector(" #box-latest-products  li:nth-child(" +i+") .sticker"));
            if (L2.size() !=1) throw new Exception("label for Latest Production either does not exist or is not the only one") ;
        }

        List<WebElement> Campaigns= driver.findElements(By.cssSelector("#box-campaigns li"));
        int campaigns_size= Campaigns.size();
        //Campaigns
        for(int i = 1; i <(campaigns_size+1); i++) {
            List <WebElement>L3= driver.findElements(By.cssSelector("#box-campaigns  li:nth-child(" +i+") .sticker"));
            if (L3.size() !=1) throw new Exception("label for Latest Production either does not exist or is not the only one") ;
        }


    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

    }