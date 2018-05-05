import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import java.util.concurrent.*;
import org.openqa.selenium.support.ui.*;
import static org.junit.Assert.*;

public class InsuranceTest {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\aplana\\AutoTestFirstTry\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public void Inserting(By x,String str){
        driver.findElement(x).clear();
        driver.findElement(x).sendKeys(str);
    }
    @Test
    public void Testing() throws InterruptedException{
        driver.navigate().to("https://www.rgs.ru/");
        WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Страхование')]"));
        element.click();
        driver.findElement(By.xpath("//*[contains(text(),'ДМС')]")).click();
        Wait<WebDriver> wait = new WebDriverWait(driver,5,1000);
            wait.until(ExpectedConditions.visibilityOf( driver.findElement(By.xpath("//*[@id=\"rgs-main-context-bar\"]/div/div/div/a[3]"))));
            driver.findElement(By.xpath("//*[@id=\"rgs-main-context-bar\"]/div/div/div/a[3]")).click();
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/div[7]/div/div/div/div[1]/h4/b"))));
            assertEquals("Заявка на добровольное медицинское страхование", driver.findElement(By.xpath("/html/body/div[7]/div/div/div/div[1]/h4/b")).getText());

            Inserting(By.name("FirstName"),"Иван");
            Inserting(By.name("LastName"),"Осипов");
            Inserting(By.name("MiddleName"),"Владимирович");

            Select select  = new Select(driver.findElement(By.name("Region")));
            select.selectByValue("77");

            Inserting(By.xpath("//*[@id=\"applicationForm\"]/div[2]/div[5]/input"),"(962) 473-07-99");
            Inserting(By.name("Email"),"qwertyqwerty");
            Inserting(By.name("ContactDate"),"05052018");
            Inserting(By.name("Comment"),"mycomment");

            driver.findElement(By.cssSelector("input.checkbox")).click();

            driver.findElement(By.id("button-m")).click();

            assertEquals("Осипов", driver.findElement(By.name("LastName")).getAttribute("value"));
            assertEquals("Владимирович", driver.findElement(By.name("MiddleName")).getAttribute("value"));
            assertEquals("Иван", driver.findElement(By.name("FirstName")).getAttribute("value"));
            assertEquals("+7 (962) 473-07-99", driver.findElement(By.xpath("//*[@id=\"applicationForm\"]/div[2]/div[5]/input")).getAttribute("value"));
            assertEquals("qwertyqwerty", driver.findElement(By.name("Email")).getAttribute("value"));
            assertEquals("05.05.2018", driver.findElement(By.name("ContactDate")).getAttribute("value"));
            assertEquals("mycomment", driver.findElement(By.name("Comment")).getAttribute("value"));
            assertEquals("Москва",
                    new Select(driver.findElement(By.name("Region"))).getAllSelectedOptions().get(0).getText());
            assertEquals("Введите адрес электронной почты",
                    driver.findElement(By.xpath("//*[text()='Эл. почта']/..//span[@class='validation-error-text']")).getText());
        }


    @After
    public void tearDown(){
        driver.close();
    }
}
