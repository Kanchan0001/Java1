
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.time.LocalDate;
import java.net.URL;
import java.util.ResourceBundle;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentGradesTableView implements Initializable {
    @FXML
    private TableView<StudentGrade> gradesTable;

    @FXML
    private TableColumn<StudentGrade, Integer> studentIdColumn;

    @FXML
    private TableColumn<StudentGrade, String> studentNameColumn;

    @FXML
    private TableColumn<StudentGrade, String> courseNameColumn;

    @FXML
    private TableColumn<StudentGrade, Double> gradeColumn;

    @FXML
    private TableColumn<StudentGrade, LocalDate> dateAssignedColumn;

    private ObservableList<StudentGrade> gradesData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialize table columns
        studentIdColumn.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        studentNameColumn.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        courseNameColumn.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));
        dateAssignedColumn.setCellValueFactory(new PropertyValueFactory<>("dateAssigned"));

        // Load student grades data from database
        try (ResultSet resultSet = DBUtility.executeQueryWithResults("SELECT * FROM student_grades")) {
            while (resultSet.next()) {
                StudentGrade studentGrade = new StudentGrade(
                        resultSet.getInt("student_id"),
                        resultSet.getString("student_name"),
                        resultSet.getString("course_name"),
                        resultSet.getDouble("grade"),
                        resultSet.getDate("date_assigned").toLocalDate()
                );
                gradesData.add(studentGrade);
            }
        } catch (SQLException e) {
            System.err.println("Error loading student grades data: " + e.getMessage());
        }

        // Set student grades data to table
        gradesTable.setItems(gradesData);
    }
}