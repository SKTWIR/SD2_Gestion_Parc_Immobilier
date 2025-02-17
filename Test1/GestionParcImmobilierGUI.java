import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.NumberFormatter;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.text.NumberFormat;

public class GestionParcImmobilierGUI {
	public static void main(String[] args) {
        JFrame frame = new JFrame("Gestion de parc immobilier");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(46, 102, 92));

        JLabel titleLabel = new JLabel("Gestion de parc immobilier");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setForeground(Color.WHITE);

        JButton proprietairesButton = new JButton("Liste Des Propriétaires");
        JButton clientsButton = new JButton("Liste Des Clients");
        JButton biensButton = new JButton("Liste Des Biens");
        JButton transactionsButton = new JButton("Transactions");

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
        frame.setVisible(true);
	}
}


class ListeProprietairesGUI {
    public void display() {
        JFrame frame = new JFrame("Gestion Des Propriétaires");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JButton retourButton = new JButton("Retour");
        retourButton.addActionListener(e -> frame.dispose());
        topPanel.add(retourButton);

        JButton ajouterButton = new JButton("Ajouter");
        ajouterButton.addActionListener(e -> new FormulaireAjoutProprietaire().display());
        topPanel.add(ajouterButton);
        
        JButton supprimerButton = new JButton("Supprimer");
        topPanel.add(supprimerButton);

        String[] columns = {"Code Propriétaire", "Nom", "Adresse", "Numéro de Téléphone", "Email"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable table = new JTable(model);
        loadCSVData("proprietaires.csv", model);
        
        supprimerButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                String codeProprietaire = model.getValueAt(selectedRow, 0).toString();
                model.removeRow(selectedRow);
                updateCSV("proprietaires.csv", codeProprietaire);
                JOptionPane.showMessageDialog(frame, "Propriétaire supprimé avec succès.");
            } else {
                JOptionPane.showMessageDialog(frame, "Veuillez sélectionner un propriétaire à supprimer.");
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
        Set<String> existingCodes1 = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", -1);
                if (values.length >= 1) {
                    existingCodes1.add(values[0].trim());
                }
            }
        }
        Random random = new Random();
        String code1;
        do {
            code1 = String.valueOf(1001 + random.nextInt(9999));
        } while (existingCodes1.contains(code1));
        return code1;
    }
}

