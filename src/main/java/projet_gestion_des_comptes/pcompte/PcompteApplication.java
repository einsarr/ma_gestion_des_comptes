package projet_gestion_des_comptes.pcompte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import projet_gestion_des_comptes.pcompte.dao.ClientRepository;
import projet_gestion_des_comptes.pcompte.dao.CompteRepository;
import projet_gestion_des_comptes.pcompte.dao.OperationRepository;
import projet_gestion_des_comptes.pcompte.models.*;
import projet_gestion_des_comptes.pcompte.services.IBanqueMetier;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class PcompteApplication implements CommandLineRunner {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private IBanqueMetier iBanqueMetier;
    public static void main(String[] args) {
        SpringApplication.run(PcompteApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*Client c1 = clientRepository.save(new Client("SARR","einsarr@gmail"));
        Client c2 = clientRepository.save(new Client("GUEYE","groupeisi@gmail"));

        Compte cp1 =compteRepository.save(new CompteCourant("c1",new Date(),90000,c1,6000));
        Compte cp2 =compteRepository.save(new CompteEpargne("c2",new Date(),6000,c2,5.5));

        operationRepository.save(new Versement(new Date(),9000,cp1));
        operationRepository.save(new Versement(new Date(),6000,cp1));
        operationRepository.save(new Versement(new Date(),2300,cp1));
        operationRepository.save(new Retrait(new Date(),3000,cp1));

        operationRepository.save(new Versement(new Date(),2300,cp2));
        operationRepository.save(new Versement(new Date(),400,cp2));
        operationRepository.save(new Versement(new Date(),2300,cp2));
        operationRepository.save(new Retrait(new Date(),3000,cp2));


        iBanqueMetier.verser("c1",1111111);
        List<Operation> liste = iBanqueMetier.listeOperation();

        for (Operation op : liste)
        {
            System.out.println(op.getClass().getName()+op.getMontant());
        }*/
    }
}
