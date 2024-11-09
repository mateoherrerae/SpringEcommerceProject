# Spring Boot E-commerce Backend

This is a Spring Boot-based backend for an e-commerce application. It provides RESTful APIs for managing products, including functionalities such as adding, updating, deleting, and searching for products. 

## Features

- Add new products with image upload
- Update existing products
- Delete products
- Search for products by name, description, brand, or category
- Retrieve product details and images

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven

## Getting Started

### Prerequisites

- Java 23
- Maven
- PostgreSQL

### Installation

1. Clone the repository:
   ```sh
### Installation

1. Clone the repository

2. Load the Maven file with the dependencies.

3. Configure the database:
    - Update the `application.properties` file with your database configuration.

4. Build the project:
   ```sh
   mvn clean install
   ```

5. Run the application:
   ```sh
   mvn spring-boot:run
   ```

### API Endpoints

#### Product Endpoints 

- `GET /api/products` - Retrieve all products
- `GET /api/product/{id}` - Retrieve a product by ID
- `GET /api/product/{productId}/image` - Retrieve the image of a product by ID
- `POST /api/product` - Add a new product
- `PUT /api/product/{id}` - Update an existing product
- `DELETE /api/product/{id}` - Delete a product by ID
- `GET /api/products/search` - Search for products by keyword

## Frontend

The frontend for this project was not developed by me. It was taken from the following GitHub repository: [E-commerce Frontend](https://github.com/navinreddy20/ecom-frontend-5)

## Testing
I used Postman to test the APIs. You can import the Postman collection provided in the repository to test the endpoints.