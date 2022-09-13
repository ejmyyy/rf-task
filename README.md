# rf-task

**Instructions:** 
- clone the repository into your computer
- open project in your IDE
- set environmental variables for DB credentials (I used postgres db) see application.properties
- run project, default port 8080
- authorization for all endpoints
- users are already created in SecurityConfiguration (e.g. username: linda, passowrd: pass)
- schema.sql and data.sql are provided for creating tables and inserting data
- you can test the application using postman [collections](./postman-collection).


**Note:** 
- I wanted to deploy the app on AWS and I also wanted to create unit tests but the lack of time and me being sick for couple days already made
me being late with the assignement. I am sorry for that. If you have any questions about the task my email is amy.hriadelova@gmail.com

**Task description:**

Create a simple java backend app with REST API and authentication. Send us your work as archive or link to GitHub repository.

 

Lightway version of document management system

Purpose of this application is managing documents and protocols.

- app should manage all necessary data over REST API

- app should secure all REST API with authentication

- app should using JSON for communication

- app should persist data in database (choice of database is up to you)

- app should be able to run on application server (choice of server is up to you)

- app should be easy to run or contains manual

 

1.) Documents

- create REST APIs and database structures for manage documents

- every document should have these metadata - document name, who created it, when was created and document type (pdf, jpg).

- app should contains these APIs:

- create document

- edit document

- delete document

 

2.) Protocols

- create REST APIs and database structures for manage protocols (set of documents)

- protocol cannot be created without documents - every protocol contains 1:n documents

- every document should have these metadata - who created it, when was created, state of protocol (NEW, PREPARE_FOR_SHIPMENT, CANCELED) and references to documents

- app should contains these APIs:

- create protocol

- edit whole protocol (all data)

- edit only state of protocol
