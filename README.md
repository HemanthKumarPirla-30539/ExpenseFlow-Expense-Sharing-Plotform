# ExpenseFlow — Expense Sharing Platform

A full-stack expense-sharing application designed to help groups record shared expenses, track member balances, and simplify settlement calculations.

## Overview

ExpenseFlow provides a central place for users to create groups, manage members, record expenses, and calculate who owes whom. The project focuses on practical full-stack development, REST APIs, authentication, database persistence, and business logic.

## Key Features

- User registration and authentication
- JWT-based authentication
- Group creation and member management
- Expense creation and tracking
- Expense sharing among group members
- Balance calculation and settlement logic
- REST API-based backend communication
- Persistent application data

## Architecture

```text
React Frontend
      |
      | REST API / JSON
      v
Spring Boot Backend
      |
      +--> Authentication / JWT
      |
      +--> Business Services
      |
      +--> JPA / Hibernate
      |
      v
    MySQL
```

## Tech Stack

| Area | Technology |
| --- | --- |
| Language | Java |
| Backend | Spring Boot |
| API | REST API |
| ORM | JPA / Hibernate |
| Database | MySQL |
| Authentication | JWT |
| Frontend | React, Vite |
| HTTP Client | Axios |
| Build / Development | Maven, npm |
| Version Control | Git, GitHub |

## Core Backend Concepts

- Layered backend architecture
- Entity and relationship modeling
- RESTful endpoint design
- Authentication and authorization
- Expense and settlement business logic
- Database persistence using JPA/Hibernate

## Frontend

The frontend is built with React and Vite and communicates with the backend through REST APIs.

The current frontend dependencies include React, React Router, and Axios.

## Getting Started

### Backend

Open the backend project and configure the MySQL connection and required environment/application properties.

Then start the Spring Boot application using Maven.

```bash
mvn spring-boot:run
```

### Frontend

```bash
npm install
npm run dev
```

The exact backend and frontend directory names should be taken from the current repository structure.

## Security

Do not commit database passwords, JWT secrets, API keys, or other credentials. Use environment variables or local configuration for sensitive values.

## Future Improvements

- Add automated settlement optimization
- Add richer expense analytics
- Add notifications for outstanding balances
- Add deployment configuration
- Add automated tests and CI checks

## Author

**Hemanth Kumar Pirla**  
Java / Backend Developer | Computer Science Engineering Student

[GitHub](https://github.com/HemanthKumarPirla-30539)
