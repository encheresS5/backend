package encheres.backoffice.repository;
import encheres.backoffice.models.Produit;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ProduitRepository extends CrudRepository<Produit,Integer> {
    @Transactional
    @Modifying
    @Query(value = "insert into produits values (default,:nomProduit,:idCategorie)",nativeQuery = true)
    public void insertProduit(@Param("nomProduit") String nomProduit, @Param("idCategorie") int idCategorie);
}
