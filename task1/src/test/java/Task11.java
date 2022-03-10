import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Task11 {
    private WebDriver driver;


    @Before
    public void start() {
        driver = new ChromeDriver();
    }

    @Test
    public void test() throws InterruptedException {

        //создние рандомного числа
        double a = Math.random()*1000+Math.random()*400+Math.random()*30;
        int a1= (int) a;
        System.out.println(a1);

        //переменные
        String FirstName = "Yana" + a1;
        String LastName = "Fom" +a1 ;
        String Address1 = "Voronezskaya street";
        String Postcode = "00001";
        String City = "City1";
        String Email = a1+"@mapl.ru";
        String Country = "United States";
        String Phone = "937640"+a1;
        String DesiredPassword = "1qaz@WSX";
        String ConfirmedPassword = "1qaz@WSX";

        System.out.println(FirstName);
        System.out.println(LastName);
        System.out.println(Email);

        driver.get("http://localhost/litecart");
        driver.findElement(new By.ByLinkText("New customers click here")).click();

        //заполнение данных
        driver.findElement(By.name("firstname")).sendKeys(FirstName);
        driver.findElement(By.name("lastname")).sendKeys(LastName);
        driver.findElement(By.name("address1")).sendKeys(Address1);
        driver.findElement(By.name("postcode")).sendKeys(Postcode);
        driver.findElement(By.name("city")).sendKeys(City);
        driver.findElement(By.name("password")).sendKeys(DesiredPassword);
        driver.findElement(By.name("confirmed_password")).sendKeys(ConfirmedPassword);
        driver.findElement(By.name("email")).sendKeys(Email);
        driver.findElement(By.name("phone")).sendKeys(Phone);

        //выбор страны
        driver.findElement(By.cssSelector("span.select2-selection__arrow  b")).click();
        driver.findElement(By.cssSelector("span.select2-search.select2-search--dropdown input")).sendKeys(Country+ Keys.ENTER);


        // создание аккаунта и логин
        driver.findElement(By.name("create_account")).click();

        // логаут
        driver.findElement(By.linkText("Logout")).click();

        // новый логин и новый логаут
        driver.findElement(By.name("email")).sendKeys(Email);
        driver.findElement(By.name("password")).sendKeys(DesiredPassword);
        driver.findElement(By.cssSelector("#box-account-login button:first-child")).click();
       // wait(7000);
        driver.findElement(By.linkText("Logout")).click();

    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}

