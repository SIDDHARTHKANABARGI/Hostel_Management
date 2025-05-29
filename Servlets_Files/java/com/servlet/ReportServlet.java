package com.servlet;

import com.dao.HostelDAO;
import com.model.Student;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private HostelDAO hostelDAO;

    public void init() {
        hostelDAO = new HostelDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String reportType = request.getParameter("reportType");
        
        try {
            List<Student> students = null;
            
            switch (reportType) {
                case "pendingFees":
                    students = hostelDAO.studentsWithPendingFees();
                    break;
                case "roomStudents":
                    String roomNumber = request.getParameter("roomNumber");
                    students = hostelDAO.studentsInRoom(roomNumber);
                    break;
                case "dateRange":
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date startDate = format.parse(request.getParameter("startDate"));
                    Date endDate = format.parse(request.getParameter("endDate"));
                    students = hostelDAO.studentsAdmittedInDateRange(startDate, endDate);
                    break;
            }
            
            request.setAttribute("students", students);
            request.setAttribute("reportType", reportType);
            request.getRequestDispatcher("report_result.jsp").forward(request, response);
            
        } catch (ParseException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error generating report: " + e.getMessage());
            request.getRequestDispatcher("reports.jsp").forward(request, response);
        }
    }
}