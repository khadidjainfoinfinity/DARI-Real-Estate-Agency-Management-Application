# Rapport du projet " DARI "
## qu'est-ce que l'application DARI ? :
Bienvenue dans ce rapport où nous allons vous guider au fur à mesure pour vous expliquer en toute clarté le fonctionnement de notre projet. Tout d'abord une application de telle taille a besoin d'une belle interface, et c'est le premier point que nous allons aborder plus tard. Ensuite nous avons également utilisé quelques outils supplémentaires comme JetBrainTools comme IDE principale qui fonctionne très bien avec le framework SpringBoot afin de pouvoir connecter le back-end et le front-end, en plus de cela, ça nous facilite la gestion de la base de données. Et bien sûr par dessus cela nous avons les classes en java qui représente l'engrenage de notre application.

## interface de l'application Dari :
Le design comporte 5 écrans : page d'accueil (tableau de bord), page des ventes, page des messages, page des clients, et une page pour représenter une maison individuelle. Aucun framework n'est utilisé pour le frontend (frontend en pur JavaScript) et pour les bibliothèques, j'ai utilisé tilt.js pour les effets d'inclinaison et chart.js pour créer les graphiques.

Nous n'avons pas trouvé le temps de connecter le front-end avec le back-end en utilisant Spring Boot, mais cela sera fait le jour de la présentation.
##### not responsive

[Watch the video on Google Drive](https://drive.google.com/file/d/10a-DwkhJ0ZBP6xJN94rCpp3FLqOuSS-9/view?usp=sharing)

<img src="https://github.com/khadidjainfoinfinity/DARI-Real-Estate-Agency-Management-Application/blob/main/home.png?raw=true" alt="Project Screenshot" width="300"/>

<img src="https://github.com/khadidjainfoinfinity/DARI-Real-Estate-Agency-Management-Application/blob/main/house.png?raw=true" alt="Project Screenshot" width="300"/>

<img src="https://github.com/khadidjainfoinfinity/DARI-Real-Estate-Agency-Management-Application/blob/main/charts.png?raw=true" alt="Project Screenshot" width="300"/>

<img src="https://github.com/khadidjainfoinfinity/DARI-Real-Estate-Agency-Management-Application/blob/main/clients.png?raw=true" alt="Project Screenshot" width="300"/>

<img src="https://github.com/khadidjainfoinfinity/DARI-Real-Estate-Agency-Management-Application/blob/main/messages.png?raw=true" alt="Project Screenshot" width="300"/>

LES CLASSES EN JAVA
public class BienImmobilier
Parmi les classes les plus essentiels dans ce projet si ce n'est la plus essentiel, elle contient tous les attributs d'un bien immobilier (Wilaya, commune, prix, etc..) elle comport également des constructeurs, des setters et des getters.

public class Annonce extends BienImmobilier
Cette classe est fille de la classe précédente, puisqu'un bien immobilier peut être une annonce, en plus des attributs de la classe mère nous avons 2 nouveaux attributs, l'ID qui sera très utile pour reconnaitre les annonces quand on les stockera dans la base de données, et puis on a également l'attribut Likes qui représente le nombre de like qu'une annonce a reçu. Comme la classe mère on a des constructeurs, des setters et des getters. Enfin nous avons 3 méthodes.
public void Créer : pour créer une annonce et la stocker dans la base de données
public void Supprimer : pour supprimer une annonce de la base de données
public void Assigner : pour assigner une annonce et donc un bien immobilier à un agent immobilier

public class Compte
Comme son nom l'indique, cette classe va gérer tous les comptes de l'application. Elle comporte des attributs comme le nom, prénom etc.. et aussi permet de donner le type du compte, si c'est un agent ou un client ( acheteur, bailleur, etc...). Elle comporte un constructeur, des getters et des setters, pour l'instant rien de spécial. Ensuite nous avons plusieurs méthodes.
public void créerCompte : pour créer un compte et le stocker dans la base de données
public void supprimerCompte: pour supprimer un compte de la base de données
public void ajouterAnnonceID: pour ajouter une annonce que l'utilisateur a liké
public void supprimerAnnonceID : pour supprimer une annonce dont l'utilisateur a enlevé le like
private void mettreAJourAnnoncesID: pour transformer le tableau d'entier ( des ID ) en chaine de caractère pour faciliter le stockage dans la base de données.
private List<Integer> obtenirAnnoncesID: pour transformer la chaine de caractère qui liste les biens que l'utilisateur a liké, en un tableau d'entiers ( les ID )

public class GestionTransactions
Cette classe permet de gérer les transactions comme leurs suivis, la plnification de visite, l'enregistrement des paiements, la génération de contrats et les rendez-vous.


