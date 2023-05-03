package StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.DetailsArticlePage;

public class DetailsArticlePageStepdefs {

    DetailsArticlePage detailsArticlePage = new DetailsArticlePage(Hooks.driver);

    @And("Un lien actif sur ces éléments redirige vers le détail de l'article")
    public void unLienActifSurCesÉlémentsRedirigeVersLeDétailDeLArticle() {
    }

    @Then("l'article est présenté par une photographie")
    public boolean lArticleEstPrésentéParUnePhotographie() {
        return detailsArticlePage.verifierQueLaDescriptionDeLarticleEstPresent();

    }

    @And("un détail déscriptif est present")
    public boolean unDétailDéscriptifEstPresent() {
        return detailsArticlePage.verifierQueLaDescriptionDeLarticleEstPresent();


    }

    @And("le prix est present")
    public boolean lePrixEstPresent() {
        return detailsArticlePage.verifierQueLePrixDeLarticleEstPresent();

    }

    @And("le nombre d'exemplaires dispo est présent")
    public boolean leNombreDExemplairesDispoEstPrésent() {
        return detailsArticlePage.verifierQueLestockDesArticlesEstVisible();

    }

    @Then("le bouton ADD TO BASKET est present")
    public boolean leBoutonADDTOBASKETEstPresent() {
        return detailsArticlePage.verifierQueAddToBasketEstVisible();

    }

    @And("le champ pour le nombre d'exemplaire est present")
    public boolean leChampPourLeNombreDExemplaireEstPresent() {
        return detailsArticlePage.verifierNombreArticlevouluEst();
    }

    @Given("je me redirige vers la page Detail de l'article via le lien {string}")
    public void jeMeRedirigeVersLaPageDetailDeLArticleViaLeLien(String lien) {
        Hooks.driver.get("https://practice.automationtesting.in/product/mastering-javascript/");

    }

    @And("Le logo est bien présent sur la page Detail Article")
    public void leLogoEstBienPrésentSurLaPageDetailArticle() {
        detailsArticlePage.checkVisibilityLogo();
    }

    @And("le basket link est present sur la page Detail Article")
    public void leBasketLinkEstPresentSurLaPageDetailArticle() {
        detailsArticlePage.checkVisibilityBasketLink();
    }

    @And("je clique sur le bouton {string}")
    public void jeCliqueSurLeBouton(String arg0) {
        detailsArticlePage.cliquerSurAddToCart();

    }


    @Then("le message {string} se affiche")
    public boolean leMessageSeAffiche(String arg0) {
        return detailsArticlePage.verifierQueLeMessageEstPresent();
    }

    @Given("je me redirige vers la page Detail de l'article {string}")
    public void jeMeRedirigeVersLaPageDetailDeLArticle(String arg0) {
        Hooks.driver.get("https://practice.automationtesting.in/product/mastering-javascript/");
    }

    @When("je choisi la quantité d'exemplaire")
    public void jeChoisiLaQuantiteDExemplaire() {
    }
}

