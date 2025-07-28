package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CommonPage;

import java.time.Duration;

@Epic("KitapYurdu Arama Modülü")
@Feature("Ürün Arama Fonksiyonu")
public class SearchTest extends BaseTest {

    private final By matchingResult = By.xpath(
            "//div[contains(@class, 'product-cr')]//div[@class='name']/a/span[" +
                    "contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZÇĞİÖŞÜ', 'abcdefghijklmnopqrstuvwxyzçğıöşü'), 'nietzsche')]"
    );

    @Test(description = "Arama sonucunda ilgili anahtar kelimeyi içeren ürün gelmeli")
    @Story("Pozitif senaryo: Anahtar kelime ile doğru ürün sonucu")
    @Severity(SeverityLevel.NORMAL)
    @Description("Kullanıcı arama alanına 'Nietzsche' yazar. Gelen sonuçlardan en az birinin başlığında bu kelime geçmelidir.")
    public void shouldReturnResultsContainingKeyword() {
        CommonPage commonPage = new CommonPage(driver);

        commonPage.searchForProduct("Nietzsche");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String bookTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(matchingResult)).getText().toLowerCase();

        Assert.assertTrue(bookTitle.contains("nietzsche"),
                "Search result does not contain the expected keyword. Found: " + bookTitle);
    }
}
