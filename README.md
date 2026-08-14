# 🎓 Student Management System

A web-based Student Management System developed using Java, Spring Boot, Spring MVC, Spring Data JPA, Spring Security, Thymeleaf, and MySQL.

This application helps manage students, courses, enrollments, and dashboard statistics through a simple and user-friendly interface.

## 🚀 Features

- 🔐 User Login & Logout
- 🛡️ Spring Security Authentication
- 👨‍🎓 Student Management
- 📚 Course Management
- 📝 Student Course Enrollment
- 📊 Dashboard with Statistics
- 🔎 Search and Pagination
- 📋 View Student Enrollment Details
- 🔒 Password Encryption using BCrypt
- 🗄️ MySQL Database Integration
- 🎨 Responsive UI using Bootstrap and CSS
- ⚠️ Error Handling Pages

## 🛠️ Technologies Used

### Backend
- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- Spring Security
- Hibernate
- Maven

### Frontend
- HTML5
- CSS3
- JavaScript
- Bootstrap
- Thymeleaf

### Database
- MySQL

### Tools
- STS IDE
- MySQL Workbench
- Git & GitHub

## 🏗️ Project Architecture

The project follows a layered architecture:

Controller
↓
Service
↓
Repository
↓
Database

### Main Layers

- **Controller** – Handles HTTP requests and responses.
- **Service** – Contains the business logic.
- **Repository** – Handles database operations using Spring Data JPA.
- **Model/Entity** – Represents the database entities.
- **DTO** – Used for transferring data between different layers.
- **Security Configuration** – Handles authentication, authorization, password encryption, and logout.

## 🔐 Security

Spring Security is used to secure the application and manage user authentication.

### Security Features

- User Login & Logout
- Authentication using Spring Security
- Password Encryption using BCrypt
- CSRF Protection
- Protected Application Pages
- Secure Logout
- Public access for Login Page and required static resources

## 📊 Dashboard

The dashboard provides an overview of the Student Management System.

### Dashboard Includes

- Total Students
- Total Courses
- Total Enrollments
- Recently Enrolled Students
- Top Performing Course
- Enrollment Statistics

## 🗄️ Database

The application uses **MySQL** as the database.

### Main Entities

- User
- Student
- Course
- Enrollment

JPA and Hibernate are used for database operations and entity relationships.

### Database Configuration

Update the database configuration in:

`application.properties`

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/studentmanagement
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


## ⚙️ How to Run the Project

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/student-management-system.git

## 📸 Screenshots

### 🔐 Login Page

Screenshot (1252).png

### 📊 Dashboard

<img width="1366" height="768" alt="Screenshot (1253)" src="https://github.com/user-attachments/assets/5eeaf7d9-d629-4bbb-974d-a62570705280" />

### 📝 Enrollment

<img width="1366" height="768" alt="Screenshot (1254)" src="https://github.com/user-attachments/assets/e24d6ef6-6c70-4143-9622-1443e20f6c94" />



