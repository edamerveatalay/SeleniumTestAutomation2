package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class ProductDetailPage extends BaseTest {
    public ProductDetailPage favoriteButtonClick() {
        try {
            // Favori butonunu bulmak için geniş bir seçici kullanalım
            By favoriteButton = By.cssSelector("[class*='favorite'], [class*='heart'], [class*='i-heart']");
            By orangeFavoriteButton = By.cssSelector("[class='i-heart-orange']"); // Turuncu hali

            // Öncelikle turuncu (seçilmiş) olup olmadığını kontrol et
            boolean isOrange = !driver.findElements(orangeFavoriteButton).isEmpty();

            if (isOrange) {
                System.out.println("Favori butonu zaten turuncu, işlem yapılmayacak.");
            } else {
                // JavaScript ile scrolling yapalım
                WebElement element = driver.findElement(favoriteButton);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

                sleep(1000);

                // JavaScript ile tıklama yapalım
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

                System.out.println("Favori butonuna tıklandı.");
            }
        } catch (Exception e) {
            System.out.println("Favori butonuna tıklanırken hata: " + e.getMessage());
        }
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
            // Popup'ın görünmesini bekleyelim
            sleep(2000);

            // Önce popup'ın kendisini bulalım (varsa)
            By popupLocator = By.xpath("//div[contains(@class, 'popover') or contains(@class, 'modal')]");

            // Anladım butonunu daha genel bir seçiciyle bulalım
            By anladimButton = By.xpath("//*[text()='Anladım']");

            // JavaScript ile sayfayı aşağı kaydıralım (popup görünür olmayabilir)
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 250)");
            sleep(1000);

            // Butonu bulmaya çalışalım
            WebElement button = driver.findElement(anladimButton);

            // JavaScript ile butona tıklayalım (daha güvenilir)
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);

            System.out.println("Konum Seç popup'ı başarıyla kapatıldı.");
            sleep(1000); // Popup kapandıktan sonra kısa bir bekleme
        } catch (Exception e) {
            System.out.println("Popup kapatılırken hata: " + e.getMessage());
            // Hata durumunda yine de devam et
        }
        return this;
    }

}