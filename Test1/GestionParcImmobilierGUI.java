import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionParcImmobilierGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Gestion de parc immobilier");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(46, 102, 92));
        panel.setLayout(new GridBagLayout());

        JLabel titleLabel = new JLabel("Gestion de parc immobilier");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(Color.WHITE);

        JButton proprietairesButton = new JButton("Liste Des Propriétaires");
        JButton clientsButton = new JButton("Liste Des Clients");
        JButton biensButton = new JButton("Liste Des Biens");
        JButton transactionsButton = new JButton("Transactions");

        proprietairesButton.setPreferredSize(new Dimension(200, 40));
        clientsButton.setPreferredSize(new Dimension(200, 40));
        biensButton.setPreferredSize(new Dimension(200, 40));
        transactionsButton.setPreferredSize(new Dimension(200, 40));

        proprietairesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ListeProprietairesGUI().display();
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0);
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

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(230, 230, 230));

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton retourButton = new JButton("Retour");
        retourButton.addActionListener(e -> frame.dispose());
        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("Rechercher");
        JButton addButton = new JButton("Ajouter");
        JButton viewButton = new JButton("Voir");
        JButton deleteButton = new JButton("Supprimer");
        deleteButton.setBackground(Color.RED);

        topPanel.add(retourButton);
        topPanel.add(searchField);
        topPanel.add(searchButton);
        topPanel.add(addButton);
        topPanel.add(viewButton);
        topPanel.add(deleteButton);

        String[] columns = {"Code Propriétaire", "Nom", "Adresse", "Numéro de Téléphone", "Email"};
        Object[][] data = {
            {"1124", "Nathalie Fluet", "10 rue Jean-Monnet 95500", "117431595", "natalie.fluet@gmail.com"}
        };
        DefaultTableModel model = new DefaultTableModel(data, columns);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        frame.add(panel);
        frame.setVisible(true);
    }
}
