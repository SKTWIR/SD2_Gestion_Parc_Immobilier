
import java.awt.EventQueue;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Test {

    private JFrame frame;
    private JTextField textFieldEmail;
    private JPasswordField textFieldPassword;

    // Simulation de base de données : email -> {mot de passe, type}
    private static HashMap<String, String[]> utilisateurs = new HashMap<>();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Test window = new Test();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Test() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 638, 496);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Bouton Se connecter
        JButton btnLogin = new JButton("Se connecter");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = textFieldEmail.getText();
                String password = new String(textFieldPassword.getPassword());

                if (utilisateurs.containsKey(email)) {
                    if (utilisateurs.get(email)[0].equals(password)) {
                        JOptionPane.showMessageDialog(frame, "Connexion réussie !");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Mot de passe incorrect !");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Email inconnu. Veuillez créer un compte.");
                }
            }
        });
        btnLogin.setBounds(108, 281, 195, 44);
        frame.getContentPane().add(btnLogin);

        // Boutons radio pour les types d'utilisateur
        JRadioButton rdbtnProprietaire = new JRadioButton("Propriétaire");
        rdbtnProprietaire.setBounds(197, 246, 109, 23);
        frame.getContentPane().add(rdbtnProprietaire);

        JRadioButton rdbtnPrestataire = new JRadioButton("Prestataire");
        rdbtnPrestataire.setBounds(197, 220, 109, 23);
        frame.getContentPane().add(rdbtnPrestataire);

        JRadioButton rdbtnVisiteur = new JRadioButton("Visiteur");
        rdbtnVisiteur.setBounds(197, 194, 109, 23);
        frame.getContentPane().add(rdbtnVisiteur);

        // Groupement des boutons radio
        ButtonGroup group = new ButtonGroup();
        group.add(rdbtnProprietaire);
        group.add(rdbtnPrestataire);
        group.add(rdbtnVisiteur);

        // Label principal
        JLabel lblNewLabel = new JLabel("Connection au gestionnaire immobilier");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setBounds(179, 43, 296, 44);
        frame.getContentPane().add(lblNewLabel);

        // Champs texte pour l'email
        textFieldEmail = new JTextField();
        textFieldEmail.setBounds(189, 102, 255, 20);
        frame.getContentPane().add(textFieldEmail);
        textFieldEmail.setColumns(10);

        // Champs texte pour le mot de passe
        textFieldPassword = new JPasswordField();
        textFieldPassword.setBounds(189, 142, 255, 20);
        frame.getContentPane().add(textFieldPassword);
        textFieldPassword.setColumns(10);

        // Labels
        JLabel lblEmail = new JLabel("email :");
        lblEmail.setBounds(148, 105, 48, 14);
        frame.getContentPane().add(lblEmail);

        JLabel lblPassword = new JLabel("mot de passe :");
        lblPassword.setBounds(108, 145, 71, 14);
        frame.getContentPane().add(lblPassword);

        // Bouton Créer un compte
        JButton btnRegister = new JButton("Créer un compte");
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = textFieldEmail.getText();
                String password = new String(textFieldPassword.getPassword());

                if (!utilisateurs.containsKey(email)) {
                    String type = null;
                    if (rdbtnVisiteur.isSelected()) type = "Visiteur";
                    else if (rdbtnPrestataire.isSelected()) type = "Prestataire";
                    else if (rdbtnProprietaire.isSelected()) type = "Propriétaire";

                    if (type != null) {
                        utilisateurs.put(email, new String[]{password, type});
                        JOptionPane.showMessageDialog(frame, "Compte créé avec succès !");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Veuillez sélectionner un type.");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Email déjà utilisé. Veuillez vous connecter.");
                }
            }
        });
        btnRegister.setBounds(312, 281, 195, 44);
        frame.getContentPane().add(btnRegister);

        // Bouton Mot de passe oublié
        JButton btnForgotPassword = new JButton("Mot de passe oublié ?");
        btnForgotPassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = textFieldEmail.getText();

                if (utilisateurs.containsKey(email)) {
                    String newPassword = JOptionPane.showInputDialog(frame, "Entrez un nouveau mot de passe :");
                    if (newPassword != null && !newPassword.isEmpty()) {
                        utilisateurs.get(email)[0] = newPassword;
                        JOptionPane.showMessageDialog(frame, "Mot de passe mis à jour avec succès !");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Email inconnu !");
                }
            }
        });
        btnForgotPassword.setBounds(457, 141, 135, 23);
        frame.getContentPane().add(btnForgotPassword);
    }
}


