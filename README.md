# Email-Manager

APIs : 


	POST /user    ( Creates a new user)

	GET  /users   ( Returns list of users)

	GET  /user/{id} (Return user by id)

	POST /email    (Create an email in DB)

	GET  /emails/count/{userId} (Returns number of email send by a user)

Tables : 

a. User Table
		
		i. First Name
		
		ii. Last name
		
		iii. Email address
		
		iv. phone number

b. Email Table
		
		
		i. From
		
		ii. To
		
		iii. Subject 
		
		iv. Body
    
How to run the project : 

	1. Open the project in a IDE.
	
	2. Go to src/main/java/com/assign/emailManager/EmailManagerApplication.java
	
	3. Run the main method present in the class by right clicking it.

	4. The project is up running at localhost:8080
