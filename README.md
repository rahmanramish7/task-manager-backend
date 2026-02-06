# Task Manager Backend –  Assignment
This project is a secure backend service for managing tasks with an approval workflow.  
It is implemented as part of a **backend take-home assignment** to demonstrate clean architecture, security, and correct business rule enforcement.


 **USER**
  - Can create tasks
  - Can view only their own tasks

- **ADMIN**
  - Can view all tasks
  - Can approve or reject tasks
  ----------------------------------------------------------------------------------
  SETUP INSTRUCTIONS
  - Java 17 installed
- MySQL 8+
- Maven installed
(1) create database
``sql
CREATE DATABASE task_manager_db;

(2)configure application.yml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/task_manager_db
    username: root
    password: root
    
(3) Build and Run 
mvn clean install
mvn spring-boot:run 
    
    
    
    



