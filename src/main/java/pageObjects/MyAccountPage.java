package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyAccountPage {
    WebDriver driver;
    @FindBy(css = "[name=register]")
    private WebElement registerBtn;

    //Locating Login Button
    @FindBy(css = "[name=login]")
    private WebElement loginBtn;
    @FindBy(id = "reg_email")
    private WebElement reg_email;

    @FindBy(id = "reg_password")
    private WebElement reg_password;

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "rememberme")
    private WebElement rememberMe;


    @FindBy(css = ".u-column2 h2")
    private WebElement registerTitle;

    @FindBy(css = ".u-column1 h2")
    private WebElement loginTitle;
    @FindBy(css = ".current-menu-item a")
    private WebElement myAccountItem;

    @FindBy(css = ".woocommerce-MyAccount-content")
    private WebElement welcomeText;

    @FindBy(css = ".woocommerce-password-strength.strong")
    private WebElement strenthPwdInformation;

    @FindBy(css = ".woocommerce-password-hint")
    private WebElement passwordHint;


    @FindBy(css = ".woocommerce-MyAccount-navigation-link--dashboard a")
    private WebElement dashboard;

    @FindBy(css = ".woocommerce-MyAccount-navigation-link--orders a")
    private WebElement orders;

    @FindBy(css = ".woocommerce-MyAccount-navigation-link--downloads a")
    private WebElement downloads;

    @FindBy(css = ".woocommerce-MyAccount-navigation-link--edit-address a")
    private WebElement adresses;

    @FindBy(css = ".woocommerce-MyAccount-navigation-link--edit-account a")
    private WebElement accountDetails;

    @FindBy(css = ".woocommerce-MyAccount-navigation-link--customer-logout a")
    private WebElement logout;


    @FindBy(css = ".woocommerce-error li")
    private WebElement loginErrorMsg;

    @FindBy(css = "div.woocommerce-MyAccount-content a[href*='customer-logout']")
    private WebElement signOut;

    @FindBy(css = "#site-logo a")
    private WebElement logo;

   // private WebDriver driver;


    public MyAccountPage(WebDriver driver) {
       this.driver = driver;
       PageFactory.initElements(driver, this);

    }

    public boolean checkRegisterIsDisplayed() {
       return registerTitle.isDisplayed();
    }
    public boolean checkLoginIsDisplayed() {
        return loginTitle.isDisplayed();
    }
    public boolean isRegisterBtnDisabled(){

        return !(registerBtn.isEnabled());
    }

    public void loginAction(String username, String pwd){
        this.username.sendKeys(username);
        password.sendKeys(pwd);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtn.click();
    }

    //Method that performs register action using the web elements
    public void registerWithStrongPasswordAction(String username, String pwd){
     reg_email.sendKeys(username);
        reg_password.sendKeys(pwd);
        reg_password.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(strenthPwdInformation));
        registerBtn.click();
    }

    public void registerWithWeakPasswordAction(String username, String pwd){
        reg_email.sendKeys(username);
        reg_password.sendKeys(pwd);
        reg_password.click();
    }
    public String isMyAccountTheCurrentItem(){

        return myAccountItem.getText();
    }

    public String welcomeTextInMyAccount(){
        return welcomeText.getText();
    }


    public String passwordHintText(){
        return passwordHint.getText();
    }

    public String loginErrorText(){
        return loginErrorMsg.getText();
    }
    public boolean doDashboardNavItemsLinksExist(){
        return dashboard.isDisplayed() &&
                orders.isDisplayed() &&
                downloads.isDisplayed() &&
                adresses.isDisplayed() &&
                accountDetails.isDisplayed() &&
                logout.isDisplayed();
    }

    public void checkRememberMe(){
        rememberMe.click();
    }
    public void loginAndRememberMeAction(String username, String pwd){
        this.username.sendKeys(username);
        password.sendKeys(pwd);
        checkRememberMe();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtn.click();
    }

    public void signOut(){
        signOut.click();
    }

    public String getValueofUsernameField(){
       return username.getAttribute("value");

    }
}
