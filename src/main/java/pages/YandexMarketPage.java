package pages;
import utils.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexMarketPage  extends BasePage{
    @FindBy(xpath = "//a[@data-id='market']")
    WebElement marketBtn;

    public YandexMarketPage(){
        driver = Stash.getDriver();
        PageFactory.initElements(driver, this);
        marketBtn.click();
    }


}


