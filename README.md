
# Medication Delivery System


This project is a REST API that allows clients to communicate with the drones. The specific communicaiton with the drone is outside the scope of this task.

## Table of Contents

 - Introduction
 - Requirements
    - Functional Requirements
    - Non-Functional Requirements
- Getting Started
    - Prerequisites
    - Building and Running the Application
    - Using the Application
- Assumptions
- Notes


## Introduction

There is a major new technology that is destined to be a disruptive force in the field of transportation: the drone. Just as the mobile phone allowed developing countries to leapfrog older technologies for personal communication, the drone has the potential to leapfrog traditional transportation infrastructure. Useful drone functions include delivery of small items that are (urgently) needed in locations with difficult access.

We have a fleet of 10 drones. A drone is capable of carrying devices, other than cameras, and capable of delivering small loads. For our use case the load is medications.

# Requirements

# Functional Requirements

- There is no need for UI
- Prevent the drone from being loaded with more weight that it can carry
- Prevent the drone from being in LOADING state if the battery level is below 25%
- Introduce a periodic task to check drones battery levels and create history/audit event log for this

### Non-Functional Requirements

- Input/output data must be in JSON format
- Your project must be buildable and runnable
- Your project must have a README file with build/run/test instructions (use DB that can be run locally, e.g. in-memory, via container)
- Any data required by the application to run (e.g. reference tables, dummy data) must be preloaded in the database.
- JUnit tests are optional but advisable (if you have time)
- Advice: Show us how you work through your commit history

# Getting Started

# Prerequisites

To build and run this application, you will need

 - Java 11
 - Gradle
    - Spring Boot
    - H2 Database
    - JUnit 5
    - Swagger/OpenAPI
 - Docker (Optional)

### Build and Run Instructions

 - Clone the repository to your local machine

			HTTPS : https://github.com/nlakjaya/drones-service.git
			SSH : git@github.com:nlakjaya/drones-service.git
			git : git clone https://github.com/nlakjaya/drones-service.git

 - Open a terminal and navigate to the project directory
 - Build the application using Gradle

			./gradlew build
			
 - To run the JUnit test cases seperately
 
			./gradlew test

 - Create a Docker image

			docker build -t drones-service .

 - Run the Docker container

			docker run -p 8080:8080 drones-service

 - OpenAPI (Swagger) documentation link

			http://localhost:8080/swagger-ui.html

 - Postman Collection

			./etc/Drones-v1.postman_collection.json

# Database

The project uses an in-memory H2 database, which is preloaded with some sample data on startup. You can access the H2 console at

 - H2 console Link

			http://localhost:8080/h2-console

 - H2 User Name

			sa
 - Password

			< empty >

### Assumptions
 
 - Medications can only be loaded onto a drone when it is not actively engaged.
 - The drone can deliver medications to one location at a time.
 - Each drone has a unique Serial Number for identification.
 - A newly created drone automatically starts in the IDLE state.
 - The battery level of the drone decreases by 1% per minute when it is active.
 - The drone can only be charged when it is not actively engaged, and the charging rate is 2% per minute.
 - Once loaded with medications, the drone begins the delivery process within 5 minutes.
 - The drone is programmed to deliver medications to locations that can be reached within 30 minutes.
 - After delivering the medications, the drone starts its return journey within 5 minutes.
 - The drone is expected to return within 30 minutes.
 - Once the drone returns, it transitions back to the IDLE state within 5 minutes.


### Notes


 - The drone service validates drone input to ensure that all required fields are present, data types are correct, lengths are appropriate, formats are valid, and values are within the expected range. This ensures the validity and consistency of drone data.
 - Medication input is also validated by the service, checking for required fields, data types, lengths, formats, and range to maintain data consistency and prevent potential errors.
 - A scheduled task is implemented in the project, running every 5 minutes, to monitor and log the battery levels of all drones, creating a history of events for auditing purposes.
 - The weight limit of drones is verified before loading medications to avoid exceeding the limit. If the weight limit is exceeded, the drones are not loaded with medications.
 - Drones are prevented from entering the LOADING state if their battery level is below 25%.


