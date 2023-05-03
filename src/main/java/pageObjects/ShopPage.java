package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShopPage {

    public WebDriver driver;
    @FindBy(css = "#site-logo")
    private WebElement logo;
    @FindBy(css = "body")
    private static WebElement bodyElement;
    @FindBy(css = ".wpmenucartli > a")
    public WebElement basketLink;
    @FindBy (css = "#menu-item-40 > a")
    private WebElement shopLink;
    @FindBy (css = ".add_to_cart_button.ajax_add_to_cart")
    private WebElement addToBasket;
    By addToBasketButtonBy = By.cssSelector(".add_to_cart_button.ajax_add_to_cart");

    @FindBy (css = "#content >ul")
    private WebElement articleElements;

    @FindBy (css = "#woocommerce_product_categories-2 > h4")
    private WebElement selectPopularityBySelector;

    @FindBy (css = "#woocommerce_price_filter-2 > h4")
    private WebElement selectPriceBySelector;


    @FindBy (css = "a.button.product_type_simple.ajax_add_to_cart")
    private WebElement readMore;

    @FindBy (css = "a.button.wc-forward")
    private WebElement viewBasket;

    @FindBy (tagName = "html")
    private WebElement tagHtmlSelector;

    public ShopPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public void cliquerSurShop(){

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        shopLink.click();
    }
    public void cliquerSurAddToBasket(){

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Actions action =  new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        addToBasket.click();
    }
    public boolean verifierQueAddToBasketEstVisible(){
        return addToBasket.isDisplayed();
    }
    public boolean verifierQueReadMoreEstVisible(){
        return readMore.isDisplayed();
    }

    public boolean validerLapresenceListeArticle(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return articleElements.isDisplayed();
    }

    public void verifierQuePeuxAffinerArticleTheme(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        selectPopularityBySelector.isDisplayed();
    }

    public void verifierQuePeuxAffinerArticlePrix(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        selectPriceBySelector.isDisplayed();

    }


    public boolean verifierQueViewBasketEstVisible(){
        return viewBasket.isDisplayed();
    }

    public void cliquerSurViewBasket(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        viewBasket.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Actions action =  new Actions(driver);
        action.moveToElement(tagHtmlSelector);
        action.moveByOffset(-400, 0).click().build().perform();
    }


    public boolean checkVisibilityBasketLink(){
        return basketLink.isDisplayed();
    }

    public boolean checkVisibilityLogo(){
        return logo.isDisplayed();
    }

    public void clickBasketLink(){
        basketLink.click();
    }

    public static void scroll() {
        bodyElement.sendKeys(Keys.END);
    }




}
