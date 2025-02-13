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
import java.util.Random;

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

public class ListeAgent extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	ListeAgent frame = new ListeAgent();
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
    public ListeAgent() {
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

        JLabel GestionAgents= new JLabel("Gestion Des Agents ", personicon , JLabel.LEFT); 
        GestionAgents.setFont(new Font("Core Sans C 75 ExtraBold", Font.PLAIN, 18));
        GestionAgents.setBounds(20, 10, 233, 31);
        contentPane.add(GestionAgents);
        
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

        JButton SupprimerAgent = new JButton();
        SupprimerAgent.setBackground(new Color(221, 0, 0));
        SupprimerAgent.setPreferredSize(new Dimension(31, 7));
        SupprimerAgent.setBounds(864, 30, 39, 23);

        ImageIcon originalIcon1 = new ImageIcon("resources/delete.png");
        Image scaledImage1 = originalIcon1.getImage().getScaledInstance(20, 20 , Image.SCALE_SMOOTH);
        ImageIcon deleteicon= new ImageIcon(scaledImage1);

        SupprimerAgent.setIcon(deleteicon);
        SupprimerAgent.setBounds(852, 30, 47, 40);
        contentPane.add(SupprimerAgent);

        JButton voirProfile = new JButton();
        voirProfile.setBackground(new Color(255, 255, 255));
        voirProfile.setBounds(477, 30, 50, 40);

        ImageIcon originalIcon2 = new ImageIcon("resources/eye.png");
        Image scaledImage2 = originalIcon2.getImage().getScaledInstance(20, 20 , Image.SCALE_SMOOTH);
        ImageIcon viewicon = new ImageIcon(scaledImage2);

        voirProfile.setIcon(viewicon);
        voirProfile.setBounds(800, 30, 47, 40);
        contentPane.add(voirProfile); 
        
        
     

        JTextField rechercherAgent = new JTextField();
        rechercherAgent.setBounds(44, 83, 549, 31);
        contentPane.add(rechercherAgent);
        rechercherAgent.setColumns(10);

        ImageIcon originalIcon3 = new ImageIcon("resources/plus_icon.png");
        Image scaledImage3 = originalIcon3.getImage().getScaledInstance(15, 15 , Image.SCALE_SMOOTH);
        ImageIcon plusicon = new ImageIcon(scaledImage3);

        /*JButton ajouterAgent = new JButton("Ajouter");
        ajouterAgent.setBackground(new Color(255, 255, 255));
        ajouterAgent.setFont(new Font("Core Sans C 65 Bold", Font.PLAIN, 13));
        ajouterAgent.setBounds(675, 83, 224, 32);
        ajouterAgent.setIcon(plusicon); // Set the icon
        ajouterAgent.setHorizontalTextPosition(SwingConstants.LEFT); // Position text to the left of the icon
        ajouterAgent.setFocusPainted(false); // Optional: To remove the focus border
        contentPane.add(ajouterAgent);*/
        
     

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setFont(new Font("Core Sans C 55 Medium", Font.PLAIN, 11));
        scrollPane.setBounds(44, 139, 855, 439);
        contentPane.add(scrollPane);

        JTable TableAgent = new JTable();
        TableAgent.setIntercellSpacing(new Dimension(9, 9));
        TableAgent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TableAgent.setFont(new Font("Core Sans C 55 Medium", Font.PLAIN, 13));
        TableAgent.setRowHeight(40);
        scrollPane.setViewportView(TableAgent);

        // Initialize data in HashMap with Code Client as the key
        HashMap<Long, Object[]> dataMap = new HashMap<>();
        dataMap.put(1124L, new Object[]{1124L, "Nathalie Fluet", "10 rue Jean-Monnet 95500 Gonesse", 0677756453 , "natalie.fluet@gmail.com"});
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
                "Code Agent", "Nom Agent", "Adresse", "Numero de Telephone", "Email"}
        ) {
            Class[] columnTypes = new Class[]{
                Long.class, Long.class, Long.class, Long.class, Long.class
            };

            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        };

        // Set model to the table
        TableAgent.setModel(tableModel);
        
        voirProfile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the selected row from the table
                int selectedRow = TableAgent.getSelectedRow();

                // Make sure a row is selected
                if (selectedRow != -1) {
                    // Get data from the selected row
                    String CodeAgent = TableAgent.getValueAt(selectedRow, 0).toString();  // Code Bien column
                    String NomAgent = TableAgent.getValueAt(selectedRow, 1).toString();  // Type column
                    String Numtelephone = TableAgent.getValueAt(selectedRow, 2).toString();
                    String Adresse = TableAgent.getValueAt(selectedRow, 3).toString();  // Description column
                    String email = TableAgent.getValueAt(selectedRow, 4).toString();  // Prix column             
                    // Create and show the AfficherInfo frame
                    AfficherInfoAgent frame = new AfficherInfoAgent(CodeAgent , NomAgent, Numtelephone, Adresse, email);
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
        
        
        Searchbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the search query from the text field
                String query = rechercherAgent.getText().trim().toLowerCase();

                // Get the table model to manipulate rows
                DefaultTableModel model = (DefaultTableModel) TableAgent.getModel();

                // Original data (replicated for filtering)
                Object[][] data = {
                		 {1124L, "Harmim Amine", "Cite Diar El Mahçoul, Oran, bloc 12/3", 550123456 , "amineh7@gmail.com"},
                	     {2238L, "Aigoun Ahmed", "Quartier Sidi M'hamed, Alger, bâtiment A4", 560987654 , "Aigmed7@gmail.com"},
                	     {3348L, "Benali Leila", "Résidence El Yasmine, Blida, immeuble 15", 571478523 , "Benali7@gmail.com"},
                	     {4458L, "Guermat Ines", "Quartier Diar Essalam, Skikda, bloc D1", 549876543 , "Guernes7@gmail.com"},
                	     {1128L, "Bouhraoua Mohamed", "Résidence Les Pins, Bejaia, bâtiment 10", 523654123 , "Bouhmoh7@gmail.com"},
                	     {2238L, "Hachi Mohamed", "Quartier Sidi M'hamed, Alger, bâtiment A4", 541234567 , "Hachmoh7@gmail.com"},
                	     {3347L, "Heffaf Karima", "Cite 20 Août, Annaba, bloc B2", 559876543 , "Hefkar7@gmail.com"},
                	     {4459L, "Tilmatine Sara", "Cite des Roses, Sétif, immeuble 02", 567890123 , "Tilsar7@gmail.com"},
                	     {1129L, "Barama Neila", "Résidence El Amal, Tizi Ouzou, immeuble 17", 573210987 , "Barnei7@gmail.com"},
                	     {2239L, "Dahmoune Sonia", "Résidence El Amal, Tizi Ouzou, immeuble 17", 525678901 , "Dahson7@gmail.com"},
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
        for (int j = 0; j < TableAgent.getColumnCount(); j++) {
        	TableAgent.getColumnModel().getColumn(j).setCellRenderer(centerRenderer);
        }
        

        SupprimerAgent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = TableAgent.getSelectedRow();
                if (selectedRow != -1) { // Check if a row is selected
                    supprimerPanel supperimerPanel = new supprimerPanel(selectedRow, TableAgent);
                    supperimerPanel.setVisible(true);
                    supperimerPanel.setLocationRelativeTo(null); // Center the panel
                } else {
                    System.out.println("Please select a row to delete.");
                }
            }
        });
        
     // Bouton Ajouter
        JButton btnAjouter = new JButton("Ajouter");
        btnAjouter.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnAjouter.setBounds(675, 83, 224, 32);
        contentPane.add(btnAjouter);
        
        btnAjouter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JPanel panel = new JPanel();
                panel.setLayout(null);
                JFrame frame = new JFrame("Ajouter un Agent");
                frame.setSize(400, 300);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
                JLabel lblNom = new JLabel("Nom:");
                lblNom.setBounds(20, 20, 100, 25);
                panel.add(lblNom);
                JTextField txtNom = new JTextField();
                txtNom.setBounds(140, 20, 200, 25);
                panel.add(txtNom);
                
                JLabel lblAdresse = new JLabel("Adresse:");
                lblAdresse.setBounds(20, 60, 100, 25);
                panel.add(lblAdresse);
                JTextField txtAdresse = new JTextField();
                txtAdresse.setBounds(140, 60, 200, 25);
                panel.add(txtAdresse);
                
                JLabel lblTelephone = new JLabel("Téléphone:");
                lblTelephone.setBounds(20, 100, 100, 25);
                panel.add(lblTelephone);
                JTextField txtTelephone = new JTextField();
                txtTelephone.setBounds(140, 100, 200, 25);
                panel.add(txtTelephone);
                
                JLabel lblEmail = new JLabel("Email:");
                lblEmail.setBounds(20, 140, 100, 25);
                panel.add(lblEmail);
                JTextField txtEmail = new JTextField();
                txtEmail.setBounds(140, 140, 200, 25);
                panel.add(txtEmail);
                
                JButton btnSave = new JButton("Enregistrer");
                btnSave.setBounds(140, 180, 120, 30);
                panel.add(btnSave);
                
                btnSave.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Random rand = new Random();
                        int codeAgent = rand.nextInt(9000) + 1000; // Générer un code entre 1000 et 9999
                        
                        tableModel.addRow(new Object[]{
                            codeAgent, txtNom.getText(), txtAdresse.getText(), txtTelephone.getText(), txtEmail.getText()
                        });
                        
                        frame.dispose();
                    }
                });
                
                frame.add(panel);
                frame.setVisible(true);
            }
        });

        /*ajouterAgent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) TableAgent.getModel();
                model.addRow(new Object[]{
                        0L, "", 0L, "", "", ""
                });
            }
        });*/     
    }
}