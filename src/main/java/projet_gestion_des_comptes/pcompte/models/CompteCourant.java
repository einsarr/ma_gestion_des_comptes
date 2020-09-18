package projet_gestion_des_comptes.pcompte.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte{
    private double decouvert;

    public CompteCourant(){
        super();
    }
    public CompteCourant(String numCompte, Date dateCreation,double solde,Client client,double decouvert) {
        super(numCompte,dateCreation,solde,client);
        this.decouvert = decouvert;
    }

    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }
}
