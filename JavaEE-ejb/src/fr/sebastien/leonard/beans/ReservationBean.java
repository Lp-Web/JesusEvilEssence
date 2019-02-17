package fr.sebastien.leonard.beans;

import fr.sebastien.leonard.Evenement;
import fr.sebastien.leonard.Personne;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "ReservationEJB")
public class ReservationBean {

    @PersistenceContext(unitName = "TicketLink")
    private EntityManager manager;

    public void save(int personne, int evenement) {
        Evenement event = (Evenement) manager.createQuery("select e from Evenement e where e.id = :id")
                    .setParameter("id", evenement).getResultList().get(0);

        Personne perso = (Personne) manager.createQuery("select p from Personne p where p.id = :id")
                    .setParameter("id", personne).getResultList().get(0);

        perso.addReservation(event);
        manager.merge(perso);
    }

}
