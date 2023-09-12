package com.example.csc311_assignment_lab_02;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.control.Button;

/**
 *  LoanPane uses Grid pane to position all the labels, buttons, and text-fields
 *  into two separate V-Boxes.This class also contains a method used to compute
 *  the monthly payment and total payment on an amortization loan.
 *
 *  @author guzmjo
 */
public class LoanPane extends GridPane {
    private final TextField interest, years, amount, monthly, total;

    /**
     *  Default constructor that positions all of our GUI components.
     *  In total, it contains:
     *      - "Annual Interest Rate" label & text-field
     *
     *      - "Number of Years" label & text-field
     *
     *      - "Loan Amount" label & text-field
     *
     *      - "Monthly Payment" label & text-field
     *          - setEditable(false) as this is one of our results
     *            and don't want users to tamper with the final result
     *
     *      - "Total Payment" label & text-field
     *          - setEditable(false) as this is one of our results
     *            and don't want users to tamper with the final result
     *
     *      - Labels and Text-fields are grouped into two separate V-boxes
     *
     *      - "Calculator" button
     *          - will use the calculateTotal method on action
     */
    public LoanPane() {

        Font font = new Font(14);

        Button calcButton = new Button("Calculator");
        calcButton.setPadding(new Insets(5, 5, 5, 5));
        GridPane.setHalignment(calcButton, HPos.RIGHT);

        Label interestLabel = new Label("Annual Interest Rate: ");
        interestLabel.setFont(font);
        GridPane.setHalignment(interestLabel, HPos.RIGHT);

        Label yearLabel = new Label("Number of Years: ");
        yearLabel.setFont(font);
        GridPane.setHalignment(yearLabel, HPos.RIGHT);

        Label amountLabel = new Label("Loan Amount: ");
        amountLabel.setFont(font);
        GridPane.setHalignment(amountLabel, HPos.RIGHT);

        Label monthlyLabel = new Label("Monthly Payment: ");
        monthlyLabel.setFont(font);
        GridPane.setHalignment(monthlyLabel, HPos.RIGHT);

        Label totalLabel = new Label("Total Payment: ");
        totalLabel.setFont(font);
        GridPane.setHalignment(totalLabel,HPos.RIGHT);

        interest = new TextField();
        GridPane.setHalignment(interest, HPos.LEFT);

        years = new TextField();
        GridPane.setHalignment(years, HPos.LEFT);

        amount = new TextField();
        GridPane.setHalignment(amount, HPos.LEFT);

        monthly = new TextField();
        monthly.setEditable(false);
        GridPane.setHalignment(monthly, HPos.LEFT);

        total = new TextField();
        total.setEditable(false);
        GridPane.setHalignment(total, HPos.LEFT);

        VBox vBox2 = new VBox(interest, years, amount, monthly, total);
        vBox2.setSpacing(6);
        vBox2.setPadding(new Insets(5, 5, 5,5));

        VBox vBox = new VBox(interestLabel, yearLabel, amountLabel, monthlyLabel, totalLabel);
        vBox.setSpacing(15);
        vBox.setPadding(new Insets(5, 5, 5,5));

        add(vBox, 1, 1);
        add(vBox2, 2, 1);
        add(calcButton, 2, 2);

        calcButton.setOnAction(this::calculateTotal);
    }

    /**
     *  Method will compute the monthly payments and the overall total payment
     *  on an amortization loan. The formula for which is:
     *
     *      MP =  P [ r / n ]  / [ 1 - ( 1 + r / n) ^ -nt ]
     *
     *      P = principal amount of loan
     *      r = rate of interest
     *      n = amount of payments annually
     *      t = term of the loan in years
     *
     *  which will calculate the required monthly payments. The formula to calculate
     *  how much money it took to actually pay off the loan is:
     *
     *      TP = MP * ( t * n )
     *
     *      MP = monthly payment amount
     *      t = term of the loan in years
     *      n = amount of payments annually
     *
     * @param event button click
     */
    private void calculateTotal(ActionEvent event){

        double intRate = Double.parseDouble(interest.getText()) / 100;
        double numYear = Double.parseDouble(years.getText());
        double loanAmo = Double.parseDouble(amount.getText());

        double monthlyPay;
        double totalPay;

        monthlyPay = (loanAmo * (intRate / 12)) / (1 - Math.pow(1 + (intRate / 12), -12 * numYear));
        monthly.setText(String.format("$ %.2f", monthlyPay));

        totalPay = monthlyPay * (numYear * 12);
        total.setText(String.format("$ %.2f", totalPay));
    }
}
