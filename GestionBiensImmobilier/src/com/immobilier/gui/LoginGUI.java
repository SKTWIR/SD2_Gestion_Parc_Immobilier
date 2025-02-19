package com.immobilier.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class LoginGUI {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginGUI() {
        frame = new JFrame("Connexion - Gestion de parc immobilier");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel userLabel = new JLabel("Nom d'utilisateur:");
        usernameField = new JTextField();
        JLabel passLabel = new JLabel("Mot de passe:");
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Se connecter");
        JButton registerButton = new JButton("Créer un compte");

        loginButton.addActionListener(this::login);
        registerButton.addActionListener(this::register);

        frame.add(userLabel);
        frame.add(usernameField);
        frame.add(passLabel);
        frame.add(passwordField);
        frame.add(new JLabel());
        frame.add(loginButton);
        frame.add(new JLabel());
        frame.add(registerButton);

        frame.setVisible(true);
    }

    private void login(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (verifyCredentials(username, password)) {
            JOptionPane.showMessageDialog(frame, "Connexion réussie !");
            frame.dispose(); // Fermer la fenêtre de connexion
            SwingUtilities.invokeLater(() -> new GestionParcImmobilierGUI()); // Ouvrir l'application principale
        } else {
            JOptionPane.showMessageDialog(frame, "Identifiants incorrects.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void register(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Veuillez remplir tous les champs.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (isUserExists(username)) {
            JOptionPane.showMessageDialog(frame, "Ce nom d'utilisateur existe déjà.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (FileWriter writer = new FileWriter("gestionnaire.csv", true)) {
            writer.write(username + "," + password + "\n");
            JOptionPane.showMessageDialog(frame, "Compte créé avec succès !");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, "Erreur d'enregistrement.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean verifyCredentials(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("gestionnaire.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException ignored) {}
        return false;
    }

    private boolean isUserExists(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader("gestionnaire.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.split(",")[0].equals(username)) {
                    return true;
                }
            }
        } catch (IOException ignored) {}
        return false;
    }

    public static void main(String[] args) {
        new LoginGUI();
    }
}
