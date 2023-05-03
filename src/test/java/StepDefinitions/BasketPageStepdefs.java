package StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.BasketPage;

public class BasketPageStepdefs {
    BasketPage basketPage = new BasketPage(Hooks.driver);

    @And("Je clique sur le lien Lost you Password ?")
    public void jeCliqueSurLeLien(String arg0) {
    }


    @Given("La page panier affiche un récapitulatif des articles ajoutés et les informations {string}")
    public void laPagePanierAfficheUnRécapitulatifDesArticlesAjoutésEtLesInformations(String arg0) {
        basketPage.verifierQueLePrixTotalEstVisible();
        basketPage.verifierQueLeChampsTaxEstVisible();
        basketPage.verifierQueLePrixTotalApresTaxeIsVisible();

    }


    @And("Chaque article contient une photo descriptive, un libellé et le prix affiché au-dessous")
    public void chaqueArticleContientUnePhotoDescriptiveUnLibelléEtLePrixAffichéAuDessous() {
        basketPage.verifierQueLeLibelleEstPresent();
        basketPage.verifierQueLePrixEstPresent();
        basketPage.verifierQueImageEStVisible();
    }


    @When("Je cliquer sur le bouton supprimer l'article")
    public void jeCliquerSurLeBoutonSupprimerLArticle() {
        basketPage.verifierQueLeDeleteButtonEstVisible();
        basketPage.suppressionArticle();

    }

    @Then("Je valide que l'article à bien été supprimer")
    public boolean jeValideQueLArticleÀBienÉtéSupprimer() {
        return basketPage.verifierQueLeMessageDeSuppressionEstVisible();

    }

    @When("Je vérifie l'éxistance du champ quantité")
    public void jeVérifieLÉxistanceDuChampQuantité() {
        basketPage.verifierQueLaQuantiteEstVisible();

    }

    @And("Je modifie la quantité d'article via le champ quantité")
    public boolean jeModifieLaQuantitéDArticleViaLeChampQuantité() {
        return basketPage.verifierQueUpdateQuantityIsVisible();
    }

    @Then("Je valide que la quantité de chaque article à bien été modifié par le champs quantité")
    public void jeValideQueLaQuantitéDeChaqueArticleÀBienÉtéModifiéParLeChampsQuantité() {
        basketPage.updateQuantity();
    }


    @And("le basket link est present sur la page panier")
    public boolean leBasketLinkEstPresentSurLaPagePanier() {
        return basketPage.checkVisibilityBasketLink();
    }

    @And("Le logo est bien présent sur la page panier")
    public boolean leLogoEstBienPrésentSurLaPagePanier() {
        return basketPage.checkVisibilityLogo();
    }

    @And("un champ {string} et un bouton {string} permettant d’apppliquer un code promotionnel sur la commande")
    public void unChampEtUnBoutonPermettantDApppliquerUnCodePromotionnelSurLaCommande(String arg0, String arg1) {
        basketPage.verifierQueApplyCouponEstVisible();
        basketPage.verifierQueCouponCodeFieldIsVisible();
    }

    @Then("je me redirige vers le panier")
    public void jeMeRedirigeVersLePanier() {
        basketPage.verifierQueNoussommesDansLaPagePanier();
    }




    @Then("Je valide que la page panier affiche un récapitulatif des articles ajoutés spécifiant la quantité, le prix unitaire et le prix total")
    public void jeValideQueLaPagePanierAfficheUnRécapitulatifDesArticlesAjoutésSpécifiantLaQuantitéLePrixUnitaireEtLePrixTotal() {
        basketPage.verifierQueLePrixTotalEstVisible();
        basketPage.verifierQueLePrixDeLarticleEstVisible();
        basketPage.verifierQueLaQuantiteEstVisible();

    }

    @And("le bouton {string} est affiché au dessus de  article et redirige vers espace panier")
    public void leBoutonEstAffichéAuDessusDeArticleEtRedirigeVersEspacePanier(String arg0) {
    }

    @And("je clique sur  bouton {string}")
    public void jeCliqueSurBouton(String arg0) {
        basketPage.jeCliqueSurViewbasket();

    }
}
