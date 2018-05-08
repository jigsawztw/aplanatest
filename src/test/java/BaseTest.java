import org.junit.*;
import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import java.util.concurrent.*;
import org.openqa.selenium.support.ui.*;
import static org.junit.Assert.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.chrome.*;
/**
 * @author  Osipov Ivan, student
 */
public class BaseTest {
    protected static WebDriver driver;
    protected static String baseUrl;
    public static Properties properties =  TestProperties.getInstance().getProperties();
    static Person person;


    @BeforeClass
    public static void setUp() throws Exception{
        String s = properties.getProperty("browser");
        if (s.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
            driver = new FirefoxDriver();

        } else if (s.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        person = Person.getRandomPerson();
    }

    @AfterClass
    public static void tearDown() throws Exception{
        driver.quit();
    }
    /**
     * Метод, который ожидает видимости элемента
     */
    public static void waitVisibilityOf(WebElement webElement){
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.visibilityOf(webElement));
    }
    /**
     * Метод, который ожидает кликабельности элемента
     */
    public static void waitClickableOf(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /**
     * Метод, который заполняет значением str поле элемента x
     */
    public static void inserting(WebElement x, String str){
        x.clear();
        x.sendKeys(str);
    }
}
