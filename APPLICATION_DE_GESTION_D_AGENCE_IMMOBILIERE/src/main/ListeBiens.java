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

public class ListeBiens extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	ListeBiens frame = new ListeBiens();
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
    public ListeBiens() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 964, 639);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        ImageIcon originalIcon = new ImageIcon("resources/noun-house-7369835.png");
        Image scaledImage = originalIcon.getImage().getScaledInstance(23, 23 , Image.SCALE_SMOOTH);
        ImageIcon houseicon = new ImageIcon(scaledImage);

        JLabel GestiondesBien = new JLabel("Gestion Des Biens", houseicon, JLabel.LEFT);
        GestiondesBien.setFont(new Font("Core Sans C 75 ExtraBold", Font.PLAIN, 18));
        GestiondesBien.setBounds(20, 10, 200, 31);
        contentPane.add(GestiondesBien);
        
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

        JButton SupprimerBien= new JButton();
        SupprimerBien.setBackground(new Color(221, 0, 0));
        SupprimerBien.setPreferredSize(new Dimension(31, 7));
        SupprimerBien.setBounds(864, 30, 39, 23);

        ImageIcon originalIcon1 = new ImageIcon("resources/delete.png");
        Image scaledImage1 = originalIcon1.getImage().getScaledInstance(20, 20 , Image.SCALE_SMOOTH);
        ImageIcon deleteicon= new ImageIcon(scaledImage1);

        SupprimerBien.setIcon(deleteicon);
        SupprimerBien.setBounds(852, 30, 47, 40);
        contentPane.add(SupprimerBien);

        JButton voirProfile = new JButton();
        voirProfile.setBackground(new Color(255, 255, 255));
        voirProfile.setBounds(477, 30, 50, 40);

        ImageIcon originalIcon2 = new ImageIcon("resources/eye.png");
        Image scaledImage2 = originalIcon2.getImage().getScaledInstance(20, 20 , Image.SCALE_SMOOTH);
        ImageIcon viewicon = new ImageIcon(scaledImage2);

        voirProfile.setIcon(viewicon);
        voirProfile.setBounds(800, 30, 47, 40);
        contentPane.add(voirProfile); 
        
        
     

        JTextField rechercherBien= new JTextField();
        rechercherBien.setBounds(281, 83, 312, 31);
        contentPane.add(rechercherBien);
        rechercherBien.setColumns(10);

        ImageIcon originalIcon3 = new ImageIcon("resources/plus_icon.png");
        Image scaledImage3 = originalIcon3.getImage().getScaledInstance(15, 15 , Image.SCALE_SMOOTH);
        ImageIcon plusicon = new ImageIcon(scaledImage3);

        JButton ajouterBien = new JButton("Ajouter");
        ajouterBien.setBackground(new Color(255, 255, 255));
        ajouterBien.setFont(new Font("Core Sans C 65 Bold", Font.PLAIN, 13));
        ajouterBien.setBounds(675, 83, 224, 32);
        ajouterBien.setIcon(plusicon); // Set the icon
        ajouterBien.setHorizontalTextPosition(SwingConstants.LEFT); // Position text to the left of the icon
        ajouterBien.setFocusPainted(false); // Optional: To remove the focus border
        contentPane.add(ajouterBien);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setFont(new Font("Core Sans C 55 Medium", Font.PLAIN, 11));
        scrollPane.setBounds(44, 139, 855, 439);
        contentPane.add(scrollPane);

        JTable TableBien = new JTable();
        TableBien.setIntercellSpacing(new Dimension(9, 9));
        TableBien.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TableBien.setFont(new Font("Core Sans C 55 Medium", Font.PLAIN, 13));
        TableBien.setRowHeight(40);
        scrollPane.setViewportView(TableBien);

        HashMap<Long, Object[]> data = new HashMap<>();
        data.put(112847L, new Object[]{112847, "Appartement", 3864383, 123000000, "Alger, Lebiar", "Vue sur autoroute, résidence Araucaria", 9264, 1029});
        data.put(223874L, new Object[]{223874, "Maison", 5000000, 250000000, "Oran, Canastel", "Grande villa avec piscine et jardin", 8374, 2048});
        data.put(334839L, new Object[]{334839, "Terrain", 10000000, 80000000, "Constantine, Boussouf", "Terrain plat près du centre-ville", 10392, 3017});
        data.put(445892L, new Object[]{445892, "Bungalow", 2000000, 60000000, "Bejaia, Tichy", "Vue sur mer avec accès direct à la plage", 7294, 4502});
        data.put(112842L, new Object[]{112842, "Appartement", 4500000, 175000000, "Alger, Hydra", "Appartement luxueux dans une résidence sécurisée", 10284, 3209});
        data.put(223834L, new Object[]{223834, "Maison", 6000000, 300000000, "Tlemcen, Mansourah", "Maison traditionnelle avec cour intérieure", 12567, 4001});
        data.put(334725L, new Object[]{334725, "Terrain", 15000000, 120000000, "Setif, El Eulma", "Terrain agricole près de l'autoroute", 9402, 5092});
        data.put(445924L, new Object[]{445924, "Bungalow", 2500000, 70000000, "Annaba, Seraidi", "Bungalow isolé dans un cadre naturel", 3024, 6781});
        data.put(112983L, new Object[]{112983, "Appartement", 4000000, 140000000, "Alger, Bab El Oued", "Appartement en centre-ville proche des commerces", 8392, 1294});
        data.put(223945L, new Object[]{223945, "Maison", 7000000, 350000000, "Blida, Ouled Yaich", "Maison moderne avec jardin spacieux", 7281, 9021});

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
                "Code Bien", " Type", "Superficie ", "Prix ", "Localisation", "Description"  ," Code Client" , "Code Agent"}
        ) {
            Class[] columnTypes = new Class[]{
                Long.class, String.class, Long.class, String.class, String.class, String.class
            };

            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        };

        // Set model to the table
        TableBien.setModel(tableModel);
        
        voirProfile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the selected row from the table
                int selectedRow = TableBien.getSelectedRow();

                // Make sure a row is selected
                if (selectedRow != -1) {
                    // Access columns correctly based on the expected order
                    String CodeBien = TableBien.getValueAt(selectedRow, 0).toString();  // CodeBien column (index 0)
                    String Type = TableBien.getValueAt(selectedRow, 1).toString();  // Type column (index 1)
                    String Superficie = TableBien.getValueAt(selectedRow, 2).toString();  // Superficie column (index 2)
                    String Prix = TableBien.getValueAt(selectedRow, 3).toString();  // Prix column (index 3)
                    String Localisation = TableBien.getValueAt(selectedRow, 4).toString();  // Localisation column (index 4)
                    String Description = TableBien.getValueAt(selectedRow, 5).toString();  // Description column (index 5)
                    String CodeClient = TableBien.getValueAt(selectedRow, 6).toString();  // CodeClient column (index 6)
                    String CodeAgent = TableBien.getValueAt(selectedRow, 7).toString();  // CodeAgent column (index 7)

                    // Handle null or empty values gracefully (optional)
                    CodeBien = (CodeBien != null) ? CodeBien : "N/A";
                    Type = (Type != null) ? Type : "N/A";
                    Superficie = (Superficie != null) ? Superficie : "N/A";
                    Prix = (Prix != null) ? Prix : "N/A";
                    Localisation = (Localisation != null) ? Localisation : "N/A";
                    Description = (Description != null) ? Description : "N/A";
                    CodeClient = (CodeClient != null) ? CodeClient : "N/A";
                    CodeAgent = (CodeAgent != null) ? CodeAgent : "N/A";

                    // Create and show the AfficherInfo frame with the collected data
                    AfficherInfo frame = new AfficherInfo(CodeBien, Type, Superficie, Prix, Localisation, Description, CodeClient, CodeAgent);
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
        
        JComboBox<String> TypeBien = new JComboBox<>();
        TypeBien.setBackground(new Color(255, 255, 255));
        TypeBien.setFont(new Font("Core Sans C 65 Bold", Font.PLAIN, 13));
        TypeBien.setToolTipText("Type De Bien");
        TypeBien.setBounds(42, 83, 193, 31); // Set bounds correctly
        contentPane.add(TypeBien); // Add only once to the content pane

        TypeBien.setModel(new DefaultComboBoxModel<>(new String[] {"Type De Bien", "Maison", "Appartement", "Terrain", "Bungalow"}));
        TypeBien.setSelectedIndex(0); // Default selection set to "Type De Bien"

        TypeBien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Step 1: Get the selected type from the combo box
                String selectedType = (String) TypeBien.getSelectedItem();
                System.out.println("Selected Type: " + selectedType); // Debug: Check what type is selected

                // Step 2: Get the table model and clear current rows
                DefaultTableModel model = (DefaultTableModel) TableBien.getModel();

                // Step 3: Your data to populate in the table
                Object[][] data = {
                    {112847, "Appartement", 3864383, 123000000, "Alger, Lebiar", "Vue sur autoroute, résidence Araucaria", 9264, 1029},
                    {223874, "Maison", 5000000, 250000000, "Oran, Canastel", "Grande villa avec piscine et jardin", 8374, 2048},
                    {334839, "Terrain", 10000000, 80000000, "Constantine, Boussouf", "Terrain plat près du centre-ville", 10392, 3017},
                    {445892, "Bungalow", 2000000, 60000000, "Bejaia, Tichy", "Vue sur mer avec accès direct à la plage", 7294, 4502},
                    {112842, "Appartement", 4500000, 175000000, "Alger, Hydra", "Appartement luxueux dans une résidence sécurisée", 10284, 3209},
                    {223834, "Maison", 6000000, 300000000, "Tlemcen, Mansourah", "Maison traditionnelle avec cour intérieure", 12567, 4001},
                    {334725, "Terrain", 15000000, 120000000, "Setif, El Eulma", "Terrain agricole près de l'autoroute", 9402, 5092},
                    {445924, "Bungalow", 2500000, 70000000, "Annaba, Seraidi", "Bungalow isolé dans un cadre naturel", 3024, 6781},
                    {112983, "Appartement", 4000000, 140000000, "Alger, Bab El Oued", "Appartement en centre-ville proche des commerces", 8392, 1294},
                    {223945, "Maison", 7000000, 350000000, "Blida, Ouled Yaich", "Maison moderne avec jardin spacieux", 7281, 9021}
                };

                // Step 4: Check if "Type De Bien" filter is selected
                model.setRowCount(0); // Clear the existing rows

                if (selectedType != null && !selectedType.equals("Type De Bien")) {
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


        
        Searchbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the search query from the text field
                String query = rechercherBien.getText().trim().toLowerCase();

                // Get the table model to manipulate rows
                DefaultTableModel model = (DefaultTableModel) TableBien.getModel();

                // Original data (replicated for filtering)
                Object[][] data = {
                		{112847, "Appartement", 3864383, 123000000, "Alger, Lebiar", "Vue sur autoroute, résidence Araucaria", 9264, 1029},
                        {223874, "Maison", 5000000, 250000000, "Oran, Canastel", "Grande villa avec piscine et jardin", 8374, 2048},
                        {334839, "Terrain", 10000000, 80000000, "Constantine, Boussouf", "Terrain plat près du centre-ville", 10392, 3017},
                        {445892, "Bungalow", 2000000, 60000000, "Bejaia, Tichy", "Vue sur mer avec accès direct à la plage", 7294, 4502},
                        {112842, "Appartement", 4500000, 175000000, "Alger, Hydra", "Appartement luxueux dans une résidence sécurisée", 10284, 3209},
                        {223834, "Maison", 6000000, 300000000, "Tlemcen, Mansourah", "Maison traditionnelle avec cour intérieure", 12567, 4001},
                        {334725, "Terrain", 15000000, 120000000, "Setif, El Eulma", "Terrain agricole près de l'autoroute", 9402, 5092},
                        {445924, "Bungalow", 2500000, 70000000, "Annaba, Seraidi", "Bungalow isolé dans un cadre naturel", 3024, 6781},
                        {112983, "Appartement", 4000000, 140000000, "Alger, Bab El Oued", "Appartement en centre-ville proche des commerces", 8392, 1294},
                        {223945, "Maison", 7000000, 350000000, "Blida, Ouled Yaich", "Maison moderne avec jardin spacieux", 7281, 9021}
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
        for (int j = 0; j < TableBien.getColumnCount(); j++) {
            TableBien.getColumnModel().getColumn(j).setCellRenderer(centerRenderer);
        }
        

        SupprimerBien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = TableBien.getSelectedRow();
                if (selectedRow != -1) { // Check if a row is selected
                    supprimerPanel supperimerPanel = new supprimerPanel(selectedRow, TableBien);
                    supperimerPanel.setVisible(true);
                    supperimerPanel.setLocationRelativeTo(null); // Center the panel
                } else {
                    System.out.println("Please select a row to delete.");
                }
            }
        });

        ajouterBien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) TableBien.getModel();
                model.addRow(new Object[]{
                        0L, "", 0L, "", "", ""
                });
            }
        });
    }
}