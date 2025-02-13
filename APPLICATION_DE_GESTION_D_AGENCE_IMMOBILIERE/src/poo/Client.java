package poo;

import java.util.ArrayList;
import java.util.List;

public class Client {
	private static int idCounter = 1;
    private String id;
    private String nom;
    private String email;
    private String type;
    private String num;
    private String demande;
    private String preferences;
    private List<historiqueInteractions> historiqueInteraction;

    public Client( String nom , String email, String type, String num, String demande, String preferences) {
        this.id = generateId();
        this.nom = nom;
        this.email = email;
        this.type = type;
        this.num = num;
        this.demande = demande;
        this.preferences = preferences;
        this.historiqueInteraction = new ArrayList<>();
    }
    

    public void addHistoriqueInteraction(historiqueInteractions interaction) {
        this.historiqueInteraction.add(interaction);
    }

    public List<historiqueInteractions> getHistoriqueInteractions() {
        return this.historiqueInteraction;
    }

    private String generateId() {
        return "CL" + String.format("%07d", idCounter++);  
    }
    

    public String getId() {
        return id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getDemande() {
        return demande;
    }

    public void setDemande(String demande) {
        this.demande = demande;
    }

    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }
    
    public void afficherClientEtHistorique(Client client) {
        System.out.println("Informations du client:");
        System.out.println("ID: " + client.getId());
        System.out.println("Nom: " + client.getNom());
        System.out.println("Email: " + client.getEmail());
        System.out.println("Type: " + client.getType());
        System.out.println("Numéro: " + client.getNum());
        System.out.println("Demande: " + client.getDemande());
        System.out.println("Préférences: " + client.getPreferences());
        System.out.println();

        System.out.println("Historique des interactions:");
        List<historiqueInteractions> historique = client.getHistoriqueInteractions();
        if (historique.isEmpty()) {
            System.out.println("Aucune interaction disponible.");
        } else {
            for (historiqueInteractions interaction : historique) {
                System.out.println("Date: " + interaction.getDate());
                System.out.println("Type d'interaction: " + interaction.getTypeInteraction());
                System.out.println("Code Agent: " + interaction.getCodeAgent());
                System.out.println("Code Bien: " + interaction.getCodeAgent());
                System.out.println();
            }
        }
    }

}
