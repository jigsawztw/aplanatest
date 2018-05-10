package pages;
import utils.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class Electronix extends BasePage{
    @FindBy(xpath = "//li[@data-department='Электроника']/a[text()='Электроника']")
    WebElement electronixBtn;


    public Electronix(){
        driver = Stash.getDriver();
        PageFactory.initElements(driver, this);
        electronixBtn.click();
    }
}
