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