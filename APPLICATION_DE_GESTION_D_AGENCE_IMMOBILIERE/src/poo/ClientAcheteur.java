package poo;

public class ClientAcheteur extends Client {
    
    private double Budget ;
    
    public ClientAcheteur(String nom, String email, String type, String num, String demande, String preferences , double Budget ) {
        super(nom, email, "acheteur", num, demande, preferences);
        this.Budget = Budget;
    }
    
    public double getBudget() {
        return Budget;
    }

    public void setBudget(double Budget) {
        this.Budget = Budget;
    }
}
