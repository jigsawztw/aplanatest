import java.util.*;
import java.io.*;

/**
 * @author  Osipov Ivan, student
 */
public class TestProperties {
    private final Properties properties = new Properties();
    private static TestProperties INSTANCE = null;

    private TestProperties(){
        try {
            properties.load(new FileInputStream(new File("application.properties"))); //загружаем свойства из файла
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public static TestProperties getInstance(){
        if(INSTANCE==null){
            INSTANCE = new TestProperties();
        }
        return INSTANCE;
    }
    public Properties getProperties(){
        return properties;
    }
}
