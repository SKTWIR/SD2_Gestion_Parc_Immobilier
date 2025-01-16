//classe mère qui sert de base aux 3 différents rôles utiliser dans l'application
public class Utilisateur {
	// déclarations des variable nécessaire à l'identification d'un utilisateurs
	String idUtilisateur;
	private String identifiantUtilisateur;
	private String motDePasse;
	
	
	//création de la méthode qui permet de se connecter à l'application.
	public void SeConnecter(String identifiantUtilisateur, String motDePasse) {
		
	}
	
	
	// génération des getter and setter des valeurs permmetants de se connecter
	public String getIdentifiantUtilisateur() {
		return identifiantUtilisateur;
	}
	public void setIdentifiantUtilisateur(String identifiantUtilisateur) {
		this.identifiantUtilisateur = identifiantUtilisateur;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
}
