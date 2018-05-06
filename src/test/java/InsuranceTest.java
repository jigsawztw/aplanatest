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
public class InsuranceTest  extends BaseTest{


    @FindBy(xpath = "//*[contains(text(),'Страхование')]")
    WebElement insuranceElem;

    @FindBy(xpath = "//*[contains(text(),'ДМС')]")
    WebElement dmsElem;

    @FindBy(xpath = "//*[@id=\"rgs-main-context-bar\"]//a[@data-form='insuranceApplication']")
    WebElement buttonSendRequest;

    @FindBy(xpath = "//b[text()='Заявка на добровольное медицинское страхование']")
    WebElement requestPageTitle;

    @FindBy(xpath = "//input[@class='checkbox']")
    WebElement checkBox;

    @FindBy(id = "button-m")
    WebElement sendButton;

    @FindBy(name = "FirstName")
    WebElement fname;

    @FindBy(name = "LastName")
    WebElement lname;

    @FindBy(name = "MiddleName")
    WebElement mname;

    @FindBy(xpath = "//*[@id=\"applicationForm\"]/div[2]/div[5]/input")
    WebElement phone;

    @FindBy(name = "Email")
    WebElement email;

    @FindBy(name = "ContactDate")
    WebElement contactDate;

    @FindBy(name = "Comment")
    WebElement comm;

    @FindBy(xpath = "//*[text()='Эл. почта']/..//span[@class='validation-error-text']")
    WebElement errorInvalidEmail;


    @Test
    public void Test() throws InterruptedException{
        PageFactory.initElements(driver,this);
        insuranceElem.click();                         //Страхование
        dmsElem.click();                               //ДМС
        waitVisibilityOf(buttonSendRequest);          //Ожидаем, пока кнопка станет видимой
        waitClickableOf(buttonSendRequest);         //без этой функции порой тест вылетает.. не могу понять почему. Но с ним все вроде работает.
        buttonSendRequest.click();                     //Жмем кнопку "Отправить заявку"
        waitVisibilityOf(requestPageTitle);           //Ожидаем, пока кнопка станет видимой форма с шапкой "Заявка на добровольное медицинское страхование"
        assertEquals("Заявка на добровольное медицинское страхование", requestPageTitle.getText()); //проверяем, есть ли на загруженной форме "Заявка на добровольное медицинское страхование"
        Inserting(fname,person.getFirstName());     //Записываем в поле "Имя" имя заранее созданного рандомного Person
        Inserting(lname,person.getLastName());      //Записываем в поле "Фамилия" фамилию заранее созданного рандомного Person
        Inserting(mname,person.getMiddleName());    //Записываем в поле "Отчество" отчество заранее созданного рандомного Person
        Select region = new Select(driver.findElement(By.name("Region")));
        region.selectByValue("77");                 //Выбираем из выпадающего списка регион со значением "77" (Москва)
        Inserting(phone,"(962) 473-07-99");     //Записываем в поле "телефон" номер телефона
        Inserting(email,"qwertyqwerty");        //Записываем в поле "электронная почта" адрес ящика
        Inserting(contactDate,"05092018");      //Записываем в поле "желаемая дата для связи" дату
        Inserting(comm,"mycomment");            //Записываем в поле "комментарий" комментарий
        checkBox.click();                           //Ставим галочку в чекбокс
        sendButton.click();                         //Жмем кнопку отправить

        assertEquals(person.getLastName(), lname.getAttribute("value"));
        assertEquals(person.getMiddleName(), mname.getAttribute("value"));
        assertEquals(person.getFirstName(), fname.getAttribute("value"));
        assertEquals("Номер не соответствует введенному","+7 (962) 473-07-99", phone.getAttribute("value"));
        assertEquals("Почта не соответствует введенной","qwertyqwerty", email.getAttribute("value"));
        assertEquals("Дата не соответствует введенной","05.09.2018", contactDate.getAttribute("value"));
        assertEquals("Комментарий не соответствует введенному","mycomment", comm.getAttribute("value"));
        assertEquals("Регион не соответствует введенному","Москва", region.getAllSelectedOptions().get(0).getText());
        assertEquals("Почта неверное указана","Введите адрес электронной почты", errorInvalidEmail.getText());
        }

}
