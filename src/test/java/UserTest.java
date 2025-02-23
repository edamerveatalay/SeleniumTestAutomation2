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
                 .clickLoginButton();a
        sleep(5000);

        Assert.assertEquals(mainPage.getAccount(),"Hesabım");
    }
    @Test
    public void LoginUnsuccessful() throws InterruptedException {
        driver.findElement(By.id("login-email")).sendKeys(email);
        driver.findElement(By.name("login-password")).sendKeys("testeda123.");
        driver.findElement(By.cssSelector("[class='q-primary q-fluid q-button-medium q-button submit']")).click();
        Thread.sleep(5000);
        System.out.println(driver.findElement(By.cssSelector("[class='message']")).getText());
        Assert.assertEquals(driver.findElement(By.cssSelector("[class='message']")).getText(), "E-posta adresiniz ve/veya şifreniz hatalı.");
    }


}
