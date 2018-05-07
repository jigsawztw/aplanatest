import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import java.util.concurrent.*;
import org.openqa.selenium.support.ui.*;
import static org.junit.Assert.*;
import org.openqa.selenium.support.*;


/**
 * @author  Osipov Ivan, student
 */
public class InsuranceTest2  extends BaseTest{

    @FindBy(xpath = "//span[@class='region-list__arrow']")
    WebElement regionButton;

    @FindBy(xpath = "//input[@placeholder='Введите название региона']")
    WebElement inputRegionField;

    @FindBy(xpath = "//span[@class='region-search-box__option']")
    WebElement optionElem;

    @FindBy(xpath = "//span[text()='Нижегородская область']")
    WebElement regionMainPage;

    @FindBy(xpath = "//div[@class='footer-info']")
    WebElement footerElem;

    @FindBy(xpath = "//div[@class='sbrf-div-list-inner --area bp-area footer-white']//span[@class='social__icon social__icon_type_fb']")
    WebElement facebook;
    @FindBy(xpath = "//div[@class='sbrf-div-list-inner --area bp-area footer-white']//span[@class='social__icon social__icon_type_yt']")
    WebElement youtube;
    @FindBy(xpath = "//div[@class='sbrf-div-list-inner --area bp-area footer-white']//span[@class='social__icon social__icon_type_tw']")
    WebElement twitter;
    @FindBy(xpath = "//div[@class='sbrf-div-list-inner --area bp-area footer-white']//span[@class='social__icon social__icon_type_vk']")
    WebElement vkontakte;
    @FindBy(xpath = "//div[@class='sbrf-div-list-inner --area bp-area footer-white']//span[@class='social__icon social__icon_type_ok']")
    WebElement odnoklassniki;
    @FindBy(xpath = "//div[@class='sbrf-div-list-inner --area bp-area footer-white']//span[@class='social__icon social__icon_type_ins']")
    WebElement instagramm;

    @Test
    public void Test() throws InterruptedException {
        PageFactory.initElements(driver,this);
        waitVisibilityOf(regionButton);                 //Ожидаем пока кнопка выбора региона будет видимой
        regionButton.click();                           //Кликаем по кнопке выбора региона
        waitVisibilityOf(inputRegionField);             //Ожидаем пока поле для ввода региона будет видимым
        inputRegionField.click();                       //Кликаем в поле ввода
        Inserting(inputRegionField,"Нижегородская область");    //Вводим текст  "Нижегородская область" в поле поиска

        optionElem.click();                          //Кликаем по предлагаемому результату
        assertEquals("Отображаемый регион не соответствует ожидаемому","Нижегородская область", regionMainPage.getText()); //Проверяем соответсвует ли регион выбранному
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);",footerElem); //Прокручиваем скролл до футера
        facebook.isDisplayed();                     //видим ли элемент
        youtube.isDisplayed();                      //видим ли элемент
        twitter.isDisplayed();                      //видим ли элемент
        vkontakte.isDisplayed();                    //видим ли элемент
        odnoklassniki.isDisplayed();                //видим ли элемент
        instagramm.isDisplayed();                   //видим ли элемент
        Thread.sleep(1000);                    // Задержка 1с
    }


}
