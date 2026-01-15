-- SQL Server Script to create Employee Database and Table
-- Execute this script on your SQL Server instance

-- Create the Database
CREATE DATABASE EmployeeDB;
GO

-- Use the database
USE EmployeeDB;
GO

-- Create the Employees table
CREATE TABLE employees (
    employee_id INT PRIMARY KEY IDENTITY(1,1),
    first_name NVARCHAR(100) NOT NULL,
    last_name NVARCHAR(100) NOT NULL,
    email NVARCHAR(100) NOT NULL UNIQUE,
    phone_number NVARCHAR(20),
    department NVARCHAR(100),
    salary DECIMAL(10, 2),
    position NVARCHAR(100),
    hire_date NVARCHAR(50),
    created_at DATETIME DEFAULT GETDATE(),
    updated_at DATETIME DEFAULT GETDATE()
);
GO

-- Create an index on email for faster lookups
CREATE INDEX idx_email ON employees(email);
GO

-- Create an index on department for faster queries
CREATE INDEX idx_department ON employees(department);
GO

-- Insert sample data
INSERT INTO employees (first_name, last_name, email, phone_number, department, salary, position, hire_date)
VALUES 
    ('John', 'Doe', 'john.doe@example.com', '555-0101', 'IT', 75000.00, 'Software Engineer', '2022-01-15'),
    ('Jane', 'Smith', 'jane.smith@example.com', '555-0102', 'HR', 65000.00, 'HR Manager', '2021-06-20'),
    ('Robert', 'Johnson', 'robert.johnson@example.com', '555-0103', 'Finance', 70000.00, 'Financial Analyst', '2020-03-10'),
    ('Emily', 'Williams', 'emily.williams@example.com', '555-0104', 'IT', 80000.00, 'Senior Developer', '2019-11-05'),
    ('Michael', 'Brown', 'michael.brown@example.com', '555-0105', 'Sales', 72000.00, 'Sales Manager', '2021-09-12');
GO

-- Verify the data
SELECT * FROM employees;
GO

-- Display table schema
EXEC sp_columns @table_name = 'employees';
GO
