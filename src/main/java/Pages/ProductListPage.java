package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;

public class ProductListPage extends BaseTest {

    public ProductListPage firstProductClick() {

        driver.findElements(By.cssSelector("[class='p-card-wrppr with-campaign-view']")).get(0).click();
        return this;

    }
}
