# Simple Online Ticketing

## Points traités dans le sujet

### Entités présentes dans le projet
- Entité *Evenement* qui correspond à un événement.
	> Un événement est constitué d'un id auto-généré, d'une date, d'un lieu, d'une description et d'une liste de places.

- Entité *PlaceEvenement* qui correspond à une place pour un événement.
	> Une place d'événement est constituée d'un id auto-généré et d'un prix.

### Présenter une liste d'événements qui vont avoir lieu
La liste de tous les événements apparaît via la route `/app` du site. Cette même route crée un nouvel événement à chaque rafraîchissement de la page (cf. *Difficultés rencontrées*).
La liste des événements affiche un tableau contenant l'id et le lieu de l'événement.

### Présenter le détail d'un événement
Le détail d'un événement est accessible via la route `/app` en y ajoutant un paramètre **id** désignant l'id de l'événement à détailler.
> **Exemple:** `{...}/app?id=2`

Le détail d'un événement affiche l'id, le lieu, la description et la date de l'événement.

## Difficultés rencontrées
- Wildfly et JBoss nous ont posé de gros problèmes au début du projet. En effet, nous étions obligés de tuer le serveur via un terminal plusieurs fois avant chaque redéploiement pour avoir les droits nécessaire au-dit redéploiement. Au bout d'un certain temps, nous étions forcés de redémarrer les machines physiques.

- Les projets sous Netbeans ont finis par ne plus fonctionner, tout comme les commandes du terminal. À partir de ce point, nous devions redémarrer les machines physiques avant chaque redéploiement. Nous avons donc choisi de passer sous IntelliJ Ultimate Edition, qui prend en charge les déploiements.

- Le serveur Wildfly ne nous autorise pas la connexion à notre base de données, malgré le fait que nous ayons suivi à la lettre les consignes du premier TP et malgré votre aide lors du dernier TP. C'est pourquoi les événements sont créés via la méthode GET de notre route `/app`.
