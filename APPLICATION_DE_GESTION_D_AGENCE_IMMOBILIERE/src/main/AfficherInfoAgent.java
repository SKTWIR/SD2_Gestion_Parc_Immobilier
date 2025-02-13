package main;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AfficherInfoAgent extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtCodeAgent, txtNom, txtAdresse, txtNumTele, txtAdressemail;

    // Constructor accepting data for the fields
    public AfficherInfoAgent(String codeAgent, String Nom, String Adresse, String NumTelephone, String Email) {
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
        createLabelAndField("Code Agent:", 24, 67, codeAgent, txtCodeAgent = new JTextField());
        createLabelAndField("Nom Complet:", 24, 111, Nom, txtNom = new JTextField());
        createLabelAndField("Adresse:", 24, 155, Adresse, txtAdresse = new JTextField());
        createLabelAndField("Numero Telephone:", 24, 199, NumTelephone, txtNumTele = new JTextField());
        createLabelAndField("Adresse Email:", 24, 243, Email, txtAdressemail = new JTextField());
    }

    // Helper method to create labels and populate fields
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