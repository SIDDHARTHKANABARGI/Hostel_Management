<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Report Results</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .container { max-width: 1000px; margin: 0 auto; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #4CAF50; color: white; }
        tr:nth-child(even) { background-color: #f2f2f2; }
        .report-title { margin-bottom: 20px; }
        .menu { margin-top: 20px; }
        .menu a { display: inline-block; margin: 5px; padding: 10px 15px; 
                 background-color: #4CAF50; color: white; text-decoration: none; 
                 border-radius: 4px; }
        .menu a:hover { background-color: #45a049; }
    </style>
</head>
<body>
    <div class="container">
        <c:choose>
            <c:when test="${reportType == 'pendingFees'}">
                <h1 class="report-title">Students with Pending Fees</h1>
            </c:when>
            <c:when test="${reportType == 'roomStudents'}">
                <h1 class="report-title">Students in Room</h1>
            </c:when>
            <c:when test="${reportType == 'dateRange'}">
                <h1 class="report-title">Students Admitted in Date Range</h1>
            </c:when>
            <c:otherwise>
                <h1 class="report-title">Report Results</h1>
            </c:otherwise>
        </c:choose>
        
        <table>
            <tr>
                <th>Student ID</th>
                <th>Student Name</th>
                <th>Room Number</th>
                <th>Admission Date</th>
                <th>Fees Paid</th>
                <th>Pending Fees</th>
            </tr>
            <c:forEach var="student" items="${students}">
                <tr>
                    <td><c:out value="${student.studentID}" /></td>
                    <td><c:out value="${student.studentName}" /></td>
                    <td><c:out value="${student.roomNumber}" /></td>
                    <td><c:out value="${student.admissionDate}" /></td>
                    <td><c:out value="${student.feesPaid}" /></td>
                    <td><c:out value="${student.pendingFees}" /></td>
                </tr>
            </c:forEach>
        </table>
        
        <div class="menu">
            <a href="reports.jsp">Back to Reports</a>
            <a href="index.jsp">Back to Home</a>
        </div>
    </div>
</body>
</html>