package projet_gestion_des_comptes.pcompte.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
    @Column(length = 55)
    private String nom;
    @Column(length = 55)
    private String email;
    @OneToMany(mappedBy = "client")
    private Collection<Compte> comptes;
    public Client() {

    }
    public Client(Long code, String nom) {
        this.code = code;
        this.nom = nom;
    }
    public Client( String nom,String email) {
        this.nom = nom;
        this.email = email;
    }
    public Client(String nom) {
        this.nom = nom;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(Collection<Compte> comptes) {
        this.comptes = comptes;
    }
}
