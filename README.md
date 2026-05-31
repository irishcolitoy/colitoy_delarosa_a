# Ecommerce API

## Overview

REST API for managing products.

## Run

./gradlew bootRun

## Endpoints

GET /api/v1/products

GET /api/v1/products/{id}

POST /api/v1/products

PUT /api/v1/products/{id}

PATCH /api/v1/products/{id}

DELETE /api/v1/products/{id}

GET /api/v1/products/filter?category=Electronics

## Sample Request

{
  "name": "Laptop",
  "description": "Gaming Laptop",
  "category": "Electronics",
  "price": 50000,
  "stock": 10
}

## Testing Evidence

### GET ALL

Screenshot.

### GET BY ID

Screenshot.

### POST

Screenshot.

### PUT

Screenshot.

### PATCH

Screenshot.

### DELETE

Screenshot.

### FILTER

GET /api/v1/products/filter?category=Electronics

Screenshot.