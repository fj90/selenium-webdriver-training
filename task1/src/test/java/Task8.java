import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.openqa.selenium.By;

public class Task8 {
    private WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
    }

    @Test
    public void test() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        driver.get(" http://localhost/litecart/admin/?app=countries&doc=countries");

        char[] CHARS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        String a = driver.findElement(By.cssSelector("#content > form > table > tbody > tr:nth-child(2) > td:nth-child(5) > a")).getAttribute("textContent");
        //System.out.println (a);

       String a1 = driver.findElement(By.cssSelector("  #content > form > table > tbody")).getAttribute("textContent");
       // System.out.println (a1);
        String a2 = a1.replace(" ","");
        String[] ary = a2.split("\n");
        System.out.println (ary.toString());

       // String a2 = a1.substring(20);
        //String a2 = a1.trim();
      //  String a2 = a1.replace("\n", "").replace(" ","");
       // String a3 = a2.substring(24);
   //     System.out.println (a3);
        int i =1;
       // }




    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
