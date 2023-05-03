package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage  {

    WebDriver driver;
    @FindBy(id = "menu-item-50")
    private WebElement myAccount;
    @FindBy(id = "menu-item-40")
    private WebElement shop;
    @FindBy(id = "dismiss-button")
    private WebElement btnCloseGoogleAd;

    @FindBy(css = "[name=aswift_7]")
    private WebElement firstIframeGoogleAd;

    @FindBy(css = "[name=ad_iframe]")
    private WebElement secondIframeGoogleAd;


    @FindBy(css = "#n2-ss-6 img")
    private WebElement homePageImg;

   // private  WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToLoginPage() {
       myAccount.click();

    }
    public void goToShopPage() {
        shop.click();

    }
    public void closeGoogleAds() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement iFrame = firstIframeGoogleAd;
        wait.until(ExpectedConditions.visibilityOf(iFrame));
        driver.switchTo().frame(iFrame);
        WebElement iFrame2 = secondIframeGoogleAd;

        wait.until(ExpectedConditions.visibilityOf(iFrame2));
        driver.switchTo().frame(iFrame2);


        wait.until(ExpectedConditions.elementToBeClickable(btnCloseGoogleAd));
        btnCloseGoogleAd.click();
        driver.switchTo().defaultContent();
    }
    public  boolean doesLogoRedirectToHomePage(){
       return homePageImg.isDisplayed();
    }

}
