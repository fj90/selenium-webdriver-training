package Task19;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import Task19.pages.BasketPage;
import Task19.pages.MainPage;
import Task19.pages.ProductPage;
import Task19.pages.Page;


public class Application {
    private WebDriver driver;
    private WebDriverWait wait;
    private MainPage mainPage;
    private ProductPage productPage;
    private BasketPage basketPage;
    private Page page;

    public Application() {
        System.out.println("Запуск браузера");
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        productPage = new ProductPage(driver);
        basketPage = new BasketPage(driver);
        page = new Page(driver);
    }


    public void quit() {
        System.out.println("Завершение работы браузера");
        driver.quit();
        driver = null;
    }

    public void openMainPage() {
        page.open("http://localhost/litecart/en/");
    }

    public void addProduct() {
        mainPage.clickProduct();

        productPage.selectSize();
        productPage.clickAddButton();
        productPage.clickMainPage();
    }

    public void clearBasket() {
        mainPage.clickBasket();
        while (!basketPage.cartIsEmpty()) {
            basketPage.deleteProduct();
        }

    }
}