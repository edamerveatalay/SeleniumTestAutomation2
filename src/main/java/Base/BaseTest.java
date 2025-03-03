package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends BaseLibrary {

    @BeforeMethod
    public void OpenBrowser(){
        driver = new ChromeDriver();
        driver.get("https://www.trendyol.com/giris");
        driver.manage().window().fullscreen();

    }



    //@AfterMethod
    //public void CloseBrowser() {
    //driver.quit();
    //}

}