class FormulaireAjoutProprietaire {
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
        enregistrerButton.addActionListener(e -> {
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

class ListeClientsGUI {
    public void display() {
        JFrame frame = new JFrame("Gestion Des Clients");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JButton retourButton = new JButton("Retour");
        retourButton.addActionListener(e -> frame.dispose());
        topPanel.add(retourButton);

        JButton ajouterButton = new JButton("Ajouter");
        ajouterButton.addActionListener(e -> new FormulaireAjoutClients().display());
        topPanel.add(ajouterButton);
        
        JButton supprimerButton = new JButton("Supprimer");
        topPanel.add(supprimerButton);

        String[] columns = {"Code Clients", "Nom", "Numéro de Téléphone", "Email", "Type"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable table = new JTable(model);
        loadCSVData("clients.csv", model);
        
        supprimerButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                String codeClients = model.getValueAt(selectedRow, 0).toString();
                model.removeRow(selectedRow);
                updateCSV("clients.csv", codeClients);
                JOptionPane.showMessageDialog(frame, "Clients supprimé avec succès.");
            } else {
                JOptionPane.showMessageDialog(frame, "Veuillez sélectionner un client à supprimer.");
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
        Set<String> existingCodes2 = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", -1);
                if (values.length >= 1) {
                    existingCodes2.add(values[0].trim());
                }
            }
        }
        Random random = new Random();
        String code2;
        do {
            code2 = String.valueOf(10001 + random.nextInt(89999));
        } while (existingCodes2.contains(code2));
        return code2;
    }
}

class FormulaireAjoutClients {
    public void display() {
        JFrame frame = new JFrame("Ajouter un Client");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(350, 300);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));
        JTextField nomField = new JTextField();
        JTextField telephoneField = new JTextField();
        JTextField emailField = new JTextField();
        String[] types = {"acheteur", "locataire", "vendeur"};
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
        enregistrerButton.addActionListener(e -> {
            try {
                String codeClients = ListeClientsGUI.generateUniqueCode("clients.csv");
                try (FileWriter writer = new FileWriter("clients.csv", true)) {
                    String newEntry = String.format("%s,%s,%s,%s,%s\n", codeClients, nomField.getText(), telephoneField.getText(), emailField.getText(), typeComboBox.getSelectedItem().toString());
                    writer.write(newEntry);
                    JOptionPane.showMessageDialog(frame, "Enregistrement réussi avec le code : " + codeClients);
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

class ListeBiensGUI {
	private DefaultTableModel model;
	
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
        ajouterButton.addActionListener(e -> new FormulaireAjoutBiens(model).display());
        topPanel.add(ajouterButton);
        
        JButton supprimerButton = new JButton("Supprimer");
        topPanel.add(supprimerButton);

        String[] columns = {"Code Biens", "Type", "Superficie (m²)", "Prix (€)", "Localisation", "Code Propriétaire", "Code Client"};
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
                String codeBiens = model.getValueAt(selectedRow, 0).toString();
                model.removeRow(selectedRow);
                updateCSV("biens.csv", codeBiens);
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
        Set<String> existingCodes3 = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",", -1);
                if (values.length >= 1) {
                    existingCodes3.add(values[0].trim());
                }
            }
        }
        Random random = new Random();
        String code3;
        do {
            code3 = String.valueOf(100001 + random.nextInt(899999));
        } while (existingCodes3.contains(code3));
        return code3;
    }
}

class FormulaireAjoutBiens {
    private DefaultTableModel model;

    public FormulaireAjoutBiens(DefaultTableModel tableModel) {
        this.model = tableModel;
    }

    public void display() {
        JFrame frame = new JFrame("Ajouter un Bien");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(350, 300);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(7, 2, 5, 5));

        // ComboBox pour le type
        String[] types = {"Terrain", "Maison", "Appartement"};
        JComboBox<String> typeComboBox = new JComboBox<>(types);

        // Liste déroulante pour le Code Propriétaire
        JComboBox<String> codeProprietaireComboBox = new JComboBox<>(loadProprietaireCodes("proprietaires.csv"));
        JComboBox<String> codeClientComboBox = new JComboBox<>(loadClientCodes("clients.csv"));

        // Champs formatés pour les nombres
        NumberFormatter numberFormatter = new NumberFormatter(NumberFormat.getIntegerInstance());
        numberFormatter.setAllowsInvalid(true);
        numberFormatter.setMinimum(0);
        JFormattedTextField superficieField = new JFormattedTextField(numberFormatter);
        JFormattedTextField prixField = new JFormattedTextField(numberFormatter);

        // Autres champs
        JTextField localisationField = new JTextField();

        // Ajout des composants
        panel.add(new JLabel("Type:"));
        panel.add(typeComboBox);
        panel.add(new JLabel("Superficie (m²):"));
        panel.add(superficieField);
        panel.add(new JLabel("Prix (€):"));
        panel.add(prixField);
        panel.add(new JLabel("Localisation:"));
        panel.add(localisationField);
        panel.add(new JLabel("Code Propriétaire:"));
        panel.add(codeProprietaireComboBox);
        panel.add(new JLabel("Code Client:"));
        panel.add(codeClientComboBox);

        // Bouton d'enregistrement avec mise à jour immédiate du tableau
        JButton enregistrerButton = new JButton("Enregistrer");
        enregistrerButton.addActionListener(e -> {
            try {
                String codeBiens = ListeBiensGUI.generateUniqueCode("biens.csv");
                String newEntry = String.format("%s,%s,%s,%s,%s,%s,%s",
                        codeBiens,
                        typeComboBox.getSelectedItem().toString(),
                        superficieField.getText(),
                        prixField.getText(),
                        localisationField.getText(),
                        codeProprietaireComboBox.getSelectedItem().toString(),
                        codeClientComboBox.getSelectedItem().toString());

                // Écrire dans le fichier CSV
                try (FileWriter writer = new FileWriter("biens.csv", true)) {
                    writer.write(newEntry + "\n");
                }

                // Ajouter immédiatement au tableau
                JOptionPane.showMessageDialog(frame, "Enregistrement réussi avec le code : " + codeBiens);
                frame.dispose();
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
            JOptionPane.showMessageDialog(null, "Erreur lors de la lecture des codes propriétaires : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        return codes.toArray(new String[0]);
    }
    
    private String[] loadClientCodes(String filePath) {
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
            JOptionPane.showMessageDialog(null, "Erreur lors de la lecture des codes propriétaires : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        return codes.toArray(new String[0]);
    }
}
    
class ListeTransactionsGUI {
    	private DefaultTableModel model;
    	
        public void display() {
            JFrame frame = new JFrame("Gestion Des Transactions");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(800, 500);
            frame.setLocationRelativeTo(null);

            JPanel panel = new JPanel(new BorderLayout());
            JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

            JButton retourButton = new JButton("Retour");
            retourButton.addActionListener(e -> frame.dispose());
            topPanel.add(retourButton);

            JButton ajouterButton = new JButton("Ajouter");
            ajouterButton.addActionListener(e -> new FormulaireAjoutTransactions(model).display());
            topPanel.add(ajouterButton);
            
            JButton supprimerButton = new JButton("Supprimer");
            topPanel.add(supprimerButton);

            String[] columns = {"Code Transaction", "Type", "Date", "Status", "Code Propriétaire", "Code Client", "Code Biens", "Frais"};
            DefaultTableModel model = new DefaultTableModel(columns, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            JTable table = new JTable(model);
            loadCSVData("transactions.csv", model);
            
            supprimerButton.addActionListener(e -> {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String codeBiens = model.getValueAt(selectedRow, 0).toString();
                    model.removeRow(selectedRow);
                    updateCSV("transactions.csv", codeBiens);
                    JOptionPane.showMessageDialog(frame, "Transaction supprimé avec succès.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Veuillez sélectionner une transaction à supprimer.");
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
            Set<String> existingCodes4 = new HashSet<>();
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",", -1);
                    if (values.length >= 1) {
                        existingCodes4.add(values[0].trim());
                    }
                }
            }
            Random random = new Random();
            String code4;
            do {
                code4 = String.valueOf(1000001 + random.nextInt(8999999));
            } while (existingCodes4.contains(code4));
            return code4;
        }
    }

	class FormulaireAjoutTransactions {
        private DefaultTableModel model;

        public FormulaireAjoutTransactions(DefaultTableModel tableModel) {
            this.model = tableModel;
        }

        public void display() {
            JFrame frame = new JFrame("Ajouter une Transaction");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(350, 300);
            frame.setLocationRelativeTo(null);

            JPanel panel = new JPanel(new GridLayout(8, 2, 5, 5));

            // ComboBox pour le type
            String[] types = {"Location", "Vente"};
            JComboBox<String> typeComboBox = new JComboBox<>(types);

            String[] status = {"Validée", "En attente"};
            JComboBox<String> statusComboBox = new JComboBox<>(status);

            // Liste déroulante pour le Code Propriétaire
            JComboBox<String> codeProprietaireComboBox = new JComboBox<>(loadProprietaireCodes("proprietaires.csv"));
            JComboBox<String> codeClientComboBox = new JComboBox<>(loadClientCodes("clients.csv"));
            JComboBox<String> codeBiensComboBox = new JComboBox<>(loadBiensCodes("biens.csv"));

            // Champs formatés pour les nombres
            NumberFormatter numberFormatter = new NumberFormatter(NumberFormat.getIntegerInstance());
            numberFormatter.setAllowsInvalid(true);
            numberFormatter.setMinimum(0);
            JFormattedTextField fraisField = new JFormattedTextField(numberFormatter);

            // Autres champs
            JTextField dateField = new JTextField();

            // Ajout des composants
            panel.add(new JLabel("Type:"));
            panel.add(typeComboBox);
            panel.add(new JLabel("Date:"));
            panel.add(dateField);
            panel.add(new JLabel("Status:"));
            panel.add(statusComboBox);
            panel.add(new JLabel("Code Propriétaire:"));
            panel.add(codeProprietaireComboBox);
            panel.add(new JLabel("Code Client:"));
            panel.add(codeClientComboBox);
            panel.add(new JLabel("Code Bien:"));
            panel.add(codeBiensComboBox);
            panel.add(new JLabel("Frais:"));
            panel.add(fraisField);

            // Bouton d'enregistrement avec mise à jour immédiate du tableau
            JButton enregistrerButton = new JButton("Enregistrer");
            enregistrerButton.addActionListener(e -> {
                try {
                    String codeTransactions = ListeTransactionsGUI.generateUniqueCode("transactions.csv");
                    String newEntry = String.format("%s,%s,%s,%s,%s,%s,%s,%s",
                            codeTransactions,
                            typeComboBox.getSelectedItem().toString(),
                            dateField.getText(),
                            statusComboBox.getSelectedItem().toString(),
                            codeProprietaireComboBox.getSelectedItem().toString(),
                            codeClientComboBox.getSelectedItem().toString(),
                            codeBiensComboBox.getSelectedItem().toString(),
                            fraisField.getText());

                    // Écrire dans le fichier CSV
                    try (FileWriter writer = new FileWriter("transactions.csv", true)) {
                        writer.write(newEntry + "\n");
                    }

                    // Ajouter immédiatement au tableau
                    JOptionPane.showMessageDialog(frame, "Enregistrement réussi avec le code : " + codeTransactions);
                    frame.dispose();
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
                JOptionPane.showMessageDialog(null, "Erreur lors de la lecture des codes propriétaires : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
            return codes.toArray(new String[0]);
        }
        
        private String[] loadClientCodes(String filePath) {
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
                JOptionPane.showMessageDialog(null, "Erreur lors de la lecture des codes clients : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
            return codes.toArray(new String[0]);
        }

        private String[] loadBiensCodes(String filePath) {
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
                JOptionPane.showMessageDialog(null, "Erreur lors de la lecture des codes biens : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
            return codes.toArray(new String[0]);
        }
        
}

	