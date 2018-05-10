package utils;
import org.openqa.selenium.WebDriver;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class Stash {
    private static Map<String, Object> stash = new HashMap<String, Object>();
    public static final String itemName = "itemName";


    public static Object get (String key){
        return stash.get(key);
    }

    public static void put(String key, Object value){
        stash.put(key, value);
    }

    public static WebDriver getDriver(){
        return (WebDriver) stash.get("driver");
    }

    public static void waitVisibilityOf(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }


}
