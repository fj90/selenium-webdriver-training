import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class Task6MenuClick {


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

        List<WebElement> Menu_list = driver.findElements(By.cssSelector("#box-apps-menu li"));
        int menu_list_size = Menu_list.size();

        for (int i = 1; i < (menu_list_size + 1); i++) {
            driver.findElement(By.cssSelector(".logotype")).click();
            driver.findElement(By.cssSelector("#box-apps-menu li:nth-child(" + i + ")")).click();

            if (driver.findElements(By.cssSelector("#box-apps-menu li li")).size()!=0)
                 {
                List<WebElement> Submenu_list = driver.findElements(By.cssSelector("#box-apps-menu li li"));
                int submenu_list_size = Submenu_list.size();
                for (int y = 1; y < (submenu_list_size + 1); y++) {
                    driver.findElement(By.cssSelector("#box-apps-menu li li:nth-child(" + y + ")")).click();
                    driver.findElement(By.cssSelector("#content > h1"));
                }

            }

        }

    }
    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}



