package encheres.backoffice.models;
import javax.persistence.*;

import lombok.NoArgsConstructor;

@Entity
@Table(name="produits")
@NoArgsConstructor
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idproduit", nullable = false)
    private int idProduit;
    @Column(name = "nomproduit")
    private int nomProduit;
    @ManyToOne(targetEntity = Categorie.class)
    @JoinColumn(name = "idcategorie", referencedColumnName = "idcategorie")
    private Categorie categorie;

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public int getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(int nomProduit) {
        this.nomProduit = nomProduit;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
