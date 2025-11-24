# Libralian-Service — Run locally

Prerequisites
- JDK 21 installed and JAVA_HOME set (matches pom.xml java.version).
- Git (optional).
- Internet for Maven dependencies (or use offline repo).

Build & test (use wrapper)
- Windows:
  .\mvnw.cmd -v
  .\mvnw.cmd clean test
- Unix/mac:
  ./mvnw -v
  ./mvnw clean test

Run application
- Windows:
  .\mvnw.cmd spring-boot:run
- Unix/mac:
  ./mvnw spring-boot:run

Or build a jar and run
- Windows:
  .\mvnw.cmd clean package
  java -jar target\Libralian-Service-0.0.1-SNAPSHOT.jar
- Unix/mac:
  ./mvnw clean package
  java -jar target/Libralian-Service-0.0.1-SNAPSHOT.jar

Default runtime info
- Base URL: http://localhost:8081
- REST endpoints (examples):
  - GET  /dashboard/books        — list all books
  - GET  /dashboard/books/{id}   — get book
  - POST /dashboard/books        — add book (JSON body)
  - PUT  /dashboard/books/{id}   — update book (JSON body)
  - DELETE /dashboard/books/{id} — delete book
- H2 console (if enabled): http://localhost:8081/h2-console
  - JDBC URL: jdbc:h2:mem:librariandb
  - User: sa
  - Password: (empty)

Notes
- If using an IDE, import the Maven project and run the main class:
  `com.example.librarian.LibrarianServiceApplication`
- If the app fails to start, check logs for missing dependencies or port conflicts (8081).
