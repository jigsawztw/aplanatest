package pages;
import utils.*;
import java.util.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import java.util.stream.*;

public class SearchResultPage extends BasePage{


    private static final String cardListItemXpath = "//div[starts-with(@class, \"n-snippet-card2 i-bem\")]";
    @FindBy(xpath = cardListItemXpath)
    List<WebElement> results;

    public WebElement get(int x){
            return results.get(x);
        }

    public SearchResultPage(){
        driver = Stash.getDriver();
        PageFactory.initElements(driver, this);
    }


    public  SearchResultPage saveName(int position) {
        WebElement element = results.get(position);
        String fullItemName = element.findElement(By.xpath("//div[@class='n-snippet-card2__title']")).getText();
        Stash.put(Stash.itemName, fullItemName);
        return this;
    }



}
