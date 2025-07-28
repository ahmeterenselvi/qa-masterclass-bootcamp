package tests;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CommonPage;

import java.time.Duration;

@Epic("KitapYurdu Üyelik Modülü")
@Feature("Giriş (Login) İşlemleri")
public class LoginTest extends BaseTest {

    private final By userNameText = By.cssSelector(".account-details__infos--name");

    @Test(description = "Geçerli bilgilerle başarılı login işlemi")
    @Story("Pozitif senaryo: Doğru e-posta ve şifre ile giriş yapılabilmeli")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Kullanıcı 'otomasyonselvi@gmail.com' ve doğru şifre ile giriş yaptığında, kullanıcı adı görünmelidir.")
    public void shouldLoginSuccessfully() {
        attemptLogin("otomasyonselvi@gmail.com", "otomasyon123");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement userNameElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(userNameText));

        String actualUserName = userNameElement.getText().trim();
        Assert.assertEquals(actualUserName, "Otomasyon Deneme",
                "Giriş sonrası kullanıcı adı beklenildiği gibi değil.");
    }

    @Test(description = "Geçersiz e-posta ile login olmamalı")
    @Story("Negatif senaryo: Geçersiz e-posta")
    @Severity(SeverityLevel.NORMAL)
    @Description("Kullanıcı yanlış e-posta ve doğru şifre ile giriş yapmaya çalışır. Hata mesajı görüntülenmelidir.")
    public void loginInvalidEmailTest() {
        attemptLogin("asfasfa@gmail.com", "otomasyon123");
        assertLoginErrorDisplayed();
    }

    @Test(description = "Geçersiz şifre ile login olmamalı")
    @Story("Negatif senaryo: Geçersiz şifre")
    @Severity(SeverityLevel.NORMAL)
    @Description("Kullanıcı doğru e-posta ve yanlış şifre ile giriş yapmaya çalışır. Hata mesajı görüntülenmelidir.")
    public void loginInvalidPasswordTest() {
        attemptLogin("otomasyonselvi@gmail.com", "2152151");
        assertLoginErrorDisplayed();
    }

    private void attemptLogin(String email, String password) {
        CommonPage commonPage = new CommonPage(driver);
        commonPage.login(email, password);
    }

    private void assertLoginErrorDisplayed() {
        By errorMessageLocator = By.xpath("//*[contains(text(), 'E-Posta Adresi ya da şifreniz yanlış')]");
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
    }
}
