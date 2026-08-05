# 🎓 Spring Boot Student CRUD REST API

A RESTful CRUD API built using **Spring Boot**, **Spring Data JPA**, and **MySQL**. This project demonstrates a layered architecture (Controller → Service → Repository) and performs complete CRUD operations on student records.

---

## 🚀 Features

- ✅ Create Student
- ✅ Get Student by ID
- ✅ Get All Students
- ✅ Update Student
- ✅ Delete Student
- ✅ MySQL Database Integration
- ✅ Spring Data JPA
- ✅ RESTful APIs
- ✅ JSON Request/Response
- ✅ Layered Architecture

---

## 🛠️ Tech Stack

- Java 21/26
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Postman
- IntelliJ IDEA

---

## 📂 Project Structure

```
src
├── main
│   ├── java
│   │   └── com.springbootweb.springbootApplicationweb
│   │       ├── controller
│   │       ├── service
│   │       ├── repository
│   │       ├── entity
│   │       └── SpringbootApplicationwebApplication.java
│   └── resources
│       └── application.properties
```

---

## ⚙️ Database Configuration

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/student_crud_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

## 📌 REST API Endpoints

### Create Student

```
POST /api/students/create
```

Request Body

```json
{
  "name": "Ankit Shukla",
  "email": "ankit.shukla@gmail.com",
  "age": 22,
  "rollNo": 101,
  "subject": "Spring Boot"
}
```

---

### Get Student

```
GET /api/students/{id}
```

---

### Get All Students

```
GET /api/students
```

---

### Update Student

```
PUT /api/students/{id}
```

---

### Delete Student

```
DELETE /api/students/{id}
```

---

## 🗄️ Database Schema

| Column | Type |
|---------|------|
| id | BIGINT (AUTO_INCREMENT) |
| name | VARCHAR(255) |
| email | VARCHAR(255) |
| age | INT |
| roll_no | INT |
| subject | VARCHAR(255) |

---

## ▶️ Running the Project

Clone the repository

```bash
git clone https://github.com/Ankitshukla63/springboot-student-crud.git
```

Go to the project directory

```bash
cd springboot-student-crud
```

Run the application

```bash
mvn spring-boot:run
```

The application starts at

```
http://localhost:8080
```

---

## 🧪 Testing

The APIs can be tested using:

- Postman
- Thunder Client
- curl

---

## 📈 Future Improvements

- DTO Pattern
- Validation using `@Valid`
- Global Exception Handling
- Pagination & Sorting
- Search APIs
- Swagger/OpenAPI Documentation
- Unit & Integration Testing
- Docker Support
- Spring Security with JWT

---

## 👨‍💻 Author

**Ankit Shukla**

GitHub: https://github.com/Ankitshukla63

LinkedIn: *(Add your LinkedIn profile here)*

---
⭐ If you found this project useful, consider giving it a star!
