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

@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private HostelDAO hostelDAO;

    public void init() {
        hostelDAO = new HostelDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int studentID = Integer.parseInt(request.getParameter("studentID"));
            String studentName = request.getParameter("studentName");
            String roomNumber = request.getParameter("roomNumber");
            
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date admissionDate = format.parse(request.getParameter("admissionDate"));
            
            double feesPaid = Double.parseDouble(request.getParameter("feesPaid"));
            double pendingFees = Double.parseDouble(request.getParameter("pendingFees"));
            
            Student student = new Student(studentID, studentName, roomNumber, admissionDate, feesPaid, pendingFees);
            hostelDAO.updateStudent(student);
            response.sendRedirect("studentdisplay.jsp");
        } catch (ParseException | SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error updating student: " + e.getMessage());
            request.getRequestDispatcher("studentupdate.jsp").forward(request, response);
        }
    }
}