import Base.BaseTest;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTest extends BaseTest {

LoginPage loginPage = new LoginPage();
    @Test
    public void loginSuccessful() throws InterruptedException {
        loginPage.fillEmail(email).fillPassword(password);
        driver.findElement(By.cssSelector("[class='q-primary q-fluid q-button-medium q-button submit']")).click();
        Thread.sleep(5000);
        String text =driver.findElements(By.cssSelector("[class='link-text']")).get(0).getText();
        System.out.println(text);
        Assert.assertEquals(text,"Hesabım");
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
