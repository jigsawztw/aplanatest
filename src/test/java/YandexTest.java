import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

public class YandexTest {

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        Stash.put("driver", driver);
        driver.get("https://yandex.ru/");
    }


    @After
    public void shutDown(){
        Stash.getDriver().quit();
    }


    @Test
    public void search_ipad_and_check_price() {
        new SearchPage()
                .searchByName(itemName)
                .savePriceAndName(1)
                .chooseItemByPosition(1)
                .checkPriceAndName();
    }

}
}
