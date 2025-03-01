package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class ProductDetailPage extends BaseTest {
    public ProductDetailPage favoriteButtonClick() {
        driver.findElement(By.cssSelector("[class='product-container'] [class='i-heart']")).click();
        return this;
    }

   /* public ProductDetailPage approveButtonClick(){
        driver.findElement(By.cssSelector("[class='onboarding-popover__default-renderer-primary-button']")).click();
        return this;
    }*/

    /**
     * Sayfa açıldığında çıkabilecek 'Konum Seç' popup'ını kapatır.
     * Eğer popup çıkmazsa, hata almadan devam eder.
     */
    public ProductDetailPage closeLocationPopup() {
        try {
            // 'Anladım' butonunu bul - Burada XPath kullandım çünkü bu tip dinamik popup'larda genellikle daha stabil olur.
            By anladimButton = By.xpath("//button[contains(text(),'Anladım')]");

            // Eğer element varsa ekrana scroll yapalım
            WebElement element = driver.findElement(anladimButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

            // Scroll sonrası bekleme (gerekirse dinamik wait de eklenebilir)
            sleep(1000);

            // Tıkla
            element.click();

            System.out.println("Konum Seç popup'ı kapatıldı.");
        } catch (Exception e) {
            // Popup çıkmadıysa buraya düşer, sorun değil.
            System.out.println("Konum Seç popup'ı görünmedi, devam ediliyor...");
        }
        return this;
    }
}