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

public class ListeClient extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	ListeClient frame = new ListeClient();
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
    public ListeClient() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 964, 639);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon originalIcon = new ImageIcon("resources/profile.png");
        Image scaledImage = originalIcon.getImage().getScaledInstance(23, 23 , Image.SCALE_SMOOTH);
        ImageIcon personicon = new ImageIcon(scaledImage);

        JLabel GestionClients = new JLabel("Gestion Des Clients", personicon , JLabel.LEFT); 
        GestionClients.setFont(new Font("Core Sans C 75 ExtraBold", Font.PLAIN, 18));
        GestionClients.setBounds(20, 10, 217, 31);
        contentPane.add(GestionClients);
        
        JButton btnRetour = new JButton("Retour");
        btnRetour.setBackground(new Color(255, 255, 255));
        btnRetour.setFont(new Font("Core Sans C 65 Bold", Font.PLAIN, 13));
        btnRetour.setBounds(44, 43, 100, 30);
        contentPane.add(btnRetour);
        btnRetour.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		LandingPage landingPage = new LandingPage();
        		landingPage.setVisible(true);
        	}
        });

        JButton SupprimerClient = new JButton();
        SupprimerClient.setBackground(new Color(221, 0, 0));
        SupprimerClient.setPreferredSize(new Dimension(31, 7));
        SupprimerClient.setBounds(864, 30, 39, 23);

        ImageIcon originalIcon1 = new ImageIcon("resources/delete.png");
        Image scaledImage1 = originalIcon1.getImage().getScaledInstance(20, 20 , Image.SCALE_SMOOTH);
        ImageIcon deleteicon= new ImageIcon(scaledImage1);

        SupprimerClient.setIcon(deleteicon);
        SupprimerClient.setBounds(852, 30, 47, 40);
        contentPane.add(SupprimerClient);

        JButton voirProfile = new JButton();
        voirProfile.setBackground(new Color(255, 255, 255));
        voirProfile.setBounds(477, 30, 50, 40);

        ImageIcon originalIcon2 = new ImageIcon("resources/eye.png");
        Image scaledImage2 = originalIcon2.getImage().getScaledInstance(20, 20 , Image.SCALE_SMOOTH);
        ImageIcon viewicon = new ImageIcon(scaledImage2);

        voirProfile.setIcon(viewicon);
        voirProfile.setBounds(800, 30, 47, 40);
        contentPane.add(voirProfile); 
        
        
     

        JTextField rechercherClient = new JTextField();
        rechercherClient.setBounds(281, 83, 312, 31);
        contentPane.add(rechercherClient);
        rechercherClient.setColumns(10);

        ImageIcon originalIcon3 = new ImageIcon("resources/plus_icon.png");
        Image scaledImage3 = originalIcon3.getImage().getScaledInstance(15, 15 , Image.SCALE_SMOOTH);
        ImageIcon plusicon = new ImageIcon(scaledImage3);

        JButton ajouterClient = new JButton("Ajouter");
        ajouterClient.setBackground(new Color(255, 255, 255));
        ajouterClient.setFont(new Font("Core Sans C 65 Bold", Font.PLAIN, 13));
        ajouterClient.setBounds(675, 83, 224, 32);
        ajouterClient.setIcon(plusicon); // Set the icon
        ajouterClient.setHorizontalTextPosition(SwingConstants.LEFT); // Position text to the left of the icon
        ajouterClient.setFocusPainted(false); // Optional: To remove the focus border
        contentPane.add(ajouterClient);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setFont(new Font("Core Sans C 55 Medium", Font.PLAIN, 11));
        scrollPane.setBounds(44, 139, 855, 439);
        contentPane.add(scrollPane);

        JTable TableClient = new JTable();
        TableClient.setIntercellSpacing(new Dimension(9, 9));
        TableClient.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TableClient.setFont(new Font("Core Sans C 55 Medium", Font.PLAIN, 13));
        TableClient.setRowHeight(40);
        scrollPane.setViewportView(TableClient);

        // Initialize data in HashMap with Code Client as the key
        HashMap<Long, Object[]> dataMap = new HashMap<>();
        dataMap.put(11234L, new Object[]{11234L, "Client 1", 600123456L, "client1@gmail.com", "acheteur", "Demande 1", "Preference1"});
        dataMap.put(11235L, new Object[]{11235L, "Client 2", 600234567L, "client2@gmail.com", "vendeur", "Demande 2", "Preference2"});
        dataMap.put(11236L, new Object[]{11236L, "Client 3", 600345678L, "client3@gmail.com", "locataire", "Demande 3" , "Preference3"});
        dataMap.put(11237L, new Object[]{11237L, "Client 4", 600456789L, "client4@gmail.com", "acheteur", "Demande 4", "Preference4"});
        dataMap.put(11238L, new Object[]{11238L, "Client 5", 600567890L, "client5@gmail.com", "vendeur", "Demande 5" , "Preference5"});
        dataMap.put(11239L, new Object[]{11239L, "Client 6", 600678901L, "client6@gmail.com", "locataire", "Demande 1", "Preference1"});
        dataMap.put(11240L, new Object[]{11240L, "Client 7", 600789012L, "client7@gmail.com", "acheteur", "Demande 2", "Preference2"});
        dataMap.put(11241L, new Object[]{11241L, "Client 8", 600890123L, "client8@gmail.com", "vendeur", "Demande 3" ,"Preference3"});
        dataMap.put(11242L, new Object[]{11242L, "Client 9", 600901234L, "client9@gmail.com", "locataire", "Demande 4", "Preference4"});
        dataMap.put(11243L, new Object[]{11243L, "Client 10", 600012345L, "client10@gmail.com", "acheteur", "Demande 5", "Preference5"});

        // Convert HashMap to 2D Object array
        Object[][] dataArray = new Object[dataMap.size()][];
        int i = 0;
        for (Object[] value : dataMap.values()) {
            dataArray[i++] = value;
        }

        // Create table model with data from HashMap
        DefaultTableModel tableModel = new DefaultTableModel(
            dataArray, // Use the data array here
            new String[]{
                "Code Client", "Nom Client", "Numero de Telephone", "Email", "Type", "Demande" , " Preference"}
        ) {
            Class[] columnTypes = new Class[]{
                Long.class, String.class, Long.class, String.class, String.class, String.class , String.class
            };

            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        };

        // Set model to the table
        TableClient.setModel(tableModel);
        
        voirProfile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the selected row from the table
                int selectedRow = TableClient.getSelectedRow();

                // Make sure a row is selected
                if (selectedRow != -1) {
                    // Get data from the selected row
                    String Codeclient = TableClient.getValueAt(selectedRow, 0).toString();  // Code Bien column
                    String Nomclient = TableClient.getValueAt(selectedRow, 1).toString();  // Type column
                    String Numtelephone = TableClient.getValueAt(selectedRow, 2).toString();  // Superficie column
                    String email = TableClient.getValueAt(selectedRow, 3).toString();  // Prix column
                    String type = TableClient.getValueAt(selectedRow, 4).toString();  // Localisation column
                    String demande = TableClient.getValueAt(selectedRow, 5).toString();
                    String Preference = TableClient.getValueAt(selectedRow, 6).toString();// Description column
             
                    // Create and show the AfficherInfo frame
                    AfficherInfoClient frame = new AfficherInfoClient(Codeclient , Nomclient, Numtelephone, email, type, demande, Preference);
                    frame.setVisible(true);  // Show the AfficherInfo window
                } else {
                    // Show an error message if no row is selected
                    JOptionPane.showMessageDialog(null, "Please select a row from the table.");
                }
            }
        });

        
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
        
        JComboBox<String> Typeclient = new JComboBox<>();
        Typeclient.setBackground(new Color(255, 255, 255));
        Typeclient.setFont(new Font("Core Sans C 65 Bold", Font.PLAIN, 13));
        Typeclient.setToolTipText("Type De Client");
        Typeclient.setBounds(44, 84, 193, 31); // Set bounds correctly
        contentPane.add(Typeclient); // Add only once to the content pane

        Typeclient.setModel(new DefaultComboBoxModel<>(new String[] {"Type De Client", "acheteur", "Locataire", "Vendeur"}));
        Typeclient.setSelectedIndex(0); // Default selection set to "Type De Client"
                
        Typeclient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Step 1: Get the selected type from the combo box
                String selectedType = (String) Typeclient.getSelectedItem(); 
                System.out.println("Selected Type: " + selectedType); // Debug: Check what type is selected

                // Step 2: Get the table model and clear current rows
                DefaultTableModel model = (DefaultTableModel) TableClient.getModel();

                // Step 3: Your data to populate in the table
                Object[][] data = {
                		{11234L, "Client 1", 600123456L, "client1@gmail.com", "acheteur", "Demande 1", "Preference1"},
                		{11235L, "Client 2", 600234567L, "client2@gmail.com", "vendeur", "Demande 2", "Preference2"},
                		{11236L, "Client 3", 600345678L, "client3@gmail.com", "locataire", "Demande 3", "Preference3"},
                		{11237L, "Client 4", 600456789L, "client4@gmail.com", "acheteur", "Demande 4", "Preference4"},
                		{11238L, "Client 5", 600567890L, "client5@gmail.com", "vendeur", "Demande 5", "Preference5"},
                		{11239L, "Client 6", 600678901L, "client6@gmail.com", "locataire", "Demande 1", "Preference1"},
                		{11240L, "Client 7", 600789012L, "client7@gmail.com", "acheteur", "Demande 2", "Preference2"},
                		{11241L, "Client 8", 600890123L, "client8@gmail.com", "vendeur", "Demande 3", "Preference3"},
                		{11242L, "Client 9", 600901234L, "client9@gmail.com", "locataire", "Demande 4", "Preference4"},
                		{11243L, "Client 10", 600012345L, "client10@gmail.com", "acheteur", "Demande 5", "Preference5"},

                };

                // Step 4: Check if "Type De Client" filter is selected
                model.setRowCount(0); // Clear the existing rows
                if (selectedType != null && !selectedType.equals("Type De Client")) {
                    // Convert selected type and row type to lowercase for case-insensitive comparison
                    String selectedTypeLower = selectedType.toLowerCase();
                    // Filter the data based on the selected client type
                    for (Object[] row : data) {
                        String rowType = (String) row[4]; // Get the client type from the data
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

        
        Searchbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the search query from the text field
                String query = rechercherClient.getText().trim().toLowerCase();

                // Get the table model to manipulate rows
                DefaultTableModel model = (DefaultTableModel) TableClient.getModel();

                // Original data (replicated for filtering)
                Object[][] data = {
                		{11234L, "Client 1", 600123456L, "client1@gmail.com", "acheteur", "Demande 1", "Preference1"},
                		{11235L, "Client 2", 600234567L, "client2@gmail.com", "vendeur", "Demande 2", "Preference2"},
                		{11236L, "Client 3", 600345678L, "client3@gmail.com", "locataire", "Demande 3", "Preference3"},
                		{11237L, "Client 4", 600456789L, "client4@gmail.com", "acheteur", "Demande 4", "Preference4"},
                		{11238L, "Client 5", 600567890L, "client5@gmail.com", "vendeur", "Demande 5", "Preference5"},
                		{11239L, "Client 6", 600678901L, "client6@gmail.com", "locataire", "Demande 1", "Preference1"},
                		{11240L, "Client 7", 600789012L, "client7@gmail.com", "acheteur", "Demande 2", "Preference2"},
                		{11241L, "Client 8", 600890123L, "client8@gmail.com", "vendeur", "Demande 3", "Preference3"},
                		{11242L, "Client 9", 600901234L, "client9@gmail.com", "locataire", "Demande 4", "Preference4"},
                		{11243L, "Client 10", 600012345L, "client10@gmail.com", "acheteur", "Demande 5", "Preference5"},

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
        for (int j = 0; j < TableClient.getColumnCount(); j++) {
            TableClient.getColumnModel().getColumn(j).setCellRenderer(centerRenderer);
        }
        

        SupprimerClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = TableClient.getSelectedRow();
                if (selectedRow != -1) { // Check if a row is selected
                    supprimerPanel supperimerPanel = new supprimerPanel(selectedRow, TableClient);
                    supperimerPanel.setVisible(true);
                    supperimerPanel.setLocationRelativeTo(null); // Center the panel
                } else {
                    System.out.println("Please select a row to delete.");
                }
            }
        });

        ajouterClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) TableClient.getModel();
                model.addRow(new Object[]{
                        0L, "", 0L, "", "", ""
                });
            }
        });
    }
}