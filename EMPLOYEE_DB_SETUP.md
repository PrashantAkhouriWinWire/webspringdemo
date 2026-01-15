# SQL Server Employee Database Setup Guide

## Overview
This guide will help you set up a SQL Server database connection for the Employee table in your Spring Boot application.

## Prerequisites
- SQL Server 2019 or later installed and running
- SQL Server Management Studio (SSMS) or similar tool
- Maven installed
- Java 25 LTS installed

## Setup Steps

### 1. Create the Database and Table

1. Open SQL Server Management Studio
2. Connect to your SQL Server instance
3. Open a new Query window
4. Copy and paste the contents of `employee_db_setup.sql`
5. Execute the script to create the database and table

Alternatively, you can run the script from command line:
```batch
sqlcmd -S localhost -U sa -P YourPassword123 -i "path\to\employee_db_setup.sql"
```

### 2. Update Database Configuration

Edit `src/main/resources/application.properties` with your SQL Server credentials:

```properties
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=EmployeeDB;encrypt=true;trustServerCertificate=true
spring.datasource.username=sa
spring.datasource.password=YourPassword123
spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver
```

**Update the following:**
- `localhost` - Your SQL Server hostname/IP
- `sa` - Your SQL Server username
- `YourPassword123` - Your SQL Server password
- `EmployeeDB` - Database name (if different)

### 3. Build and Run the Application

```batch
mvn clean install
mvn spring-boot:run
```

## API Endpoints

The Employee API provides the following endpoints:

### Get All Employees
```
GET /api/employees
```

### Get Employee by ID
```
GET /api/employees/{id}
```

### Get Employee by Email
```
GET /api/employees/email/{email}
```

### Get Employees by Department
```
GET /api/employees/department/{department}
```

### Create Employee
```
POST /api/employees
Content-Type: application/json

{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john@example.com",
  "phoneNumber": "555-1234",
  "department": "IT",
  "salary": 75000.00,
  "position": "Developer",
  "hireDate": "2024-01-15"
}
```

### Update Employee
```
PUT /api/employees/{id}
Content-Type: application/json

{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john@example.com",
  "phoneNumber": "555-1234",
  "department": "IT",
  "salary": 80000.00,
  "position": "Senior Developer",
  "hireDate": "2024-01-15"
}
```

### Delete Employee
```
DELETE /api/employees/{id}
```

### Get Total Employee Count
```
GET /api/employees/count/total
```

## Project Structure

```
src/main/java/com/webspringboot/webspringdemo/
├── entity/
│   └── Employee.java          # Employee JPA Entity
├── repository/
│   ├── EmployeeRepository.java # Spring Data JPA Repository
│   └── UserRepository.java     # Existing repository
├── service/
│   ├── EmployeeService.java    # Business logic service
│   └── UserDataService.java    # Existing service
└── controller/
    ├── EmployeeController.java # REST API Controller
    └── LoginController.java    # Existing controller
```

## Files Added/Modified

### New Files:
- `src/main/java/com/webspringboot/webspringdemo/entity/Employee.java`
- `src/main/java/com/webspringboot/webspringdemo/repository/EmployeeRepository.java`
- `src/main/java/com/webspringboot/webspringdemo/service/EmployeeService.java`
- `src/main/java/com/webspringboot/webspringdemo/controller/EmployeeController.java`
- `src/main/resources/employee_db_setup.sql`

### Modified Files:
- `pom.xml` - Added Spring Data JPA and SQL Server JDBC dependencies
- `src/main/resources/application.properties` - Added SQL Server configuration

## Troubleshooting

### Connection Issues
- Verify SQL Server is running: `sqlcmd -S localhost -U sa -P YourPassword123`
- Check firewall settings for SQL Server (default port 1433)
- Ensure database name matches in connection string

### Hibernate DDL Issues
- If tables already exist, set `spring.jpa.hibernate.ddl-auto=validate`
- For fresh setup, use `spring.jpa.hibernate.ddl-auto=create`
- For development, use `spring.jpa.hibernate.ddl-auto=update`

### Dependencies
- Run `mvn clean install` to ensure all dependencies are downloaded
- Check Maven's internet connection

## Additional Features

The `EmployeeService` and `EmployeeRepository` provide:
- Find employees by email
- Find employees by department or position
- Custom queries for salary-based searches
- Name-based search functionality
- Full CRUD operations

## Notes
- Lombok annotations (`@Data`, `@NoArgsConstructor`, `@AllArgsConstructor`) require Lombok library
- Add Lombok dependency if not already present: `org.projectlombok:lombok`
- Ensure SQL Server uses TCP/IP protocol enabled
- Keep database credentials secure in production (use environment variables or vault)
