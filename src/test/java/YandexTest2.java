import pages.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BasePage;
import java.util.concurrent.TimeUnit;
import utils.*;
    public class YandexTest2  extends BasePage {

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
        public void yandexTestPhones() throws InterruptedException{
            new YandexMarketPage();
            new Electronix();
            new HeadPhones();
            SearchPage secondSearch = new SearchPage();
            secondSearch.setPriceFrom("5000");
            secondSearch.setChooseBrand("Sennheiser");
            secondSearch.showFiltered();
            secondSearch.changeCountOfResultsTo12();
            new SearchResultPage().saveName(1);
            secondSearch.search((String)Stash.get(Stash.itemName));
            new ItemPage().checkPos();
            //Thread.sleep(500);



        }
    }
