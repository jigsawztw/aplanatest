package pages;
import utils.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class ElectronixTV extends BasePage{
    @FindBy(xpath = "//li[@data-department='Электроника']/a[text()='Электроника']")
    WebElement electronixBtn;
    @FindBy(xpath = "//div[@class='catalog-menu__list']/a[text()='Телевизоры']")
    WebElement tvBtn;

    public ElectronixTV(){
        driver = Stash.getDriver();
        PageFactory.initElements(driver, this);
        electronixBtn.click();
        tvBtn.click();
    }
}
