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

public class Task10 {
    private WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
    }

    @Test
    public void test() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String rgbaColorGray = "rgba(119, 119, 119, 1)";
        String rgbaColorGray2 = "rgba(102, 102, 102, 1)";
        String rgbaColorRed = "rgba(204, 0, 0, 1)";
        String boltTextSize = "700";
        ArrayList<String> nameMainCampaigns = new ArrayList<>();
        ArrayList<String> regPriceMainCampaigns = new ArrayList<>();
        ArrayList<String> sizeRegPriceMainCampaigns = new ArrayList<>();
        ArrayList<String> regColorMainCampaigns = new ArrayList<>();
        ArrayList<String> sizeCampPriceMainCampaigns = new ArrayList<>();
        ArrayList<String> campColorMainCampaigns = new ArrayList<>();
        ArrayList<String> regDecorMainCampaigns = new ArrayList<>();
        ArrayList<String> campDecorMainCampaigns = new ArrayList<>();
        ArrayList<String> campNameMainCampaigns = new ArrayList<>();
        driver.get("http://localhost/litecart/en/");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#box-campaigns li")));
        int box_ammount = driver.findElements(By.cssSelector("#box-campaigns li")).size();
        for (int g = 1; g < (box_ammount + 1); g++) {
            nameMainCampaigns.add(driver.findElement(By.cssSelector("#box-campaigns li:nth-child(" + g + ") div.name")).getText());
            regPriceMainCampaigns.add(driver.findElement(By.cssSelector("#box-campaigns li:nth-child(" + g + ") s.regular-price")).getText());
            sizeRegPriceMainCampaigns.add(driver.findElement(By.cssSelector("#box-campaigns li:nth-child(" + g + ") s.regular-price")).getCssValue("font-size"));
            regColorMainCampaigns.add(driver.findElement(By.cssSelector("#box-campaigns li:nth-child(" + g + ") s.regular-price")).getCssValue("color"));
            regDecorMainCampaigns.add(driver.findElement(By.cssSelector("#box-campaigns li:nth-child(" + g + ") s.regular-price")).getCssValue("text-decoration"));
            campNameMainCampaigns.add(driver.findElement(By.cssSelector("#box-campaigns li:nth-child(" + g + ") strong.campaign-price")).getText());
            sizeCampPriceMainCampaigns.add(driver.findElement(By.cssSelector("#box-campaigns li:nth-child(" + g + ") strong.campaign-price")).getCssValue("font-size"));
            campColorMainCampaigns.add(driver.findElement(By.cssSelector("#box-campaigns li:nth-child(" + g + ") strong.campaign-price")).getCssValue("color"));
            campDecorMainCampaigns.add(driver.findElement(By.cssSelector("#box-campaigns li:nth-child(" + g + ") strong.campaign-price")).getCssValue("font-weight"));

            driver.findElement(By.cssSelector("#box-campaigns li:nth-child(" + g + ") a.link")).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#box-product h1")));

//          Проверки
            g = g - 1;
//          проверка цвета основной странице
//          обычная цена зачёркнутая и серая на основной странице
            Assert.assertEquals("цвет цены не серый", regColorMainCampaigns.get(g), rgbaColorGray);
            Assert.assertTrue("цвет цены не зачеркнут", regDecorMainCampaigns.get(g).contains("line-through"));
//          акционная жирная и красная на основной странице
            Assert.assertEquals("цвет цены со скидкой не красный", campColorMainCampaigns.get(g), rgbaColorRed);
            Assert.assertEquals("цвет цены со скидкой не выделин жирным", campDecorMainCampaigns.get(g), boltTextSize);
//          акционная цена крупнее, чем обычная на основной странице
            Assert.assertTrue("цена со скидкой не выделена в размере с основной ценой",
                    Double.parseDouble(sizeRegPriceMainCampaigns.get(g).substring(0, sizeRegPriceMainCampaigns.get(g).length() - 2))
                            <
                            Double.parseDouble(sizeCampPriceMainCampaigns.get(g).substring(0, sizeCampPriceMainCampaigns.get(g).length() - 2)));

//          проверка цвета на странице товара
            String colorRegCampaigns = driver.findElement(By.cssSelector("#box-product s.regular-price")).getCssValue("color");
            String decorRegCampaigns = driver.findElement(By.cssSelector("#box-product s.regular-price")).getCssValue("text-decoration");
            String colorCampaigns = driver.findElement(By.cssSelector("#box-product strong.campaign-price")).getCssValue("color");
            String decorCampaigns = driver.findElement(By.cssSelector("#box-product strong.campaign-price")).getCssValue("font-weight");
//          обычная цена зачёркнутая и серая на странице товара
            Assert.assertEquals("цвет цены не серый", colorRegCampaigns, rgbaColorGray2);
            Assert.assertTrue("цвет цены не зачеркнут", decorRegCampaigns.contains("line-through"));
//          акционная жирная и красная на странице товара
            Assert.assertEquals("цвет цены со скидкой не красный", colorCampaigns, rgbaColorRed);
            Assert.assertEquals("цвет цены со скидкой не выделин жирным", decorCampaigns, boltTextSize);
//          акционная цена крупнее, чем обычная на странице товара
            double sizeRegPriceCampaigns = Double.parseDouble(
                    driver.findElement(By.cssSelector("#box-product s")).
                            getCssValue("font-size").
                            substring(0, driver.findElement(By.cssSelector("#box-product s")).
                                    getCssValue("font-size").length() - 2));
            double sizePriceCampaigns = Double.parseDouble(
                    driver.findElement(By.cssSelector("#box-product strong.campaign-price")).
                            getCssValue("font-size").
                            substring(0, driver.findElement(By.cssSelector("#box-product strong.campaign-price")).
                                    getCssValue("font-size").length() - 2));
            Assert.assertTrue("цена со скидкой не выделена в размере с основной ценой", sizeRegPriceCampaigns < sizePriceCampaigns);

//          на главной странице и на странице товара совпадает текст названия товара
            Assert.assertEquals(
                    "имя товара основной страницы не соответствует имени в описании товара",
                    nameMainCampaigns.get(g),
                    driver.findElement(By.cssSelector("#box-product h1")).getText());
//          на главной странице и на странице товара совпадают цены
            Assert.assertEquals(
                    "основная цена товара основной страницы не соответствует цене в описании товара",
                    regPriceMainCampaigns.get(g),
                    driver.findElement(By.cssSelector("#box-product s")).getText());
            Assert.assertEquals(
                    "цена со скидкой товара основной страницы не соответствует цене в описании товара",
                    campNameMainCampaigns.get(g),
                    driver.findElement(By.cssSelector("#box-product strong.campaign-price")).getText());
            g = g + 1;
            driver.get("http://localhost/litecart/en/");
        }
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}