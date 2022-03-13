package Task19.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Page {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public Page(WebDriver webDriver) {
        this.driver = webDriver;
        wait = new WebDriverWait(webDriver, 10);
    }

    public void open(String string){
        driver.get(string);
    }

    boolean isElementPresent(WebDriver webDriver, By by) {
        return webDriver.findElements(by).size() > 0;
    }
}