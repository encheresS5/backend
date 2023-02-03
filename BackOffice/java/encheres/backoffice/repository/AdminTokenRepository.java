package encheres.backoffice.repository;

import encheres.backoffice.models.AdminToken;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface AdminTokenRepository extends CrudRepository<AdminToken,Integer> {
    @Query(value = "select isAdminTokenValid(?1)",nativeQuery = true)
    public boolean isAdminTokenValid(String token);

    @Query(value = "select * from admintokens where token=?1",nativeQuery = true)
    public AdminToken getTokenByToken(String token);

    @Transactional
    @Modifying
    @Query(value = "update admintokens set dateexpiration=now() where token=:token",nativeQuery = true)
    public void deconnexion(@Param("token")String token);
}
