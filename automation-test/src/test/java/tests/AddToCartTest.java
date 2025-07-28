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

@Epic("KitapYurdu Alışveriş Modülü")
@Feature("Sepete Ekleme Fonksiyonu")
public class AddToCartTest extends BaseTest {

    private final By successPopup = By.xpath(
            "//div[contains(@class,'swal2-popup') and contains(@class,'swal2-toast') and contains(@class,'swal2-show')]"
    );

    @Test(description = "İlk kitabın sepete başarıyla eklenmesi")
    @Story("Pozitif senaryo: Kitap sepete eklenebilmeli")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Arama alanına 'Nietzsche' yazılıp ilk çıkan kitap sepete eklenir. Sepete başarıyla eklendiğine dair popup kontrol edilir.")
    public void shouldAddFirstBookToCartSuccessfully() {
        CommonPage commonPage = new CommonPage(driver);
        commonPage.searchForProduct("Nietzsche");
        commonPage.addFirstProductToCart();

        WebElement popup = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(successPopup));

        Assert.assertTrue(popup.isDisplayed(), "Success pop-up did not appear.");
    }
}
