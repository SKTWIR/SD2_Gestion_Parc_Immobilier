package poo;

import java.util.Date;

public class Paiement {
    private int idPaiement;
    private double montant;
    private Date datePaiement;
    private int idTransaction;

    public Paiement(int idPaiement, double montant, Date datePaiement, int idTransaction) {
        this.idPaiement = idPaiement;
        this.montant = montant;
        this.datePaiement = datePaiement;
        this.idTransaction = idTransaction;
    }

    @Override
    public String toString() {
        return "Paiement [ID=" + idPaiement + ", Montant=" + montant +
               ", Date=" + datePaiement + ", Transaction=" + idTransaction + "]";
    }
}
