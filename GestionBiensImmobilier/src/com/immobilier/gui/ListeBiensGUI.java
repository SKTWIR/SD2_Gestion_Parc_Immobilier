package com.immobilier.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ListeBiensGUI {
    public void display() {
        JFrame frame = new JFrame("Gestion Des Biens");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JButton retourButton = new JButton("Retour");
        retourButton.addActionListener(e -> frame.dispose());
        topPanel.add(retourButton);

        JButton ajouterButton = new JButton("Ajouter");
        ajouterButton.addActionListener(e -> new FormulaireAjoutBiens().display());
        topPanel.add(ajouterButton);

        JButton supprimerButton = new JButton("Supprimer");
        topPanel.add(supprimerButton);

        String[] columns = {"Code Bien", "Type", "Superficie", "Prix", "Localisation", "Code Propriétaire", "Code Client"};
        @SuppressWarnings("serial")
		DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable table = new JTable(model);
        loadCSVData("biens.csv", model);

        supprimerButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                String codeBien = model.getValueAt(selectedRow, 0).toString();
                model.removeRow(selectedRow);
                updateCSV("biens.csv", codeBien);
                JOptionPane.showMessageDialog(frame, "Bien supprimé avec succès.");
            } else {
                JOptionPane.showMessageDialog(frame, "Veuillez sélectionner un bien à supprimer.");
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void loadCSVData(String filePath, DefaultTableModel model) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", -1);
                if (values.length >= 5) {
                    model.addRow(values);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erreur lors de la lecture du fichier CSV : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateCSV(String filePath, String codeToRemove) {
        java.util.List<String> lines = new java.util.ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.startsWith(codeToRemove + ",")) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erreur de lecture lors de la suppression : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erreur d'écriture lors de la suppression : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static String generateUniqueCode(String filePath) throws IOException {
        Set<String> existingCodes = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", -1);
                if (values.length >= 1) {
                    existingCodes.add(values[0].trim());
                }
            }
        }
        Random random = new Random();
        String code;
        do {
            code = String.valueOf(10001 + random.nextInt(89999));
        } while (existingCodes.contains(code));
        return code;
    }
}
