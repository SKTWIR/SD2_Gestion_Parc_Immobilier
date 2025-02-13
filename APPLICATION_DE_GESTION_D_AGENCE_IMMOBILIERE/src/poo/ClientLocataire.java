package poo;

public class ClientLocataire extends Client {

    private double PrixLocation;
    private String dureeLocation;
    
    public ClientLocataire(String nom, String email, String type, String num, String demande, String preferences , double PrixLocation , String dureeLocation) {
        super(nom,email,"locataire",num,demande,preferences);
        this.PrixLocation = PrixLocation;
        this.dureeLocation = dureeLocation;
    }

    public double getPrixLocation() {
        return PrixLocation;
    }
    
    public void setPrixLocation(double PrixLocation) {
        this.PrixLocation = PrixLocation;
    }
    
    public String getDureetLocation() {
        return dureeLocation;
    }
    
    public void setDureeLocation(String dureeLocation) {
        this.dureeLocation=dureeLocation;
    }
}