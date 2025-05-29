<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Student</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .container { max-width: 500px; margin: 0 auto; }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; }
        input[type="text"], input[type="number"], input[type="date"] {
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
        <h1>Update Student</h1>
        <form action="UpdateStudentServlet" method="post">
            <div class="form-group">
                <label for="studentID">Student ID:</label>
                <input type="number" id="studentID" name="studentID" required>
            </div>
            <div class="form-group">
                <label for="studentName">Student Name:</label>
                <input type="text" id="studentName" name="studentName" required>
            </div>
            <div class="form-group">
                <label for="roomNumber">Room Number:</label>
                <input type="text" id="roomNumber" name="roomNumber" required>
            </div>
            <div class="form-group">
                <label for="admissionDate">Admission Date:</label>
                <input type="date" id="admissionDate" name="admissionDate" required>
            </div>
            <div class="form-group">
                <label for="feesPaid">Fees Paid:</label>
                <input type="number" id="feesPaid" name="feesPaid" step="0.01" required>
            </div>
            <div class="form-group">
                <label for="pendingFees">Pending Fees:</label>
                <input type="number" id="pendingFees" name="pendingFees" step="0.01" required>
            </div>
            <button type="submit">Update Student</button>
        </form>
        <p class="error">${errorMessage}</p>
        <p><a href="index.jsp">Back to Home</a></p>
    </div>
</body>
</html>