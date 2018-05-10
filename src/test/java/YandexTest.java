import pages.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BasePage;
import java.util.concurrent.TimeUnit;
import utils.*;

public class YandexTest  extends BasePage {

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        Stash.put("driver", driver);

        driver.get("https://yandex.ru/");
    }


    @After
    public void shutDown(){
        Stash.getDriver().quit();
    }


    @Test
    public void yandexTestTV() throws InterruptedException{
        new YandexMarketPage();
        new ElectronixTV();
        SearchPage firstSearch = new SearchPage();
        firstSearch.setPriceFrom("20000");
        firstSearch.setChooseBrand("LG");
        firstSearch.setChooseBrand("Samsung");
        firstSearch.showFiltered();
        firstSearch.changeCountOfResultsTo12();
        new SearchResultPage().saveName(1);
        firstSearch.search((String)Stash.get(Stash.itemName));
        new ItemPage().checkPos();
        //Thread.sleep(500);



}
}
