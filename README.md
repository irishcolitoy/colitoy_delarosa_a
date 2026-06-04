## 📄 Sample Request & Response

### ✅ Create Product (POST /api/v1/products)

*Request Body*

```json
{
  "name": "Wireless Headphones",
  "price": 1299.99,
  "description": "Noise cancelling",
  "category": "Electronics",
  "imageUrl": "img/headphones.jpg",
  "stockQuantity": 40
}

---

🗄️ Database Schema

Category Table

Column| Type| Description
id| BIGINT| Primary Key
name| VARCHAR(255)| Category Name

Product Table

Column| Type| Description
id| BIGINT| Primary Key
name| VARCHAR(255)| Product Name
description| VARCHAR(255)| Product Description
price| DOUBLE| Product Price
stock| INT| Available Stock
category_id| BIGINT| Foreign Key

Relationship

- One Category can have many Products.
- One Product belongs to one Category.

Category (1)
     |
     |
     |----< Product (Many)

---

🔗 Database-Backed API Endpoints

Get All Products

GET /api/products

Sample Response

[
  {
    "id": 1,
    "name": "Laptop",
    "description": "Gaming Laptop",
    "price": 50000,
    "stock": 10
  },
  {
    "id": 2,
    "name": "Burger",
    "description": "Cheese Burger",
    "price": 120,
    "stock": 50
  },
  {
    "id": 3,
    "name": "Coke Zero",
    "description": "Softdrinks",
    "price": 30,
    "stock": 100
  },
  {
    "id": 4,
    "name": "Chocolate",
    "description": "Sweet",
    "price": 20,
    "stock": 200
  }
]

---

🧪 Database Integration Testing

Flow Test

1. Started the Spring Boot backend application.
2. Opened the frontend page in the browser.
3. Successfully fetched product data from the MySQL database.
4. Verified that products were displayed dynamically on the webpage using JavaScript Fetch API.

Responsive Check

The application was tested using browser developer tools using mobile view mode (iPhone 12 Pro) to verify that dynamic content loads correctly on smaller screen sizes.

---

📸 Screenshots

Database Table

"Database Table" (screenshots/database-table.png)

Browser Console

"Browser Console" (screenshots/browser-console.png)

Frontend Output

"Frontend Output" (screenshots/frontend-output.png)

Responsive View

"Responsive View" (screenshots/responsive-view.png)

---

📝 Notes

The frontend uses JavaScript Fetch API to retrieve product data from the Spring Boot backend.

The backend uses Spring Data JPA and Hibernate to interact with the MySQL database.

Product data is dynamically fetched from the database and rendered on the webpage.

---

👨‍💻 Git Workflow

Feature Branch

feat-db-integration

Commands Used

git checkout main
git merge feat-db-integration
git push origin main

The feature branch was preserved as required by the project instructions.

---

# Security Architecture

This project uses Spring Security with Session-Based Authentication.

## Authentication Flow

1. User accesses the login page.
2. User submits username and password.
3. Spring Security validates the credentials.
4. If authentication is successful, a server-side session is created.
5. A JSESSIONID cookie is sent to the browser.
6. The browser automatically sends the cookie with every request.
7. Protected endpoints can only be accessed by authenticated users.
8. Unauthenticated users are redirected to the login page.

### Session-Based Authentication Diagram

User Login
↓
Spring Security Authentication
↓
Session Created
↓
JSESSIONID Cookie Generated
↓
Access Protected Endpoints

---

# Validation Rules

## User Validation

- Username must not be empty.
- Username must be unique.
- Password must not be empty.

## Product Validation

- Product name must not be empty.
- Product description must not be empty.
- Product price must be greater than zero.
- Product stock must not be negative.

## Order Validation

- Customer name must not be empty.
- Order must contain at least one item.

---

# API Reference

## Public Endpoints

| Method | Endpoint | Description |
|----------|----------|----------|
| GET | /login | Display login page |
| POST | /login | Authenticate user |
| POST | /api/v1/auth/register | Register new user |

## Protected Endpoints

| Method | Endpoint | Description |
|----------|----------|----------|
| GET | /api/products | Get all products |
| GET | /api/orders | Get all orders |
| POST | /api/orders | Create order |
| PUT | /api/orders/{id} | Update order |
| DELETE | /api/orders/{id} | Delete order |

Authentication is required for all protected endpoints.

---

# Security Testing

## Session Authentication Test

### Login Test

1. Opened login page.
2. Registered a new user.
3. Logged in using valid credentials.
4. Verified successful authentication.
5. Verified JSESSIONID cookie creation.

### Protected Endpoint Test

1. Accessed protected endpoint after login.
2. Request completed successfully.
3. Verified session remained active.

### Unauthorized Access Test

1. Opened protected endpoint without login.
2. Application redirected to login page.
3. Access was denied until authentication was completed.

### Browser Verification

- Login page displayed correctly.
- Session persisted across requests.
- Protected pages required authentication.
- Logout/session removal prevented access to secured resources.

---

# Security Configuration Notes

The application uses Spring Security for authentication and authorization.

Key Security Features:

- Session-Based Authentication
- Password Encryption using BCrypt
- Protected API Endpoints
- Login Form Authentication
- Session Management using JSESSIONID Cookie
- Authentication Required for Protected Resources

---

# Task 8 Testing Summary

The following tests were completed successfully:

- User Registration
- User Login
- Session Creation
- Session Persistence
- Protected Endpoint Access
- Unauthorized Access Prevention
- Browser Authentication Flow
- Database Integration Verification

Result: PASSED

---

# Task 9 Documentation Summary

Completed Documentation:

- Security Architecture
- Validation Rules
- API Reference
- Security Testing Results
- Session Authentication Flow
- Protected Endpoint Documentation

Status: COMPLETE