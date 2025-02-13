package main;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AfficherInfo extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtCodeBien , txtType, txtSuperficie, txtPrix, txtLocalisation, txtDescription, txtCodeAgent, txtCodeClient;
    private JTextField textField;

    // Constructor accepting data for the fields
    public AfficherInfo(String codeBien , String type, String superficie, String prix, String localisation, String description , String codeClient,String codeAgent) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 452, 493);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblInformation = new JLabel("Information");
        lblInformation.setFont(new Font("Core Sans C 75 ExtraBold", Font.PLAIN, 17));
        lblInformation.setBounds(24, 11, 163, 24);
        contentPane.add(lblInformation);

        // Labels and Text Fields
        createLabelAndField("Code Bien:", 24, 354, codeBien, txtCodeBien = new JTextField());
        createLabelAndField("Type:", 24, 59, type, txtType = new JTextField());
        createLabelAndField("Superficie:", 24, 100, superficie, txtSuperficie = new JTextField());
        createLabelAndField("Prix:", 24, 141, prix, txtPrix = new JTextField());
        createLabelAndField("Localisation:", 24, 183, localisation, txtLocalisation = new JTextField());
        createLabelAndField("Description:", 24, 215, description, txtDescription = new JTextField());
        createLabelAndField("Code Client:", 24, 313, codeClient, txtCodeClient = new JTextField());
        createLabelAndField("Code Agent:", 24, 272, codeAgent, txtCodeAgent = new JTextField());
    }

    // Helper method to create labels and populate field
    	
    	 private void createLabelAndField(String labelText, int x, int y, String value, JTextField field) {
    	        // Create and configure label
    	        JLabel label = new JLabel(labelText);
    	        label.setFont(new Font("Core Sans C 55 Medium", Font.PLAIN, 13));
    	        label.setBounds(x, y, 150, 20); // Adjust width of the label for alignment
    	        contentPane.add(label);

    	        // Configure text field
    	        field.setText(value);
    	        field.setEditable(false); // Make fields non-editable
    	        field.setBounds(x + 160, y, 200, 20); // Align text field relative to the label
    	        contentPane.add(field);
  
        
        
        
        
    }
}