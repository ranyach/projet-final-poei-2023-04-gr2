package StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageObjects.*;

public class HomeStepdefs {

    String url = "https://practice.automationtesting.in/";
    HomePage homePage;

    public HomeStepdefs() {
        homePage = new HomePage(Hooks.driver);
    }

    @Given("J ouvre l application")
    public void jOuvreLApplication() {
        Hooks.driver.get(url);
    }

    @When("Je vais dans l espace My account")
    public void jeVaisDansLEspaceMyAccount() {
        homePage.goToLoginPage();
        homePage.closeGoogleAds();
    }

    @Given("Je suis sur le pavé Register")
    public void jeSuisSurLePavéRegister() {
        Hooks.driver.get(url);
        homePage.goToLoginPage();
        homePage.closeGoogleAds();
    }

    @And("Je suis dans l espace My account")
    public void jeSuisDansLEspaceMyAccount() {
        homePage.goToLoginPage();
        homePage.closeGoogleAds();
    }

    @When("je vais sur la page {string}")
    public void jeVaisSurLaPage(String pageName) {

        ShopPage shop = new ShopPage(Hooks.driver);

        switch (pageName) {
            case "Home":
                break;
            case "My Account":
                homePage.goToLoginPage();
                homePage.closeGoogleAds();
                break;
            case "Cart":
                homePage.goToShopPage();
                homePage.closeGoogleAds();
                shop.addProductToCartAndViewBasket();

                break;
            case "Product":
                homePage.goToShopPage();
                homePage.closeGoogleAds();
                shop.goToFirstProduct();
                break;
            case "Shop":
                homePage.goToShopPage();
                homePage.closeGoogleAds();
            default:
                break;
        }
    }

    @Then("le logo <AT> est présent sur la page {string}")
    public void leLogoATEstPrésentSurLaPage(String pageName) {
        BasePage p;
        switch (pageName) {
            case "Home":
                p = this.homePage;
                Assert.assertTrue("Le logo n'existe pas sur la page " + pageName, p.doesLogoExists());
                break;
            case "My Account":
                p = new MyAccountPage(Hooks.driver);
                Assert.assertTrue("Le logo n'existe pas sur la page " + pageName, p.doesLogoExists());
                break;
            case "Cart":
                p = new CartPage(Hooks.driver);
                Assert.assertTrue("Le logo n'existe pas sur la page " + pageName, p.doesLogoExists());
                break;
            case "Product":
                p = new ProductPage(Hooks.driver);
                Assert.assertTrue("Le logo n'existe pas sur la page " + pageName, p.doesLogoExists());
                break;
            case "Shop":
                p = new ShopPage(Hooks.driver);
                Assert.assertTrue("Le logo n'existe pas sur la page " + pageName, p.doesLogoExists());
                break;
            default:
                break;
        }


    }


    @When("je clique sur le logo AT en haut à gauche de la page {string}")
    public void jeCliqueSurLeLogoATEnHautÀGaucheDeLaPage(String pageName) {

        BasePage p;
        switch (pageName) {
            case "Home":
                p = this.homePage;
                p.clickOnLogo();
                break;
            case "My Account":
                p = new MyAccountPage(Hooks.driver);
                p.clickOnLogo();
                break;
            case "Cart":
                p = new CartPage(Hooks.driver);
                p.clickOnLogo();
                break;
            case "Product":
                p = new ProductPage(Hooks.driver);
                p.clickOnLogo();
                break;
            case "Shop":
                p = new ShopPage(Hooks.driver);
                p.clickOnLogo();
                break;
            default:
                break;
        }


    }

    @Then("je suis redirigé vers la page d'accueil")
    public void jeSuisRedirigéVersLaPageDAccueil() {
        Assert.assertTrue("Le lien du logo ne redirige pas vers la page d'accueil", homePage.doesLogoRedirectToHomePage());

    }
}
