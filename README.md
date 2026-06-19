# 🚀 EmpFlow: Employee Management System
<p align="center">
  <img src="https://img.shields.io/badge/Java-25-orange?style=for-the-badge&logo=openjdk" alt="Java 25">
  <img src="https://img.shields.io/badge/Framework-Javalin-blue?style=for-the-badge" alt="Javalin">
  <img src="https://img.shields.io/badge/Build-Maven-red?style=for-the-badge&logo=apache-maven" alt="Maven">
  <img src="https://img.shields.io/badge/UI-Tailwind_CSS-38B2AC?style=for-the-badge&logo=tailwind-css" alt="Tailwind">
  <img src="https://img.shields.io/badge/Database-JSON/Flat--File-lightgrey?style=for-the-badge" alt="Database">
</p>

---

## 📝 Project Overview
This project focuses on building a clean and functional system for managing employee records with a responsive UI and efficient backend logic. It demonstrates core concepts of CRUD operations, authentication, and data persistence.


---

## ✨ Features
- 🔐 Secure admin authentication (login & signup)
- 📊 Dynamic dashboard with real-time updates (Fetch API)
- 🧾 Full CRUD operations for employee management
- 💾 Persistent data storage using json file 
- 🎨 Modern UI using Tailwind CSS (Glassmorphism design)
- 📂 Employees data will be saved in `'employees.txt`
- 🔐 Login/Signup information will be saved in `users.json`

---

## 🛠️ Tech Stack

| Category | Technology |
|----------|-----------|
| Backend | Java 25, Javalin |
| Build Tool | Maven |
| Frontend | HTML5, JavaScript (ES6), Tailwind CSS |
| Storage | Flat-file (employees.txt) |

---

## 📚 What I Learned

- Implementing CRUD operations in a real-world system  
- Handling data persistence without a database  
- Building REST-like backend using Javalin  
- Creating responsive UI with Tailwind CSS  
- Structuring a full-stack application
- Employee data will be saved in employees.txt
- Login/Signup information will be saved in Users.txt 

---

## 🚀 How to Run

### 1. Prerequisites
-  Ensure **JDK 25** is installed and `JAVA_HOME` is configured.
- Apache Maven installed  

### 2. Installation
```bash
git clone https://github.com/NexVerix/EmpFlow-Java-System
cd EmpFlow
```

### 3. Clean previous builds and compile classes
```
mvn clean compile
```
### 4. Execute using double-quoted runtime property parameters
```
mvn exec:java "-Dexec.mainClass=App"
```
--- 

## 🖼️ Interface Preview
<p align="center">
  <img src="screenshots/Login-Signup-Page.png" width="70%" alt="Login Signup Page Overview">
  <img src="screenshots/Login_Error-Page.png" width="70%" alt="Login Error Page">
  <img src="screenshots/Main-Page.png" width="70%" alt="Main Page">
  <img src="screenshots/Main-Page-with-Data.png" width="70%" alt="Main Page with Data">
</p>

---

## 👨‍💻 Author

**Md Aziz Rain**  
Built under **NexVerix** — focusing on practical and real-world development. <br>
GitHub: https://github.com/NexVerix   
