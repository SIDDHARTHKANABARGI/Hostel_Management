<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Student</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .container { max-width: 500px; margin: 0 auto; }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; }
        input[type="number"] {
            width: 100%; padding: 8px; border: 1px solid #ddd; border-radius: 4px;
        }
        button { background-color: #f44336; color: white; padding: 10px 15px; 
                border: none; border-radius: 4px; cursor: pointer; }
        button:hover { background-color: #d32f2f; }
        .error { color: red; }
    </style>
</head>
<body>
    <div class="container">
        <h1>Delete Student</h1>
        <form action="DeleteStudentServlet" method="post">
            <div class="form-group">
                <label for="studentID">Student ID:</label>
                <input type="number" id="studentID" name="studentID" required>
            </div>
            <button type="submit">Delete Student</button>
        </form>
        <p class="error">${errorMessage}</p>
        <p><a href="index.jsp">Back to Home</a></p>
    </div>
</body>
</html>