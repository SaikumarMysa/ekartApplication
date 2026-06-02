drop database if exists ekart_app;

     create database ekart_app;
    use database ekart_app;

        create TABLE Customer(
            customerId INTEGER AUTO_INCREMENT PRIMARY KEY,
            emailId VARCHAR(20) NOT NULL,
            name VARCHAR(30) NOT NULL,
            password VARCHAR(10) NOT NULL,
            confirmPassword VARCHAR(10) NOT NULL,
            phoneNumber VARCHAR(10) NOT NULL,
            address VARCHAR(30) NOT NULL,
        );

INSERT into Customer(customerId,emailId,name,password,confirmPassword,phoneNumber,address)
VALUES (1001,"abc@gmail.com","Anudeep","Anudeep123","Anudeep123","7989560240","Karimnagar");

