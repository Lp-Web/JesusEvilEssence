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
