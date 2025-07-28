package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CommonPage;

@Epic("KitapYurdu Keşif Modülü")
@Feature("En Çok Satan Kitaplar")
public class TopSellerTest extends BaseTest {

    @Test(description = "Haftalık en çok satan kitabın başlığı alınmalı")
    @Story("Pozitif senaryo: Haftalık top seller liste kontrolü")
    @Severity(SeverityLevel.MINOR)
    @Description("Kullanıcı 'Haftalık' sekmesindeki en çok satan kitabın başlığını alır. Başlık boş olmamalıdır.")
    public void shouldGetWeeklyTopSellerBook() {
        CommonPage commonPage = new CommonPage(driver);
        commonPage.goToTopSellersPage();
        String title = commonPage.getTopSellerBookTitle("Haftalık");
        System.out.println("Haftalık en çok satan kitap: " + title);
        Assert.assertFalse(title.isEmpty(), "Haftalık en çok satan kitap başlığı boş geldi.");
    }

    @Test(description = "Aylık en çok satan kitabın başlığı alınmalı")
    @Story("Pozitif senaryo: Aylık top seller liste kontrolü")
    @Severity(SeverityLevel.MINOR)
    @Description("Kullanıcı 'Aylık' sekmesindeki en çok satan kitabın başlığını alır. Başlık boş olmamalıdır.")
    public void shouldGetMonthlyTopSellerBook() {
        CommonPage commonPage = new CommonPage(driver);
        commonPage.goToTopSellersPage();
        String title = commonPage.getTopSellerBookTitle("Aylık");
        System.out.println("Aylık en çok satan kitap: " + title);
        Assert.assertFalse(title.isEmpty(), "Aylık en çok satan kitap başlığı boş geldi.");
    }

    @Test(description = "Yıllık en çok satan kitabın başlığı alınmalı")
    @Story("Pozitif senaryo: Yıllık top seller liste kontrolü")
    @Severity(SeverityLevel.MINOR)
    @Description("Kullanıcı 'Yıllık' sekmesindeki en çok satan kitabın başlığını alır. Başlık boş olmamalıdır.")
    public void shouldGetYearlyTopSellerBook() {
        CommonPage commonPage = new CommonPage(driver);
        commonPage.goToTopSellersPage();
        String title = commonPage.getTopSellerBookTitle("Yıllık");
        System.out.println("Yıllık en çok satan kitap: " + title);
        Assert.assertFalse(title.isEmpty(), "Yıllık en çok satan kitap başlığı boş geldi.");
    }
}
