package com.immobilier.gui;

import javax.swing.*;
import java.awt.*;
import com.formdev.flatlaf.FlatDarkLaf;

public class GestionParcImmobilierGUI {
    private JFrame frame;

    // ✅ Ajout d'un constructeur public
    public GestionParcImmobilierGUI() {
        frame = new JFrame("Gestion de parc immobilier");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(72, 76, 76));

        JLabel titleLabel = new JLabel("Gestion de parc immobilier");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setForeground(Color.WHITE);

        JButton proprietairesButton = new JButton("Liste Des Propriétaires");
        JButton clientsButton = new JButton("Liste Des Clients");
        JButton biensButton = new JButton("Liste Des Biens");
        JButton transactionsButton = new JButton("Transactions");
        styliserBouton(proprietairesButton);
        styliserBouton(clientsButton);
        styliserBouton(biensButton);
        styliserBouton(transactionsButton);

        Dimension buttonSize = new Dimension(220, 45);
        proprietairesButton.setPreferredSize(buttonSize);
        clientsButton.setPreferredSize(buttonSize);
        biensButton.setPreferredSize(buttonSize);
        transactionsButton.setPreferredSize(buttonSize);

        proprietairesButton.addActionListener(e -> new ListeProprietairesGUI().display());
        clientsButton.addActionListener(e -> new ListeClientsGUI().display());
        biensButton.addActionListener(e -> new ListeBiensGUI().display());
        transactionsButton.addActionListener(e -> new ListeTransactionsGUI().display());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 0, 15, 0);
        gbc.gridx = 0;

        gbc.gridy = 0;
        panel.add(titleLabel, gbc);
        gbc.gridy = 1;
        panel.add(proprietairesButton, gbc);
        gbc.gridy = 2;
        panel.add(clientsButton, gbc);
        gbc.gridy = 3;
        panel.add(biensButton, gbc);
        gbc.gridy = 4;
        panel.add(transactionsButton, gbc);

        frame.add(panel);
        frame.setVisible(true); // ✅ S'assurer que la fenêtre s'affiche bien
        titleLabel.setForeground(new Color(255, 255, 255)); // Jaune doré pour le titre
        
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf()); // Activer le Look & Feel moderne
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(GestionParcImmobilierGUI::new); // ✅ Assurer l'affichage via EDT
    }
    
    private void styliserBouton(JButton button) {
        button.setBackground(new Color(30, 136, 229)); // Bleu moderne
        button.setForeground(Color.WHITE); // Texte blanc
        button.setFont(new Font("SansSerif", Font.BOLD, 16));
        button.setFocusPainted(false); // Enlever l'effet de focus
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Arrondir
    }

    /*public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf()); // Activer le Look & Feel moderne
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(GestionParcImmobilierGUI::new); // ✅ Assurer l'affichage via EDT
    }*/
}
