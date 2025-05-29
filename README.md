A comprehensive web application for managing Student Data in Hostel built with JSP, Servlets, and MySQL following MVC architecture principles.
___
📋 Prerequisites                                                
Before running this application, make sure you have the following installed:                                                
Java Development Kit (JDK) 8 or higher                                                
Apache Tomcat 9.0 or higher                                                
MySQL Server 5.7 or XAMP Server                                                
MySQL JDBC Driver (mysql-connector-java)                                                
IDE: Eclipse (J2EE), IntelliJ IDEA, or any Java IDE                                                
Web Browser: Chrome, Firefox, or Edge                                                
___
🗄️ Database Setup                                                
1. Create Database                                                                            
CREATE DATABASE HostelManagement;                                     
USE HostelManagement;                                    
        
2. Create Table                                                                                        

CREATE TABLE HostelStudents (                                        
    StudentID INT PRIMARY KEY,                                        
    StudentName VARCHAR(100) NOT NULL,                                        
    RoomNumber VARCHAR(10) NOT NULL,                                        
    AdmissionDate DATE NOT NULL,                                        
    FeesPaid DECIMAL(10,2) DEFAULT 0,                                        
    PendingFees DECIMAL(10,2) DEFAULT 0                                        
);                                       
___

🖼️ Screenshots                                                      

🏠 Home Page                                         

![Output](https://github.com/SIDDHARTHKANABARGI/Hostel_Management/blob/main/_Outputs_/Home.png)

➕ Add Student Page                                                           

![Output](https://github.com/SIDDHARTHKANABARGI/Hostel_Management/blob/main/_Outputs_/AddStudent.png)


❌ Delete Student Data                                   
![Output](https://github.com/SIDDHARTHKANABARGI/Hostel_Management/blob/main/_Outputs_/DeleteStudent.png)


🆕 Update Student Data                           
![Output](https://github.com/SIDDHARTHKANABARGI/Hostel_Management/blob/main/_Outputs_/UpdateStudent.png)

🔍 View Student Data                                            

![Output](https://github.com/SIDDHARTHKANABARGI/Hostel_Management/blob/main/_Outputs_/UpdateStudent.png)


📋 Reports                                      
![Output](https://github.com/SIDDHARTHKANABARGI/Hostel_Management/blob/main/_Outputs_/StudentReports.png)



MVC Architecture: Clear separation between Model, View, and Controller  

Database Integration: CRUD operations with MySQL                      

Web Development: JSP, Servlets, HTML, CSS, JavaScript                

Input Validation: Both client-side and server-side                                     

Report Generation: Dynamic data analysis and presentation         

Professional UI: Responsive design with Bootstrap              

