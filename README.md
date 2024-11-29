🚗 Car Dealership Web Application
The Car Dealership Web Application is a comprehensive platform developed using Spring Boot that facilitates interactions between car dealers and buyers. It enables dealers to list cars for sale and buyers to browse, add cars to their cart, and make purchases. The project includes role-based access for enhanced user experience and security.

📋 Table of Contents
Features
Tech Stack
Project Structure
Setup Instructions
Database Schema
Screenshots
Contributing
License
Contact

🎯 Features
🛍️ For Buyers
    - User-friendly registration and login.
    - Browse available cars and view details.
    - Add cars to a cart and proceed with purchases.
    - View purchase history.
    
📈 For Dealers
   - Register and log in as a dealer.
   - Add, edit, and delete car listings.
   - Manage car inventory.
   - View client purchases related to their cars.
   - 
🔒 Security
    - Role-based access control using Spring Security.
    - Encrypted passwords with BCrypt.
    - Separate dashboards for buyers and dealers.
💻 General
Responsive and intuitive design.
Thymeleaf templates for dynamic front-end rendering.
RESTful APIs for handling requests and responses.

💡 Tech Stack
 - Backend
   - Spring Boot: Core framework for the application.
   - Spring Security: For authentication and authorization.
   - JPA (Hibernate): ORM for database interactions.
 - Frontend
   - HTML and CSS: For user interface design.
   - Thymeleaf: For server-side template rendering.
 - Database
   - MySQL: For storing user, car, and purchase data.

📊 Database Schema
Tables
Users

id (Primary Key)
username
password
role (ROLE_CLIENT, ROLE_DEALER)
Dealers

dealer_id (Primary Key)
name
contact
address
Cars

car_id (Primary Key)
model
brand
price
dealer_id (Foreign Key)
Purchases

purchase_id (Primary Key)
car_id (Foreign Key)
client_id (Foreign Key)
purchase_date


 
