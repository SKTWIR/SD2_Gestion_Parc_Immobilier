package com.immobilier.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;

public class FormulaireAjoutProprietaire {
    public void display() {
        JFrame frame = new JFrame("Ajouter un Propriétaire");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(350, 300);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));
        JTextField nomField = new JTextField();
        JTextField adresseField = new JTextField();
        JTextField telephoneField = new JTextField();
        JTextField emailField = new JTextField();

        panel.add(new JLabel("Nom:"));
        panel.add(nomField);
        panel.add(new JLabel("Adresse:"));
        panel.add(adresseField);
        panel.add(new JLabel("Téléphone:"));
        panel.add(telephoneField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);

        JButton enregistrerButton = new JButton("Enregistrer");
        enregistrerButton.addActionListener((ActionEvent e) -> {
            try {
                String codeProprietaire = ListeProprietairesGUI.generateUniqueCode("proprietaires.csv");
                try (FileWriter writer = new FileWriter("proprietaires.csv", true)) {
                    String newEntry = String.format("%s,%s,%s,%s,%s\n", codeProprietaire, nomField.getText(), adresseField.getText(), telephoneField.getText(), emailField.getText());
                    writer.write(newEntry);
                    JOptionPane.showMessageDialog(frame, "Enregistrement réussi avec le code : " + codeProprietaire);
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