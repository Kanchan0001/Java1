

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class MainController {
    @FXML
    private TextField studentIdField;
    @FXML
    private TextField studentNameField;
    @FXML
    private TextField courseNameField;
    @FXML
    private TextField gradeField;
    @FXML
    private ListView<String> listView;
    @FXML
    private Button addButton;

    // In-memory data structure to store student grades
    private ArrayList<String> entries = new ArrayList<>();

    @FXML
    private void handleAddButtonAction() {
        String studentId = studentIdField.getText();
        String studentName = studentNameField.getText();
        String courseName = courseNameField.getText();
        String grade = gradeField.getText();

        if (!studentId.isEmpty() && !studentName.isEmpty() && !courseName.isEmpty() && !grade.isEmpty()) {
            String entry = String.format("ID: %s, Name: %s, Course: %s, Grade: %s", studentId, studentName, courseName, grade);
            entries.add(entry); // Store in memory
            listView.getItems().add(entry); // Update ListView
            clearFields(); // Clear the input fields
        }
    }

    private void clearFields() {
        studentIdField.clear();
        studentNameField.clear();
        courseNameField.clear();
        gradeField.clear();
    }
}