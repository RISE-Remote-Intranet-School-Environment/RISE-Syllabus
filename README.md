# RISE-Syllabus

# Table of contents

* [Project participants](#project-participants)
* [About the project](#question-about-the-project)
* [Getting started](#rocket-getting-started)
* [API](#boom-api)

## **Project participants**

### 2023-24

- Van Olffen Victor 20253
- Maillard Corentin 21306
- Mettioui Mourad 195019

### 2022-23

- Kuijpers Nick 20324
- Baudouin Losseau 19593
- Quentin Jadoul 18155
- Theo Engels 195367

## :question: About the project

The purpose of this project is to allow students to buy syllabus online using our API.

## :rocket: Getting started


This is a springboot project. 
Use intellij in order to use java and maven. 
In MySQL Workbench, import the dump folder located in /Assets/dumpsylla/ .  

When you have succesfully imported the db and cloned the repository, you simply have to run SyllaApplication located in src/main/java/com/RISE/sylla/SyllaApplication.java with inteliji.

You can test that the application is running properly by trying with postman. 
For example, http://localhost:8081/user/users 


## TEST

The Unit-tests are made on src/test/java/com/RISE/sylla.java you can run this javaClass to verify the status of the test.

## DOCUMENTATION

The documentation for this Java program is generated using the JavaDoc tool. 
You can see there the goal of each function, the params they need and what they return.

To generate the documentation, follow these steps:

-Open the project in IntelliJ IDEA. \
-Click on the "Generate JavaDoc" button in the toolbar (as shown in the image you provided). \
-Specify the output directory \
-Click "OK" to generate the documentation. \
-The documentation will be generated in HTML format, and can be viewed by opening the index.html file in a web browser. \

You can generated this documentation in intellij \
![image](https://user-images.githubusercontent.com/67092457/206734346-17a032eb-96a4-48f8-8d07-697ed877d6ef.png) \
We generate the documentation at the end of our project but you can do it by yourself 

Download the repository and open one html file the open this documentation \

## :boom: API

For our API, we did all our tests using Postman. Then, we exported the Postman Collection v2.1 as a JSON file.
Finally, we converted the Postman Collection v2.1 to OpenAPI v3.0 following the documentation in this [repository](https://github.com/joolfe/postman-to-openapi).

The resulting OpenAPI schema is in [schema.yaml]().
