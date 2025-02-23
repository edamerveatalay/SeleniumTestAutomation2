package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;

public class LoginPage extends BaseTest {
    public LoginPage fillEmail (String email) {
        driver.findElement(By.id("login-email")).sendKeys(email);
        return this;
    }
    public LoginPage fillPassword (String password) {
        driver.findElement(By.name("login-password")).sendKeys(password);
        return this;
    }

    public LoginPage clickLoginButton () {
        driver.findElement(By.cssSelector("[class='q-primary q-fluid q-button-medium q-button submit']")).click();
        return this;
    }

    }
