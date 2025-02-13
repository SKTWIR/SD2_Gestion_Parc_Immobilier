package poo;

public class Agent {

    private static int idCounter = 1;
    private String Id;
    private String nom;
    private String num ;
    private String email ;
    private String adresse ;
    
    public Agent( String nom , String num , String email , String adresse) {
        this.Id = generateId() ;
        this.nom = nom ;
        this.num = num ;
        this.email = email;
        this.adresse = adresse;
    }
    
    private String generateId() {
        return String.format("%04d", idCounter++);  
    }
    
    public String getId() {
        return Id;
    }
    
    public void setId(String Id) {
        this.Id= Id;
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom= nom;
    }
    
    public String getNum() {
        return num;
    }
    
    public void setNum(String num) {
        this.num = num ;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getAdresse() {
        return adresse;
    }
    
    public void setAdresse(String adresse) {
        this.adresse =adresse;
    }

     public void afficherAgent(Agent agent) {
            System.out.println("Informations de l agent:");
            System.out.println("ID: " + agent.getId());
            System.out.println("Nom: " + agent.getNom());
            System.out.println("Email: " + agent.getEmail());
            System.out.println("Numéro: " + agent.getNum());
            System.out.println("Adresse: " + agent.getAdresse());
            System.out.println();}


}