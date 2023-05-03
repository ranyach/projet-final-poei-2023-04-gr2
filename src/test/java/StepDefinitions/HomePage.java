package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    @FindBy(css = ".wpmenucartli > a")
    public WebElement headerBasketLink;

    @FindBy(css = "#site-logo")
    public WebElement logo;

    @FindBy(css = "div.n2-ss-slide-background")
    WebElement homePageSelector;


    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public boolean checkVisibilityBasketLink() {
        return headerBasketLink.isDisplayed();
    }

    public boolean checkVisibilityLogo() {
        return logo.isDisplayed();
    }

    public void clickBasketLink() {
        headerBasketLink.click();
    }

    public void clickLogo() {
    }

    public boolean verifierQueJesuissurlaHomePage() {
        return homePageSelector.isDisplayed();
    }
}