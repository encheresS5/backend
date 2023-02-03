package encheres.backoffice.models;

import java.sql.Timestamp;
import javax.persistence.*;

import lombok.NoArgsConstructor;

@Entity
@Table(name="mises")
@NoArgsConstructor
public class Mise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idmise", nullable = false)
    private int idMise;
    @ManyToOne(targetEntity = Utilisateur.class)
    @JoinColumn(name = "idutilisateur", referencedColumnName = "idutilisateur")
    private Utilisateur utilisateur;
    @ManyToOne(targetEntity = Enchere.class)
    @JoinColumn(name = "idenchere", referencedColumnName = "idenchere")
    private Enchere enchere;
    @Column(name = "montant")
    private int montant;
    @Column(name = "datemise")
    private Timestamp dateMise;

    public int getIdMise() {
        return idMise;
    }

    public void setIdMise(int idMise) {
        this.idMise = idMise;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Enchere getEnchere() {
        return enchere;
    }

    public void setEnchere(Enchere enchere) {
        this.enchere = enchere;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public Timestamp getDateMise() {
        return dateMise;
    }

    public void setDateMise(Timestamp dateMise) {
        this.dateMise = dateMise;
    }
}
