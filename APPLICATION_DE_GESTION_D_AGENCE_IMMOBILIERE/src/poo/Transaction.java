package poo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    private static int compteur = 0;
    private String numeroTransaction;
    private Date dateTransaction;
    private String codeAgent;
    private String codeVendeurOuLocataire;
    private String codeAcheteur;
    private String transactionStatus;
    private double frais;

    public Transaction(Date dateTransaction, String codeAgent, String codeVendeurOuLocataire,
                       String codeAcheteur, String transactionStatus, double frais) {
        this.numeroTransaction = "TR" + String.format("%06d", ++compteur);
        this.dateTransaction = dateTransaction;
        this.codeAgent = codeAgent;
        this.codeVendeurOuLocataire = codeVendeurOuLocataire;
        this.codeAcheteur = codeAcheteur;
        this.transactionStatus = transactionStatus;
        this.frais = frais;
    }

    public void afficherTransaction() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Numéro : " + numeroTransaction);
        System.out.println("Date : " + sdf.format(dateTransaction));
        System.out.println("Code Agent : " + codeAgent);
        System.out.println("Code Vendeur/Locataire : " + codeVendeurOuLocataire);
        System.out.println("Code Acheteur : " + codeAcheteur);
        System.out.println("Statut : " + transactionStatus);
        System.out.println("Frais : " + frais);
    }

    // Getters (si nécessaire)
    public String getNumeroTransaction() {
        return numeroTransaction;
    }
}