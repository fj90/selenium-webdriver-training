package Task19;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class Task19 {

    private Application application;

    @Before
    public void beforeTest() {
        application = new Application();
    }

    @After
    public void afterTest() {
        application.quit();
        application = null;
    }

    @Test
    public void ProductBasket() {
        application.openMainPage();
        for (int i = 0; i < 3; i++) {
            application.addProduct();
        }
        application.clearBasket();
    }
}