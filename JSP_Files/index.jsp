<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hostel Management System</title>
    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }
        
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f5f5f5;
            color: #333;
            line-height: 1.6;
            padding: 20px;
        }
        
        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
        }
        
        header {
            text-align: center;
            margin-bottom: 40px;
        }
        
        h1 {
            color: #2c3e50;
            font-size: 2.5rem;
            margin-bottom: 10px;
        }
        
        .menu {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 20px;
            margin-top: 30px;
        }
        
        .menu-card {
            background: white;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            transition: all 0.3s ease;
            overflow: hidden;
            text-align: center;
        }
        
        .menu-card:hover {
            transform: translateY(-5px);
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
        }
        
        .menu-card a {
            display: block;
            padding: 30px 20px;
            text-decoration: none;
            color: white;
            font-weight: bold;
            font-size: 1.1rem;
            height: 100%;
        }
        
        .menu-card.add {
            background: linear-gradient(135deg, #4CAF50, #2E7D32);
        }
        
        .menu-card.view {
            background: linear-gradient(135deg, #2196F3, #1565C0);
        }
        
        .menu-card.update {
            background: linear-gradient(135deg, #FF9800, #EF6C00);
        }
        
        .menu-card.delete {
            background: linear-gradient(135deg, #F44336, #C62828);
        }
        
        .menu-card.reports {
            background: linear-gradient(135deg, #9C27B0, #6A1B9A);
        }
        
        .menu-card i {
            font-size: 2.5rem;
            margin-bottom: 15px;
            display: block;
        }
        
        @media (max-width: 768px) {
            .menu {
                grid-template-columns: 1fr;
            }
            
            h1 {
                font-size: 2rem;
            }
        }
    </style>
    <!-- Add Font Awesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
    <div class="container">
        <header>
            <h1>Hostel Management System</h1>
            <p>Manage student admissions, room allocations, and fee payments</p>
        </header>
        
        <div class="menu">
            <div class="menu-card add">
                <a href="studentadd.jsp">
                    <i class="fas fa-user-plus"></i>
                    Add New Student
                </a>
            </div>
            
            <div class="menu-card view">
                <a href="DisplayStudentsServlet">
                    <i class="fas fa-users"></i>
                    View All Students
                </a>
            </div>
            
            <div class="menu-card update">
                <a href="studentupdate.jsp">
                    <i class="fas fa-user-edit"></i>
                    Update Student
                </a>
            </div>
            
            <div class="menu-card delete">
                <a href="studentdelete.jsp">
                    <i class="fas fa-user-times"></i>
                    Delete Student
                </a>
            </div>
            
            <div class="menu-card reports">
                <a href="reports.jsp">
                    <i class="fas fa-chart-bar"></i>
                    Reports
                </a>
            </div>
        </div>
    </div>
</body>
</html>