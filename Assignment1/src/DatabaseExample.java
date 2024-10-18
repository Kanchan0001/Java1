package src.com.example.studentgrading;

import java.sql.*;

public class StudentGradingDatabase {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Update database connection to point to student grading database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_grades", "username", "password");

            // Modify SQL query to retrieve student grades
            String sql = "SELECT student_id, student_name, course_name, grade FROM student_grades";

            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            // Process the result set
            while (resultSet.next()) {
                int studentId = resultSet.getInt("student_id");
                String studentName = resultSet.getString("student_name");
                String courseName = resultSet.getString("course_name");
                double grade = resultSet.getDouble("grade");

                System.out.println("Student ID: " + studentId);
                System.out.println("Student Name: " + studentName);
                System.out.println("Course Name: " + courseName);
                System.out.println("Grade: " + grade);
                System.out.println();
            }
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        } finally {
            // Close resources
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}