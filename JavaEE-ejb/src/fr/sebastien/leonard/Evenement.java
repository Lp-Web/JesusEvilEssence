package fr.sebastien.leonard;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
public class Evenement implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String dateEvenement;
    private String lieu;

    private String desc;
    
    @OneToMany(targetEntity = PlaceEvenement.class)
    private List<PlaceEvenement> places;

    public Evenement() {}

    public Evenement(String date, String lieu, String desc, List<PlaceEvenement> places) {
        setDateEvenement(date);
        setLieuEvenement(lieu);
        setPlaces(places);
        setDesc(desc);
    }

    public void setDesc(String d) { this.desc = d; }
    public String getDesc() { return desc; }

    public void setPlaces(List<PlaceEvenement> places) { this.places = places; }
    public List<PlaceEvenement> getPlaces() { return this.places; }
    
    public void setLieuEvenement(String lieu) { this.lieu = lieu; }
    public String getLieu() { return this.lieu; }

    public void setDateEvenement(String date) { this.dateEvenement = date; }  
    public String getDateEvenement() { return this.dateEvenement; }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Evenement)) {
            return false;
        }
        Evenement other = (Evenement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.sebastien.jpa.Evenement[ id=" + id + " ]";
    }
    
}
