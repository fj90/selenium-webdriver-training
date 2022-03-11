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

            if ( driver.findElements(By.cssSelector("#box-product select")).size()!=0) { //если есть выбор размера утки
                driver.findElement(By.cssSelector("#box-product select")).click();
                driver.findElement(By.cssSelector("[value=Small]")).click();
            }

            driver.findElement(By.cssSelector("#box-product button")).click();
            driver.findElement(By.cssSelector("#cart span.quantity")).getText();
            wait.until(ExpectedConditions.attributeToBe(driver.findElement(By.cssSelector("#cart span.quantity")), "innerText", String.valueOf(g)));
            driver.get("http://localhost/litecart/");
        }

            driver.findElement(new By.ByLinkText("Checkout »")).click(); //переход в корзину
            driver.findElement(By.cssSelector("[name='cart_form']")).click();

            int item_amount = driver.findElements(By.cssSelector("ul.items li")).size();
            for (int i = 0; i < item_amount; i++) {
            int line_count = driver.findElements(By.cssSelector("div#box-checkout-summary tr")).size(); // число строк в таблице
             driver.findElement(By.cssSelector("li.item:nth-child(1) button[name='remove_cart_item']")).click(); //  Remove
            wait.until((WebDriver driver) -> driver.findElements(By.cssSelector("div#box-checkout-summary tr")).size() < line_count);
            System.out.println("товар номер" +i+ "удален");

        }





            }
            


    @After
    public void stop() {
        driver.quit();
        driver = null;}
}