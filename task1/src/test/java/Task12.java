import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;

public class Task12 {
    private WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
    }

    @Test
    public void test() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        driver.findElement(new By.ByLinkText("Catalog")).click();
        driver.findElement(new By.ByLinkText("Add New Product")).click();

        //General
        double a = Math.random()*1000+Math.random()*400+Math.random()*30;//создание рандомного числа
        int a1= (int) a;
        driver.findElement(By.name("name[en]")).sendKeys("New name"+a1);
        driver.findElement(By.cssSelector("[name='code']")).sendKeys("Code");
        driver.findElement(By.cssSelector("[name='product_groups[]']")).click();
        driver.findElement(By.cssSelector("[name='quantity']")).sendKeys("20.0000");
        File file = new File("./src/test/resources/ut_capitan.jpg");
        driver.findElement(By.cssSelector("[name='new_images[]']")).sendKeys(file.getAbsolutePath());
        driver.findElement(By.cssSelector("[name='date_valid_from']")).sendKeys("17.03.2022");
        driver.findElement(By.cssSelector("[name='date_valid_to']")).sendKeys("17.04.2022");

        //Information
        driver.findElement(By.cssSelector("[href='#tab-information']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[name=manufacturer_id]")));
        new Select(driver.findElement(By.cssSelector("[name=manufacturer_id]"))).selectByValue("1");
        driver.findElement(By.cssSelector("[name='keywords']")).sendKeys("keywords");
        driver.findElement(By.cssSelector("[name='short_description[en]']")).sendKeys("short_description");
        driver.findElement(By.cssSelector(".trumbowyg-editor")).sendKeys("something new");
        driver.findElement(By.cssSelector("[name='head_title[en]']")).sendKeys("title");
        driver.findElement(By.cssSelector("[name='meta_description[en]']")).sendKeys("description");


        //Prices
        driver.findElement(By.cssSelector("[href='#tab-prices']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[name='purchase_price']")));
        WebElement pr = driver.findElement(By.cssSelector("[name='purchase_price']"));
        pr.clear();
        pr.sendKeys( "123456789");
        new Select(driver.findElement(By.cssSelector("[name='purchase_price_currency_code']"))).selectByValue("USD");
        driver.findElement(By.cssSelector("[name='prices[USD]']")).sendKeys("20.0000");
        driver.findElement(By.cssSelector("[name='prices[EUR]']")).sendKeys("18.0000");


        //Saving
        driver.findElement(By.cssSelector("[name='save']")).click();

        //Finding
        driver.findElement(By.cssSelector("#doc-catalog span")).click();
        driver.findElement(By.linkText("Rubber Ducks")).click();
        Assert.assertTrue(driver.findElement(By.linkText("New name"+a1)).isDisplayed());
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;}
}