package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    //locating logo
    @FindBy(css = "#site-logo a")
    private WebElement logo;
    WebDriver driver;


    // Constructor dor BasePage instantiation via initElements
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    // click on logo
    public void clickOnLogo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(logo));
        logo.click();
    }

    // check logo visibility
    public boolean doesLogoExists() {
        return logo.isDisplayed();
    }


}
