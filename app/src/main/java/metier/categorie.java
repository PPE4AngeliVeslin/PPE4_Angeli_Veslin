package metier;

import java.util.ArrayList;

public class categorie {
    private int id;
    private String libelle;

    public categorie() {
    }

    public categorie(int unId, String unLibelle) {
        this.id = unId;
        this.libelle = unLibelle;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() { return this.libelle; }
}
