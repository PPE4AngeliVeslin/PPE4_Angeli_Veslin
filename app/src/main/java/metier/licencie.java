package metier;

import java.util.ArrayList;

public class licencie {
    private int id;
    private String nom;
    private String prenom;
    private String nomUtilisateur;
    private String password;
    private int idEquipe;

    public licencie() {
    }

    public licencie(int id, String nom, String prenom, String nomUtilisateur, String password, int idEquipe) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.nomUtilisateur = nomUtilisateur;
        this.password = password;
        this.idEquipe = idEquipe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(int idEquipe) {
        this.idEquipe = idEquipe;
    }

    public String toString() { return this.nomUtilisateur; }
}
