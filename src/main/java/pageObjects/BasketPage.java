package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasketPage {

    public WebDriver driver;
    @FindBy(css = ".wpmenucartli > a")
    public WebElement basketLink;

    @FindBy(css = "#site-logo")
    public WebElement logo;

    @FindBy(css = ".shop_table")
    WebElement summaryBasket;

    @FindBy(css = ".quantity")
    WebElement quantity;

    @FindBy(css = "td.product-price")
    WebElement articlePrice;

    // prix total par article
    @FindBy(css = "td.product-subtotal")
    WebElement articleTotalPrice;

    @FindBy(css = "a[class=remove]")
    WebElement deleteButton;

    @FindBy(css = "input[name = coupon_code]")
    WebElement couponCodeField;

    @FindBy(css = "div.coupon > .button")
    WebElement applyCodeButton;

    @FindBy(css = "p[class=cart-empty]")
    WebElement emptyMessage;

    //prix total de tout le panier
    @FindBy(css = "tr.cart-subtotal > td >.amount")
    WebElement basketTotalPrice;

    @FindBy(css = "tr.tax-rate > td >.amount")
    WebElement tax;

    //prix total du panier taxé
    @FindBy(css = "tr.order-total > td > strong >.amount")
    WebElement taxedTotalPrice;

    By quantityBy = By.cssSelector(".quantity");

    @FindBy(css = ".wc-forward")
    WebElement viewBasketButton;

    @FindBy (tagName = "html")
    private WebElement tagHtmlSelector;

    @FindBy (css = " td.product-thumbnail > a")
    private WebElement imageSelector;
    @FindBy (css = "div.woocommerce > form")
    private WebElement basketSelector;
    @FindBy (css = "td.product-name > a")
    private WebElement libelleSelector;

    @FindBy (css = "td.product-price > span")
    private WebElement priceSelector;



    public BasketPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void cliquerSurApplyCoupon() {
        applyCodeButton.click();
    }

    public boolean verifierQueApplyCouponEstVisible() {
        return applyCodeButton.isDisplayed();
    }

    public boolean verifierQueLePrixTotalEstVisible() {
        return articleTotalPrice.isDisplayed();
    }

    public boolean verifierQueLePrixTotalEstVisibleDansLePanier() {
        return basketTotalPrice.isDisplayed();
    }

    public boolean verifierQueLePrixDeLarticleEstVisible() {
        return articlePrice.isDisplayed();
    }

    public boolean verifierQueLeDeleteButtonEstVisible() {

        return deleteButton.isDisplayed();
    }

    public boolean verifierQueNoussommesDansLaPagePanier() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Actions action =  new Actions(driver);
        action.moveToElement(tagHtmlSelector);
        action.moveByOffset(-400, 0).click().build().perform();

        return basketSelector.isDisplayed();
    }
    public boolean verifierQueLeLibelleEstPresent() {
        return libelleSelector.isDisplayed();
    }
    public boolean verifierQueLePrixEstPresent() {
        return priceSelector.isDisplayed();
    }


    public boolean verifierQueSummaryBasketIsVisible() {
        return summaryBasket.isDisplayed();
    }

    public boolean verifierQueUpdateQuantityIsVisible() {
        return quantity.isDisplayed();
    }

    public boolean verifierQueCouponCodeFieldIsVisible() {
        return couponCodeField.isDisplayed();
    }

    public boolean verifierQueLePrixTotalApresTaxeIsVisible() {
        return taxedTotalPrice.isDisplayed();
    }

    public boolean checkVisibilityBasketLink() {
        return basketLink.isDisplayed();
    }

    public boolean checkVisibilityLogo() {
        return logo.isDisplayed();
    }

    public boolean verifierQueImageEStVisible() {
        return imageSelector.isDisplayed();
    }

    public void clickBasketLink() {
        basketLink.click();
    }

    public void clickLogo() {
        logo.click();
    }

    public boolean verifierQueLeChampsTaxEstVisible() {
        return tax.isDisplayed();
    }

    public Object updateQuantity(int productIndex, int newQuantity) {
        WebElement quantitySelectTag = driver.findElements(quantityBy).get(productIndex);
        Select dropdownQuantity = new Select(quantitySelectTag);
        dropdownQuantity.selectByIndex(newQuantity);
        return this;
    }

    public boolean verifierQueLaQuantiteEstVisible() {
        return quantity.isDisplayed();
    }
    public void jeCliqueSurViewbasket() {

        viewBasketButton.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Actions action =  new Actions(driver);
        action.moveToElement(tagHtmlSelector);
        action.moveByOffset(-400, 0).click().build().perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public boolean verifierQueLeMessageDeSuppressionEstVisible() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return emptyMessage.isDisplayed();
    }
    public void suppressionArticle() {
        deleteButton.click();
        Actions action =  new Actions(driver);
        action.moveToElement(tagHtmlSelector);
        // Click at an offset of 400px to the left of the element
        action.moveByOffset(-400, 0).click().build().perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateQuantity() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        quantity.click();
    }


}
