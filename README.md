# Web Services with Spring Boot, JPA, and Hibernate

## Technologies Used

![SpringBoot](https://img.shields.io/badge/Spring_boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)![Spring](https://img.shields.io/badge/_-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Maven](https://img.shields.io/badge/maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![Heroku](https://img.shields.io/badge/Heroku-430098?style=for-the-badge&logo=heroku&logoColor=white)
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=Postman&logoColor=white)
![Apache Tom Cat](https://img.shields.io/badge/apachetomcat-F8DC75?style=for-the-badge&logo=ApacheTomCat&logoColor=black)
![H2 Database](https://img.shields.io/badge/H2_Database-041259?style=for-the-badge&logo=H2&logoColor=black)
![PostgreSQL](https://img.shields.io/badge/postgresql-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)

## Objectives

- Create a Spring Boot Java project
- Implement a domain model
- Structure logical layers: resource, service, repository
- Configure a test database (H2)
- Populate the database
- CRUD - Create, Retrieve, Update, Delete
- Exception handling

## Domain Model

### Product
- **id**: Integer (Primary Key)
- **name**: String
- **description**: String
- **price**: Double
- **imgUrl**: String
- **Relationships**:
    - One-to-Many with `OrderItem`
    - Many-to-Many with `Category`

### Category
- **id**: Integer (Primary Key)
- **name**: String
- **Relationships**:
    - Many-to-Many with `Product`

### OrderItem
- **quantity**: Integer
- **price**: Double
- **Methods**:
    - **subTotal()**: double
- **Relationships**:
    - Many-to-One with `Product`
    - Many-to-One with `Order`

### Order
- **id**: Integer (Primary Key)
- **moment**: Date
- **orderStatus**: OrderStatus
- **Methods**:
    - **total()**: double
- **Relationships**:
    - One-to-Many with `OrderItem`
    - Many-to-One with `User`
    - One-to-One with `Payment`

### User
- **id**: Integer (Primary Key)
- **name**: String
- **email**: String
- **phone**: String
- **password**: String
- **Relationships**:
    - One-to-Many with `Order`

### Payment
- **id**: Integer (Primary Key)
- **moment**: Date
- **Relationships**:
    - One-to-One with `Order`

### OrderStatus (Enum)
- **WAITING_PAYMENT**: int
- **PAID**: int
- **SHIPPED**: int
- **DELIVERED**: int
- **CANCELED**: int

## Domain Model with Instances

### Category
- **id**: Integer (Primary Key)
- **name**: String

#### Instances
- **cat1**: Category
    - id = 1
    - name = Electronics
- **cat2**: Category
    - id = 2
    - name = Books
- **cat3**: Category
    - id = 3
    - name = Computers

### Product
- **id**: Integer (Primary Key)
- **name**: String
- **description**: String
- **price**: Double
- **imgUrl**: String

#### Instances
- **p1**: Product
    - id = 1
    - name = The Lord of the Rings
    - description = Lorem ipsum dolor sit amet, consectetur.
    - price = 90.5
    - imgUrl
- **p2**: Product
    - id = 2
    - name = Smart TV
    - description = Nulla eu imperdiet purus. Maecenas ante.
    - price = 2190.0
    - imgUrl
- **p3**: Product
    - id = 3
    - name = MacBook Pro
    - description = Nam eleifend maximus tortor, at mollis.
    - price = 1250.0
    - imgUrl
- **p4**: Product
    - id = 4
    - name = PC Gamer
    - description = Donec aliquet odio ac rhoncus cursus.
    - price = 1200.0
    - imgUrl
- **p5**: Product
    - id = 5
    - name = Rails for Dummies
    - description = Cras fringilla convallis sem vel faucibus.
    - price = 100.99
    - imgUrl

### OrderItem
- **quantity**: Integer
- **price**: Double

#### Instances
- **oi1**: OrderItem
    - quantity = 2
    - price = 90.5
- **oi2**: OrderItem
    - quantity = 1
    - price = 1250.0
- **oi3**: OrderItem
    - quantity = 2
    - price = 1250.0
- **oi4**: OrderItem
    - quantity = 2
    - price = 100.99

### Order
- **id**: Integer (Primary Key)
- **moment**: Date
- **orderStatus**: OrderStatus

#### Instances
- **o1**: Order
    - id = 1
    - moment = 2019-06-20T19:53:07Z
    - orderStatus = PAID
- **o2**: Order
    - id = 2
    - moment = 2019-07-21T03:42:10Z
    - orderStatus = WAITING_PAYMENT
- **o3**: Order
    - id = 3
    - moment = 2019-07-22T15:21:22Z
    - orderStatus = WAITING_PAYMENT

### User
- **id**: Integer (Primary Key)
- **name**: String
- **email**: String
- **phone**: String
- **password**: String

#### Instances
- **u1**: User
    - id = 1
    - name = Maria Brown
    - email = maria@gmail.com
    - phone = 988888888
    - password = 123456
- **u2**: User
    - id = 2
    - name = Alex Green
    - email = alex@gmail.com
    - phone = 977777777
    - password = 123456

### Payment
- **id**: Integer (Primary Key)
- **moment**: Date

#### Instances
- **pay1**: Payment
    - id = 1
    - moment = 2019-06-23T13:02:55Z

## Getting Started

### Reference Documentation
For further reference, please consider the following sections:

- [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
- [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.3.0/maven-plugin/reference/html/)
- [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.3.0/maven-plugin/reference/html/#build-image)
- [Spring Web](https://docs.spring.io/spring-boot/docs/3.3.0/reference/htmlsingle/index.html#web)

### Guides
The following guides illustrate how to use some features concretely:

- [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
- [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
- [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
