# Selenium Page Object Model (POM) – Registration & Login Flow

This project demonstrates a **Selenium Page Object Model (POM)** framework implemented using **Java and TestNG**.  

---

## 🚀 Technologies Used
- Java
- Selenium WebDriver
- TestNG
- Maven
- ChromeDriver

---

## 🧠 Key Concepts Covered

### 🔹 Page Object Model (POM)
- Each web page is represented as a separate class
- Page classes contain **locators and actions only**
- Test classes contain **business flow and assertions**

### 🔹 Readability & Maintainability
- Well-structured comments explaining intent

### 🔹 Test Design
- End-to-end registration and login flow
- Test dependency handling using `dependsOnMethods`
- Shared test data via utility class
- Centralized WebDriver lifecycle management

---

## 🧪 Test Scenarios

### ✅ TC001 – User Registration
- Navigate to registration page
- Fill user details
- Submit registration form
- Validate success message
- Store credentials for login test

### ✅ TC002 – Login with Registered User
- Navigate to login via Sign-In link
- Login using stored credentials
- Validate login success message

---


1. Clone the repository
   ```bash
