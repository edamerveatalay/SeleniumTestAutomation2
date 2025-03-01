package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;


public class ProductListPage extends BaseTest {

    // Pop-up'ı kapatmak için sayfanın boş bir alanına tıkla
    public ProductListPage closePopupIfPresent() {
        // Eğer "kullanıcı yorumları" popup'ı varsa, boş alana tıkla
        if (driver.findElements(By.cssSelector("[class='popup']")).size() > 0) {
            System.out.println("Popup bulundu, kapatılıyor...");
            Actions actions = new Actions(driver);
            actions.moveByOffset(10, 10).click().perform();  // Sayfanın sol üst köşesine yakın bir yere tıkla
            sleep(1000); // Popup kapanması için bekleme süresi
        } else {
            System.out.println("Popup bulunamadı.");
        }
        return this;
    }

    public ProductListPage firstProductClick() {
        sleep(5000);
        driver.findElements(By.cssSelector("[class='p-card-wrppr with-campaign-view']")).get(0).click();
        return this;

    }
}
