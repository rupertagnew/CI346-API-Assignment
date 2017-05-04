# CI346 API Assignment

## This assignment is split into two separate project files:
1.) HATEOAS Shifts Project
2.) PostgreSQL JUNIT Test Project

### HATEOAS Shifts

* The 'HATEOAS Shifts' section is to demonstrate the HATEOAS/ReactJS frontend elements of the assignment, I have implemented authentication using Spring Security.
The credentials are:

```
 university/fielding.
```
To install type:
```
mvn spring-boot:run
```


* At the moment the passwords stored in the application.properties file are not encrypted. 
* I did not want to just clone the full repository from greg turnquist's github page which implemented proper BCRYPT authentication as I wanted to learn how to implement it fully myself. However, I ran out of time but **do** understand the importance of password encryption. 
* Unencrypted passwords mean that if for any reason any attacker gained access to the application.properties file, the username and password would be on show to anybody in plaintext, other than it being publically accessable on GitHub. Normally the application.properties file will be server-side so unauthorised access has taken place anyway.
* The *correct* type of encryption needs to be chosen.
* For use in passwords, you actually need to store the hash value of a password, and not encrypt it. This is because encrypting implies that it can be decrypted, but we just want a one way hash value for something to be compared with.
* Using salted MD5 and SHA for passwords is a bad idea. Not because of MD5's cryptographic weaknesses, but because it's fast. This means that an attacker can try billions of potential passwords per second on a single GPU.
* You should use are deliberately slow hash constructors, such as scrypt, bcrypt and PBKDF2.
* By using a hash of a password, you can compare entries for two passwords. On the server side you simply compare the value entered from the client to the value stored in the database, if they match, the password has been correctly entered and the user should be allowed to log in.
* A random salt should be automatically generated. This protects against rainbow attacks which are a list of pre-generated hash values of common passwords. A randomly generated salt will ensure even the same original password will have a different hash value every time. 


### PostgreSQL

* This project defines a persistant database unlike the H2 database which is just saved in memory. I have also created some JUnit tests to test general adding/deleting/searching of employees 



	
##	Setup:
* 	Please create the following table in postgres using the database name **"postgres"** and credentials **postgres/1234**. These can be found or configured in the **application.properties file** in the PostgreSQL project

```
	CREATE TABLE employee(
    id BIGINT PRIMARY KEY  NOT NULL,
    firstname VARCHAR(20),
    lastname VARCHAR(20)
    );
```

* Then run:
```
mvn spring-boot:run -DskipTests
```
On the first run to **skip tests** as the tests require data from the first set-up run to work.

* Upon second run then check the tests by running:
```
mvn test
```

 ### Explaination of the JUnit Tests run:
 **   Postgres project: **
```
	ApplicationTest.java
		shouldReturnDefaultMessage() - tests to see if initial setup worked
		addAccount() - Adds Employee with firstname and lastname
		checkAddedAcount() - Query's database to see if Employee is added by searching for their lastname
		deleteAccount() - Deletes employee by their employeeID
	
	HttpTest.java
		checkFirstNameWorks() - Tests to see if Employee "Jack" exists - from initial start up addition data
		checkSurnameWorks() - Tests to see if Employee with surname "Davis" exists - from initial start up addition data
		
	SmokeTest.java - Smoke testing is to cover the most important functionality of a system
		contexLoads() - Tests to see if webcontroller exists
```



* I have not included a many to many database relationship in my project however if I were to implement a many to many relationship I would do so by executing the following SQL queries:

```
dbo.employee:
employee_id, first_name, last_name

dbo.shifts: 
shift_id, name, employee_id

employeeShifts:
shift_id, employee_id    

CREATE TABLE dbo.employees
(
    employeeID BIGINT PRIMARY KEY  NOT NULL,
    firstname VARCHAR(20) NOT NULL,
    lastname VARCHAR(20) NOT NULL
)

CREATE TABLE dbo.shifts
(
   shiftID INT IDENTITY(1, 1) NOT NULL,
   shiftday VARCHAR(9) NOT NULL,
   shifttime DATETIME(100) NOT NULL,
);

CREATE TABLE dbo.employeeShifts
(
   dbo.employees.employeeID INT NOT NULL,
   dbo.shifts.shiftID INT NOT NULL
);
```



   ## References

* [JUnit Tests Template](http://www.lucassaldanha.com/unit-and-integration-tests-in-spring-boot/)
* [React + Spring API Tutorial](https://github.com/spring-guides/tut-react-and-spring-data-rest)
* [PostgreSQL + Spring Tutorial](http://javasampleapproach.com/spring-framework/use-spring-jpa-postgresql-spring-boot)


### Images:
![Image 0](https://cloud.githubusercontent.com/assets/11032404/25718761/360447d8-30ff-11e7-9312-144d5893a6a5.PNG) - Authentication
![Image 1](https://cloud.githubusercontent.com/assets/11032404/25718764/361d4120-30ff-11e7-9b1b-53283454b084.PNG) - Dashboard/2 per page
![Image 2](https://cloud.githubusercontent.com/assets/11032404/25718760/35f0bc54-30ff-11e7-8223-9457c12a7bee.PNG) - 4 per page
![Image 3](https://cloud.githubusercontent.com/assets/11032404/25718762/361d18ee-30ff-11e7-9c17-9fb060f9372d.PNG) - PostgreSQL Dashboard commands
![Image 4](https://cloud.githubusercontent.com/assets/11032404/25718763/361d4b48-30ff-11e7-8594-7cbbb3344046.PNG) - JUnit Tests success after running mvn test
