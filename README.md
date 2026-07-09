# Smart Inventory Management System - Backend API

A robust and secure backend REST API for managing smart inventory, built using modern Spring Boot technologies. This system provides secure endpoints for managing categories and products with integrated JWT authentication.

## 🚀 Tech Stack

* **Java 17+**
* **Spring Boot** (Web, Data JPA, Security)
* **Spring Security & JWT** (JSON Web Tokens)
* **MySQL Database**
* **Hibernate / Spring Data JPA**
* **Lombok** (Boilerplate code reduction)
* **Maven**

## ✨ Key Features Implemented

1. **Secure User Authentication:**
   * User Registration with BCrypt Password Hashing.
   * Login generation with highly secure JWT Tokens.
   * `JwtAuthenticationFilter` to intercept and validate requests.
2. **Category Management:**
   * Fully relational category handling.
3. **Product Management:**
   * CRUD operations for products mapping to specific categories.
4. **Security & Authorization:**
   * Public endpoints for Authentication (`/api/auth/**`).
   * Protected endpoints requiring Bearer Tokens for Inventory management.

## ⚙️ Prerequisites to Run

Before running this application, ensure you have the following installed:
* Java Development Kit (JDK) 17 or later
* MySQL Server
* Maven

## 🛠️ Database Setup

1. Open your MySQL client (e.g., MySQL Workbench).
2. Execute the following script to create the database:
   ```sql
   CREATE DATABASE smart_inventory_db;
