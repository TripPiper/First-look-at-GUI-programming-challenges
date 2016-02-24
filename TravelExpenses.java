/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 * - Number of days on the trip - Amount of airfare, if any - Amount of car
 * rental fees, if any - Number of miles driven, if a private vehicle was used -
 * Amount of parking fees, if any - Amount of taxi charges, if any - Conference
 * or seminar registration fees, if any - Lodging charges, per night
 *
 * The company reimburses travel expenses according to the following policy: -
 * $37 per day for meals - Parking fees, up to $10.00 per day - Taxi charges up
 * to $95.00 per day - If a private vehicle is used, $0.27 per mile driven
 *
 * The application should calculate and display the following: - Total expenses
 * incurred by the business person - Total allowable expenses for the trip - The
 * excess that must be paid by the business person, if any - The amount saved by
 * the business person if the expenses are under the total allowed
 */
/**
 *
 * @author Tutor
 */
public class TravelExpenses extends JFrame {

    private JPanel panel, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, pExtra;		                  // to reference a panel
    private JLabel numberDaysMessageLabel;		  // to reference wholesale label
    private JLabel amountOfAirFareMessageLabel;	          // to reference mark up label
    private JLabel amountCarRentalLabel;
    private JLabel numberOfMilesDrivenMessageLabel;       // get number of miles driven in private vechical
    private JLabel parkingFeesMessageLabel;	          // to reference parking fees
    private JLabel taxiFeesMessageLabelel;
    private JLabel registrationMessageLabel;		// to reference wholesale label
    private JLabel lodgingChargesMessageLabel;		// to reference per night lodging charges
    private JLabel reimbursementALabel;
    private JLabel excessPaidByYouLabel;
    private JLabel savedByYouTLabel;
    private JLabel reimbursementTLabel;
    private JLabel amountReimburseToYouLabel;
    private JLabel greeting;

    private JTextField numberDaysPriceField;	          // to reference the Whole Sale Price Field
    private JTextField amountOfAirFareField;		  // to reference the Mark Up text field
    private JTextField amountCarRentalField;	          // to reference the Retail Price Field
    private JTextField numberOfMilesDrivenField;	          // to reference the Whole Sale Price Field
    private JTextField parkingFeesField;		  // to reference the Mark Up text field
    private JTextField registrationField;	          // to reference the Retail Price Field
    private JTextField lodgingChargesField;		  // to reference the Mark Up text field
    private JTextField taxiFeesField;
    private JTextField reimbursementTField;
    private JTextField reimbursementAField;
    private JTextField excessPaidByYouField;
    private JTextField savedByYouTField;
    private JTextField amountReimburseToYouField;

    private JButton calculateButton;			  // to reference calculate button
    private final int WINDOW_WIDTH = 600;			// Window Width
    private final int WINDOW_HEIGHT = 150;			// Window Height 

    // 5 required constants
    private double MEALS_AMOUNT = 37.00; // Meals amount reimbursed by company per day.
    private double PARKING_FEES_REIMBURSED = 10.00; // Parking Fees amount reimbursed by company per day.
    private double TAXI_CHARGES_REIM = 20.00; // Taxi Charges amount reimbursed by company per day.
    private double LODGING_CHARGES_REIMBURSED = 95.00; // Lodging Charges amount reimbursed by company per day.
    private double pr_Vechicle_Per_Mile_Reimbursed = 0.27; // Private Vehicle per miles reimbursment rate.

    public TravelExpenses() {

        // set window title
        setTitle("Travel Expense Calculator");

        // set widow size
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        // tell what to do when the window closes
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a BorderLayout manager.
        setLayout(new GridLayout(5, 2));

        // build the panel and add it to the frame
        buildPanel();

        // add the panel to the frame's content pane
        //add(panel);
        // display the window
        setVisible(true);
    }

