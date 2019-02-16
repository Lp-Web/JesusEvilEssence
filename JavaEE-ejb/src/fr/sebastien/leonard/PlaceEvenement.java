package fr.sebastien.leonard;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class PlaceEvenement implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int prix;

    public PlaceEvenement() {}

    public PlaceEvenement(int prix) {
        setPrix(prix);
    }

    public void setPrix(int prix) { this.prix = prix; }
    public int getPrix() { return this.prix; }
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
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlaceEvenement)) {
            return false;
        }
        PlaceEvenement other = (PlaceEvenement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.sebastien.jpa.PlaceEvenement[ id=" + id + " ]";
    }
    
}
