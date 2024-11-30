# Role-Based Access Control (RBAC) System

## Overview

This project implements a **Role-Based Access Control (RBAC)** system, enabling secure and flexible access management. It allows administrators to assign roles to users and define permissions for roles, controlling access to system resources based on user roles.

## Features

- **User Authentication and Role Assignment**: Secure login and role-based user management.
- **Role-based Permission Management**: Assign specific permissions to roles.
- **Resource-level Access Control**: Control access to system resources based on user roles and permissions.
- **Scalable Database Design**: Easily extendable database schema to accommodate growing roles, permissions, and users.
- **APIs for Authentication, Authorization, and Administration**: Expose endpoints for managing users, roles, permissions, and resources.

## Architecture

### Key Components:
1. **Users**: Individuals or systems accessing the application.
2. **Roles**: Groups defining access levels (e.g., Admin, User, Viewer).
3. **Permissions**: Actions users can perform (e.g., Read, Write, Delete).
4. **Resources**: System entities on which actions are performed.

### Mappings:
- **Users ↔ Roles**
- **Roles ↔ Permissions**
- **Permissions ↔ Resources**

### Access Flow:
1. User logs in and is authenticated.
2. The system checks the user’s role(s) and associated permissions.
3. Access to resources is granted or denied based on permissions.

## Database Design

### Tables

1. **Users**  
   - `id`: Primary Key  
   - `username`: Unique identifier  
   - `email`: Contact email  
   - `password_hash`: Encrypted password  

2. **Roles**  
   - `id`: Primary Key  
   - `role_name`: Unique role name  
   - `description`: Role description  

3. **Permissions**  
   - `id`: Primary Key  
   - `permission_name`: Unique permission name  
   - `description`: Permission description  

4. **Resources**  
   - `id`: Primary Key  
   - `resource_name`: Unique resource name  
   - `description`: Resource description  

5. **Role_Permission**  
   - `role_id`: Foreign Key referencing `Roles.id`  
   - `permission_id`: Foreign Key referencing `Permissions.id`  

6. **User_Role**  
   - `user_id`: Foreign Key referencing `Users.id`  
   - `role_id`: Foreign Key referencing `Roles.id`  

7. **Permission_Resource**  
   - `permission_id`: Foreign Key referencing `Permissions.id`  
   - `resource_id`: Foreign Key referencing `Resources.id`  

## APIs

### 1. Authentication API

- **Endpoint**: `/auth/login`
- **Method**: POST
- **Description**: Authenticates users and generates tokens.

### 2. Authorization API

- **Endpoint**: `/auth/authorize`
- **Method**: POST
- **Description**: Checks if a user has permission for a specific action on a resource.

### 3. Admin APIs

#### a. Manage Users
- **Endpoint**: `/admin/users`
- **Methods**: GET, POST, PUT, DELETE
- **Description**: CRUD operations for users.

#### b. Manage Roles
- **Endpoint**: `/admin/roles`
- **Methods**: GET, POST, PUT, DELETE
- **Description**: CRUD operations for roles.

#### c. Manage Permissions
- **Endpoint**: `/admin/permissions`
- **Methods**: GET, POST, PUT, DELETE
- **Description**: CRUD operations for permissions.

#### d. Manage Resources
- **Endpoint**: `/admin/resources`
- **Methods**: GET, POST, PUT, DELETE
- **Description**: CRUD operations for resources.

### Key Sections:

1. **Overview**: A high-level description of the RBAC system.
2. **Features**: The main functionalities and use cases.
3. **Architecture**: Describes the core components like users, roles, permissions, resources, and their relationships.
4. **Database Design**: SQL table structures for users, roles, permissions, and their relationships.
5. **APIs**: Endpoints for user authentication, authorization, and administration.
6. **Setup and Installation**: Instructions on how to set up and run the project locally.
7. **Usage**: How to interact with the system, including testing APIs.
8. **Scalability Considerations**: Tips for optimizing the application in a production environment.
9. **License**: Licensing information.
10. **Contributing**: Guidelines for contributing to the project.

This `README.md` provides a comprehensive guide for anyone who wants to set up, use, or contribute to the RBAC system.
