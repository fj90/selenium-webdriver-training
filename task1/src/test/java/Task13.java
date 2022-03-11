import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Task13 {
    private WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
       
    }

    @Test
    public void test() {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        driver.get("http://localhost/litecart/");
        //добавление товаров
        for (int g = 1; g < 4; g++) {
            driver.findElement(By.cssSelector("#box-most-popular li:nth-child(1)")).click();

            if ( driver.findElements(By.cssSelector("#box-product select")).size()!=0) {
                driver.findElement(By.cssSelector("#box-product select")).click();
                driver.findElement(By.cssSelector("[value=Small]")).click();
            }

            driver.findElement(By.cssSelector("#box-product button")).click();
            System.out.println(driver.findElement(By.cssSelector("#cart span.quantity")).getText());
            driver.findElement(By.cssSelector("#cart > a.content > span.quantity")).getText();
            wait.until(ExpectedConditions.attributeToBe(driver.findElement(By.cssSelector("#cart span.quantity")), "innerText", String.valueOf(g)));
            driver.get("http://localhost/litecart/");
            System.out.println( "g="+g);
        }

        driver.findElement(new By.ByLinkText("Checkout »")).click();


        while (driver.findElements(By.cssSelector("#box-checkout-cart [value=Remove]")).size()!=0) {
                String previous_value = driver.findElement(By.cssSelector("table tr.footer td:nth-child(2)")).getText();
                System.out.println("previous_value =" + previous_value);
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#box-checkout-cart [value=Remove]")))).click();

                if (driver.findElements(By.cssSelector("#order_confirmation-wrapper table")).size() != 0) {

                    wait.until(ExpectedConditions.attributeToBe(driver.findElement(By.cssSelector("table tr.footer td:nth-child(2)")), "innerText", previous_value));
                   // System.out.println(driver.findElement(By.cssSelector("new value" + driver.findElement(By.cssSelector("table tr.footer td:nth-child(2)")))));
                    //  int i =1;
                }
            }


            //int j =1;
    }


    @After
    public void stop() {
        driver.quit();
        driver = null;}
}