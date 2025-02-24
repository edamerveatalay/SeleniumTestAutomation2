import Base.BaseTest;
import Pages.LoginPage;
import Pages.MainPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTest extends BaseTest {

LoginPage loginPage = new LoginPage();
MainPage mainPage = new MainPage();
    @Test
    public void loginSuccessful() {
        loginPage.fillEmail(email)
                 .fillPassword(password)
                 .clickLoginButton();
        sleep(5000);

        Assert.assertEquals(mainPage.getAccount(),"Hesabım");
    }
    @Test
    public void LoginUnsuccessful() {
        loginPage.fillEmail(email)
                        .fillPassword(password+"44")
                                .clickLoginButton();
        sleep(5000);
        Assert.assertEquals(loginPage.getErrorMessage(), "E-posta adresiniz ve/veya şifreniz hatalı.");
    }


}
