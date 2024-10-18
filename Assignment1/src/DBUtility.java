

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtility {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/student_grades"; // Updated to student_grades
    private static final String DB_USER = "root"; // Update as necessary
    private static final String DB_PASSWORD = "password"; // Update as necessary

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public static void executeQuery(String query) throws SQLException {
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.executeUpdate();
        }
    }

    public static ResultSet executeQueryWithResults(String query) throws SQLException {
        Connection conn = getConnection(); // Keep connection open for ResultSet
        PreparedStatement pstmt = conn.prepareStatement(query);
        return pstmt.executeQuery();
    }
}