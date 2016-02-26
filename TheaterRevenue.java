package graphicalunitinterfacechalleges;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Me
 */
public class TheaterRevenue extends JFrame {

    private JPanel panel;

    private JLabel adultTicketsPriceL;
    private JLabel adultTicketsSoldL;
    private JLabel childTicketsPriceL;
    private JLabel childTicketsSoldL;
    private JLabel grossRevnueAdultLabel;		
    private JLabel netReveuneAdultLabel;
    private JLabel grossRevnueChildLabel;
    private JLabel netRevenueChildLabel;
    private JLabel totalGrossRevLabel;
    private JLabel totalNetRevLabel;

    private JTextField adultTicketsPriceF;
    private JTextField adultTicketsSoldF;
    private JTextField childTicketsPriceF;
    private JTextField childTicketsSoldF;
    private JTextField grossRevnueAdultField;	       
    private JTextField netReveuneAdultField;		  
    private JTextField grossRevnueChildField;	          
    private JTextField netRevenueChildField;	         
    private JTextField totalGrossRevField;		  
    private JTextField totalNetRevField;	          

    private JButton calculateButton;			  
    private final int WINDOW_WIDTH = 600;			
    private final int WINDOW_HEIGHT = 300;		

    private double BOX_OFFICE_PERCENTAGE = .20;

    public TheaterRevenue() {
        // set window title
        setTitle("Theater revenue Calculator");

        // set widow size
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        // tell what to do when the window closes
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a BorderLayout manager.
        //setLayout(new FlowLayout());

        // build the panel and add it to the frame
        buildPanel();

        // add the panel to the frame's content pane
        //add(panel);
        // display the window
        setVisible(true);
    }

    private void buildPanel() {

        // create a label for 
        adultTicketsPriceL = new JLabel("Enter price for adult tickets. ");

        // create a text field 10 characters wide
        adultTicketsPriceF = new JTextField(10);

        // create a label for 
        childTicketsPriceL = new JLabel("Enter price for child tickets. ");

        // create a text field 10 characters wide
        childTicketsPriceF = new JTextField(10);

        // create a label for 
        adultTicketsSoldL = new JLabel("Enter number of adult tickets sold . ");

        // create a text field 10 characters wide
        adultTicketsSoldF = new JTextField(10);

        // create a label for 
        childTicketsSoldL = new JLabel("Enter number of child tickets sold . ");

        // create a text field 10 characters wide
        childTicketsSoldF = new JTextField(10);

        // create a button with the capation "Calculate reimbursement"
        calculateButton = new JButton("Calculate revenue ");

        grossRevnueAdultLabel = new JLabel("Gross adult revenue : ");
        netReveuneAdultLabel = new JLabel("Net adult revenue :  ");
        grossRevnueChildLabel = new JLabel("Gross child revenue :");
        netRevenueChildLabel = new JLabel("Net child revenue :");
        totalGrossRevLabel = new JLabel("Total gross revenue : ");
        totalNetRevLabel = new JLabel(" Total net revenue : ");

        grossRevnueAdultField = new JTextField(10);
        netReveuneAdultField = new JTextField(10);
        grossRevnueChildField = new JTextField(10);
        netRevenueChildField = new JTextField(10);
        totalGrossRevField = new JTextField(10);
        totalNetRevField = new JTextField(10);

        // add an action listener to the button
        calculateButton.addActionListener(
                new TheaterRevenue.CalcButtonListener());

        // create a JPanel object and let the panel filed reference it
        panel = new JPanel();

        // Add the labels, text field and button components to the panel
        panel.add(adultTicketsPriceL);

        panel.add(adultTicketsPriceF);
        
        panel.add(adultTicketsSoldL);

        panel.add(adultTicketsSoldF);

        panel.add(childTicketsPriceL);

        panel.add(childTicketsPriceF);

        

        panel.add(childTicketsSoldL);

        panel.add(childTicketsSoldF);

        panel.add(calculateButton);

        panel.add(grossRevnueAdultLabel);

        panel.add(grossRevnueAdultField);

        panel.add(netReveuneAdultLabel);
        panel.add(netReveuneAdultField);

        panel.add(grossRevnueChildLabel);

        panel.add(grossRevnueChildField);

        panel.add(netRevenueChildLabel);

        panel.add(netRevenueChildField);

        panel.add(totalGrossRevLabel);

        panel.add(totalGrossRevField);

        panel.add(totalNetRevLabel);
        panel.add(totalNetRevField);

        //Add panels to content pane
        add(panel);

    }

    private class CalcButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            String numberA, numberC, priceA, priceC;
            double numberAD, numberCD, priceAD, priceCD;

            DecimalFormat formatter = new DecimalFormat("$##0.00");
            // get the text entered by the user in the text field box

            numberA = adultTicketsSoldF.getText();
            priceA = adultTicketsPriceF.getText();
            numberC = childTicketsSoldF.getText();
            priceC = childTicketsPriceF.getText();

            // Convert input text to double
            numberAD = Double.parseDouble(numberA);
            priceAD = Double.parseDouble(priceA);
            numberCD = Double.parseDouble(numberC);
            priceCD = Double.parseDouble(priceC);

            double gRA = (numberAD * priceAD);

            double gRC = (numberCD * priceCD);

            double nRA = (gRA * BOX_OFFICE_PERCENTAGE);

            double nRC = (gRC * BOX_OFFICE_PERCENTAGE);

            double totalGrossRevenue = (gRA + gRC);
            double totalNetRevenue = (nRA + nRC);

            String gRAS = formatter.format(gRA);
            String gRCS = formatter.format(gRC);
            String nRAS = formatter.format(nRA);
            String nRCS = formatter.format(nRC);
            String TG = formatter.format(totalGrossRevenue);
            String TN = formatter.format(totalNetRevenue);

            // display the results
            grossRevnueAdultField.setText(gRAS);
            grossRevnueChildField.setText(gRCS);

            netReveuneAdultField.setText(nRAS);
            netRevenueChildField.setText(nRCS);

            totalGrossRevField.setText(TG);
            totalNetRevField.setText(TN);

        }
    }
    
    public static void main(String[] args) {
        new TheaterRevenue();
    }
}
