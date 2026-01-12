# Selenium Page Object Model (POM) – Registration & Login Flow

This project demonstrates a **Selenium Page Object Model (POM)** framework implemented using **Java and TestNG**.  
The focus of this project is **clean structure, readability, and maintainable automation code**, along with **CI integration using Jenkins**.

---

## 🚀 Technologies Used
- Java
- Selenium WebDriver
- TestNG
- Maven
- ChromeDriver
- Jenkins (CI)

---

## 🧠 Key Concepts Covered

### 🔹 Page Object Model (POM)
- Each web page is represented as a separate class
- Page classes contain **locators and actions only**
- Test classes contain **business flow and assertions**

### 🔹 Readability & Maintainability
- Clear class and method naming conventions
- Method-based actions for reusable steps
- Well-structured comments explaining intent
- No direct `WebElement` usage inside test classes

### 🔹 Test Design
- End-to-end registration and login flow
- Test dependency handling using `dependsOnMethods`
- Shared test data via utility class
- Centralized WebDriver lifecycle management

### 🔹 CI Integration (Jenkins)
- Jenkins Pipeline configured using a `Jenkinsfile`
- Poll SCM used for safe, automated builds
- Builds triggered automatically on Git changes
- Test execution handled via Maven
- Test reports archived after execution

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

## ▶️ How to Run the Tests Locally

1. Clone the repository
   ```bash
   git clone https://github.com/TheRuchika/Web_Automation_POM.git
