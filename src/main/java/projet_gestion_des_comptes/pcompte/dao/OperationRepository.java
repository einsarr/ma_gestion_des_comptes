package projet_gestion_des_comptes.pcompte.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import projet_gestion_des_comptes.pcompte.models.Operation;

import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<Operation,Long> {
    @Query("SELECT o FROM Operation o WHERE o.compte.numCompte=:x order by o.dateOperation desc")
    public List<Operation> listeOperationC(@Param("x") String numCompte);
}
