CREATE DATABASE HostelManagement;
USE HostelManagement;

CREATE TABLE HostelStudents (
    StudentID INT PRIMARY KEY,
    StudentName VARCHAR(100) NOT NULL,
    RoomNumber VARCHAR(10) NOT NULL,
    AdmissionDate DATE NOT NULL,
    FeesPaid DECIMAL(10,2) DEFAULT 0,
    PendingFees DECIMAL(10,2) DEFAULT 0
);