package models;


import java.util.UUID;


public class BienImmobilier {
	
	


	    private String id; // ID unique pour le bien
	    private double superficie; // en mètres carrés
	    private double prix; // en euros
	    private String localisation; // Adresse complète
	    private String description; // Description détaillée

	    // Constructeur
	    public BienImmobilier(String type, double superficie, double prix, String localisation, String description) {
	        this.id = generateId(type); // Génère un ID unique basé sur le type
	        this.superficie = superficie;
	        this.prix = prix;
	        this.localisation = localisation;
	        this.description = description;
	    }

	    // Génère un ID unique avec les deux premières lettres du type
	    private String generateId(String type) {
	        String prefix = type.substring(0, 2).toUpperCase(); // Extrait les deux premières lettres du type
	        String uuid = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8); // Génère une partie aléatoire
	        return prefix + uuid;
	    }

	    // Getters
	    public String getId() {
	        return id;
	    }

	    public double getSuperficie() {
	        return superficie;
	    }

	    public double getPrix() {
	        return prix;
	    }

	    public String getLocalisation() {
	        return localisation;
	    }

	    public String getDescription() {
	        return description;
	    }

	    // Méthode toString pour afficher les informations d'un bien
	    @Override
	    public String toString() {
	        return getClass().getSimpleName() + " {ID: " + id + ", Superficie: " + superficie + " m², Prix: " + prix + " €, Localisation: " + localisation + ", Description: " + description + "}";
	    }
	}

