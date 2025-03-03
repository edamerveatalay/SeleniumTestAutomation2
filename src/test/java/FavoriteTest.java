import Base.BaseTest;
import Pages.LoginPage;
import Pages.MainPage;
import Pages.ProductDetailPage;
import Pages.ProductListPage;
import io.qameta.allure.*;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class FavoriteTest extends BaseTest {

    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    ProductListPage productListPage = new ProductListPage();
    ProductDetailPage productDetailPage = new ProductDetailPage();//nesne tanımı yapıyoruz ki diğer classtan bilgi çekebilelim


    @Test
    @Description("Kullanıcı iphone 13 aratır ve ilk ürünü favoriye ekler")  // Testin açıklaması
    @Severity(SeverityLevel.CRITICAL) // Öncelik seviyesi
    public void favoriteTest(){
        loginPage.fillEmail(email)
                .fillPassword(password)
                .clickLoginButton();

        sleep(3000);

        mainPage.fillSearch("iphone 13 128 gb");

        sleep(3000);

        productListPage.closePopupIfPresent()  // Yeni eklenen pop-up kontrolü
                .firstProductClick();


        switchTab(1);//yukarıdaki işlemler yapıldıktan sonra hangi sayfanın aöılıp oradan devam edilmesini istiyorsak burada onu belirttik

        sleep(2000);

        productDetailPage.closeLocationPopup();

        sleep(1000);

        productDetailPage.favoriteButtonClick();
                //.closeLocationPopup();
                //.approveButtonClick();


    }

}
