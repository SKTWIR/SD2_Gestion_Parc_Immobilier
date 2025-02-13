package main;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color; // Import this for using Color
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class LandingPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Image backgroundImage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LandingPage frame = new LandingPage();
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
	public LandingPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 625);
		contentPane = new JPanel() {
			// Overriding the paintComponent to add the background image
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				// Draw the background image
				if (backgroundImage != null) {
					g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
				}
				// Draw the overlay with the new color and opacity
				Color overlayColor = new Color(64, 128, 128, 180); // #408080 with 50% opacity
				g.setColor(overlayColor);
				g.fillRect(0, 0, getWidth(), getHeight());
			}
		};
		contentPane.setBackground(new Color(17, 91, 60)); // Default background color
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Load background image
		backgroundImage = new ImageIcon("resources/noun-house-7369835.jpg").getImage();
		
		JLabel bienvenue = new JLabel("Gestion de parc immobilier");
		bienvenue.setForeground(new Color(255, 255, 255));
		bienvenue.setFont(new Font("Core Sans C 75 ExtraBold", Font.PLAIN, 35));
		bienvenue.setBounds(165, 66, 489, 69);
		contentPane.add(bienvenue);
		
		JButton listeagentbutton = new JButton("Liste Des Propriétaires");
		listeagentbutton.setBorder(new LineBorder(new Color(255, 255, 255), 4, true));
		listeagentbutton.setBackground(new Color(255, 255, 255));
		listeagentbutton.setFont(new Font("Core Sans C 65 Bold", Font.PLAIN, 13));
		listeagentbutton.setBounds(282, 181, 179, 42);
		contentPane.add(listeagentbutton);
		
		  listeagentbutton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Here, create the second window (JFrame) that will be shown when the button is clicked
	                ListeAgent listeagent = new ListeAgent();  // Assuming SecondPage is the second JFrame class
	                listeagent.setVisible(true);
	                dispose();  // Close the landing page window if needed
	            }
	        });
		
		JButton listeclientbutton = new JButton("Liste Des Clients");
		listeclientbutton.setBackground(new Color(255, 255, 255));
		listeclientbutton.setBorder(new LineBorder(new Color(255, 255, 255), 4, true));
		listeclientbutton.setFont(new Font("Core Sans C 65 Bold", Font.PLAIN, 13));
		listeclientbutton.setBounds(282, 259, 179, 42);
		contentPane.add(listeclientbutton);
		
		listeclientbutton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Here, create the second window (JFrame) that will be shown when the button is clicked
	                ListeClient listeclients = new ListeClient();  // Assuming SecondPage is the second JFrame class
	                listeclients.setVisible(true);
	                dispose();  // Close the landing page window if needed
	            }
	        });
		
		JButton listebienbutton = new JButton("Liste Des Biens");
		listebienbutton .setBackground(new Color(255, 255, 255));
		listebienbutton .setBorder(new LineBorder(new Color(255, 255, 255), 4, true));
		listebienbutton .setFont(new Font("Core Sans C 65 Bold", Font.PLAIN, 13));
		listebienbutton .setBounds(282, 337, 179, 42);
		contentPane.add(listebienbutton );
		

		listebienbutton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Here, create the second window (JFrame) that will be shown when the button is clicked
	                ListeBiens listebiens = new ListeBiens();  // Assuming SecondPage is the second JFrame class
	                listebiens.setVisible(true);
	                dispose();  // Close the landing page window if needed
	            }
	        });
		
		JButton listetransactionbutton  = new JButton("Transactions");
		listetransactionbutton.setBackground(new Color(255, 255, 255));
		listetransactionbutton.setBorder(new LineBorder(new Color(255, 255, 255), 4, true));
		listetransactionbutton.setFont(new Font("Core Sans C 65 Bold", Font.PLAIN, 13));
		listetransactionbutton.setBounds(282, 413, 179, 42);
		contentPane.add(listetransactionbutton);
		

		listetransactionbutton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Here, create the second window (JFrame) that will be shown when the button is clicked
	            	ListeTransactions listetransactions = new ListeTransactions();  // Assuming SecondPage is the second JFrame class
	            	listetransactions.setVisible(true);
	                dispose();  // Close the landing page window if needed
	            }
	        });
		
		
	}
}