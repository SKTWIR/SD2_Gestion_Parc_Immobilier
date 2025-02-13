package poo;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestionTransactions  {
    private List<Transaction> transactions;

    public GestionTransactions() {
        this.transactions = new ArrayList<>();
    }

    // Ajouter une nouvelle transaction
    public void ajouterTransaction(Date dateTransaction, String codeAgent, String codeVendeurOuLocataire,
                                   String codeAcheteur, String transactionStatus, double frais) {
        Transaction transaction = new Transaction(dateTransaction, codeAgent, codeVendeurOuLocataire, 
                                                  codeAcheteur, transactionStatus, frais);
        transactions.add(transaction);
        System.out.println("Transaction ajoutée avec succès !");
    }

    // Afficher toutes les transactions
    public void afficherToutesLesTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("Aucune transaction enregistrée.");
            return;
        }
        for (Transaction transaction : transactions) {
            transaction.afficherTransaction();
            System.out.println("-----------------------------");
        }
    }

    // Rechercher une transaction par index (si nécessaire)
    public Transaction obtenirTransactionParIndex(int index) {
        if (index >= 0 && index < transactions.size()) {
            return transactions.get(index);
        } else {
            System.out.println("Index invalide !");
            return null;
        }
    }

    // Supprimer une transaction par index
    public boolean supprimerTransactionParIndex(int index) {
        if (index >= 0 && index < transactions.size()) {
            transactions.remove(index);
            System.out.println("Transaction supprimée avec succès !");
            return true;
        } else {
            System.out.println("Index invalide !");
            return false;
        }
    }

    // Obtenir le nombre total de transactions
    public int nombreDeTransactions() {
        return transactions.size();
    }
}