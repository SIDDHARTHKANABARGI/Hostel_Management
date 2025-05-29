package com.dao;

import com.model.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HostelDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    
    // No-argument constructor
    public HostelDAO() {
        this.jdbcURL = "jdbc:mysql://localhost:3306/HostelManagement";
        this.jdbcUsername = "root";
        this.jdbcPassword = "";
    }
    
    private static final String INSERT_STUDENT_SQL = "INSERT INTO HostelStudents (StudentID, StudentName, RoomNumber, AdmissionDate, FeesPaid, PendingFees) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_STUDENT_BY_ID = "SELECT * FROM HostelStudents WHERE StudentID=?";
    private static final String SELECT_ALL_STUDENTS = "SELECT * FROM HostelStudents";
    private static final String DELETE_STUDENT_SQL = "DELETE FROM HostelStudents WHERE StudentID=?";
    private static final String UPDATE_STUDENT_SQL = "UPDATE HostelStudents SET StudentName=?, RoomNumber=?, AdmissionDate=?, FeesPaid=?, PendingFees=? WHERE StudentID=?";
    private static final String SELECT_STUDENTS_WITH_PENDING_FEES = "SELECT * FROM HostelStudents WHERE PendingFees > 0";
    private static final String SELECT_STUDENTS_BY_ROOM = "SELECT * FROM HostelStudents WHERE RoomNumber=?";
    private static final String SELECT_STUDENTS_BY_DATE_RANGE = "SELECT * FROM HostelStudents WHERE AdmissionDate BETWEEN ? AND ?";
    
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    
    public void addStudent(Student student) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL)) {
            preparedStatement.setInt(1, student.getStudentID());
            preparedStatement.setString(2, student.getStudentName());
            preparedStatement.setString(3, student.getRoomNumber());
            preparedStatement.setDate(4, new java.sql.Date(student.getAdmissionDate().getTime()));
            preparedStatement.setDouble(5, student.getFeesPaid());
            preparedStatement.setDouble(6, student.getPendingFees());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    
    public boolean updateStudent(Student student) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENT_SQL)) {
            statement.setString(1, student.getStudentName());
            statement.setString(2, student.getRoomNumber());
            statement.setDate(3, new java.sql.Date(student.getAdmissionDate().getTime()));
            statement.setDouble(4, student.getFeesPaid());
            statement.setDouble(5, student.getPendingFees());
            statement.setInt(6, student.getStudentID());
            
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    
    public Student selectStudent(int studentID) {
        Student student = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID)) {
            preparedStatement.setInt(1, studentID);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                String studentName = rs.getString("StudentName");
                String roomNumber = rs.getString("RoomNumber");
                Date admissionDate = rs.getDate("AdmissionDate");
                double feesPaid = rs.getDouble("FeesPaid");
                double pendingFees = rs.getDouble("PendingFees");
                student = new Student(studentID, studentName, roomNumber, admissionDate, feesPaid, pendingFees);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return student;
    }
    
    public List<Student> selectAllStudents() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS)) {
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                int studentID = rs.getInt("StudentID");
                String studentName = rs.getString("StudentName");
                String roomNumber = rs.getString("RoomNumber");
                Date admissionDate = rs.getDate("AdmissionDate");
                double feesPaid = rs.getDouble("FeesPaid");
                double pendingFees = rs.getDouble("PendingFees");
                students.add(new Student(studentID, studentName, roomNumber, admissionDate, feesPaid, pendingFees));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return students;
    }
    
    public boolean deleteStudent(int studentID) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_STUDENT_SQL)) {
            statement.setInt(1, studentID);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
    
    public List<Student> studentsWithPendingFees() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENTS_WITH_PENDING_FEES)) {
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                int studentID = rs.getInt("StudentID");
                String studentName = rs.getString("StudentName");
                String roomNumber = rs.getString("RoomNumber");
                Date admissionDate = rs.getDate("AdmissionDate");
                double feesPaid = rs.getDouble("FeesPaid");
                double pendingFees = rs.getDouble("PendingFees");
                students.add(new Student(studentID, studentName, roomNumber, admissionDate, feesPaid, pendingFees));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return students;
    }
    
    public List<Student> studentsInRoom(String roomNumber) {
        List<Student> students = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENTS_BY_ROOM)) {
            preparedStatement.setString(1, roomNumber);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                int studentID = rs.getInt("StudentID");
                String studentName = rs.getString("StudentName");
                Date admissionDate = rs.getDate("AdmissionDate");
                double feesPaid = rs.getDouble("FeesPaid");
                double pendingFees = rs.getDouble("PendingFees");
                students.add(new Student(studentID, studentName, roomNumber, admissionDate, feesPaid, pendingFees));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return students;
    }
    
    public List<Student> studentsAdmittedInDateRange(java.util.Date startDate, java.util.Date endDate) {
        List<Student> students = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENTS_BY_DATE_RANGE)) {
            preparedStatement.setDate(1, new java.sql.Date(startDate.getTime()));
            preparedStatement.setDate(2, new java.sql.Date(endDate.getTime()));
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                int studentID = rs.getInt("StudentID");
                String studentName = rs.getString("StudentName");
                String roomNumber = rs.getString("RoomNumber");
                Date admissionDate = rs.getDate("AdmissionDate");
                double feesPaid = rs.getDouble("FeesPaid");
                double pendingFees = rs.getDouble("PendingFees");
                students.add(new Student(studentID, studentName, roomNumber, admissionDate, feesPaid, pendingFees));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return students;
    }
    
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}