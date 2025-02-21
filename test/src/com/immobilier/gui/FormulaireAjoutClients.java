package com.immobilier.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;

public class FormulaireAjoutClients {
    public void display() {
        JFrame frame = new JFrame("Ajouter un Client");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(350, 300);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));
        JTextField nomField = new JTextField();
        JTextField telephoneField = new JTextField();
        JTextField emailField = new JTextField();
        String[] types = {"Acheteur", "Locataire", "Vendeur"};
        JComboBox<String> typeComboBox = new JComboBox<>(types);

        panel.add(new JLabel("Nom:"));
        panel.add(nomField);
        panel.add(new JLabel("Téléphone:"));
        panel.add(telephoneField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("Type:"));
        panel.add(typeComboBox);

        JButton enregistrerButton = new JButton("Enregistrer");
        enregistrerButton.addActionListener((ActionEvent e) -> {
            try {
                String codeClient = ListeClientsGUI.generateUniqueCode("clients.csv");
                try (FileWriter writer = new FileWriter("clients.csv", true)) {
                    String newEntry = String.format("%s,%s,%s,%s,%s\n", codeClient, nomField.getText(), telephoneField.getText(), emailField.getText(), typeComboBox.getSelectedItem().toString());
                    writer.write(newEntry);
                    JOptionPane.showMessageDialog(frame, "Enregistrement réussi avec le code : " + codeClient);
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
