package projet_gestion_des_comptes.pcompte.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "compte_type",discriminatorType = DiscriminatorType.STRING,length = 2)
public class Compte {
    @Id
    private String numCompte;
    private Date dateCreation;
    private double solde;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @OneToMany(mappedBy = "compte")
    private Collection<Operation> operations;

    public Compte() {
    }

    public Compte(String numCompte, Date dateCreation,double solde,Client client) {
        this.numCompte = numCompte;
        this.solde = solde;
        this.dateCreation = dateCreation;
        this.client = client;
    }

    public String getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(String numCompte) {
        this.numCompte = numCompte;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Collection<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Collection<Operation> operations) {
        this.operations = operations;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }
}
