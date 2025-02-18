package com.immobilier.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;

public class FormulaireAjoutTransactions {
    public void display() {
        JFrame frame = new JFrame("Ajouter une Transaction");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 350);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(8, 2, 5, 5));
        String[] types = {"Location", "Vente"};
        JComboBox<String> typeComboBox = new JComboBox<>(types);
        JTextField dateField = new JTextField();
        String[] statusOptions = {"Validée", "En attente"};
        JComboBox<String> statusComboBox = new JComboBox<>(statusOptions);
        JTextField codeProprietaireField = new JTextField();
        JTextField codeClientField = new JTextField();
        JTextField codeBienField = new JTextField();
        JTextField fraisField = new JTextField();

        panel.add(new JLabel("Type:"));
        panel.add(typeComboBox);
        panel.add(new JLabel("Date:"));
        panel.add(dateField);
        panel.add(new JLabel("Status:"));
        panel.add(statusComboBox);
        panel.add(new JLabel("Code Propriétaire:"));
        panel.add(codeProprietaireField);
        panel.add(new JLabel("Code Client:"));
        panel.add(codeClientField);
        panel.add(new JLabel("Code Bien:"));
        panel.add(codeBienField);
        panel.add(new JLabel("Frais (€):"));
        panel.add(fraisField);

        JButton enregistrerButton = new JButton("Enregistrer");
        enregistrerButton.addActionListener((ActionEvent e) -> {
            try {
                String codeTransaction = ListeTransactionsGUI.generateUniqueCode("transactions.csv");
                try (FileWriter writer = new FileWriter("transactions.csv", true)) {
                    String newEntry = String.format("%s,%s,%s,%s,%s,%s,%s,%s\n", codeTransaction, typeComboBox.getSelectedItem().toString(), dateField.getText(), statusComboBox.getSelectedItem().toString(), codeProprietaireField.getText(), codeClientField.getText(), codeBienField.getText(), fraisField.getText());
                    writer.write(newEntry);
                    JOptionPane.showMessageDialog(frame, "Enregistrement réussi avec le code : " + codeTransaction);
                    frame.dispose();
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Erreur d'enregistrement : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(new JLabel());
        panel.add(enregistrerButton);
        frame.add(panel);
        frame.setVisible(true);
    }
}
