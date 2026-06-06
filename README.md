# Ecommerce API

A Spring Boot Ecommerce API integrated with MySQL, Docker, Spring Security, JWT Authentication, Hibernate, and RESTful API architecture.

---

# Project Overview

This project is an Ecommerce Management System that allows users to manage products and categories through REST APIs.

The application uses:

- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Spring Security
- JWT Authentication
- Docker
- Docker Compose

---

# Features

## Product Management

- Create Product
- View All Products
- View Product By ID
- Update Product
- Delete Product

## Category Management

- Create Category
- View All Categories
- View Category By ID
- Update Category
- Delete Category

## Authentication

- User Registration
- User Login
- JWT Token Generation
- Protected Endpoints

---

# Database Schema

## Category Table

| Column | Type | Description |
|----------|----------|----------|
| id | BIGINT | Primary Key |
| name | VARCHAR(255) | Category Name |

---

## Product Table

| Column | Type | Description |
|----------|----------|----------|
| id | BIGINT | Primary Key |
| name | VARCHAR(255) | Product Name |
| description | VARCHAR(1000) | Product Description |
| price | DOUBLE | Product Price |
| stock | INT | Available Stock |
| category_id | BIGINT | Foreign Key |

---

# Entity Relationship

One Category can have many Products.

One Product belongs to one Category.

Category (1)
     |
     |
     |----< Product (Many)

---

# API Endpoints

## Authentication

| Method | Endpoint | Description |
|----------|----------|----------|
| POST | /api/v1/auth/register | Register User |
| POST | /api/v1/auth/login | Login User |

---

## Categories

| Method | Endpoint |
|----------|----------|
| GET | /api/categories |
| GET | /api/categories/{id} |
| POST | /api/categories |
| PUT | /api/categories/{id} |
| DELETE | /api/categories/{id} |

---

## Products

| Method | Endpoint |
|----------|----------|
| GET | /api/products |
| GET | /api/products/{id} |
| POST | /api/products |
| PUT | /api/products/{id} |
| DELETE | /api/products/{id} |

---

# Sample Request

## Create Category

POST /api/categories

{
  "name": "Electronics"
}

Sample Response

{
  "id": 1,
  "name": "Electronics",
  "products": []
}

---

## Create Product

POST /api/products

{
  "name": "Laptop",
  "price": 50000,
  "description": "Gaming Laptop",
  "stock": 10,
  "category": {
    "id": 1
  }
}

Sample Response

{
  "id": 1,
  "name": "Laptop",
  "price": 50000,
  "description": "Gaming Laptop",
  "stock": 10
}

---

## Get All Products

GET /api/products

Sample Response

[
  {
    "id": 1,
    "name": "Laptop",
    "price": 50000,
    "description": "Gaming Laptop",
    "stock": 10
  }
]

---

# Security Architecture

This project uses Spring Security with JWT Authentication.

## Authentication Flow

1. User registers an account.
2. User logs in using username and password.
3. Credentials are validated by Spring Security.
4. JWT Token is generated.
5. JWT Token is returned to the client.
6. Client includes the token in the Authorization Header.
7. JwtAuthenticationFilter validates the token.
8. Authorized users can access protected endpoints.

Authentication Flow

User Login
     ↓
Credential Validation
     ↓
JWT Token Generated
     ↓
Token Returned
     ↓
Authorization Header
     ↓
JwtAuthenticationFilter
     ↓
Protected Resources

---

# Validation Rules

## User Validation

- Username must not be empty.
- Username must be unique.
- Password must not be empty.

## Product Validation

- Product name is required.
- Product price must be greater than zero.
- Product stock must be greater than zero.
- Product must belong to a category.

## Category Validation

- Category name must not be empty.

---

# Docker Configuration

This project is containerized using Docker and Docker Compose.

Containers:

- ecommerce-app
- ecommerce-mysql

---

## Run Application

docker compose up --build

---

## Stop Application

docker compose down

---

# Docker Verification

Running Containers:

docker ps

Expected Containers:

text
ecommerce-app
ecommerce-mysql

---

# Database Integration Testing

Completed Tests:

- Category Creation
- Product Creation
- Product Retrieval
- Product Listing
- Database Connection
- MySQL Integration
- REST API Testing

Result: PASSED

---

# Frontend Testing

Completed Tests:

- Product data fetched from API
- Dynamic product rendering
- Browser display verification
- Product list successfully loaded

Result: PASSED

---

# Screenshots

Place screenshots inside:

screenshots/

Examples:

- category-created.png
- product-created.png
- products-api.png
- frontend-output.png
- docker-containers.png

---

# Technologies Used

- Java 21
- Spring Boot
- Spring Security
- JWT
- Spring Data JPA
- Hibernate
- MySQL
- Docker
- Docker Compose
- Gradle

---

# Developers

- Dela Rosa
- Colitoy

---

# Project Status

Completed Successfully