# Classical Arabic Poetry Database System

A Java Swing desktop application for managing classical Arabic poetry using MySQL, with text tokenization and a layered software architecture. This project was developed as a university semester project to demonstrate database integration, desktop application development, text processing, and software design principles.

## Overview

The Classical Arabic Poetry Database System combines a Java-based graphical user interface with a MySQL database to work with Arabic poetry. It also includes text tokenization functionality and is organized around a layered architecture to separate application responsibilities.

The project demonstrates how Java Swing, JDBC, MySQL, and object-oriented design can be used together to build a desktop database application.

## Key Features

- **Desktop interface:** Built using Java Swing and JFrame.
- **MySQL integration:** Uses a relational database for poetry-related data.
- **Arabic poetry management:** Provides a foundation for storing and working with classical Arabic poetry.
- **Text tokenization:** Includes text-processing functionality for breaking Arabic text into tokens.
- **Layered architecture:** Organizes application components into separate responsibilities.
- **Design patterns:** Uses design-pattern concepts, including Singleton and Facade, as described in the project overview.
- **Text resources:** Includes a `Poem.txt` file associated with the project.

> The exact operations supported by the application depend on the implementation in the source code. Add specific capabilities such as searching, inserting, editing, deleting, or filtering poems only if they are implemented.

## Technology Stack

| Technology | Purpose |
|---|---|
| Java | Core application logic |
| Java Swing / JFrame | Desktop graphical user interface |
| MySQL | Relational database |
| JDBC | Java-to-database connectivity |
| Java Properties | Database configuration |
| Text processing | Arabic poetry tokenization |
| Layered architecture | Separation of application responsibilities |

## Repository Structure

```text
Java_Arabic_Poem_zzleveltesters/
├── ClassicalArabicPoem/
├── src/
├── DB.properties
├── Poem.txt
└── README.md
```

- `ClassicalArabicPoem/` — Project-related directory. Inspect its contents to confirm its specific purpose.
- `src/` — Java source code.
- `DB.properties` — Database configuration properties.
- `Poem.txt` — Text resource associated with the poetry functionality.
- `README.md` — Project documentation.

## Prerequisites

Before running the application, make sure you have:

- A compatible Java Development Kit (JDK).
- MySQL Server.
- A Java IDE, such as IntelliJ IDEA, Eclipse, or NetBeans.
- MySQL Connector/J, if it is not already included in the project.
- The database schema and initial data required by the application.

The required Java version and exact database schema should be confirmed from the source code and project configuration.

## Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/amanullahpy/Java_Arabic_Poem_zzleveltesters.git
cd Java_Arabic_Poem_zzleveltesters
```

### 2. Configure MySQL

Install and start MySQL Server. Create the database required by the application.

```sql
CREATE DATABASE arabic_poetry_db
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;
```

**Important:** `arabic_poetry_db` is an example database name. Replace it with the database name expected by the application, and create the tables required by the source code. The repository structure shown above does not establish the actual schema.

### 3. Configure database connectivity

Open `DB.properties` and inspect the property names expected by the Java connection code.

Update the configuration with your local database connection details. For example, if your application uses equivalent properties, the configuration may look like this:

```properties
db.url=jdbc:mysql://localhost:3306/arabic_poetry_db
db.username=your_mysql_username
db.password=your_mysql_password
```

This is an example only. Keep the existing property names if the application expects different names.

Add MySQL Connector/J to the project dependencies or IDE libraries if required.

### 4. Open the project

1. Open your preferred Java IDE.
2. Import or open the repository as a Java project.
3. Locate the source files under `src/` and inspect the project directory under `ClassicalArabicPoem/`.
4. Ensure the MySQL JDBC driver is available on the classpath.
5. Verify that `DB.properties` is loaded from the location expected by the application.
6. Resolve any missing dependencies before running the program.

### 5. Run the application

Locate the Java class containing the application's `main` method and run it from your IDE.

The exact main class and launch command should be confirmed from the source code. This repository does not currently document a Maven or Gradle build command.

## Architecture

The project is described as following a layered architecture. The general purpose of this approach is to separate the user interface, application logic, and database operations.

A typical layered application may be organized as follows:

| Layer | Responsibility |
|---|---|
| Presentation layer | Displays the Java Swing interface and handles user interactions |
| Application or service layer | Coordinates application operations and business rules |
| Data access layer | Communicates with MySQL through JDBC |
| Database layer | Stores structured poetry-related information |

This table describes the architectural concept, not verified package names from the repository. Refer to the actual source code for the implementation's layer boundaries.

### Design Patterns

The project description mentions the following design patterns:

- **Singleton:** Can provide a single shared instance of a resource, such as a database connection manager, where appropriate.
- **Facade:** Can provide a simplified interface to a group of underlying operations.

The precise classes and use cases should be documented after checking the implementation.

## Arabic Text Processing

Arabic text processing requires careful handling of Unicode characters, punctuation, whitespace, and optional diacritics.

When extending or testing the tokenization functionality, consider:

- Preserving Arabic Unicode characters correctly.
- Handling spaces and repeated whitespace.
- Defining how punctuation should be treated.
- Testing words with and without diacritics.
- Verifying that the database uses an appropriate Unicode character set, such as `utf8mb4`.
- Ensuring that Arabic text is displayed correctly in the Java interface.

These are useful testing considerations rather than a claim that every case is already supported.

## Configuration and Security

Database configuration must be handled carefully.

- Do not publish real database passwords, API keys, or other secrets.
- Use a local configuration file or environment variables for sensitive values.
- Restrict database permissions to the operations the application needs.
- Avoid using an administrative database account for routine application access.
- If credentials have already been committed to GitHub, rotate them and remove them from the repository history where appropriate.

Because `DB.properties` is present in the repository, verify that it contains no active credentials before sharing or deploying the project.

## Testing and Validation

The following checks are recommended when running the application:

- Verify that the application starts successfully.
- Confirm that the MySQL connection works.
- Check how database connection failures are handled.
- Test tokenization against representative Arabic text.
- Confirm that Arabic text is stored and retrieved without character corruption.
- Test invalid inputs and empty text.
- Verify that resources such as database connections are closed appropriately.
- Confirm that the implemented design patterns behave as intended.

## Future Improvements

Potential improvements include:

- Add clear installation and database initialization instructions.
- Document the database schema and relationships.
- Add screenshots or a short demonstration of the interface.
- Include sample data and reproducible test cases.
- Add automated tests for tokenization and database operations.
- Add a standard Maven or Gradle build configuration.
- Improve error handling and logging.
- Provide a sanitized example configuration file.
- Document the architecture with a diagram.
- Add a license if the project is intended for reuse.

## Academic Context

This project was developed as a university semester project and demonstrates practical application of Java desktop development, relational database integration, text processing, layered architecture, and software design concepts.

## Author

**Aman Ullah**

GitHub: [@amanullahpy](https://github.com/amanullahpy)

## License

No license is currently documented in this README. Add a `LICENSE` file and update this section if you intend to specify how others may use, modify, and distribute the project.

---

If you use or reference this project, please refer to the repository's source code for the exact implementation details and supported functionality.
