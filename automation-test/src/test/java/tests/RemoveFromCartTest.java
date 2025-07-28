package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CommonPage;

@Epic("KitapYurdu Alışveriş Modülü")
@Feature("Sepet Fonksiyonları")
public class RemoveFromCartTest extends BaseTest {

    @Test(description = "Sepet sayfasından ürün silindiğinde sepetin boş olduğu kontrol edilir")
    @Story("Pozitif senaryo: Ürün silindikten sonra sepetin boş kalması")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Bir ürün sepete eklendikten sonra, kullanıcı sepet sayfasına gider ve ürünü siler. Sistem sepetin boş olduğunu göstermelidir.")
    public void shouldRemoveProductFromCartViaCartPage() {
        CommonPage commonPage = new CommonPage(driver);

        commonPage.searchForProduct("Nietzsche");
        commonPage.addFirstProductToCart();
        commonPage.openCartPage();
        commonPage.removeProductFromCart();

        String message = commonPage.getEmptyCartMessage();

        Assert.assertEquals(message, "Sepetinizde ürün bulunmamaktadır.",
                "Ürün silinmesine rağmen sepet boş görünmüyor.");
    }
}
