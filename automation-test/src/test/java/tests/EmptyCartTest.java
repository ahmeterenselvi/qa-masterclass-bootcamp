package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CommonPage;

@Epic("KitapYurdu Alışveriş Modülü")
@Feature("Sepet Fonksiyonları")
public class EmptyCartTest extends BaseTest {

    @Test(description = "Boş sepet mesajının doğru görüntülenmesi")
    @Story("Negatif senaryo: Hiç ürün eklenmeden sepete gidildiğinde uyarı mesajı çıkmalı")
    @Severity(SeverityLevel.NORMAL)
    @Description("Kullanıcı sepete hiç ürün eklemeden direkt sepete gider. Sistem, 'Sepetinizde ürün bulunmamaktadır.' uyarısını doğru göstermelidir.")
    public void shouldDisplayEmptyCartMessageWhenCartIsNotUsed() {
        CommonPage commonPage = new CommonPage(driver);
        commonPage.openCartPage();

        String message = commonPage.getEmptyCartMessage();
        Assert.assertEquals(message, "Sepetinizde ürün bulunmamaktadır.",
                "Boş sepet mesajı beklenildiği gibi görüntülenmedi.");
    }
}
