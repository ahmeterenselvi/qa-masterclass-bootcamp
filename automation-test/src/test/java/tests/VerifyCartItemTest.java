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
@Feature("Sepet Doğrulama İşlemleri")
public class VerifyCartItemTest extends BaseTest {

    private final By cartIcon = By.id("sprite-cart-icon");
    private final By goToCartButton = By.id("js-cart");

    @Test(description = "Sepetteki ürün başlığının, detay sayfasındaki ile aynı olması")
    @Story("Pozitif senaryo: Ürün bilgisi sepete doğru yansıtılmalı")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Kullanıcı bir ürünü sepete ekler. Ürün detay sayfasındaki başlık ile sepet sayfasındaki başlık birebir aynı olmalıdır.")
    public void shouldVerifyProductTitleInCart() {
        CommonPage commonPage = new CommonPage(driver);

        commonPage.searchForProduct("Nietzsche");
        commonPage.addFirstProductToCart();

        String productTitleDetail = commonPage.getProductTitleFromDetailPage();
        System.out.println("Ürün Detay Sayfası Başlığı: " + productTitleDetail);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();

        try {
            WebElement goToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(goToCartButton));
            goToCartBtn.click();
        } catch (Exception e) {
            // Pop-up yok, zaten direkt sepete gidilmiş.
        }

        String productTitleCart = commonPage.getProductTitleFromCart();
        System.out.println("Sepetteki Ürün Başlığı: " + productTitleCart);

        Assert.assertEquals(productTitleCart.trim(), productTitleDetail.trim(),
                "Sepetteki ürün başlığı, ürün detay sayfasındaki ile aynı olmalı.");
    }
}