    private void buildPanel() {

        // create a label for 
        numberDaysMessageLabel = new JLabel("Enter number of days on trip ");

        // create a text field 10 characters wide
        numberDaysPriceField = new JTextField(10);

        // create a label for 
        amountOfAirFareMessageLabel = new JLabel("Enter amount of airfare ");

        // create a text field 10 characters wide
        amountOfAirFareField = new JTextField(10);

        // create a label for 
        amountCarRentalLabel = new JLabel("Enter total amount of car rental. ");

        // create a text field 10 characters wide
        amountCarRentalField = new JTextField(10);

        // create a label for t
        numberOfMilesDrivenMessageLabel = new JLabel("Enter number of miles driven in your personal car ");

        // create a text field 10 characters wide
        numberOfMilesDrivenField = new JTextField(10);

        // create a label for parking fees
        parkingFeesMessageLabel = new JLabel("Enter parking fees ");

        // create a text field 10 characters wide
        parkingFeesField = new JTextField(10);

        // create a label for registrationMessageLabel
        registrationMessageLabel = new JLabel("Enter registration fees ");

        // create a text field 10 characters wide
        registrationField = new JTextField(10);

        // create a label for  lodgingChargesMessageLabel
        lodgingChargesMessageLabel = new JLabel("Enter per day lodging charges. ");

        // create a text field 10 characters wide
        lodgingChargesField = new JTextField(10);

        // create a label for  taxiFeesMessageLabelel 
        taxiFeesMessageLabelel = new JLabel("Enter per day taxi charges. ");

        // create a text field 10 characters wide
        taxiFeesField = new JTextField(10);
        
        greeting = new JLabel ("THE RESULTS ARE BELOW.");

        // create a button with the capation "Calculate reimbursement"
        calculateButton = new JButton("Calculate reimbursement ");

        reimbursementTLabel = new JLabel("Total expenses :");
        reimbursementALabel = new JLabel("Allowable reimbursement : ");
        excessPaidByYouLabel = new JLabel("Out Of Pocket Expenses :");
        savedByYouTLabel = new JLabel("Amount you saved the company :");
        amountReimburseToYouLabel = new JLabel("Amount Reimbursed to you : ");

        reimbursementTField = new JTextField(10);
        reimbursementAField = new JTextField(10);
        excessPaidByYouField = new JTextField(10);
        savedByYouTField = new JTextField(10);
        amountReimburseToYouField = new JTextField(10);

        // add an action listener to the button
        calculateButton.addActionListener(
                new TravelExpenses.CalcButtonListener());

        // create a JPanel object and let the panel filed reference it
        panel = new JPanel();
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        p5 = new JPanel();
        p6 = new JPanel();
        p7 = new JPanel();
        pExtra = new JPanel();
        p8 = new JPanel();
        p9 = new JPanel();
        p10 = new JPanel();
        p11 = new JPanel();
        p12 = new JPanel();
        p13 = new JPanel();

        /**
         * // Add the labels, text field and button components to the panel
         * panel.add(numberDaysMessageLabel);
         *
         * panel.add(numberDaysPriceField);
         *
         * panel.add(amountOfAirFareMessageLabel);
         *
         * panel.add(amountOfAirFareField);
         *
         * panel.add(amountCarRentalLabel);
         *
         * panel.add(amountCarRentalField);
         *
         * panel.add(numberOfMilesDrivenMessageLabel);
         *
         * panel.add(numberOfMilesDrivenField);
         *
         * panel.add(parkingFeesMessageLabel);
         *
         * panel.add(parkingFeesField);
         *
         * panel.add(taxiFeesMessageLabelel);
         *
         * panel.add(taxiFeesField);
         *
         * panel.add(lodgingChargesMessageLabel);
         *
         * panel.add(lodgingChargesField);
         *
         * panel.add(registrationMessageLabel);
         *
         * panel.add(registrationField);
         *
         * panel.add(calculateButton);
         *
         * panel.add(reimbursementTLabel);
         *
         * panel.add(reimbursementTField);
         *
         * panel.add(reimbursementALabel); panel.add(reimbursementAField);
         *
         * panel.add(excessPaidByYouLabel); panel.add(excessPaidByYouField);
         *
         * panel.add(savedByYouTLabel); panel.add(savedByYouTField);
         *
         * panel.add(amountReimburseToYouLabel);
         * panel.add(amountReimburseToYouField);
         */
        // Add the labels, text field and button componets to the panel
        panel.add(numberDaysMessageLabel);

        panel.add(numberDaysPriceField);

        p1.add(amountOfAirFareMessageLabel);

        p1.add(amountOfAirFareField);

        p2.add(amountCarRentalLabel);

        p2.add(amountCarRentalField);

        p3.add(numberOfMilesDrivenMessageLabel);

        p3.add(numberOfMilesDrivenField);

        p4.add(parkingFeesMessageLabel);

        p4.add(parkingFeesField);

        p5.add(taxiFeesMessageLabelel);

        p5.add(taxiFeesField);

        p6.add(lodgingChargesMessageLabel);

        p6.add(lodgingChargesField);

        p7.add(registrationMessageLabel);

        p7.add(registrationField);
        
        pExtra.add( greeting);

        p8.add(calculateButton);

        p9.add(reimbursementTLabel);

        p9.add(reimbursementTField);

        p10.add(reimbursementALabel);
        p10.add(reimbursementAField);

        p11.add(excessPaidByYouLabel);
        p11.add(excessPaidByYouField);

        p12.add(savedByYouTLabel);
        p12.add(savedByYouTField);

        p13.add(amountReimburseToYouLabel);
        p13.add(amountReimburseToYouField);

        //Add panels to content pane
        add(panel);
        add(p1);
        add(p2);
        add(p3);
        add(p4);
        add(p5);
        add(p6);
        add(p7);
        add(pExtra);
        add(p8);
        add(p9);
        add(p10);
        add(p11);
        add(p12);
        add(p13);

    }

