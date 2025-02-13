package models;



public class Appartement  extends BienImmobilier{
	
	    public Appartement(double superficie, double prix, String localisation, String description) {
	        super("Appartement", superficie, prix, localisation, description); // Appelle le constructeur de la classe mère
	    }
	}

