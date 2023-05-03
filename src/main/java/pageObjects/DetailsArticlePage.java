package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DetailsArticlePage {

    public static WebDriver driver;


    @FindBy(css = ".wpmenucartli > a")
    public WebElement basketLink;

    @FindBy(css = "#site-logo")
    public WebElement logo;

    @FindBy(css = ".attachment-shop_single")
    WebElement articlePhotographie;

    @FindBy(css = "#tab-description")
    WebElement descriptionDetails;

    @FindBy(css = "p.price")
    WebElement articlePrice;

    @FindBy(css = ".in-stock")
    WebElement stock;

    @FindBy(css = ".single_add_to_cart_button")
    WebElement addToCartButton;

    @FindBy(css = ".quantity")
    WebElement quantityField;

    @FindBy(css = ".woocommerce-message")
    WebElement addedToBaksetMessage;

    @FindBy(css = ".wc-forward")
    WebElement viewBasketButton;

    By quantityBy = By.cssSelector(".quantity");

    @FindBy(css = " input[title=\"Qty\"]")
    private WebElement selectQuantity;




    public DetailsArticlePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean verifierNombreArticlevouluEst() {
        return  quantityField.isDisplayed();
    }

    public boolean verifierQueLestockDesArticlesEstVisible() {
        return stock.isDisplayed();
    }

    public boolean verifierQueAddToBasketEstVisible() {
        return addToCartButton.isDisplayed();
    }

    public void cliquerSurAddToCart() {
        addToCartButton.click();
    }

    public boolean verifierQueLeMessageEstPresent() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return addedToBaksetMessage.isDisplayed();
    }

    public boolean verifierQueLaDescriptionDeLarticleEstPresent() {
        return descriptionDetails.isDisplayed();
    }

    public boolean verifierQueLaPhotoDeLarticleEstPresent() {
        return articlePhotographie.isDisplayed();
    }

    public boolean verifierQueLePrixDeLarticleEstPresent() {
        return articlePrice.isDisplayed();
    }

    public boolean verifierQueLeLienViewBasketEstPresent() {
        return viewBasketButton.isDisplayed();
    }

    public boolean checkVisibilityBasketLink() {
        return basketLink.isDisplayed();
    }

    public boolean checkVisibilityLogo() {
        return logo.isDisplayed();
    }

    public void clickBasketLink() {
        basketLink.click();
    }

    public void clickLogo() {
        logo.click();
    }

    public void updateQuantity() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        selectQuantity.click();
    }

}