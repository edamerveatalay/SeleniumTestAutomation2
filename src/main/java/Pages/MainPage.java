package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;

public class MainPage extends BaseTest {
    public String getAccount() {
        return driver.findElements(By.cssSelector("[class='link-text']")).get(0).getText();
    }
}
