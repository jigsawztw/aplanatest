package pages;
import utils.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;

public class SearchPage  extends BasePage{


    private static final String  patternSearch = "//a[@class='n-filter-block__item-link']";

    @FindBy(xpath = "//a[@data-reactid='659']")
    WebElement allFiltersBtn;
    @FindBy(xpath = "//input[@name='glf-pricefrom-var']")
    WebElement inputPriceFrom;
    @FindBy(xpath = "//a[@class='button button_size_l button_theme_pseudo i-bem button_action_show-filtered n-filter-panel-extend__controll-button_size_big button_js_inited']")
    WebElement showFilteredBtn;
    @FindBy(xpath = "//input[@id='header-search']")
    WebElement headerSearch;
    @FindBy(xpath = "//span[@class='search2__button']")
    WebElement searchBtn;

    @FindBy(xpath = "//span[@data-bem='{\"select\":{\"textAll\":\"Показать все\"}}']")
    WebElement changeCountOfResultsBtn;
    @FindBy(xpath = "//span[@class ='select__text' and contains(text(),'Показывать по 12')]")
    WebElement selectCountOfResTo12;



    public SearchPage(){

            driver = Stash.getDriver();
            PageFactory.initElements(driver, this);
            Stash.waitVisibilityOf(allFiltersBtn);
            allFiltersBtn.click();
            inputPriceFrom.click();
        }
    public void setPriceFrom(String parameter){
        Stash.waitVisibilityOf(inputPriceFrom);
        inputPriceFrom.sendKeys(parameter);
    }
    public void setChooseBrand(String brand){
        WebElement brandElement = driver.findElement(By.xpath(patternSearch + "//label[text()='"+brand+"']"));
        Stash.waitVisibilityOf(brandElement);
        brandElement.click();
    }
    public void showFiltered(){
        Stash.waitVisibilityOf(showFilteredBtn);
        showFilteredBtn.click();
    }
    public void changeCountOfResultsTo12(){
        Stash.waitVisibilityOf(changeCountOfResultsBtn);
        changeCountOfResultsBtn.click();
        Stash.waitVisibilityOf(selectCountOfResTo12);
        selectCountOfResTo12.click();
    }
    public void search(String request){
        headerSearch.click();
        headerSearch.sendKeys(request);
        searchBtn.click();

    }






    }
