package main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;

public class ListeTransactions extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	ListeTransactions frame = new ListeTransactions();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ListeTransactions() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 964, 639);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        ImageIcon originalIcon = new ImageIcon("resources/noun-paper-7427211.png");
        Image scaledImage = originalIcon.getImage().getScaledInstance(23, 23 , Image.SCALE_SMOOTH);
        ImageIcon papericon = new ImageIcon(scaledImage);

        JLabel GestiondesTransactions = new JLabel("Gestion Des Transactions ", papericon, JLabel.LEFT);
        GestiondesTransactions.setFont(new Font("Core Sans C 75 ExtraBold", Font.PLAIN, 18));
        GestiondesTransactions.setBounds(20, 10, 257, 31);
        contentPane.add(GestiondesTransactions);
        
        JButton btnRetour = new JButton("Retour");
        btnRetour.setBackground(new Color(255, 255, 255));
        btnRetour.setFont(new Font("Core Sans C 65 Bold", Font.PLAIN, 13));
        btnRetour.setBounds(42, 43, 100, 30);
        contentPane.add(btnRetour);
        btnRetour.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		LandingPage landingPage = new LandingPage();
        		landingPage.setVisible(true);
        	}
        });

        JButton Supprimertransaction= new JButton();
        Supprimertransaction.setBackground(new Color(221, 0, 0));
        Supprimertransaction.setPreferredSize(new Dimension(31, 7));
        Supprimertransaction.setBounds(864, 30, 39, 23);

        ImageIcon originalIcon1 = new ImageIcon("resources/delete.png");
        Image scaledImage1 = originalIcon1.getImage().getScaledInstance(20, 20 , Image.SCALE_SMOOTH);
        ImageIcon deleteicon= new ImageIcon(scaledImage1);

        Supprimertransaction.setIcon(deleteicon);
        Supprimertransaction.setBounds(852, 30, 47, 40);
        contentPane.add(Supprimertransaction);


        JTextField recherchertransaction= new JTextField();
        recherchertransaction.setBounds(467, 83, 126, 31);
        contentPane.add(recherchertransaction);
        recherchertransaction.setColumns(10);

        ImageIcon originalIcon3 = new ImageIcon("resources/plus_icon.png");
        Image scaledImage3 = originalIcon3.getImage().getScaledInstance(15, 15 , Image.SCALE_SMOOTH);
        ImageIcon plusicon = new ImageIcon(scaledImage3);

        JButton ajouterTransaction = new JButton("Ajouter");
        ajouterTransaction.setBackground(new Color(255, 255, 255));
        ajouterTransaction.setFont(new Font("Core Sans C 65 Bold", Font.PLAIN, 13));
        ajouterTransaction.setBounds(675, 83, 224, 32);
        ajouterTransaction.setIcon(plusicon); // Set the icon
        ajouterTransaction.setHorizontalTextPosition(SwingConstants.LEFT); // Position text to the left of the icon
        ajouterTransaction.setFocusPainted(false); // Optional: To remove the focus border
        contentPane.add(ajouterTransaction);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setFont(new Font("Core Sans C 55 Medium", Font.PLAIN, 11));
        scrollPane.setBounds(44, 139, 855, 439);
        contentPane.add(scrollPane);

        JTable Tabletransaction = new JTable();
        Tabletransaction.setIntercellSpacing(new Dimension(9, 9));
        Tabletransaction.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        Tabletransaction.setFont(new Font("Core Sans C 55 Medium", Font.PLAIN, 13));
        Tabletransaction.setRowHeight(40);
        scrollPane.setViewportView(Tabletransaction);

        HashMap<Long, Object[]> data = new HashMap<>();
        data.put(112847L, new Object[]{223945L, "Vente", "2024-01-15", "Validée", 1001, 9264, 1029, 1500, "Contrat001"});
        data.put(223874L, new Object[]{223945L, "Location", "2024-02-10", "En attente", 1002, 8374, 2048, 1200, "Contrat002"});
        data.put(334839L, new Object[]{223945L, "Vente", "2024-03-22", "Validée", 1003, 10392, 3017, 2500, "Contrat003"});
        data.put(445892L, new Object[]{223945L, "Location", "2024-04-05", "Annulée", 1004, 7294, 4502, 800, "Contrat004"});
        data.put(112842L, new Object[]{223945L, "Vente", "2024-05-17", "Validée", 1005, 10284, 3209, 3500, "Contrat005"});
        data.put(223834L, new Object[]{223945L, "Vente", "2024-06-01", "En attente", 1006, 12567, 4001, 1800, "Contrat006"});
        data.put(334725L, new Object[]{223945L, "Location", "2024-07-09", "Validée", 1007, 9402, 5092, 2000, "Contrat007"});
        data.put(445924L, new Object[]{223945L, "Vente", "2024-08-11", "Annulée", 1008, 3024, 6781, 2200, "Contrat008"});
        data.put(112983L, new Object[]{223945L, "Location", "2024-09-23", "En attente", 1009, 8392, 1294, 950, "Contrat009"});
        data.put(223945L, new Object[]{223945L, "Vente", "2024-10-05", "Validée", 1010, 7281, 9021, 2800, "Contrat010"});



        // Convert HashMap to 2D Object array
        Object[][] dataArray = new Object[data.size()][];
        int i = 0;
        for (Object[] value : data.values()) {
            dataArray[i++] = value;
        }

        // Create table model with data from HashMap
        DefaultTableModel tableModel = new DefaultTableModel(
            dataArray, // Use the data array here
            new String[]{
                "Numero Transaction", " Type Transaction ", "Date Transaction ", "Status ", "Agent Respo " ," Code Client1" , "Code Client2","Frais" , "Contrat"}
        ) {
            Class[] columnTypes = new Class[]{
                Long.class, String.class,  String.class, String.class,  Long.class,  Long.class ,  Long.class ,  Long.class ,String.class 
            };

            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        };

        // Set model to the table
        Tabletransaction.setModel(tableModel);
        
        
        JButton Searchbutton = new JButton();
        Searchbutton.setBackground(new Color(255, 255, 255));
		Searchbutton.setAlignmentX(Component.RIGHT_ALIGNMENT);
		Searchbutton.setBounds(610, 83,62, 31);
		
		ImageIcon originalImage4 = new ImageIcon("resources/noun-search-4648873.png") ; 
		Image scaledImage4 = originalImage4.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH); 
		ImageIcon searchicon = new ImageIcon(scaledImage4) ; 

		Searchbutton.setIcon(searchicon); 
        Searchbutton.setBounds(610, 83, 55, 31);
        contentPane.add(Searchbutton);  
        
        JComboBox<String> Typetransaction = new JComboBox<>();
        Typetransaction.setBackground(new Color(255, 255, 255));
        Typetransaction.setFont(new Font("Core Sans C 65 Bold", Font.PLAIN, 13));
        Typetransaction.setToolTipText("");
        Typetransaction.setBounds(253, 84, 193, 31); // Set bounds correctly
        contentPane.add(Typetransaction); // Add only once to the content pane

        Typetransaction.setModel(new DefaultComboBoxModel<>(new String[] {"Type De Transaction", "Vente", "Location"}));
        Typetransaction.setSelectedIndex(0); // Default selection set to "Type De Bien"

        Typetransaction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Step 1: Get the selected type from the combo box
                String selectedType = (String) Typetransaction.getSelectedItem();
                System.out.println("Selected Type: " + selectedType); // Debug: Check what type is selected

                // Step 2: Get the table model and clear current rows
                DefaultTableModel model = (DefaultTableModel) Tabletransaction.getModel();

                // Step 3: Your data to populate in the table
                Object[][] data = {
                	{"1", "Vente", "2024-01-15", "Validée", 1001, 9264, 1029, 1500, "Contrat001"},
                	{"2", "Location", "2024-02-10", "En attente", 1002, 8374, 2048, 1200, "Contrat002"},
                	{"3", "Vente", "2024-03-22", "Validée", 1003, 10392, 3017, 2500, "Contrat003"},
                	{"4", "Location", "2024-04-05", "Annulée", 1004, 7294, 4502, 800, "Contrat004"},
                	{"5", "Vente", "2024-05-17", "Validée", 1005, 10284, 3209, 3500, "Contrat005"},
                	{"6", "Vente", "2024-06-01", "En attente", 1006, 12567, 4001, 1800, "Contrat006"},
                	{"7", "Location", "2024-07-09", "Validée", 1007, 9402, 5092, 2000, "Contrat007"},
                    {"8", "Vente", "2024-08-11", "Annulée", 1008, 3024, 6781, 2200, "Contrat008"},
                	{"9", "Location", "2024-09-23", "En attente", 1009, 8392, 1294, 950, "Contrat009"},
                	{"10", "Vente", "2024-10-05", "Validée", 1010, 7281, 9021, 2800, "Contrat010"},

                };

                // Step 4: Check if "Type De Bien" filter is selected
                model.setRowCount(0); // Clear the existing rows

                if (selectedType != null && !selectedType.equals("Type De Transaction")) {
                    // Convert selected type and row type to lowercase for case-insensitive comparison
                    String selectedTypeLower = selectedType.toLowerCase();

                    // Filter the data based on the selected property type
                    for (Object[] row : data) {
                        String rowType = (String) row[1]; // Get the property type from the data (column index 1)
                        if (rowType.toLowerCase().equals(selectedTypeLower)) { // Compare lowercase values
                            model.addRow(row); // Add row if type matches
                        }
                    }
                } else {
                    // Add all data back to the table if no type is selected
                    for (Object[] row : data) {
                        model.addRow(row);
                    }
                }
            }
        });

        JComboBox<String> status = new JComboBox<>();
        status.setBackground(new Color(255, 255, 255));
        status.setFont(new Font("Core Sans C 65 Bold", Font.PLAIN, 13));
        status.setToolTipText("");
        status.setBounds(42, 83, 193, 31); // Set bounds correctly
        contentPane.add(status); // Add only once to the content pane

        status.setModel(new DefaultComboBoxModel<>(new String[] {"Status", "En attente", "Validée", "Annulée"}));
        status.setSelectedIndex(0); // Default selection set to "Status"

        status.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Step 1: Get the selected status from the combo box
                String selectedStatus = (String) status.getSelectedItem();
                System.out.println("Selected Status: " + selectedStatus); // Debug: Check what status is selected

                // Step 2: Get the table model and clear current rows
                DefaultTableModel model = (DefaultTableModel) Tabletransaction.getModel();

                // Step 3: Your data to populate in the table
                Object[][] data = {
                		{"1", "Vente", "2024-01-15", "Validée", 1001, 9264, 1029, 1500, "Contrat001"},
                    	{"2", "Location", "2024-02-10", "En attente", 1002, 8374, 2048, 1200, "Contrat002"},
                    	{"3", "Vente", "2024-03-22", "Validée", 1003, 10392, 3017, 2500, "Contrat003"},
                    	{"4", "Location", "2024-04-05", "Annulée", 1004, 7294, 4502, 800, "Contrat004"},
                    	{"5", "Vente", "2024-05-17", "Validée", 1005, 10284, 3209, 3500, "Contrat005"},
                    	{"6", "Vente", "2024-06-01", "En attente", 1006, 12567, 4001, 1800, "Contrat006"},
                    	{"7", "Location", "2024-07-09", "Validée", 1007, 9402, 5092, 2000, "Contrat007"},
                        {"8", "Vente", "2024-08-11", "Annulée", 1008, 3024, 6781, 2200, "Contrat008"},
                    	{"9", "Location", "2024-09-23", "En attente", 1009, 8392, 1294, 950, "Contrat009"},
                    	{"10", "Vente", "2024-10-05", "Validée", 1010, 7281, 9021, 2800, "Contrat010"},
                };

                // Step 4: Clear existing rows
                model.setRowCount(0); // Clear the existing rows

                if (selectedStatus != null && !selectedStatus.equals("Status")) {
                    // Convert selected status and row status to lowercase for case-insensitive comparison
                    String selectedStatusLower = selectedStatus.toLowerCase();

                    // Filter the data based on the selected status
                    for (Object[] row : data) {
                        String rowStatus = (String) row[3]; // Get the status from the data (column index 3)
                        if (rowStatus.toLowerCase().equals(selectedStatusLower)) { // Compare lowercase values
                            model.addRow(row); // Add row if status matches
                        }
                    }
                } else {
                    // Add all data back to the table if no status is selected
                    for (Object[] row : data) {
                        model.addRow(row);
                    }
                }
            }
        });




        
        Searchbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the search query from the text field
                String query = recherchertransaction.getText().trim().toLowerCase();

                // Get the table model to manipulate rows
                DefaultTableModel model = (DefaultTableModel) Tabletransaction.getModel();

                // Original data (replicated for filtering)
                Object[][] data = {
                		{"1", "Vente", "2024-01-15", "Validée", "Agent A", 9264, 1029, 1500, "Contrat001"},
                    	{"2", "Location", "2024-02-10", "En attente", "Agent B", 8374, 2048, 1200, "Contrat002"},
                    	{"3", "Vente", "2024-03-22", "Validée", "Agent C", 10392, 3017, 2500, "Contrat003"},
                    	{"4", "Location", "2024-04-05", "Annulée", "Agent D", 7294, 4502, 800, "Contrat004"},
                    	{"5", "Vente", "2024-05-17", "Validée", "Agent E", 10284, 3209, 3500, "Contrat005"},
                    	{"6", "Vente", "2024-06-01", "En attente", "Agent F", 12567, 4001, 1800, "Contrat006"},
                    	{"7", "Location", "2024-07-09", "Validée", "Agent G", 9402, 5092, 2000, "Contrat007"},
                        {"8", "Vente", "2024-08-11", "Annulée", "Agent H", 3024, 6781, 2200, "Contrat008"},
                    	{"9", "Location", "2024-09-23", "En attente", "Agent I", 8392, 1294, 950, "Contrat009"},
                    	{"10", "Vente", "2024-10-05", "Validée", "Agent J", 7281, 9021, 2800, "Contrat010"},
                };

                // Clear the table first
                model.setRowCount(0);

                // Iterate through the data and add rows that match the query
                for (Object[] row : data) {
                    boolean matches = false;

                    // Check if any column contains the query
                    for (Object cell : row) {
                        if (cell != null && cell.toString().toLowerCase().contains(query)) {
                            matches = true;
                            break;
                        }
                    }

                    // If the row matches, add it to the table
                    if (matches) {
                        model.addRow(row);
                    }
                }

                // If no matches found, show an alert (optional)
                if (model.getRowCount() == 0) {
                    System.out.println("No matching rows found for query: " + query);
                }
            }
        });

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int j = 0; j < Tabletransaction.getColumnCount(); j++) {
        	Tabletransaction.getColumnModel().getColumn(j).setCellRenderer(centerRenderer);
        }
        

        Supprimertransaction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = Tabletransaction.getSelectedRow();
                if (selectedRow != -1) { // Check if a row is selected
                    supprimerPanel supperimerPanel = new supprimerPanel(selectedRow, Tabletransaction);
                    supperimerPanel.setVisible(true);
                    supperimerPanel.setLocationRelativeTo(null); // Center the panel
                } else {
                    System.out.println("Please select a row to delete.");
                }
            }
        });

        ajouterTransaction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) Tabletransaction.getModel();
                model.addRow(new Object[]{
                        0L, "", 0L, "", "", ""
                });
            }
        });
    }
}