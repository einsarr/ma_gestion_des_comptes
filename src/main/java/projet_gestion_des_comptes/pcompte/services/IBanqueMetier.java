package projet_gestion_des_comptes.pcompte.services;

import org.springframework.data.domain.Page;
import projet_gestion_des_comptes.pcompte.models.Compte;
import projet_gestion_des_comptes.pcompte.models.Operation;

import java.util.List;

public interface IBanqueMetier {
    public Compte consulterCompte(String numCompte);
    public void verser(String numCompte,double montant);
    public void retirer(String numCompte,double montant);
    public void virement(String numCompte,String numCompte2,double montant);
    public List<Operation> listeOperation(String numCompte);
}
