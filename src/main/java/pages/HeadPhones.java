package pages;
import utils.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class HeadPhones extends BasePage{


        @FindBy(xpath = "//div[@class='catalog-menu__list']/a[text()='Наушники и Bluetooth-гарнитуры']")
        WebElement headPhonesBtn;

        public HeadPhones(){
            driver = Stash.getDriver();
            PageFactory.initElements(driver, this);
            headPhonesBtn.click();
        }
    }
