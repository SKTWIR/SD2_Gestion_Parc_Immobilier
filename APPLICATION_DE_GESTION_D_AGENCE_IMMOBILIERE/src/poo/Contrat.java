package poo;

public class Contrat {
    private int idContrat;
    private String typeContrat; // "vente" ou "location"
    private String codeVendeur;
    private String codeAcheteur;

    public Contrat(int idTransaction, String typeContrat, String codeVendeur, String codeAcheteur) {
        this.idContrat = idTransaction; // Utilisation de l'ID transaction pour le contrat
        this.typeContrat = typeContrat;
        this.codeVendeur = codeVendeur;
        this.codeAcheteur = codeAcheteur;
    }

    @Override
    public String toString() {
        return "Contrat [ID=" + idContrat + ", Type=" + typeContrat +
               ", Vendeur=" + codeVendeur + ", Acheteur=" + codeAcheteur + "]";
    }
}
