
import java.time.LocalDate;

public class StudentGrade {
    private int studentId;
    private String studentName;
    private String courseName;
    private double grade;
    private LocalDate dateAssigned;

    public StudentGrade(int studentId, String studentName, String courseName, double grade, LocalDate dateAssigned) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.courseName = courseName;
        this.grade = grade;
        this.dateAssigned = dateAssigned;
    }

    // Getters and setters
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public LocalDate getDateAssigned() {
        return dateAssigned;
    }

    public void setDateAssigned(LocalDate dateAssigned) {
        this.dateAssigned = dateAssigned;
    }
}