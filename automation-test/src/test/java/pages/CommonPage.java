package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By searchInput          = By.id("search-input");
    private final By firstProduct          = By.xpath("(//div[contains(@class,'product-cr')])[1]");
    private final By addToCartButton      = By.id("button-cart");
    private final By productTitleOnDetail = By.cssSelector("h1.pr_header__heading");
    private final By cartItemTitle        = By.cssSelector(".product-name");

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void searchForProduct(String keyword) {
        driver.findElement(searchInput).sendKeys(keyword, Keys.ENTER);
        wait.until(ExpectedConditions.elementToBeClickable(firstProduct));
    }

    public void addFirstProductToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(firstProduct)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    public String getProductTitleFromDetailPage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productTitleOnDetail)).getText();
    }

    public String getProductTitleFromCart() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartItemTitle)).getText();
    }

    public void goToTopSellersPage() {
        By topSellersButton = By.xpath("//a[contains(text(),'Çok Satan Kitaplar')]");
        wait.until(ExpectedConditions.elementToBeClickable(topSellersButton)).click();

        Actions actions = new Actions(driver);
        actions.moveByOffset(0, 0).perform();
    }

    public String getTopSellerBookTitle(String timeRange) {
        By timeTab = By.xpath("//a[@class='tag-options-swiper__option' and contains(normalize-space(text()), '" + timeRange + "')]");

        By firstBookTitle = By.xpath("(//div[contains(@class,'product-cr')])[1]//div[contains(@class,'name')]//span");

        WebElement tabElement = wait.until(ExpectedConditions.elementToBeClickable(timeTab));
        tabElement.click();

        return wait.until(ExpectedConditions.visibilityOfElementLocated(firstBookTitle)).getText().trim();
    }

    private final By cartIcon = By.id("sprite-cart-icon");

    public void openCartPage() {
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
        try {
            WebElement goToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("js-cart")));
            goToCartBtn.click();
        } catch (Exception e) {
            // Pop-up yoksa direkt sepet sayfasına gidilmiştir
        }
    }

    public String getEmptyCartMessage() {
        By emptyCartMsg = By.xpath("//div[contains(@class,'cart-empty-text')]//span[contains(text(),'Sepetinizde ürün bulunmamaktadır.')]");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emptyCartMsg)).getText().trim();
    }

    public void removeProductFromCart() {
        By trashButton = By.cssSelector(".cart-icon-trash");
        By confirmDelete = By.xpath("//button[contains(text(), 'Sil')]");

        wait.until(ExpectedConditions.elementToBeClickable(trashButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmDelete)).click();
    }

    public void login(String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'login')]/a")));
        loginButton.click();

        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-email")));
        WebElement passwordInput = driver.findElement(By.id("login-password"));
        WebElement submitBtn = driver.findElement(By.cssSelector("button[type='submit']"));

        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);

        wait.until(driver1 -> submitBtn.isEnabled() && submitBtn.getAttribute("style").contains("opacity: 1"));

        submitBtn.click();
    }


}
