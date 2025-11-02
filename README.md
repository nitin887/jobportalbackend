# Job Portal Backend

## Project Description

The Job Portal Backend is a robust and scalable application designed to facilitate job searching and recruitment processes. It provides a comprehensive set of RESTful APIs for managing users (job seekers and recruiters), job postings, and job applications. Built with Spring Boot, Spring Security (JWT), and MySQL, this backend ensures secure and efficient operations for a dynamic job marketplace.

## Features

*   **User Management:** Register and manage user accounts (Job Seekers and Recruiters).
*   **Authentication & Authorization:** Secure user authentication using JWT (JSON Web Tokens) and role-based authorization.
*   **Job Posting Management:** Create, retrieve, update, and delete job postings.
*   **Job Application Management:** Apply for jobs, track application status, and manage applications.
*   **Search Functionality:** Search for jobs by location, title, and for job seekers by skills and experience.
*   **Recruiter Profiles:** Manage recruiter-specific information and company details.
*   **Swagger/OpenAPI Documentation:** Automatically generated API documentation for easy exploration and testing.

## Technologies Used

*   **Spring Boot:** Framework for building robust, production-ready Spring applications.
*   **Spring Security:** Provides authentication, authorization, and other security features.
*   **JWT (JSON Web Tokens):** For secure and stateless authentication.
*   **MySQL:** Relational database for storing application data.
*   **JPA / Hibernate:** For object-relational mapping.
*   **Maven:** Dependency management and build automation tool.
*   **Swagger UI / OpenAPI 3:** For API documentation and testing.

## Setup and Installation

Follow these steps to get the Job Portal Backend up and running on your local machine.

### Prerequisites

*   **Java Development Kit (JDK) 17 or higher**
*   **Apache Maven 3.6.0 or higher**
*   **MySQL Server**
*   **Git**

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/JobPortalBackend.git
cd JobPortalBackend
```

### 2. Database Configuration

1.  **Create a MySQL Database:**
    Create a new database named `Job_Portal_Backend` in your MySQL server.

    ```sql
    CREATE DATABASE Job_Portal_Backend;
    ```

2.  **Update `application.properties`:**
    Open `src/main/resources/application.properties` and configure your MySQL database credentials.

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/Job_Portal_Backend?createDatabaseIfNotExist=true
    spring.datasource.username=root
    spring.datasource.password=your_mysql_password
    ```
    **Important:** Replace `your_mysql_password` with your actual MySQL root password.

3.  **Configure JWT Secret:**
    In the same `application.properties` file, set a strong, unique secret key for JWT. **Do not use the placeholder value in production.** For production, consider using environment variables.

    ```properties
    jwt.secret=yourSuperSecretKeyThatIsAtLeast256BitsLongAndShouldBeStoredSecurely
    ```
    **Important:** Replace `yourSuperSecretKeyThatIsAtLeast256BitsLongAndShouldBeStoredSecurely` with a truly secure, long, and random string.

### 3. Build the Project

Navigate to the project root directory in your terminal and build the project using Maven:

```bash
mvn clean install
```

### 4. Run the Application

You can run the Spring Boot application using Maven:

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080` by default.

## API Endpoints

The API endpoints are documented using Swagger UI. Once the application is running, you can access the interactive documentation at:

*   **Swagger UI:** `http://localhost:8080/swagger-ui.html`
*   **OpenAPI Docs:** `http://localhost:8080/v3/api-docs`

Here's a summary of the main controllers and their base URLs:

*   **Authentication:** `POST localhost:8080/api/auth/login`
*   **Applications:** `localhost:8080/api/applications`
*   **Jobs:** `localhost:8080/api/jobs`
*   **Job Seekers:** `localhost:8080/api/jobseekers`
*   **Recruiters:** `localhost:8080/api/recruiters`
*   **Users:** `localhost:8080/api/users`

For detailed endpoint information, including request/response bodies and parameters, please refer to the Swagger UI.

## Postman Collection

A Postman collection can be generated using the OpenAPI documentation. You can import `http://localhost:8080/v3/api-docs` directly into Postman to get all endpoints.

Alternatively, here are the raw URLs for quick reference:

*   **Authentication:**
    *   `POST localhost:8080/api/auth/login`
*   **Application Endpoints:**
    *   `POST localhost:8080/api/applications`
    *   `GET localhost:8080/api/applications/:id`
    *   `GET localhost:8080/api/applications`
    *   `PUT localhost:8080/api/applications/:id`
    *   `DELETE localhost:8080/api/applications/:id`
    *   `GET localhost:8080/api/applications/user/:userId`
    *   `GET localhost:8080/api/applications/job/:jobId`
    *   `GET localhost:8080/api/applications/status/:status`
    *   `GET localhost:8080/api/applications/user/:userId/job/:jobId`
    *   `GET localhost:8080/api/applications/user/:userId/status/:status`
*   **Job Endpoints:**
    *   `POST localhost:8080/api/jobs`
    *   `GET localhost:8080/api/jobs/:id`
    *   `GET localhost:8080/api/jobs`
    *   `PUT localhost:8080/api/jobs/:id`
    *   `DELETE localhost:8080/api/jobs/:id`
    *   `GET localhost:8080/api/jobs/location/:location`
    *   `GET localhost:8080/api/jobs/search/title`
    *   `GET localhost:8080/api/jobs/search`
*   **Job Seeker Endpoints:**
    *   `POST localhost:8080/api/jobseekers`
    *   `GET localhost:8080/api/jobseekers/:id`
    *   `GET localhost:8080/api/jobseekers`
    *   `PUT localhost:8080/api/jobseekers/:id`
    *   `DELETE localhost:8080/api/jobseekers/:id`
    *   `GET localhost:8080/api/jobseekers/user/:userId`
    *   `GET localhost:8080/api/jobseekers/search/skill`
    *   `GET localhost:8080/api/jobseekers/search/experience`
*   **Recruiter Endpoints:**
    *   `POST localhost:8080/api/recruiters`
    *   `GET localhost:8080/api/recruiters/:id`
    *   `GET localhost:8080/api/recruiters`
    *   `PUT localhost:8080/api/recruiters/:id`
    *   `DELETE localhost:8080/api/recruiters/:id`
    *   `GET localhost:8080/api/recruiters/user/:userId`
    *   `GET localhost:8080/api/recruiters/company/:companyName`
    *   `GET localhost:8080/api/recruiters/search`
*   **User Endpoints:**
    *   `POST localhost:8080/api/users`
    *   `GET localhost:8080/api/users/:id`
    *   `GET localhost:8080/api/users`
    *   `PUT localhost:8080/api/users/:id`
    *   `DELETE localhost:8080/api/users/:id`
    *   `GET localhost:8080/api/users/email/:email`
    *   `GET localhost:8080/api/users/role/:role`
    *   `GET localhost:8080/api/users/search`

## Security Considerations

*   **JWT Secret:** As discussed, the `jwt.secret` in `application.properties` is critical. Ensure it's a strong, randomly generated string and, for production, manage it securely via environment variables or a secrets management service.
*   **Authentication:** All authenticated endpoints require a valid JWT in the `Authorization: Bearer <token>` header.
*   **Password Hashing:** User passwords are encrypted using BCrypt.

## Contributing

Contributions are welcome! If you have suggestions for improvements or new features, please open an issue or submit a pull request.

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.
