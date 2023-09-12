package com.example.csc311_assignment_lab_02;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 *  InterestCalculator is our driver class that will create
 *  a Scene of type LoanPane, which will be used to calculate
 *  the monthly payments and the overall amount of money a
 *  loan will cost to pay back.
 *
 *  @author guzmjo
 */
public class InterestCalculator extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Scene scene = new Scene(new LoanPane(), 315, 200);
        scene.getStylesheets().add(getClass().getResource("LoanCalcStyleSheet.css").toExternalForm());
        stage.setTitle("LoanCalculator");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}