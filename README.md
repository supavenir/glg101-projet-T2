# glg101-projet-T2

> Le projet utilise la technologie Kotlin.
> Celui-ci est réalisé dans le cadre de l'UE GLG101 (Test et Validation du Logiciel) par Thomas HOLLEY  et Thomas FONATINE--TUFFERY

Les tests sont réalisé sur la base de donnée Gatling Computer.
Plusieurs tests sont réalisé tel que la gestion des ordinateurs, la filtrage et la navigation sur le site.

Liste des mots clé d'actions et de vérifications:
- PageHome
  - `check existence of the computer`
      -> Effectue un test de recherche d'un ordinateur dans la base de données.
  - `order computers by name`
      -> Trie les ordinateurs de la base par ordre Alphabétique.
  - `go next page`
      -> Navigue vers la page suivante.
  - `go previous page`
      -> Navigue vers la page précédente.
- PageAddComputer
  - `add computer`
      -> Ajout d'un nouveau ordinateur dans la base de donnée.
- PageEditComputer
  - `edit computer`
      -> Modification d'un ordinateur de la base de donnée.
  - `delete computer`
      -> Suppression d'un ordinateur de la base de donnée.

Lancement des tests :

1. Ouvrir le projet dans un IDE
2. Appuyer sur le bouton de lancement de tests devant la fonction à tester ou lancement du test à l'aide de l'invite de commande
3. Le test se lance en ouvrant une page ChromeDriver automatiquement.
