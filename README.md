# Spring MVC Registration and Login System

## Overview
This project demonstrates a basic implementation of a **Spring MVC** design pattern for a simple registration and login system. Users can register, log in, and view their profile information. The system interacts with a MySQL database to store and retrieve user data.

## Features
- **User Registration**: Users can sign up by providing their name, email, password, and city.
- **User Login**: Registered users can log in using their email and password.
- **Profile Page**: After logging in, users are redirected to their profile page.
- **Validation and Error Handling**: Basic error handling for invalid login credentials or registration issues.

## Project Structure
### HTML Pages
1. **`index.html`**: Home page with links to register and login.
2. **`Register.html`**: Registration form for new users.
3. **`login.html`**: Login form for existing users.

### Java Servlets
1. **`Register.java`**: Handles user registration and inserts data into the database.
2. **`Login.java`**: Validates user login credentials and establishes a session.

### Database Connector
- **`DbConnection.java`**: Establishes a connection with the MySQL database.

### Model
- **`User.java`**: Represents a user object with properties like name, email, and city.

## Setup Instructions

### Prerequisites
1. Install **Java JDK** (version 8 or later).
2. Install **Apache Tomcat** server.
3. Install **MySQL** database.
4. Install an IDE like **Eclipse** or **IntelliJ IDEA**.

### Database Configuration
1. Create a MySQL database named `mvc_db`.
2. Execute the following SQL command to create the `register` table:

```sql
CREATE TABLE register (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100),
    city VARCHAR(100)
);
```

3. Update the `DbConnection.java` file with your database credentials:
   ```java
   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mvc_db", "your_username", "your_password");
   ```

### Deployment
1. Place the project in the `webapps` folder of your Tomcat server.
2. Start the Tomcat server.
3. Access the application at `http://localhost:8080/your_project_name`.

## Usage
1. Navigate to the home page.
2. Click **Register Here** to sign up.
3. Provide the required details and submit the form.
4. After successful registration, click **Login Here** to log in.
5. Enter your credentials and access your profile.

## Technology Stack
- **Frontend**: HTML
- **Backend**: Java Servlets, JSP
- **Database**: MySQL
- **Server**: Apache Tomcat

## Example Screenshots
- **Main Page**![Screenshot 2024-11-30 005518](https://github.com/user-attachments/assets/1d4d7af1-0341-47c1-bf0c-fcc3bcf902f1)

  
- **Registration Page**:![Screenshot 2024-11-30 005537](https://github.com/user-attachments/assets/9a14e0fe-d36d-40b3-8151-657a6c76e5d0)

- **Login Page**:
![Screenshot 2024-11-30 005547](https://github.com/user-attachments/assets/5e73eccb-56b5-4442-874e-8a850b36983a)

-**Profile Page** 
![Screenshot 2024-11-30 005605](https://github.com/user-attachments/assets/28cc4679-0562-4ea8-819d-19cb22ea3d41)

## Future Enhancements
1. Implement password encryption for better security.
2. Add client-side and server-side validation.
3. Enhance the UI using CSS or a framework like Bootstrap.
4. Introduce logout functionality.

## License
This project is open-source and available under the MIT License.

