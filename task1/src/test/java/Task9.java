import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task9 {
    private WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
    }

    @Test
    public void test() throws Exception {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");

        int geo_zone_ammount = driver.findElements(By.cssSelector("#content tr td:nth-child(3) a")).size();

        for (int g = 2; g <= (geo_zone_ammount + 1); g++) {
            ArrayList<String> str_arr = new ArrayList<>();
            ArrayList<String> str_arr_sort = new ArrayList<>();
            String geo_zone_name = driver.findElement(By.cssSelector("#content tr:nth-child(" + g + ") td:nth-child(3) a")).getText();
            driver.findElement(By.cssSelector("#content tr:nth-child(" + g + ") td:nth-child(3) a")).click();
            int zone_ammount = driver.findElements(By.cssSelector("#table-zones td:nth-child(3) select")).size();
            for (int i = 2; i <= (zone_ammount + 1); i++) {
                str_arr.add(driver.findElement(By.cssSelector("#table-zones tr:nth-child(" + i + ") td:nth-child(3) option[selected]")).getAttribute("textContent"));
            }
            for (int k = 0; k < str_arr.size(); k++) {
                str_arr_sort.add(str_arr.get(k));
            }
            Arrays.sort(new ArrayList[]{str_arr_sort});
//            str_arr_sort.add("sdgs");
            System.out.println(str_arr);
            System.out.println(str_arr_sort);
            Assert.assertEquals("сортировка зон геозоны " + geo_zone_name + " не по алфавиту", str_arr, str_arr_sort);
            driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        }
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}