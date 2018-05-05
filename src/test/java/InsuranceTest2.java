import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import java.util.concurrent.*;
import org.openqa.selenium.support.ui.*;
import static org.junit.Assert.*;
public class InsuranceTest2 {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\aplana\\AutoTestFirstTry\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void Testing() throws InterruptedException {
        driver.navigate().to("http://www.sberbank.ru/ru/person");
        Wait<WebDriver> wait = new WebDriverWait(driver,4,1000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='region-list__arrow']"))));
        driver.findElement(By.xpath("//span[@class='region-list__arrow']")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@placeholder='Введите название региона']"))));
        driver.findElement(By.xpath("//input[@placeholder='Введите название региона']")).click();
        Inserting(By.xpath("//input[@placeholder='Введите название региона']"),"Нижегородская область");

        driver.findElement(By.xpath("//span[@class='region-search-box__option']")).click();
        assertEquals("Нижегородская область", driver.findElement(By.xpath("//span[text()='Нижегородская область']")).getText());
        WebElement webElement = driver.findElement(By.xpath("//div[@class='footer-info']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);",webElement);
        Thread.sleep(3000);
    }
    public void Inserting(By x,String str){
        driver.findElement(x).clear();
        driver.findElement(x).sendKeys(str);
    }
    @After
    public void tearsDown(){
        driver.quit();
    }

}
