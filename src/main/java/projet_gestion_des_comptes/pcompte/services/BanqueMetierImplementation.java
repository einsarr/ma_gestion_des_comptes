package projet_gestion_des_comptes.pcompte.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projet_gestion_des_comptes.pcompte.dao.CompteRepository;
import projet_gestion_des_comptes.pcompte.dao.OperationRepository;
import projet_gestion_des_comptes.pcompte.models.*;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BanqueMetierImplementation implements IBanqueMetier{
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private OperationRepository operationRepository;

    @Override
    public Compte consulterCompte(String numCompte) {
        Compte cp = compteRepository.getOne(numCompte);
        if(cp==null) throw new RuntimeException("Compte introuvable");
        return cp;
    }

    @Override
    public void verser(String numCompte, double montant) {
        Compte cp =consulterCompte(numCompte);
        Versement v = new Versement(new Date(),montant,cp);
        operationRepository.save(v);
        cp.setSolde(cp.getSolde()+montant);
        compteRepository.save(cp);
    }

    @Override
    public void retirer(String numCompte, double montant) {
        Compte cp =consulterCompte(numCompte);
        double facilitesCaisse=0;
        if(cp instanceof CompteCourant)
            facilitesCaisse=((CompteCourant)cp).getDecouvert();
        if(cp.getSolde()+facilitesCaisse<montant)
            throw new RuntimeException("Solde insuffisant");
        Retrait r = new Retrait(new Date(),montant,cp);
        operationRepository.save(r);
        cp.setSolde(cp.getSolde()-montant);
        compteRepository.save(cp);
    }

    @Override
    public void virement(String numCompte, String numCompte2, double montant) {
        if (numCompte.equals(numCompte2))
            throw new RuntimeException("Operation impossible sur le même compte");
        retirer(numCompte,montant);
        verser(numCompte2,montant);
    }

    @Override
    public List<Operation> listeOperation(String numCompte) {
        return operationRepository.listeOperationC(numCompte);
    }
}
