package com.immobilier.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;

public class FormulaireAjoutBiens {
    public void display() {
        JFrame frame = new JFrame("Ajouter un Bien");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 350);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(7, 2, 5, 5));
        String[] types = {"Terrain", "Maison", "Appartement"};
        JComboBox<String> typeComboBox = new JComboBox<>(types);
        JTextField superficieField = new JTextField();
        JTextField prixField = new JTextField();
        JTextField localisationField = new JTextField();
        JTextField codeProprietaireField = new JTextField();
        JTextField codeClientField = new JTextField();

        panel.add(new JLabel("Type:"));
        panel.add(typeComboBox);
        panel.add(new JLabel("Superficie (m²):"));
        panel.add(superficieField);
        panel.add(new JLabel("Prix (€):"));
        panel.add(prixField);
        panel.add(new JLabel("Localisation:"));
        panel.add(localisationField);
        panel.add(new JLabel("Code Propriétaire:"));
        panel.add(codeProprietaireField);
        panel.add(new JLabel("Code Client:"));
        panel.add(codeClientField);

        JButton enregistrerButton = new JButton("Enregistrer");
        enregistrerButton.addActionListener((ActionEvent e) -> {
            try {
                String codeBien = ListeBiensGUI.generateUniqueCode("biens.csv");
                try (FileWriter writer = new FileWriter("biens.csv", true)) {
                    String newEntry = String.format("%s,%s,%s,%s,%s,%s,%s\n", codeBien, typeComboBox.getSelectedItem().toString(), superficieField.getText(), prixField.getText(), localisationField.getText(), codeProprietaireField.getText(), codeClientField.getText());
                    writer.write(newEntry);
                    JOptionPane.showMessageDialog(frame, "Enregistrement réussi avec le code : " + codeBien);
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
