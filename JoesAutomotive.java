/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphicalunitinterfacechalleges;

import javax.swing.*;
import java.awt.event.*; // Needed for event listener interface
import java.awt.*;
import java.text.DecimalFormat;


public class JoesAutomotive extends JFrame {

    private JLabel subTotalLabel;
    private JTextField hoursTextField;
    private JTextField subTotalTextField;
    private JCheckBox oil;
    private JCheckBox lube;
    private JCheckBox radiator;
    private JCheckBox transmission;
    private JCheckBox inspection;
    private JCheckBox muffler;
    private JCheckBox tire;
    private JCheckBox non;
    private final int WINDOW_WIDTH = 300; // Window width
    private final int WINDOW_HEIGHT = 70; // Window height

    DecimalFormat formatter = new DecimalFormat("$##0.00");

    public JoesAutomotive() /**
     * Constructor
     */
    {
        // Set the title bar text.
        setTitle("Joe's Automotive");

        // Specify what happens when the close button is clicked.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel panel = new JPanel();       // A panel to hold components
        JPanel leftPanel = new JPanel();
         JPanel SPanel = new JPanel();

        subTotalLabel = new JLabel(" Sub Total :");

        oil = new JCheckBox("Oil Change");
        lube = new JCheckBox("Lube job");
        radiator = new JCheckBox("Radiator flush");
        transmission = new JCheckBox("Transmission flush");
        inspection = new JCheckBox("Inspection");
        muffler = new JCheckBox("Muffler replacement");
        tire = new JCheckBox("Tire rotation");
        non = new JCheckBox("Nonroutine services");
        hoursTextField = new JTextField(6);
        subTotalTextField = new JTextField(6);
        JButton button1 = new JButton("Total");	// Create the total  button.

        // Register an event listener the button.
        button1.addActionListener(new ButtonListener());

        // Create a panel and add the checkboxes to it
        leftPanel.add(oil);
        leftPanel.add(lube);
        leftPanel.add(radiator);
        leftPanel.add(transmission);
        leftPanel.add(inspection);
        leftPanel.add(muffler);
        leftPanel.add(tire);
        leftPanel.add(non);
        leftPanel.add(hoursTextField);
        panel.add(button1);
        panel.add(subTotalLabel);
        panel.add(subTotalTextField);

        add(panel, BorderLayout.SOUTH);		// Add the panel to the content pane.
        add(leftPanel, BorderLayout.WEST);
        
        

        pack();				// Automatically set the size of the window
        setVisible(true);	// Display the window
    }

    /**
     * Private inner class that handles the event when the user clicks a button.
     */
    private class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String input;			// To hold the user's input
            double nonRoutineCost;	// Cost of nonroutine services
            double subTotal = 0;		// Subtotal

            if (oil.isSelected()) {
                subTotal += 26;
            }
            if (lube.isSelected()) {
                subTotal += 18;
            }
            if (radiator.isSelected()) {
                subTotal += 30;
            }
            if (transmission.isSelected()) {
                subTotal += 80;
            }
            if (inspection.isSelected()) {
                subTotal += 15;
            }
            if (muffler.isSelected()) {
                subTotal += 100;
            }
            if (tire.isSelected()) {
                subTotal += 20;
            }
            if (non.isSelected()) {
                input = hoursTextField.getText();
                nonRoutineCost = Double.parseDouble(input) * 20;
                subTotal += nonRoutineCost;
            }

          
            String subTotalString = formatter.format(subTotal);
            subTotalTextField.setText(subTotalString);
        }
    }

    
    public static void main(String[] args) {
        new JoesAutomotive();
    }

} // end class
