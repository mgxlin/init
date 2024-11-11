# Maven Project Generator

## Overview

This Maven Project Generator is designed to streamline development by allowing you to generate a fully functional Maven project with minimal setup. By specifying a module name and a table name, you can quickly create a runnable Maven project complete with essential code, common methods, and foundational configuration.

## Key Features

- **Quick Module Setup**: Start by specifying just the module name and table name to generate an independent Maven project.
- **Automated Base Code**: The generated project includes foundational CRUD operations, database mappings, and essential utility classes.
- **Reusable Methods and API Endpoints**: Pre-built service methods and API endpoints are included, allowing for easy customization and expansion.
- **Immediate Start**: The generated project is fully configured and ready for immediate use, letting you jump directly into coding and testing.

## Requirements

- JDK 1.8 or higher
- Maven 3.5 or higher
- MySQL Database

## Quick Start

### Step 1: Clone the Repository
```bash
git clone <repository-url>
cd <project-directory>
```

### Step 2: Generate Your Maven Project

Run the project generation command, providing the required module name and table name:
```bash
./generate.sh --module <ModuleName> --table <TableName>
```

This will generate a new Maven project in the specified directory.

### Step 3: Configure Database Connection

Update the database configuration in `application.properties` to connect your MySQL database:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### Step 4: Build and Run the Project

Use Maven to build and run the project:
```bash
mvn clean install
mvn spring-boot:run
```

## Project Structure

The generated project includes the following structure:

- **`src/main/java`**: Contains the generated Java source code, organized by package.
- **`src/main/resources`**: Contains configuration files, including `application.properties` for database settings.
- **`pom.xml`**: Maven configuration file with dependencies for Spring Boot, MySQL, and other essentials.

## Customization

You can easily extend and customize the generated code by adding additional methods, endpoints, or modifying the base configurations according to your requirements.

## Troubleshooting

If you encounter any issues, refer to the generated logs or verify that the database configuration is correct. For common issues, check the FAQ or open an issue in the repository.

## License

This project is licensed under the [MIT License](LICENSE).

--- 

With this generator, setting up your Maven project becomes a breeze—allowing you to focus more on building unique features than on repetitive setup tasks. Happy coding!
