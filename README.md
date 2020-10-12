# Healthcare Service

The Healthcare Service is a Web Application used for manage Exams for a Healthcare Institution.

## Installing / Getting started

In order to compile the Live Application Service run this command within the CLI.

```shell
cd eureka-server
mvnw clean install
mvnw spring-boot:run
```

```shell
cd healthcare-service
mvnw clean install
mvnw spring-boot:run
```

```shell
cd healthcare-client-service
mvnw clean install
mvnw spring-boot:run
```
## Requirement

### MySQL Database connection

In order to create a database a MySQL 5.7.x installation is required. After that, open a terminal (command prompt in Microsoft Windows) and open a MySQL client as a user who can create new users. For example, use the following command:

```shell
mysql -u root -p
```

This connects to MySQL as ```root``` and allows access to the user from all hosts. This is __not the recommended way__ for a production server.

To create a new database, run the following commands at the ```mysql``` prompt:

```shell
mysql> create database healthcare; -- Creates the new database
mysql> create user 'pixeon'@'%' identified by 'pixeon'; -- Creates the user
mysql> grant all on healthcare.* to 'pixeon'@'%'; -- Gives all privileges to the new user on the newly created database
```
### Deploying / Publishing

In order to build and run the project

```shell
cd eureka-server
mvnw clean package spring-boot:repackage
java -jar target/eureka-server-[VERSION].jar
```
```shell
cd healthcare-service
mvnw clean package spring-boot:repackage
java -jar target/healthcare-service-[VERSION].jar
```
```shell
cd healthcare-client-service
mvnw clean package spring-boot:repackage
java -jar target/healthcare-client-service-[VERSION].jar
```

### Eureka Server

```shell
http://localhost:7777/
```
### Healthcare Service Server

```shell
http://localhost:[PORT]/
http://localhost:[PORT]/swagger-ui/
```
### Healthcare Client Service Server

```shell
http://localhost:9090/test
```


# Pixeon Tech Challenge

Your goal will be to build a REST API which is going to be used as part of pixeon’s solution. The API will take control over the healthcare institution registration as well as the exams ingest. 

The main resources of your solution should be `HealthcareInstitution` and  `Exam`. They are composed by the following properties: 

``HealthcareInstitution:  Name, CNPJ``  
``Exam: HealthcareInstitution, PatientName, PatientAge, PatientGender, PhysicianName, PhysicianCRM, ProcedureName``

You have to provide a solution that contains the follow operations: 

  * Create a Healthcare
  * Create an exam
  * Update an exam
  * Delete an exam 
  * Get an exam by its identifier

## Functional requirements

 * Each new healthcare institution must receive 20 pixeon coins to save exams and retrieve them.
 * Every exam successfully created must charge 1 pixeon coin from the healthcare institution's bugdet
 * You must charge 1 pixeon coin from the budget when one healthcare institution retrieves an exame but if the institution retrieves the same exame more than once you must not charge it, which means you have to charge only the first access to the exam.
 * A healthcare institution must not have access to an exam that belongs to other healthcare institution.
 * A healthcare institution is not allowed to create or get an exam when running out of budget. 
 * We are expecting you to build the solution using Spring Framework and we also do not care about the database or any other tool that you might choose.


## Non-functional requirements
 
 * More than one instance of the application will serve HTTP requests at the same time.
 * Think others developers will have to work on your solution, so make sure they can easily run the application locally. Please be nice to them  =)  

## Deliverable

A git repo hosted wherever you like but if you prefer just compress the git repo directory and send it back to us.

## Important notes

* Keep in your mind that you do not need to build all the features. We strongly recommend you to focus on quality over quantity, you will be evaluated by the quality of your solution.  
* If you think something is really necessary but you did not have enough time to do, please let us know and explain how you would do it. Understanding how you think is important to us 


### Enjoy yourself coding :)
