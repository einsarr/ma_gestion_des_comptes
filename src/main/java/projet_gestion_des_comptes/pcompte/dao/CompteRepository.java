package projet_gestion_des_comptes.pcompte.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet_gestion_des_comptes.pcompte.models.Compte;

@Repository
public interface CompteRepository extends JpaRepository<Compte,String> {
}
