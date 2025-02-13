package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class supprimerPanel extends JFrame {
    private static final long serialVersionUID = 1L;

    public supprimerPanel(int selectedRow, JTable table) {
        setTitle("Confirmation");
        setSize(300, 150);
        setLayout(new BorderLayout());

        JLabel message = new JLabel("Voulez-vous supprimer cet élément ?", SwingConstants.CENTER);
        add(message, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton ouiButton = new JButton("Oui");
        JButton nonButton = new JButton("Non");

        buttonPanel.add(ouiButton);
        buttonPanel.add(nonButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // ActionListener for "Oui" button
        ouiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remove the selected row from the table
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.removeRow(selectedRow);
                dispose(); // Close the panel
            }
        });

        // ActionListener for "Non" button
        nonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the panel without action
            }
        });
    }
}