package models;


public class Terrain extends BienImmobilier {
    public Terrain(double superficie, double prix, String localisation, String description) {
        super("Terrain", superficie, prix, localisation, description); // Appelle le constructeur de la classe mère
    }
}