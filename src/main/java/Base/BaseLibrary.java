package Base;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class BaseLibrary extends Data{
    public static WebDriver driver;

    public void sleep (int millis) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void switchTab(int index){
        List<String> Tabs = new ArrayList<>(driver.getWindowHandles());//birden çok sekme açıldığını belirten bir koda
        driver.switchTo().window(Tabs.get(index));
    }
}
