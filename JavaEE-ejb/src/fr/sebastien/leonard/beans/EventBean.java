package fr.sebastien.leonard.beans;

import fr.sebastien.leonard.Evenement;
import fr.sebastien.leonard.PlaceEvenement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless(name = "EventBeanEJB")
public class EventBean {

    @PersistenceContext(unitName = "TicketLink")
    private EntityManager manager;

    public EventBean() {}

    public List<Evenement> getEvenements() {
        return manager.createQuery("select e from Evenement e").getResultList();
    }

    public Evenement getEvenementById(String id) {
        return (Evenement) manager.createQuery("select e from Evenement e where e.id = :id").setParameter("id", Long.parseLong(id)).getSingleResult();
    }

    public void createEvents(List<Evenement> evenements) {
        for(Evenement evenement : evenements) {
            for(PlaceEvenement place : evenement.getPlaces()) {
                manager.persist(place);
            }
            manager.persist(evenement);
        }
    }

    public String getName() {
        return "Leonard";
    }

}
