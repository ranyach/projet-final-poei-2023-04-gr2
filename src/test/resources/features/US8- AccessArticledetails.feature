@REQ_POEI23P2G2-3
Feature: US8- Access aux details des articles

	#* Valider qu'un bouton "ADD TO BASKET" existe et permet d'ajouter l'article au panier.
	@TEST_POEI23P2G2-18 @TNR @autom
	Scenario: Valider qu'un bouton "ADD TO BASKET" existe et permet d'ajouter l'article au panier.
	Given je me redirige vers la page Detail de l'article "mastering-javascript"
		When je choisi la quantité d'exemplaire
		And je clique sur le bouton "ADD TO BASKET"
		When le message "has been added to your basket" se affiche
		And le bouton "VIEW BASKET" est affiché au dessus de  article et redirige vers espace panier

	@TEST_POEI23P2G2-19 @TNR @autom
	Scenario: Valider l'existence d'un champ en dessous de l’article dans la page shop permettant d'indiquer le nombre d'exemplaire voulu
		Given je me redirige vers la page Detail de l'article "mastering-javascript"
		Then le bouton ADD TO BASKET est present
		And le champ pour le nombre d'exemplaire est present

	#* Vérifier qu’un  bouton "VIEW BASKET" apparaît au-dessus de  l'article  lors de l'ajout au panier, permettant de se rediriger vers l'espace panier
	@TEST_POEI23P2G2-19 @TNR @autom
	Scenario: Valider l'apparition d'un message “libellé'” has been added to your basket." à chaque ajout d’article
		Given je me redirige vers la page Detail de l'article "mastering-javascript"
		When je choisi la quantité d'exemplaire
		And je clique sur le bouton "ADD TO BASKET"
		Then le message "has been added to your basket" se affiche
		And le bouton "VIEW BASKET" est affiché au dessus de  article et redirige vers espace panier

