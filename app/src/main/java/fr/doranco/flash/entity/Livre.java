package fr.doranco.flash.entity;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "livres",
        indices = {@Index(value = {"titre"}, unique = true)})
public class Livre {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String titre;

    private String image;

    private String description;

    private double prix;

    public Livre() {
    }

    public Livre(String titre, String image, String description, double prix) {
        this.titre = titre;
        this.image = image;
        this.description = description;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "\n Livre{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                '}';
    }
}

