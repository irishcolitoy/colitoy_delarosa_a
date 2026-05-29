# E-commerce API Project

## 📋 Project Overview
This is a simple RESTful API for managing products and orders, built using Spring Boot. It provides core functionalities such as creating, reading, updating, and deleting products, as well as filtering products by category and price range. The API includes proper error handling, input validation, and consistent response formats.

## 🛠️ Setup Instructions

### Prerequisites
- Java 17 or higher
- Gradle
- IDE (VS Code / IntelliJ)

### How to Run
1.  Clone or download the project files.
2.  Open the project in your IDE.
3.  Let Gradle download all dependencies automatically.
4.  Run the application via EcommerceApiApplication.java or using terminal command:
    
    ./gradlew bootRun
    
5.  The server will start at: http://localhost:8080

---

## 📚 API Endpoint Reference

### 📦 Product Endpoints

| Method | Path | Description | Expected Response |
| :--- | :--- | :--- | :--- |
| GET | /api/v1/products | Get all available products | 200 OK - List of products |
| GET | /api/v1/products/{id} | Get single product by ID | 200 OK - Product details<br>`404 NOT FOUND` - If ID does not exist |
| POST | /api/v1/products | Create new product | 201 CREATED - Created product<br>`400 BAD REQUEST` - If input is invalid |
| PUT | /api/v1/products/{id} | Update entire product | 200 OK - Updated product<br>`404 NOT FOUND` |
| PATCH | /api/v1/products/{id} | Partial update (only changed fields) | 200 OK - Updated product<br>`404 NOT FOUND` |
| DELETE | /api/v1/products/{id} | Remove product | 204 NO CONTENT - Success, no body<br>`404 NOT FOUND` |
| GET | /api/v1/products/filter/category/{category} | Filter products by category | 200 OK - Filtered list |
| GET | /api/v1/products/filter/price?min=X&max=Y | Filter products by price range | 200 OK - Filtered list |

---

### 🧾 Order Endpoints

| Method | Path | Description | Expected Response |
| :--- | :--- | :--- | :--- |
| GET | /api/v1/orders | Get all orders | 200 OK - List of orders |
| GET | /api/v1/orders/{id} | Get single order | 200 OK - Order details<br>`404 NOT FOUND` |
| POST | /api/v1/orders | Create new order | 201 CREATED - Created order<br>`400 BAD REQUEST` |
| PUT | /api/v1/orders/{id} | Update order | 200 OK - Updated order<br>`404 NOT FOUND` |
| DELETE | /api/v1/orders/{id} | Delete order | 204 NO CONTENT`<br>404 NOT FOUND` |

---

## 📄 Sample Request & Response

### ✅ Create Product (POST /api/v1/products)

*Request Body:*
```json
{
  "name": "Wireless Headphones",
  "price": 1299.99,
  "description": "Noise cancelling",
  "category": "Electronics",
  "imageUrl": "img/headphones.jpg",
  "stockQuantity": 40
}