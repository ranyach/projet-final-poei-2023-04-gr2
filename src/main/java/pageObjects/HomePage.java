package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    // css locators on home page
    @FindBy(id = "menu-item-50")
    private WebElement myAccount;
    @FindBy(id = "menu-item-40")
    private WebElement shop;

    @FindBy(css = "#n2-ss-6 img")
    private WebElement homePageImg;
    @FindBy(id = "dismiss-button")
    private WebElement btnCloseGoogleAd;

    @FindBy(css = "[name=aswift_7]")
    private WebElement firstIframeGoogleAd;

    @FindBy(css = "[name=ad_iframe]")
    private WebElement secondIframeGoogleAd;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Method navigate to Login page
    public void goToLoginPage() {
        myAccount.click();

    }

    public void goToShopPage() {
        shop.click();

    }

    public void closeGoogleAds() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(firstIframeGoogleAd));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(secondIframeGoogleAd));
        wait.until(ExpectedConditions.elementToBeClickable(btnCloseGoogleAd));
        btnCloseGoogleAd.click();
        driver.switchTo().defaultContent();

    }

    public boolean doesLogoRedirectToHomePage() {
        return homePageImg.isDisplayed();
    }

}
