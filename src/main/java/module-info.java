module com.example.csc311_assignment_lab_02 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.csc311_assignment_lab_02 to javafx.fxml;
    exports com.example.csc311_assignment_lab_02;
}