package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

public class ShopPage extends  BasePage{


    @FindBy(css = "#wpmenucartli a")
    private WebElement iconeCart;
    @FindBy(css = ".post-165 .added_to_cart")
    private WebElement viewBasketLink;
    @FindBy(css = ".post-169")
    private WebElement firstProduct;

    @FindBy(id = "menu-item-40")
    private WebElement shopItemInMenu;

    @FindBy(css = ".post-165 .add_to_cart_button")
    private WebElement addToCartBtn;

    @FindBy(css = "[data-product_id='165']")
    private WebElement addToBasketBtn;

    @FindBy(css = ".post-169 a.ajax_add_to_cart")
    private WebElement readMoreBtn;

    @FindBy(css = ".post-169")
    private WebElement anOutOfStockArticle;
    @FindBy(css = ".stock.out-of-stock")
    private WebElement outOfStockTag;
    @FindBy(css = ".u-column2 h2")
    private WebElement shopTitle;
    @FindBy(css = ".cart_totals h2")
    private WebElement totalProductBasket;
    @FindBy(css = ".woocommerce-breadcrumb a")
        private WebElement homeTitleInShop;
    @FindBy(css = "[name=aswift_7]")
    private WebElement firstIframeGoogleAd;

    @FindBy(css = "[name=ad_iframe]")
    private WebElement secondIframeGoogleAd;
    @FindBy(id = "dismiss-button")
    private WebElement btnCloseGoogleAd;

    @FindBy(css = "body")
    private static WebElement bodyElement;

    @FindBy(css = ".products.masonry-done")
    private  List<WebElement> productsList;
    public ShopPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductListingGood(){
        Boolean check = true;
        for (int i=0; i<productsList.size(); i++){
         WebElement  product = productsList.get(i);
         boolean singleCheck = product.findElement(By.cssSelector("img")).isDisplayed() &&
                 product.findElement(By.cssSelector("h3")).isDisplayed() &&
                 product.findElement(By.cssSelector(".post-170 .amount")).isDisplayed();
         if(!singleCheck){
             return singleCheck;
         }
        }
            return check;
    }
    public boolean  checkShopPageIsDisplayed() {
        return homeTitleInShop.isDisplayed();
    }
    public String checkBasketIsDisplayed() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //scroll();
        wait.until(ExpectedConditions.visibilityOf(totalProductBasket));
        return totalProductBasket.getText();}
    public void clickOnCartIcon(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(iconeCart));
        iconeCart.click();
    }
    public boolean outOfStockIsDisplayed() {
        return outOfStockTag.isDisplayed();
    }
    public boolean isReaDMoreDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        scroll();
        return wait.until(ExpectedConditions.visibilityOf(readMoreBtn)).isDisplayed();

    }
    public void clickOnOutOfStockProduct(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        scroll();
        wait.until(ExpectedConditions.elementToBeClickable(anOutOfStockArticle)).click();

    }
    public boolean viewBasketLinkIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
           wait.until(ExpectedConditions.visibilityOf(viewBasketLink));

        return viewBasketLink.isDisplayed();

    }
    public  void addArticleToBasket(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        dezoomer(5);
        scroll();
        wait.until(ExpectedConditions.elementToBeClickable(addToBasketBtn));
        addToBasketBtn.click();
        zoomer(5);
    }
    public void goToFirstProduct(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        scroll();
        wait.until(ExpectedConditions.elementToBeClickable(firstProduct));
        firstProduct.click();
    }

    public void addProductToCartAndViewBasket(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        dezoomer(5);
        scroll();
        wait.until(ExpectedConditions.elementToBeClickable(addToBasketBtn));
        addToBasketBtn.click();
        wait.until(ExpectedConditions.visibilityOf(viewBasketLink));
        viewBasketLink.click();
        zoomer(5);
    }

    public void clickshop (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(shopItemInMenu));
        shopItemInMenu.click();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(firstIframeGoogleAd));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(secondIframeGoogleAd));
        wait.until(ExpectedConditions.elementToBeClickable(btnCloseGoogleAd));
        btnCloseGoogleAd.click();
        driver.switchTo().defaultContent();
       // new Actions(driver).moveByOffset(10, 10).click().build().perform();
       // driver.switchTo().defaultContent();

    }


    public static void scroll() {
      bodyElement.sendKeys(Keys.END);
    }

    public static void zoomer(int taille) {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < taille; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ADD);
            robot.keyRelease(KeyEvent.VK_ADD);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }
    }

    public static void dezoomer(int taille) {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < taille; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }
    }

}
