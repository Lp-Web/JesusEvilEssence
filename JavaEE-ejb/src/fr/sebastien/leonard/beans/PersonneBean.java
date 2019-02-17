package fr.sebastien.leonard.beans;

import fr.sebastien.leonard.Personne;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless(name = "PersonneBean")
public class PersonneBean {

    @PersistenceContext(unitName = "TicketLink")
    private EntityManager manager;

    public Personne getPersonneByEmail(String email) {
        return (Personne) manager.createQuery("select p from Personne p where p.email = :email")
                .setParameter("email", email).getResultList().get(0);
    }

    public void updatePersonne(Personne personne) {
        manager.merge(personne);
    }

    public void createPersonne(Personne personne) {
        manager.persist(personne);
    }

    public void deletePersonne(Personne personne) {
        manager.remove(personne);
    }

    public List<Personne> getPersonnes() {
        return manager.createQuery("select p from Personne p").getResultList();
    }

}
