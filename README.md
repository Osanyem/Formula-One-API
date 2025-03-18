# F1 REST API

## Description
This project is a RESTful API built with Spring Boot that provides structured Formula 1 data, including details about drivers, teams, and races. The API is designed for high performance, easy integration, and scalability.

## Technology Stack
- **Java**: JDK 17
- **Framework**: Spring Boot 3.2.x
- **Build Tool**: Maven
- **Database**: MySQL
- **Documentation**: SpringDoc OpenAPI (Swagger)

## Features
- **Driver Information**: Retrieve driver details, including teams and career statistics.
- **Race Data**: Fetch race schedules, results, and lap records.
- **Teams**: Access information on F1 teams, constructors, and their drivers.
- **Fast and Secure**: Optimized queries and exception handling ensure performance and reliability.

## Project Structure
```
src/
├── main/
│   ├── java/com/osanyemo/f1_api/
│   │   ├── controller/    # REST controllers
│   │   ├── entity/        # JPA entities
│   │   ├── exception/     # Exception handling
│   │   ├── repository/    # Data access layer
│   │   └── service/       # Business logic
│   └── resources/         # Configuration and static resources
└── test/
    └── java/com/osanyemo/f1_api/   # Unit and integration tests
```

## Quick Start

### Prerequisites
Ensure the following are installed:
- **Java Development Kit (JDK) 17 or later**
- **Maven**
- **Docker (optional for database management)**
- **Git**
- **MySQL Server**

### Installation & Setup

1. **Clone the Repository:**
    ```bash
    git clone https://github.com/your-username/f1-rest-api.git
    cd f1-rest-api
    ```

2. **Start MySQL Database:**
    Ensure you have MySQL running with the following credentials:
    - Database: `formulaone`
    - Username: `root`
    - Password: `f1dbpassword`

    Alternatively, use Docker:
    ```bash
    docker run --name mysql-f1 -e MYSQL_ROOT_PASSWORD=f1dbpassword -e MYSQL_DATABASE=formulaone -p 3306:3306 -d mysql:8
    ```

3. **Build the Project:**
    ```bash
    ./mvnw clean install
    ```

4. **Run the Application:**
    ```bash
    ./mvnw spring-boot:run
    ```

5. **Access API Documentation:** Open your browser and navigate to:
    ```
    http://localhost:8080/swagger-ui.html
    ```

## API Endpoints

### Drivers
- `GET /api/drivers` - Get all drivers
- `GET /api/drivers/{id}` - Get a specific driver
- `POST /api/drivers` - Create a new driver
- `PUT /api/drivers/{id}` - Update a driver

### Teams
- `GET /api/teams` - Get all teams
- `GET /api/teams/{id}` - Get a specific team
- `GET /api/teams/{id}/drivers` - Get drivers for a team
- `POST /api/teams` - Create a new team
- `PUT /api/teams/{id}` - Update a team

### Races
- `GET /api/races` - Get all races
- `GET /api/races/{id}` - Get a specific race
- `GET /api/races/season/{year}` - Get races by season
- `POST /api/races` - Create a new race
- `PUT /api/races/{id}` - Update a race

## Configuration
The application properties can be modified in `application.properties`:
```
spring.application.name=f1_api
spring.datasource.url=jdbc:mysql://localhost:3306/formulaone
spring.datasource.username=root
spring.datasource.password=f1dbpassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.sql.init.mode=always

springdoc.api-docs.enabled=true
springdoc.api-docs.path=/api-docs
```

## Contributing
1. **Fork the repository** on GitHub.
2. **Clone your fork:**
    ```bash
    git clone https://github.com/your-username/f1-rest-api.git
    cd f1-rest-api
    ```
3. **Create a feature branch:**
    ```bash
    git checkout -b feature/new-feature
    ```
4. **Make changes and commit:**
    ```bash
    git commit -m "Added new feature"
    ```
5. **Push to GitHub and create a pull request.**

## License
This project is licensed under the MIT License.

## Contact
For questions or feature requests, open an issue on GitHub or contact `your.email@example.com`. 

