Fruit Price Microservices System

A microservices-based application built using Spring Boot that manages fruit pricing data across different months and calculates total cost based on quantity. This project demonstrates RESTful API design, inter-service communication, and database integration.

⸻

🚀 Features
	•	Retrieve fruit price for a specific month
	•	Calculate total cost based on quantity
	•	Microservices architecture (FMP & FTP services)
	•	RESTful API design with JSON responses
	•	Inter-service communication using HTTP calls
	•	Data imported from Excel into a relational database

⸻

🏗️ System Architecture
	•	Fruit Month Price Service (FMP)
Fetches fruit price for a given month
	•	Fruit Total Price Service (FTP)
Calls FMP service and calculates total price
	•	Database
Stores fruit price data (fruit, month, price)

⸻

🛠️ Tech Stack
	•	Java
	•	Spring Boot
	•	Spring Data JPA (Hibernate)
	•	REST APIs
	•	MySQL / H2 Database
	•	Postman (API testing)
