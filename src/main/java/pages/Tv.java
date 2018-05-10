package pages;
import utils.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tv extends BasePage{

    @FindBy(xpath = "//div[@class='catalog-menu__list']/a[text()='Телевизоры']")
    WebElement tvBtn;

    public Tv(){
        driver = Stash.getDriver();
        PageFactory.initElements(driver, this);
        tvBtn.click();
    }
}
