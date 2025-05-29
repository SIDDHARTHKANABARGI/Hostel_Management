<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Report Criteria</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .container { max-width: 500px; margin: 0 auto; }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; }
        input[type="text"], input[type="date"] {
            width: 100%; padding: 8px; border: 1px solid #ddd; border-radius: 4px;
        }
        button { background-color: #4CAF50; color: white; padding: 10px 15px; 
                border: none; border-radius: 4px; cursor: pointer; }
        button:hover { background-color: #45a049; }
        .error { color: red; }
    </style>
</head>
<body>
    <div class="container">
        <h1>Report Criteria</h1>
        
        <c:choose>
            <c:when test="${param.reportType == 'roomStudents'}">
                <form action="ReportServlet" method="post">
                    <input type="hidden" name="reportType" value="roomStudents">
                    <div class="form-group">
                        <label for="roomNumber">Room Number:</label>
                        <input type="text" id="roomNumber" name="roomNumber" required>
                    </div>
                    <button type="submit">Generate Report</button>
                </form>
            </c:when>
            
            <c:when test="${param.reportType == 'dateRange'}">
                <form action="ReportServlet" method="post">
                    <input type="hidden" name="reportType" value="dateRange">
                    <div class="form-group">
                        <label for="startDate">Start Date:</label>
                        <input type="date" id="startDate" name="startDate" required>
                    </div>
                    <div class="form-group">
                        <label for="endDate">End Date:</label>
                        <input type="date" id="endDate" name="endDate" required>
                    </div>
                    <button type="submit">Generate Report</button>
                </form>
            </c:when>
            
            <c:otherwise>
                <p>Invalid report type selected.</p>
            </c:otherwise>
        </c:choose>
        
        <p class="error">${errorMessage}</p>
        <p><a href="reports.jsp">Back to Reports</a></p>
    </div>
</body>
</html>