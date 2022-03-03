import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.openqa.selenium.By;

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
        char[] char_arr = new char[counties_ammount];

        for (int i = 2; i < (counties_ammount); i++) {
            char_arr[i] = driver.findElement(By.cssSelector("#content tr:nth-child(" + i + ") td:nth-child(5) a")).getAttribute("textContent").charAt(0);
            String S = driver.findElement(By.cssSelector("#content tr:nth-child(" + i + ") td:nth-child(6)")).getAttribute("textContent");
            System.out.println(S);
            boolean equals = S.equals("0");
            System.out.println(equals);
            if (equals == false) {
                driver.findElement(By.cssSelector("#content tr:nth-child(" + i + ") td:nth-child(7)")).click();
                int zones_ammount = driver.findElements(By.cssSelector("#table-zones td:nth-child(3)")).size();
                char[] char_arr_zones = new char[zones_ammount];
                for (int j = 2; j < (zones_ammount); j++) {
                    char_arr_zones[j] = driver.findElement(By.cssSelector("#table-zones tr:nth-child(" + j + ") td:nth-child(3)")).getText().charAt(0);
                    char[] nonSortedArray = Arrays.copyOfRange(char_arr, 2, zones_ammount);
                    char[] SortedArray = Arrays.copyOfRange(char_arr, 2, zones_ammount);
                    Arrays.sort(SortedArray);
                    if (Arrays.equals(nonSortedArray, SortedArray) == false) {
                        throw new Exception("Countries are not in alphabetical order");
                    }
                }
                System.out.println(char_arr_zones + "- zone");
                driver.get(" http://localhost/litecart/admin/?app=countries&doc=countries");
            }
        }

        char[] nonSortedArray = Arrays.copyOfRange(char_arr, 2, counties_ammount);
        char[] SortedArray = Arrays.copyOfRange(char_arr, 2, counties_ammount);
        Arrays.sort(SortedArray);
        if (Arrays.equals(nonSortedArray, SortedArray) == false) {
            throw new Exception("Countries are not in alphabetical order");
        }
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}

