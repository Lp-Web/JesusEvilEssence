package fr.sebastien.leonard;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Personne implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private String password;

    private boolean isAdmin = false;

    @ManyToMany(targetEntity = Evenement.class)
    private List<Evenement> reservation;

    public Personne() {}

    public Personne(String email, String password, boolean isAdmin, List<Evenement> reservation) {
        setAdmin(isAdmin);
        setEmail(email);
        setPassword(password);
        setReservation(reservation);
    }

    public void addReservation(Evenement e) {
        reservation.add(e);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public List<Evenement> getReservation() {
        return reservation;
    }

    public void setReservation(List<Evenement> reservation) {
        this.reservation = reservation;
    }
}
