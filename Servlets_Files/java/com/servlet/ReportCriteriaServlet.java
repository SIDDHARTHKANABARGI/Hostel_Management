package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReportCriteriaServlet")
public class ReportCriteriaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String reportType = request.getParameter("reportType");
        
        if (reportType == null) {
            response.sendRedirect("reports.jsp");
            return;
        }
        
        switch (reportType) {
            case "pendingFees":
                request.getRequestDispatcher("report_result.jsp?reportType=pendingFees").forward(request, response);
                break;
            case "roomStudents":
                request.getRequestDispatcher("report_form.jsp?reportType=roomStudents").forward(request, response);
                break;
            case "dateRange":
                request.getRequestDispatcher("report_form.jsp?reportType=dateRange").forward(request, response);
                break;
            default:
                response.sendRedirect("reports.jsp");
        }
    }
}