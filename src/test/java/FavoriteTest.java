import Base.BaseTest;
import Pages.LoginPage;
import Pages.MainPage;
import Pages.ProductDetailPage;
import Pages.ProductListPage;
import org.testng.annotations.Test;

public class FavoriteTest extends BaseTest {

    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    ProductListPage productListPage = new ProductListPage();
    ProductDetailPage productDetailPage = new ProductDetailPage();//nesne tanımı yapıyoruz ki diğer classtan bilgi çekebilelim


    @Test
    public void favoriteTest(){
        loginPage.fillEmail(email)
                .fillPassword(password)
                .clickLoginButton();

        sleep(5000);

        mainPage.fillSearch("iphone 13 128 gb");

        sleep(5000);

        productListPage.closePopupIfPresent()  // Yeni eklenen pop-up kontrolü
                .firstProductClick();


        switchTab(1);//yukarıdaki işlemler yapıldıktan sonra hangi sayfanın aöılıp oradan devam edilmesini istiyorsak burada onu belirttik


        productDetailPage.favoriteButtonClick()
                .closeLocationPopup();
                //.approveButtonClick();


    }

}
