DROP DATABASE IF EXISTS ekart_app;

CREATE DATABASE ekart_app;

USE ekart_app;

CREATE TABLE customer (
                          customer_id INT AUTO_INCREMENT PRIMARY KEY,
                          email_id VARCHAR(255) NOT NULL UNIQUE,
                          name VARCHAR(255) NOT NULL,
                          password VARCHAR(255) NOT NULL,
                          phone_number VARCHAR(15),
                          address VARCHAR(500)
);

INSERT INTO customer(
    email_id,
    name,
    password,
    phone_number,
    address
)
VALUES (
           'abc@gmail.com',
           'Anudeep',
           'Anudeep123',
           '7989560240',
           'Karimnagar'
       );