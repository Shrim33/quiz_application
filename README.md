# quiz_application
A Spring Boot Quiz Application with REST APIs for managing questions, quizzes, and scores.
Here is a clean, professional **README.md** for your Spring Boot **Quiz Application** project.

You can copy-paste this directly into your project.

---

# 📘 **Quiz Application – Spring Boot Project**

A simple and efficient **Quiz Management System** built using **Spring Boot**, **Spring Data JPA**, and **MySQL**.
It provides REST APIs to manage questions, quizzes, and scoring.

---

## 🚀 **Features**

* Add and store quiz questions
* Fetch random questions
* Create quizzes
* Submit quiz responses
* Auto-calculate score
* REST API based architecture
* Easy to integrate with frontend (React, Angular, Android, etc.)

---

## 🛠️ **Tech Stack**

| Technology          | Purpose                       |
| ------------------- | ----------------------------- |
| **Java 17+**        | Programming language          |
| **Spring Boot**     | Backend framework             |
| **Spring Data JPA** | Database ORM                  |
| **MySQL**           | Database                      |
| **Maven**           | Build & dependency management |

---

## 📂 **Project Structure**

```
quiz/
 ├── src/main/java/com/ssm/quiz
 │     ├── Controller.java
 │     ├── MyquizApplication.java
 │     ├── Question.java
 │     ├── QuestionsRepo.java
 │     ├── QuestionsService.java
 │     ├── Quiz.java
 │     ├── QuizController.java
 │     ├── QuizDao.java
 │     └── QuizService.java
 ├── src/main/resources
 │     └── application.properties
 ├── pom.xml
 └── README.md
```

---

## ⚙️ **Setup & Installation**

### **1️⃣ Clone the repository**

```
git clone https://github.com/YOUR_USERNAME/quiz.git
cd quiz
```

### **2️⃣ Configure the database**

Edit `src/main/resources/application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/quizdb
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### **3️⃣ Build the project**

```
mvn clean install
```

### **4️⃣ Run the application**

```
mvn spring-boot:run
```

---

## 🧪 **API Endpoints**

### 📌 **Get All Questions**

```
GET /questions/allQuestions
```

### 📌 **Add a New Question**

```
POST /questions/add
Content-Type: application/json
```

### 📌 **Create a Quiz**

```
POST /quiz/create
```

### 📌 **Get Quiz Questions**

```
GET /quiz/get/{id}
```

### 📌 **Submit Quiz**

```
POST /quiz/submit/{id}
```

---

## 📦 **Build JAR**

```
mvn package
java -jar target/quiz-0.0.1-SNAPSHOT.jar
```

---

## 🤝 **Contributing**

Feel free to open issues or submit pull requests.

---

## 📄 **License**

This project is open-source and free to use.


