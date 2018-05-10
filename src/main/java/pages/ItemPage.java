package pages;
import utils.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.junit.*;
public class ItemPage  extends BasePage{

    @FindBy(xpath = "//div[@class='n-title__text']/h1")
    WebElement titleTextField;

    @FindBy(xpath = "//div[@class='n-product-price-cpa2']")
    WebElement priceTextField;

    public ItemPage (){
        driver = Stash.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void checkPos(){
        String expectedName = (String) Stash.get(Stash.itemName);
        Stash.waitVisibilityOf(driver.findElement(By.xpath("//h1[@class='title title_size_28 title_bold_yes']")));
        String factName = driver.findElement(By.xpath("//h1[@class='title title_size_28 title_bold_yes']")).getText();
        Assert.assertEquals("Название товара не соответствует запомненному", expectedName, factName);
    }
}
