import Base.BaseTest;
import Pages.LoginPage;
import org.testng.annotations.Test;

public class FavouriteTest extends BaseTest {

    LoginPage loginPage = new LoginPage();

    @Test
    public void favouriteTest(){
        loginPage.fillEmail(email)
                .fillPassword(password)
                .clickLoginButton();


    }

}
