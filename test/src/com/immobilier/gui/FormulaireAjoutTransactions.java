package com.immobilier.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class FormulaireAjoutTransactions {
    public void display() {
        JFrame frame = new JFrame("Ajouter une Transaction");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(525, 350);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(8, 2, 5, 5));

        // Sélection du type de transaction
        String[] types = {"Location", "Vente"};
        JComboBox<String> typeComboBox = new JComboBox<>(types);

        // Sélection de la date avec 3 JComboBox
        JComboBox<Integer> jourComboBox = new JComboBox<>();
        JComboBox<String> moisComboBox = new JComboBox<>();
        JComboBox<Integer> anneeComboBox = new JComboBox<>();

        // Remplir les JComboBox
        for (int i = 1; i <= 31; i++) {
            jourComboBox.addItem(i);
        }

        String[] mois = {"Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"};
        for (String m : mois) {
            moisComboBox.addItem(m);
        }

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = currentYear; i >= 2000; i--) {
            anneeComboBox.addItem(i);
        }

        // Sélection du statut
        String[] statusOptions = {"Validée", "En attente"};
        JComboBox<String> statusComboBox = new JComboBox<>(statusOptions);

        // Sélection des codes
        JComboBox<String> codeProprietaireComboBox = new JComboBox<>(loadProprietaireCodes("proprietaires.csv"));
        JComboBox<String> codeClientComboBox = new JComboBox<>(loadClientCodes("clients.csv"));
        JComboBox<String> codeBienComboBox = new JComboBox<>(loadBiensCodes("biens.csv"));

        JTextField fraisField = new JTextField();

        // Ajout des éléments à l'interface
        panel.add(new JLabel("Type:"));
        panel.add(typeComboBox);
        panel.add(new JLabel("Date:"));
        
        JPanel datePanel = new JPanel();
        datePanel.add(jourComboBox);
        datePanel.add(moisComboBox);
        datePanel.add(anneeComboBox);
        panel.add(datePanel);

        panel.add(new JLabel("Status:"));
        panel.add(statusComboBox);
        panel.add(new JLabel("Code Propriétaire:"));
        panel.add(codeProprietaireComboBox);
        panel.add(new JLabel("Code Client:"));
        panel.add(codeClientComboBox);
        panel.add(new JLabel("Code Bien:"));
        panel.add(codeBienComboBox);
        panel.add(new JLabel("Frais (€):"));
        panel.add(fraisField);

        JButton enregistrerButton = new JButton("Enregistrer");
        enregistrerButton.addActionListener((ActionEvent e) -> {
            try {
                String codeTransaction = ListeTransactionsGUI.generateUniqueCode("transactions.csv");

                // Récupérer la date sélectionnée
                int jour = (int) jourComboBox.getSelectedItem();
                int moisIndex = moisComboBox.getSelectedIndex() + 1; // Index commence à 0, on ajoute 1
                int annee = (int) anneeComboBox.getSelectedItem();
                String selectedDate = String.format("%04d-%02d-%02d", annee, moisIndex, jour);

                try (FileWriter writer = new FileWriter("transactions.csv", true)) {
                    String newEntry = String.format("%s,%s,%s,%s,%s,%s,%s,%s\n",
                            codeTransaction, 
                            typeComboBox.getSelectedItem().toString(), 
                            selectedDate, 
                            statusComboBox.getSelectedItem().toString(), 
                            codeProprietaireComboBox.getSelectedItem().toString(), 
                            codeClientComboBox.getSelectedItem().toString(), 
                            codeBienComboBox.getSelectedItem().toString(), 
                            fraisField.getText());
                    
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

    private String[] loadProprietaireCodes(String filePath) {
        return loadCodesFromFile(filePath);
    }

    private String[] loadClientCodes(String filePath) {
        return loadCodesFromFile(filePath);
    }

    private String[] loadBiensCodes(String filePath) {
        return loadCodesFromFile(filePath);
    }

    private String[] loadCodesFromFile(String filePath) {
        java.util.List<String> codes = new java.util.ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", -1);
                if (values.length > 0) {
                    codes.add(values[0].trim());
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erreur lors de la lecture des codes : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        return codes.toArray(new String[0]);
    }
}

