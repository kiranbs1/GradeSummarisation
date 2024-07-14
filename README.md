# Course Management Website

### #Java #Spring #Angular #JPA #PSql #RestControllers #Oauth2

## Overview

This is a personal project aimed at developing my skills with Angular and refreshing my knowledge of Java Spring. The application is a course management website that allows users to manage various aspects of their courses, including:

- Adding, editing, and removing courses
- Managing course years
- Handling course modules
- Setting up assessments
- Adding File attachments to assessments functionality is not finished

The application uses OAuth2 for user authentication, with GitHub being the only supported login provider currently.

## Technologies Used

- **Frontend**: Angular
- **Backend**: Java Spring
- **Database**: PostgreSQL (Psql)
- **Authentication**: OAuth2 with GitHub

## Architecture

The application follows a standard RESTful architecture with a clear separation between the frontend and backend:

- **Frontend**: The Angular application communicates with the backend via REST HTTP requests.
- **Backend**: The Java Spring server handles the business logic and interacts with the PostgreSQL database to store user and course data.

## Getting Started

### Prerequisites

- Node.js
- Angular CLI
- Java JDK
- PostgreSQL
- GitHub account for OAuth2 login

### Installation

1. **Clone the repository:**

    ```sh
    git clone https://github.com/yourusername/course-management-website.git
    cd course-management-website
    ```

2. **Backend Setup:**

    - Navigate to the backend directory:

        ```sh
        cd backend
        ```

    - Set up PostgreSQL database and update the `application.yaml` file with your database credentials.

    - Run the Spring Boot application:

        ```sh
        ./mvnw spring-boot:run
        ```
        
3. **Frontend Setup:**

    - Navigate to the frontend directory:

        ```sh
        cd frontend
        ```

    - Install the dependencies:

        ```sh
        npm install
        ```

    - Start the Angular application:

        ```sh
        ng serve
        ```

4. **Access the Application:**

    Open your browser and navigate to `http://localhost:4200` to access the course management website.
