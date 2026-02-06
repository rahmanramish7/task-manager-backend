
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
    
      ----------------------------------------------------------------------------------
    # Task Manager Backend

This project is a secure backend service for managing tasks with an approval workflow.  
It is developed as part of a backend take-home assignment for interview evaluation.

---

## Tech Stack

- Java 17
- Spring Boot
- Spring Security (JWT)
- JPA / Hibernate
- MySQL
- Maven

---

## Roles and Permissions

### USER
- Can create tasks
- Can view only their own tasks

### ADMIN
- Can view all tasks
- Can approve or reject tasks

---

## Task Lifecycle

    
Once approved or rejected, the task status cannot be changed.

---

## API Endpoints

### Authentication
- `POST /auth/register`
- `POST /auth/login`

### Tasks
- `POST /tasks` (USER only)
- `GET /tasks` (USER: own tasks, ADMIN: all tasks)
- `PUT /tasks/{id}/approve` (ADMIN only)
- `PUT /tasks/{id}/reject` (ADMIN only)

### Analytics (ADMIN only)
- `GET /analytics/tasks-by-status`
- `GET /analytics/daily-task-count`

---

## Setup Instructions

### Prerequisites
- Java 17 installed
- MySQL 8+
- Maven installed

---

### 1. Create Database

```sql
CREATE DATABASE task_manager_db;
    spring:
  datasource:
    url: jdbc:mysql://localhost:3306/task_manager_db
    username: root
    password: root
    
    
    mvn clean install
mvn spring-boot:run
    
    
    
    http://localhost:8080
    
    
    
    
    
    



