import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task8 {
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
        driver.get(" http://localhost/litecart/admin/?app=countries&doc=countries");

        int counties_ammount = driver.findElements(By.cssSelector("#content td:nth-child(5) a")).size();
        ArrayList<String> str_arr = new ArrayList<>();
        ArrayList<String> str_arr_sort;
        ArrayList<String> str_arr_zones = new ArrayList<>();
        ArrayList<String> str_arr_zones_sort;

        for (int i = 2; i <= (counties_ammount); i++) {
            str_arr.add(driver.findElement(By.cssSelector("#content tr:nth-child(" + i + ") td:nth-child(5) a")).getAttribute("textContent"));

            String S = driver.findElement(By.cssSelector("#content tr:nth-child(" + i + ") td:nth-child(6)")).getAttribute("textContent");
            boolean equals = S.equals("0");
          //  System.out.println(equals);
            if (equals == false) {
                driver.findElement(By.cssSelector("#content tr:nth-child(" + i + ") td:nth-child(7)")).click();
                int zones_ammount = driver.findElements(By.cssSelector("#table-zones td:nth-child(3)")).size();
                for (int j = 2; j <= (zones_ammount); j++) {
                    str_arr_zones.add(driver.findElement(By.cssSelector("#table-zones tr:nth-child(" + j + ") td:nth-child(3)")).getText());
                }

                str_arr_zones_sort=str_arr_zones;
                Arrays.sort(new ArrayList[]{str_arr_zones_sort});
                Assert.assertEquals( "Cортировка зон не по алфавиту", str_arr_zones, str_arr_zones_sort);

                driver.get(" http://localhost/litecart/admin/?app=countries&doc=countries");
            }
        }
        str_arr_sort = str_arr;
        Arrays.sort(new ArrayList[]{str_arr_sort});
        Assert.assertEquals( "Cортировка стран не по алфавиту", str_arr, str_arr_sort);


    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}

