<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Reports</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .container { max-width: 600px; margin: 0 auto; }
        .report-option { margin: 15px 0; padding: 15px; border: 1px solid #ddd; border-radius: 4px; }
        .report-option h3 { margin-top: 0; }
        .report-option a { display: inline-block; padding: 8px 12px; 
                          background-color: #4CAF50; color: white; 
                          text-decoration: none; border-radius: 4px; }
        .report-option a:hover { background-color: #45a049; }
        .error { color: red; }
    </style>
</head>
<body>
    <div class="container">
        <h1>Hostel Reports</h1>
        
        <div class="report-option">
            <h3>Students with Pending Fees</h3>
            <p>View all students who have pending fees to pay.</p>
            <a href="ReportCriteriaServlet?reportType=pendingFees">Generate Report</a>
        </div>
        
        <div class="report-option">
            <h3>Students in a Particular Room</h3>
            <p>View all students allocated to a specific room.</p>
            <a href="ReportCriteriaServlet?reportType=roomStudents">Generate Report</a>
        </div>
        
        <div class="report-option">
            <h3>Students Admitted in Date Range</h3>
            <p>View all students admitted between two dates.</p>
            <a href="ReportCriteriaServlet?reportType=dateRange">Generate Report</a>
        </div>
        
        <p class="error">${errorMessage}</p>
        <p><a href="index.jsp">Back to Home</a></p>
    </div>
</body>
</html>