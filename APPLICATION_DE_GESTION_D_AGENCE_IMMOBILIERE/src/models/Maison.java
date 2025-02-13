package models;



public class Maison extends BienImmobilier {
    
    
 public Maison(double superficie, double prix, String localisation, String description) {
        super("Maison", superficie, prix, localisation, description); // Appelle le constructeur de la classe mère
    }
}