    private class CalcButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            String numberOfDaysInput;	                // to hold user input for numberOfDaysInput;
            String airfareInput;	         	// to hold user input for air fare
            String carRentalInput;	                // to hold user input for car Rental
            String milesDrivenInput;		        // to hold user input for miles Driven 
            String parkingFeesInput;	                // to hold user input for parking Fees ;
            String taxiChargesInput;		        // to hold user input for taxi Charges Input;
            String registrationFeesInput;	        // to hold user input for registration Fees Input;
            String perNightLodgingFeesInput;		// to hold user input for per Night Lodging Fees
            double daysD;		                // declare  number of days as a double
            double airFareD;			        // declare air fare as a double
            double carRentalD;				// declare care rental as a double
            double milesD;		                // declare miles as a double
            double parkingFeeD;			        // declare parking as a double
            double taxiD;                                // declare taxi as a double
            double regFeeAT;			         // declare  registration fees as a double
            double lodgingPernightD;                     // declare lodging as a double

            DecimalFormat formatter = new DecimalFormat("$##0.00");
            // get the text entered by the user in the text field box
            numberOfDaysInput = numberDaysPriceField.getText();
            airfareInput = amountOfAirFareField.getText();
            carRentalInput = amountCarRentalField.getText();
            milesDrivenInput = numberOfMilesDrivenField.getText();
            parkingFeesInput = parkingFeesField.getText();
            taxiChargesInput = taxiFeesField.getText();
            perNightLodgingFeesInput = lodgingChargesField.getText();
            registrationFeesInput = registrationField.getText();

            // Convert input text to double
            daysD = Double.parseDouble(numberOfDaysInput);
            airFareD = Double.parseDouble(airfareInput);
            carRentalD = Double.parseDouble(carRentalInput);
            milesD = Double.parseDouble(milesDrivenInput);
            parkingFeeD = Double.parseDouble(parkingFeesInput);
            taxiD = Double.parseDouble(taxiChargesInput);
            regFeeAT = Double.parseDouble(registrationFeesInput);
            lodgingPernightD = Double.parseDouble(perNightLodgingFeesInput);

            // Total expenses
            double costLodgingT = (daysD * lodgingPernightD);
            double mealsAT = (daysD * MEALS_AMOUNT);
            double parkingT = (daysD * parkingFeeD);
            double taxiT = daysD * taxiD;
            double milesAT = (milesD * pr_Vechicle_Per_Mile_Reimbursed);

            // Allowable Expenses 
            double costLodgingA = (daysD * LODGING_CHARGES_REIMBURSED);
            double mealsA = (daysD * MEALS_AMOUNT);
            double parkingA = (daysD * PARKING_FEES_REIMBURSED);
            double taxiA = daysD * TAXI_CHARGES_REIM;
            double milesA = (milesD * pr_Vechicle_Per_Mile_Reimbursed);

            // Calculates total expense
            double reimbursementTotalD = (costLodgingT + mealsAT + taxiT + parkingT + milesAT + regFeeAT
                    + airFareD + carRentalD);
            // Formats total reimbursement and converts to string text
            String reimbursementTotalS = formatter.format(reimbursementTotalD);
            // Calculates allowable reimbursement
            double reimbAllowable = (costLodgingA + mealsAT + taxiA + parkingA + milesAT + regFeeAT
                    + airFareD + carRentalD);
            // Formats allowable reimbursement and converts to string text
            String reimbursementAllowableS = formatter.format(reimbAllowable);

            // Calculates save or excess.
            double excessOrSave = (reimbAllowable - reimbursementTotalD);
            // Formats excess and converts to string text
            String excess = formatter.format((reimbursementTotalD - reimbAllowable));
            // Formats save reimbursement and converts to string text
            String save = formatter.format((reimbAllowable - reimbursementTotalD));

            // display the results
            numberDaysPriceField.setText(numberOfDaysInput);
            reimbursementTField.setText(reimbursementTotalS);

            reimbursementAField.setText(reimbursementAllowableS);

            if (excessOrSave < 0) {
                excessPaidByYouField.setText(excess);
            } else {
                savedByYouTField.setText(save);
                amountReimburseToYouField.setText(reimbursementTotalS);
            }

        }
    }

    public static void main(String[] args) {
        new TravelExpenses();
    }
}
