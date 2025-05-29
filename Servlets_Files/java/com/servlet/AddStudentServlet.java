package com.servlet;

import com.dao.HostelDAO;
import com.model.Student;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private HostelDAO hostelDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        hostelDAO = new HostelDAO(); // This now works with the corrected HostelDAO
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Validate and parse input parameters
            int studentID = Integer.parseInt(request.getParameter("studentID"));
            String studentName = request.getParameter("studentName");
            String roomNumber = request.getParameter("roomNumber");
            
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date admissionDate = format.parse(request.getParameter("admissionDate"));
            
            double feesPaid = Double.parseDouble(request.getParameter("feesPaid"));
            double pendingFees = Double.parseDouble(request.getParameter("pendingFees"));
            
            // Create new student object
            Student newStudent = new Student(studentID, studentName, roomNumber, 
                                           admissionDate, feesPaid, pendingFees);
            
            // Add student to database
            hostelDAO.addStudent(newStudent);
            
            // Redirect to display page
            response.sendRedirect("DisplayStudentsServlet");
        } catch (ParseException | NumberFormatException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Invalid input format: " + e.getMessage());
            request.getRequestDispatcher("studentadd.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Database error: " + e.getMessage());
            request.getRequestDispatcher("studentadd.jsp").forward(request, response);
        }
    }
}